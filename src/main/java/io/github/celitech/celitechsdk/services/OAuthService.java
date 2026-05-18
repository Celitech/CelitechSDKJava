package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
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

  private RequestConfig getAccessTokenConfig;

  /**
   * Constructs a new instance of OAuthService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public OAuthService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getAccessToken}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public OAuthService setGetAccessTokenConfig(RequestConfig config) {
    this.getAccessTokenConfig = config;
    return this;
  }

  /**
   * Get Access Token
   *
   * @param getAccessTokenRequest {@link GetAccessTokenRequest} Request Body
   * @return response of {@code GetAccessTokenOkResponse}
   */
  public GetAccessTokenOkResponse getAccessToken(
    @NonNull GetAccessTokenRequest getAccessTokenRequest
  ) throws ApiError {
    return this.getAccessToken(getAccessTokenRequest, null);
  }

  /**
   * Get Access Token
   *
   * @param getAccessTokenRequest {@link GetAccessTokenRequest} Request Body
   * @return response of {@code GetAccessTokenOkResponse}
   */
  public GetAccessTokenOkResponse getAccessToken(
    @NonNull GetAccessTokenRequest getAccessTokenRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getAccessTokenConfig, requestConfig);
    Request request = this.buildGetAccessTokenRequest(getAccessTokenRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<GetAccessTokenOkResponse>() {});
  }

  /**
   * Get Access Token
   *
   * @param getAccessTokenRequest {@link GetAccessTokenRequest} Request Body
   * @return response of {@code CompletableFuture<GetAccessTokenOkResponse>}
   */
  public CompletableFuture<GetAccessTokenOkResponse> getAccessTokenAsync(
    @NonNull GetAccessTokenRequest getAccessTokenRequest
  ) throws ApiError {
    return this.getAccessTokenAsync(getAccessTokenRequest, null);
  }

  /**
   * Get Access Token
   *
   * @param getAccessTokenRequest {@link GetAccessTokenRequest} Request Body
   * @return response of {@code CompletableFuture<GetAccessTokenOkResponse>}
   */
  public CompletableFuture<GetAccessTokenOkResponse> getAccessTokenAsync(
    @NonNull GetAccessTokenRequest getAccessTokenRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getAccessTokenConfig, requestConfig);
    Request request = this.buildGetAccessTokenRequest(getAccessTokenRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<GetAccessTokenOkResponse>() {});
    });
  }

  private Request buildGetAccessTokenRequest(
    @NonNull GetAccessTokenRequest getAccessTokenRequest,
    RequestConfig resolvedConfig
  ) {
    FormBody.Builder formBodyBuilder = new FormBody.Builder()
      .add("client_id", getAccessTokenRequest.getClientId())
      .add("client_secret", getAccessTokenRequest.getClientSecret());
    if (getAccessTokenRequest.getGrantType() != null) {
      formBodyBuilder.add(
        "grant_type",
        String.valueOf(getAccessTokenRequest.getGrantType().getValue())
      );
    }
    return new RequestBuilder(HttpMethod.POST, this.config.getBaseOAuthUrl(), "oauth2/token")
      .setBody(formBodyBuilder.build())
      .build();
  }
}
