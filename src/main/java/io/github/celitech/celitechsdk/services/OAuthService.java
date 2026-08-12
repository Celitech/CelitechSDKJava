package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.http.CelitechResponse;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.OAuthTokenRequest;
import io.github.celitech.celitechsdk.models.OAuthTokenResponse;
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
   * Method getAccessToken
   * POST /oauth2/token
   *
   * @param oAuthTokenRequest {@link OAuthTokenRequest} Request Body
   * @return response of {@code OAuthTokenResponse}
   */
  public OAuthTokenResponse getAccessToken(@NonNull OAuthTokenRequest oAuthTokenRequest)
    throws ApiError {
    return this.getAccessToken(oAuthTokenRequest, null);
  }

  /**
   * Method getAccessToken
   * POST /oauth2/token
   *
   * @param oAuthTokenRequest {@link OAuthTokenRequest} Request Body
   * @return response of {@code OAuthTokenResponse}
   */
  public OAuthTokenResponse getAccessToken(
    @NonNull OAuthTokenRequest oAuthTokenRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().getAccessToken(oAuthTokenRequest, requestConfig).getData();
  }

  /**
   * Method getAccessToken
   * POST /oauth2/token
   *
   * @param oAuthTokenRequest {@link OAuthTokenRequest} Request Body
   * @return response of {@code CompletableFuture<OAuthTokenResponse>}
   */
  public CompletableFuture<OAuthTokenResponse> getAccessTokenAsync(
    @NonNull OAuthTokenRequest oAuthTokenRequest
  ) throws ApiError {
    return this.getAccessTokenAsync(oAuthTokenRequest, null);
  }

  /**
   * Method getAccessToken
   * POST /oauth2/token
   *
   * @param oAuthTokenRequest {@link OAuthTokenRequest} Request Body
   * @return response of {@code CompletableFuture<OAuthTokenResponse>}
   */
  public CompletableFuture<OAuthTokenResponse> getAccessTokenAsync(
    @NonNull OAuthTokenRequest oAuthTokenRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .getAccessTokenAsync(oAuthTokenRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetAccessTokenRequest(
    @NonNull OAuthTokenRequest oAuthTokenRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(HttpMethod.POST, this.config.getBaseOAuthUrl(), "oauth2/token")
      .setBody(
        new FormBody.Builder()
          .add("grant_type", String.valueOf(oAuthTokenRequest.getGrantType().toString()))
          .add("client_id", oAuthTokenRequest.getClientId())
          .add("client_secret", oAuthTokenRequest.getClientSecret())
          .add("scope", oAuthTokenRequest.getScope())
          .build()
      )
      .build();
  }

  /**
   * Returns an accessor whose methods mirror this service but return the full HTTP response
   * (status code, headers, and raw body) wrapped alongside the parsed data.
   *
   * @return An accessor exposing raw-response variants of this service's methods
   */
  public WithRawResponse withRawResponse() {
    return new WithRawResponse();
  }

  /**
   * Per-call accessor exposing raw-response variants of {@link OAuthService}'s methods.
   * Reuses the enclosing service's request builders and configuration.
   */
  public class WithRawResponse {

    /**
     * Method getAccessToken
     * POST /oauth2/token
     *
     * @param oAuthTokenRequest {@link OAuthTokenRequest} Request Body
     * @return response of {@code CelitechResponse<OAuthTokenResponse>}
     */
    public CelitechResponse<OAuthTokenResponse> getAccessToken(
      @NonNull OAuthTokenRequest oAuthTokenRequest
    ) throws ApiError {
      return this.getAccessToken(oAuthTokenRequest, null);
    }

    /**
     * Method getAccessToken
     * POST /oauth2/token
     *
     * @param oAuthTokenRequest {@link OAuthTokenRequest} Request Body
     * @return response of {@code CelitechResponse<OAuthTokenResponse>}
     */
    public CelitechResponse<OAuthTokenResponse> getAccessToken(
      @NonNull OAuthTokenRequest oAuthTokenRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getAccessTokenConfig, requestConfig);
      Request request = buildGetAccessTokenRequest(oAuthTokenRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new CelitechResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<OAuthTokenResponse>() {})
      );
    }

    /**
     * Method getAccessToken
     * POST /oauth2/token
     *
     * @param oAuthTokenRequest {@link OAuthTokenRequest} Request Body
     * @return response of {@code CompletableFuture<CelitechResponse<OAuthTokenResponse>>}
     */
    public CompletableFuture<CelitechResponse<OAuthTokenResponse>> getAccessTokenAsync(
      @NonNull OAuthTokenRequest oAuthTokenRequest
    ) throws ApiError {
      return this.getAccessTokenAsync(oAuthTokenRequest, null);
    }

    /**
     * Method getAccessToken
     * POST /oauth2/token
     *
     * @param oAuthTokenRequest {@link OAuthTokenRequest} Request Body
     * @return response of {@code CompletableFuture<CelitechResponse<OAuthTokenResponse>>}
     */
    public CompletableFuture<CelitechResponse<OAuthTokenResponse>> getAccessTokenAsync(
      @NonNull OAuthTokenRequest oAuthTokenRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getAccessTokenConfig, requestConfig);
      Request request = buildGetAccessTokenRequest(oAuthTokenRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new CelitechResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<OAuthTokenResponse>() {})
        );
      });
    }
  }
}
