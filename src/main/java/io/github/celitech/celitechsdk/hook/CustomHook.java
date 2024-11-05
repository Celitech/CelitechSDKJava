package io.github.celitech.celitechsdk.hook;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CustomHook implements Hook {

  private static String CURRENT_TOKEN = "";
  private static long CURRENT_EXPIRY = -1;

  private final ObjectMapper objectMapper = new ObjectMapper(); // Jackson's ObjectMapper

  public Map<String, Object> getToken(String clientId, String clientSecret) throws Exception {
    String fullUrl = "https://auth.celitech.net/oauth2/token";
    HttpURLConnection connection = (HttpURLConnection) new URL(fullUrl).openConnection();
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    connection.setDoOutput(true);

    String data = "client_id=" + clientId + "&client_secret=" + clientSecret + "&grant_type=client_credentials";

    try (OutputStream os = connection.getOutputStream()) {
      os.write(data.getBytes());
      os.flush();
    }

    int status = connection.getResponseCode();
    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    StringBuilder content = new StringBuilder();
    String inputLine;
    while ((inputLine = in.readLine()) != null) {
      content.append(inputLine);
    }

    in.close();
    connection.disconnect();

    // Parse JSON response string to a Map using Jackson's ObjectMapper
    return objectMapper.readValue(content.toString(), HashMap.class);
  }

  @Override
  public Request beforeRequest(Request request, Map<String, String> params) throws Exception {
    String clientId = params.get("clientId");
    String clientSecret = params.get("clientSecret");

    if (clientId == null || clientSecret == null) {
      throw new Exception("Missing clientId and/or clientSecret constructor parameters");
    }

    if (CURRENT_TOKEN.isEmpty() || CURRENT_EXPIRY < System.currentTimeMillis()) {
      Map<String, Object> tokenResponse = getToken(clientId, clientSecret);

      if (tokenResponse.containsKey("error")) {
        throw new Exception(tokenResponse.get("error").toString());
      }

      long expiresIn = ((Number) tokenResponse.get("expires_in")).longValue();
      String accessToken = (String) tokenResponse.get("access_token");

      if (expiresIn <= 0 || accessToken == null || accessToken.isEmpty()) {
        throw new Exception("There is an issue with getting the oauth token");
      }

      CURRENT_EXPIRY = System.currentTimeMillis() + expiresIn * 1000;
      CURRENT_TOKEN = accessToken;
    }

    String authorization = "Bearer " + CURRENT_TOKEN;
    request.getHeaders().put("Authorization", authorization);

    return request;
  }

  @Override
  public Response afterResponse(Request request, Response response, Map<String, String> params) {
    return response;
  }

  @Override
  public void onError(Exception error, Request request, Response response, Map<String, String> params) {}
}
