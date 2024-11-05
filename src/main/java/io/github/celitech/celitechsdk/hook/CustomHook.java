package io.github.celitech.celitechsdk.hook;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

public class CustomHook implements Hook {

  private static String CURRENT_TOKEN = "";
  private static long CURRENT_EXPIRY = -1;

  public JSONObject getToken(String clientId, String clientSecret) throws Exception {
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
    String inputLine;
    StringBuilder content = new StringBuilder();
    while ((inputLine = in.readLine()) != null) {
      content.append(inputLine);
    }

    in.close();
    connection.disconnect();

    return new JSONObject(content.toString());
  }

  @Override
  public Request beforeRequest(Request request, Map<String, String> params) throws Exception {
    String clientId = params.get("clientId");
    String clientSecret = params.get("clientSecret");

    if (clientId == null || clientSecret == null) {
      throw new Exception("Missing clientId and/or clientSecret constructor parameters");
    }

    if (CURRENT_TOKEN.isEmpty() || CURRENT_EXPIRY < System.currentTimeMillis()) {
      JSONObject tokenResponse = getToken(clientId, clientSecret);

      if (tokenResponse.has("error")) {
        throw new Exception(tokenResponse.getString("error"));
      }

      long expiresIn = tokenResponse.getLong("expires_in");
      String accessToken = tokenResponse.getString("access_token");

      if (expiresIn <= 0 || accessToken == null || accessToken.isEmpty()) {
        throw new Exception("There is an issue with getting the oauth token");
      }

      CURRENT_EXPIRY = System.currentTimeMillis() + expiresIn * 1000;
      CURRENT_TOKEN = accessToken;
    }

    String authorization = "Bearer " + CURRENT_TOKEN;
    request.getHeaders().put("Authorization", authorization);
  }

  @Override
  public Response afterResponse(Request request, Response response, Map<String, String> params) {}

  @Override
  public void onError(Exception error, Request request, Response response, Map<String, String> params) {}
}
