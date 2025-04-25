package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.exceptions.ApiException;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.GetAccessTokenOkResponse;
import io.github.celitech.celitechsdk.models.GetAccessTokenRequest;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OAuthService Service
 */
public class OAuthService extends BaseService {

  public OAuthService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Get Access Token
   *
   * @param getAccessTokenRequest {@link GetAccessTokenRequest} Request Body
   * @return response of {@code GetAccessTokenOkResponse}
   */
  public GetAccessTokenOkResponse getAccessToken(@NonNull GetAccessTokenRequest getAccessTokenRequest)
    throws ApiException {
    Request request = this.buildGetAccessTokenRequest(getAccessTokenRequest);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetAccessTokenOkResponse>() {});
  }

  /**
   * Get Access Token
   *
   * @param getAccessTokenRequest {@link GetAccessTokenRequest} Request Body
   * @return response of {@code CompletableFuture<GetAccessTokenOkResponse>}
   */
  public CompletableFuture<GetAccessTokenOkResponse> getAccessTokenAsync(
    @NonNull GetAccessTokenRequest getAccessTokenRequest
  ) throws ApiException {
    Request request = this.buildGetAccessTokenRequest(getAccessTokenRequest);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetAccessTokenOkResponse>() {})
    );
  }

  private Request buildGetAccessTokenRequest(@NonNull GetAccessTokenRequest getAccessTokenRequest) {
    FormBody.Builder formBodyBuilder = new FormBody.Builder()
      .add("client_id", getAccessTokenRequest.getClientId())
      .add("client_secret", getAccessTokenRequest.getClientSecret());
    if (getAccessTokenRequest.getGrantType() != null) {
      formBodyBuilder.add("grant_type", getAccessTokenRequest.getGrantType().getValue());
    }
    return new RequestBuilder(HttpMethod.POST, this.config.getBaseOAuthUrl(), "oauth2/token")
      .setBody(formBodyBuilder.build())
      .build();
  }
}
