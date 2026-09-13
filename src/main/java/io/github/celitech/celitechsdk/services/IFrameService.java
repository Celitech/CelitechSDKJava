package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.exceptions.BadRequestError;
import io.github.celitech.celitechsdk.exceptions.UnauthorizedError;
import io.github.celitech.celitechsdk.http.CelitechResponse;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.BadRequest;
import io.github.celitech.celitechsdk.models.TokenOkResponse;
import io.github.celitech.celitechsdk.models.Unauthorized;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * IFrameService Service
 */
public class IFrameService extends BaseService {

  private RequestConfig tokenConfig;

  /**
   * Constructs a new instance of IFrameService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public IFrameService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code token}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public IFrameService setTokenConfig(RequestConfig config) {
    this.tokenConfig = config;
    return this;
  }

  /**
   * Generate Token
   *
   * @return response of {@code TokenOkResponse}
   */
  public TokenOkResponse token() throws ApiError {
    return this.token(null);
  }

  /**
   * Generate Token
   *
   * @return response of {@code TokenOkResponse}
   */
  public TokenOkResponse token(RequestConfig requestConfig) throws ApiError {
    return withRawResponse().token(requestConfig).getData();
  }

  /**
   * Generate Token
   *
   * @return response of {@code CompletableFuture<TokenOkResponse>}
   */
  public CompletableFuture<TokenOkResponse> tokenAsync() throws ApiError {
    return this.tokenAsync(null);
  }

  /**
   * Generate Token
   *
   * @return response of {@code CompletableFuture<TokenOkResponse>}
   */
  public CompletableFuture<TokenOkResponse> tokenAsync(RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse().tokenAsync(requestConfig).thenApply(response -> response.getData());
  }

  private Request buildTokenRequest(RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "iframe/token"
    ).build();
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
   * Per-call accessor exposing raw-response variants of {@link IFrameService}'s methods.
   * Reuses the enclosing service's request builders and configuration.
   */
  public class WithRawResponse {

    /**
     * Generate Token
     *
     * @return response of {@code CelitechResponse<TokenOkResponse>}
     */
    public CelitechResponse<TokenOkResponse> token() throws ApiError {
      return this.token(null);
    }

    /**
     * Generate Token
     *
     * @return response of {@code CelitechResponse<TokenOkResponse>}
     */
    public CelitechResponse<TokenOkResponse> token(RequestConfig requestConfig) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(tokenConfig, requestConfig);
      addErrorMapping(400, BadRequest.class, (message, code, body, headers) ->
        new BadRequestError(message, (BadRequest) body, headers)
      );
      addErrorMapping(401, Unauthorized.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (Unauthorized) body, headers)
      );
      Request request = buildTokenRequest(resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new CelitechResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<TokenOkResponse>() {})
      );
    }

    /**
     * Generate Token
     *
     * @return response of {@code CompletableFuture<CelitechResponse<TokenOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<TokenOkResponse>> tokenAsync() throws ApiError {
      return this.tokenAsync(null);
    }

    /**
     * Generate Token
     *
     * @return response of {@code CompletableFuture<CelitechResponse<TokenOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<TokenOkResponse>> tokenAsync(
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(tokenConfig, requestConfig);
      addErrorMapping(400, BadRequest.class, (message, code, body, headers) ->
        new BadRequestError(message, (BadRequest) body, headers)
      );
      addErrorMapping(401, Unauthorized.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (Unauthorized) body, headers)
      );
      Request request = buildTokenRequest(resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new CelitechResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<TokenOkResponse>() {})
        );
      });
    }
  }
}
