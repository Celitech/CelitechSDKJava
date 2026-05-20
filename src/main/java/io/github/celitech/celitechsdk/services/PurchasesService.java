package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.CreatePurchaseParameters;
import io.github.celitech.celitechsdk.models.ListPurchasesParameters;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * PurchasesService Service
 */
public class PurchasesService extends BaseService {

  private RequestConfig createPurchaseConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();
  private RequestConfig listPurchasesConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();

  /**
   * Constructs a new instance of PurchasesService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public PurchasesService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code createPurchase}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public PurchasesService setCreatePurchaseConfig(RequestConfig config) {
    this.createPurchaseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listPurchases}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public PurchasesService setListPurchasesConfig(RequestConfig config) {
    this.listPurchasesConfig = config;
    return this;
  }

  /**
   * This endpoint is used to purchase a new eSIM by providing the package details.
   *
   * @param requestParameters {@link CreatePurchaseParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createPurchase(@NonNull CreatePurchaseParameters requestParameters)
    throws ApiError {
    return this.createPurchase(requestParameters, null);
  }

  /**
   * This endpoint is used to purchase a new eSIM by providing the package details.
   *
   * @param requestParameters {@link CreatePurchaseParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createPurchase(
    @NonNull CreatePurchaseParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createPurchaseConfig, requestConfig);
    Request request = this.buildCreatePurchaseRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * This endpoint is used to purchase a new eSIM by providing the package details.
   *
   * @param requestParameters {@link CreatePurchaseParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createPurchaseAsync(
    @NonNull CreatePurchaseParameters requestParameters
  ) throws ApiError {
    return this.createPurchaseAsync(requestParameters, null);
  }

  /**
   * This endpoint is used to purchase a new eSIM by providing the package details.
   *
   * @param requestParameters {@link CreatePurchaseParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createPurchaseAsync(
    @NonNull CreatePurchaseParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createPurchaseConfig, requestConfig);
    Request request = this.buildCreatePurchaseRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildCreatePurchaseRequest(
    @NonNull CreatePurchaseParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "purchases"
    )
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }

  /**
   * This endpoint can be used to list all the successful purchases made between a given interval.
   *
   * @param requestParameters {@link ListPurchasesParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listPurchases(@NonNull ListPurchasesParameters requestParameters) throws ApiError {
    return this.listPurchases(requestParameters, null);
  }

  /**
   * This endpoint can be used to list all the successful purchases made between a given interval.
   *
   * @param requestParameters {@link ListPurchasesParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listPurchases(
    @NonNull ListPurchasesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listPurchasesConfig, requestConfig);
    Request request = this.buildListPurchasesRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * This endpoint can be used to list all the successful purchases made between a given interval.
   *
   * @param requestParameters {@link ListPurchasesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listPurchasesAsync(
    @NonNull ListPurchasesParameters requestParameters
  ) throws ApiError {
    return this.listPurchasesAsync(requestParameters, null);
  }

  /**
   * This endpoint can be used to list all the successful purchases made between a given interval.
   *
   * @param requestParameters {@link ListPurchasesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listPurchasesAsync(
    @NonNull ListPurchasesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listPurchasesConfig, requestConfig);
    Request request = this.buildListPurchasesRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildListPurchasesRequest(
    @NonNull ListPurchasesParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "purchases"
    )
      .setHeader("Accept", requestParameters.getAccept())
      .setOptionalQueryParameter("purchaseId", requestParameters.getPurchaseId())
      .setOptionalQueryParameter("iccid", requestParameters.getIccid())
      .setOptionalQueryParameter("afterDate", requestParameters.getAfterDate())
      .setOptionalQueryParameter("beforeDate", requestParameters.getBeforeDate())
      .setOptionalQueryParameter("email", requestParameters.getEmail())
      .setOptionalQueryParameter("referenceId", requestParameters.getReferenceId())
      .setOptionalQueryParameter("afterCursor", requestParameters.getAfterCursor())
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("after", requestParameters.getAfter())
      .setOptionalQueryParameter("before", requestParameters.getBefore())
      .build();
  }
}
