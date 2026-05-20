package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.EditPurchaseParameters;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * EditService Service
 */
public class EditService extends BaseService {

  private RequestConfig editPurchaseConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();

  /**
   * Constructs a new instance of EditService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public EditService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code editPurchase}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public EditService setEditPurchaseConfig(RequestConfig config) {
    this.editPurchaseConfig = config;
    return this;
  }

  /**
   * This endpoint allows you to modify the validity dates of an existing purchase.
   *
   * **Behavior:**
   * - If the purchase has **not yet been activated**, both the start and end dates can be updated.
   * - If the purchase is **already active**, only the **end date** can be updated, while the **start date must remain unchanged** (and should be passed as originally set).
   * - Updates must comply with the same pricing structure; the modification cannot alter the package size or change its duration category.
   *
   * The end date can be extended or shortened as long as it adheres to the same pricing category and does not exceed the allowed duration limits.
   *
   *
   * @param requestParameters {@link EditPurchaseParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object editPurchase(@NonNull EditPurchaseParameters requestParameters) throws ApiError {
    return this.editPurchase(requestParameters, null);
  }

  /**
   * This endpoint allows you to modify the validity dates of an existing purchase.
   *
   * **Behavior:**
   * - If the purchase has **not yet been activated**, both the start and end dates can be updated.
   * - If the purchase is **already active**, only the **end date** can be updated, while the **start date must remain unchanged** (and should be passed as originally set).
   * - Updates must comply with the same pricing structure; the modification cannot alter the package size or change its duration category.
   *
   * The end date can be extended or shortened as long as it adheres to the same pricing category and does not exceed the allowed duration limits.
   *
   *
   * @param requestParameters {@link EditPurchaseParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object editPurchase(
    @NonNull EditPurchaseParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.editPurchaseConfig, requestConfig);
    Request request = this.buildEditPurchaseRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * This endpoint allows you to modify the validity dates of an existing purchase.
   *
   * **Behavior:**
   * - If the purchase has **not yet been activated**, both the start and end dates can be updated.
   * - If the purchase is **already active**, only the **end date** can be updated, while the **start date must remain unchanged** (and should be passed as originally set).
   * - Updates must comply with the same pricing structure; the modification cannot alter the package size or change its duration category.
   *
   * The end date can be extended or shortened as long as it adheres to the same pricing category and does not exceed the allowed duration limits.
   *
   *
   * @param requestParameters {@link EditPurchaseParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> editPurchaseAsync(
    @NonNull EditPurchaseParameters requestParameters
  ) throws ApiError {
    return this.editPurchaseAsync(requestParameters, null);
  }

  /**
   * This endpoint allows you to modify the validity dates of an existing purchase.
   *
   * **Behavior:**
   * - If the purchase has **not yet been activated**, both the start and end dates can be updated.
   * - If the purchase is **already active**, only the **end date** can be updated, while the **start date must remain unchanged** (and should be passed as originally set).
   * - Updates must comply with the same pricing structure; the modification cannot alter the package size or change its duration category.
   *
   * The end date can be extended or shortened as long as it adheres to the same pricing category and does not exceed the allowed duration limits.
   *
   *
   * @param requestParameters {@link EditPurchaseParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> editPurchaseAsync(
    @NonNull EditPurchaseParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.editPurchaseConfig, requestConfig);
    Request request = this.buildEditPurchaseRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildEditPurchaseRequest(
    @NonNull EditPurchaseParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "purchases/edit"
    )
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
