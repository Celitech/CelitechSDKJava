package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2Parameters;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * V2Service Service
 */
public class V2Service extends BaseService {

  private RequestConfig createPurchaseV2Config = RequestConfig.builder()
    .environment(Environment.API)
    .build();

  /**
   * Constructs a new instance of V2Service.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public V2Service(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code createPurchaseV2}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public V2Service setCreatePurchaseV2Config(RequestConfig config) {
    this.createPurchaseV2Config = config;
    return this;
  }

  /**
   * This endpoint is used to purchase a new eSIM by providing the package details.
   *
   * @param requestParameters {@link CreatePurchaseV2Parameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createPurchaseV2(@NonNull CreatePurchaseV2Parameters requestParameters)
    throws ApiError {
    return this.createPurchaseV2(requestParameters, null);
  }

  /**
   * This endpoint is used to purchase a new eSIM by providing the package details.
   *
   * @param requestParameters {@link CreatePurchaseV2Parameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createPurchaseV2(
    @NonNull CreatePurchaseV2Parameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.createPurchaseV2Config, requestConfig);
    Request request = this.buildCreatePurchaseV2Request(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * This endpoint is used to purchase a new eSIM by providing the package details.
   *
   * @param requestParameters {@link CreatePurchaseV2Parameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createPurchaseV2Async(
    @NonNull CreatePurchaseV2Parameters requestParameters
  ) throws ApiError {
    return this.createPurchaseV2Async(requestParameters, null);
  }

  /**
   * This endpoint is used to purchase a new eSIM by providing the package details.
   *
   * @param requestParameters {@link CreatePurchaseV2Parameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createPurchaseV2Async(
    @NonNull CreatePurchaseV2Parameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.createPurchaseV2Config, requestConfig);
    Request request = this.buildCreatePurchaseV2Request(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildCreatePurchaseV2Request(
    @NonNull CreatePurchaseV2Parameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "purchases/v2"
    )
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
