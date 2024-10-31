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

public class CustomHook implements Hook {

  private static String CURRENT_TOKEN = "";
  private static Instant CURRENT_EXPIRY = Instant.ofEpochMilli(-1);
  private final OkHttpClient client = new OkHttpClient();

  @Override
  public Request beforeRequest(Request request, Map<String, String> additionalParameters) {
    if (request.url().toString().endsWith("/oauth/token")) {
      return request;
    }

    String clientId = additionalParameters.get("client_id");
    String clientSecret = additionalParameters.get("client_secret");

    if (clientId == null || clientSecret == null) {
      System.out.println("Missing client_id and/or client_secret constructor parameters");
      return request;
    }

    if (CURRENT_TOKEN.isEmpty() || CURRENT_EXPIRY.isBefore(Instant.now())) {
      try {
        Map<String, String> input_data = new HashMap<>();
        input_data.put("client_id", clientId);
        input_data.put("client_secret", clientSecret);
        input_data.put("grant_type", "client_credentials");

        Map<String, Object> token_response = doPost(input_data);
        if (token_response == null) {
          System.out.println("There is an issue with getting the oauth token");
          return request;
        }

        long expiresIn = (int) token_response.get("expires_in");
        String accessToken = (String) token_response.get("access_token");

        CURRENT_EXPIRY = Instant.now().plusMillis(expiresIn * 1000);
        CURRENT_TOKEN = accessToken;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    Request.Builder builder = request.newBuilder();
    builder.header("Authorization", "Bearer " + CURRENT_TOKEN);
    return builder.build();
  }

  private Map<String, Object> doPost(Map<String, String> inputData) throws IOException {
    String fullUrl = "https://auth.celitech.net/oauth2/token";
    MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    StringBuilder formBodyBuilder = new StringBuilder();

    for (Map.Entry<String, String> entry : inputData.entrySet()) {
      if (formBodyBuilder.length() > 0) {
        formBodyBuilder.append("&");
      }
      formBodyBuilder.append(entry.getKey()).append("=").append(entry.getValue());
    }

    RequestBody body = RequestBody.create(formBodyBuilder.toString(), mediaType);
    Request request = new Request.Builder().url(fullUrl).post(body).build();

    try (Response response = client.newCall(request).execute()) {
      if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
      return new ObjectMapper().readValue(response.body().string(), Map.class);
    } catch (IOException e) {
      System.out.println("Error in posting the request: " + e.getMessage());
      return null;
    }
  }

  @Override
  public Response afterResponse(Request request, Response response, Map<String, String> additionalParameters) {
    return response;
  }

  @Override
  public void onError(Request request, Exception exception, Map<String, String> additionalParameters) {}
}
