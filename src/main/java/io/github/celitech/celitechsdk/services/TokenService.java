package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.GenerateTokenParameters;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TokenService Service
 */
public class TokenService extends BaseService {

  private RequestConfig generateTokenConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();

  /**
   * Constructs a new instance of TokenService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TokenService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code generateToken}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TokenService setGenerateTokenConfig(RequestConfig config) {
    this.generateTokenConfig = config;
    return this;
  }

  /**
   * Generate a new token to be used in the iFrame
   *
   * @param requestParameters {@link GenerateTokenParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object generateToken(@NonNull GenerateTokenParameters requestParameters) throws ApiError {
    return this.generateToken(requestParameters, null);
  }

  /**
   * Generate a new token to be used in the iFrame
   *
   * @param requestParameters {@link GenerateTokenParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object generateToken(
    @NonNull GenerateTokenParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.generateTokenConfig, requestConfig);
    Request request = this.buildGenerateTokenRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Generate a new token to be used in the iFrame
   *
   * @param requestParameters {@link GenerateTokenParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> generateTokenAsync(
    @NonNull GenerateTokenParameters requestParameters
  ) throws ApiError {
    return this.generateTokenAsync(requestParameters, null);
  }

  /**
   * Generate a new token to be used in the iFrame
   *
   * @param requestParameters {@link GenerateTokenParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> generateTokenAsync(
    @NonNull GenerateTokenParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.generateTokenConfig, requestConfig);
    Request request = this.buildGenerateTokenRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGenerateTokenRequest(
    @NonNull GenerateTokenParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "iframe/token"
    )
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
