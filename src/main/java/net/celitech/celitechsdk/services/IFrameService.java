package net.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import net.celitech.celitechsdk.config.CelitechConfig;
import net.celitech.celitechsdk.config.RequestConfig;
import net.celitech.celitechsdk.exceptions.ApiError;
import net.celitech.celitechsdk.exceptions.BadRequestException;
import net.celitech.celitechsdk.exceptions.UnauthorizedException;
import net.celitech.celitechsdk.http.Environment;
import net.celitech.celitechsdk.http.HttpMethod;
import net.celitech.celitechsdk.http.ModelConverter;
import net.celitech.celitechsdk.http.util.RequestBuilder;
import net.celitech.celitechsdk.models.BadRequest;
import net.celitech.celitechsdk.models.TokenOkResponse;
import net.celitech.celitechsdk.models.Unauthorized;
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
    RequestConfig resolvedConfig = this.getResolvedConfig(this.tokenConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildTokenRequest(resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<TokenOkResponse>() {});
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
    RequestConfig resolvedConfig = this.getResolvedConfig(this.tokenConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildTokenRequest(resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<TokenOkResponse>() {});
    });
  }

  private Request buildTokenRequest(RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "iframe/token"
    ).build();
  }
}
