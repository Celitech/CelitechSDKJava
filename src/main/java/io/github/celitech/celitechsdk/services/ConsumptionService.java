package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.GetPurchaseConsumptionParameters;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ConsumptionService Service
 */
public class ConsumptionService extends BaseService {

  private RequestConfig getPurchaseConsumptionConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();

  /**
   * Constructs a new instance of ConsumptionService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public ConsumptionService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getPurchaseConsumption}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ConsumptionService setGetPurchaseConsumptionConfig(RequestConfig config) {
    this.getPurchaseConsumptionConfig = config;
    return this;
  }

  /**
   * This endpoint can be called for consumption notifications (e.g. every 1 hour or when the user clicks a button). It returns the data balance (consumption) of purchased packages.
   *
   * @param purchaseId String
   * @param requestParameters {@link GetPurchaseConsumptionParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getPurchaseConsumption(
    @NonNull String purchaseId,
    @NonNull GetPurchaseConsumptionParameters requestParameters
  ) throws ApiError {
    return this.getPurchaseConsumption(purchaseId, requestParameters, null);
  }

  /**
   * This endpoint can be called for consumption notifications (e.g. every 1 hour or when the user clicks a button). It returns the data balance (consumption) of purchased packages.
   *
   * @param purchaseId String
   * @param requestParameters {@link GetPurchaseConsumptionParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getPurchaseConsumption(
    @NonNull String purchaseId,
    @NonNull GetPurchaseConsumptionParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getPurchaseConsumptionConfig, requestConfig);
    Request request =
      this.buildGetPurchaseConsumptionRequest(purchaseId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * This endpoint can be called for consumption notifications (e.g. every 1 hour or when the user clicks a button). It returns the data balance (consumption) of purchased packages.
   *
   * @param purchaseId String
   * @param requestParameters {@link GetPurchaseConsumptionParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getPurchaseConsumptionAsync(
    @NonNull String purchaseId,
    @NonNull GetPurchaseConsumptionParameters requestParameters
  ) throws ApiError {
    return this.getPurchaseConsumptionAsync(purchaseId, requestParameters, null);
  }

  /**
   * This endpoint can be called for consumption notifications (e.g. every 1 hour or when the user clicks a button). It returns the data balance (consumption) of purchased packages.
   *
   * @param purchaseId String
   * @param requestParameters {@link GetPurchaseConsumptionParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getPurchaseConsumptionAsync(
    @NonNull String purchaseId,
    @NonNull GetPurchaseConsumptionParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getPurchaseConsumptionConfig, requestConfig);
    Request request =
      this.buildGetPurchaseConsumptionRequest(purchaseId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetPurchaseConsumptionRequest(
    @NonNull String purchaseId,
    @NonNull GetPurchaseConsumptionParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "purchases/{purchaseId}/consumption"
    )
      .setPathParameter("purchaseId", purchaseId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
