package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.GetESimHistoryParameters;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * HistoryService Service
 */
public class HistoryService extends BaseService {

  private RequestConfig getESimHistoryConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();

  /**
   * Constructs a new instance of HistoryService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public HistoryService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getESimHistory}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public HistoryService setGetESimHistoryConfig(RequestConfig config) {
    this.getESimHistoryConfig = config;
    return this;
  }

  /**
   * Get eSIM History
   *
   * @param iccid String
   * @param requestParameters {@link GetESimHistoryParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getESimHistory(
    @NonNull String iccid,
    @NonNull GetESimHistoryParameters requestParameters
  ) throws ApiError {
    return this.getESimHistory(iccid, requestParameters, null);
  }

  /**
   * Get eSIM History
   *
   * @param iccid String
   * @param requestParameters {@link GetESimHistoryParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getESimHistory(
    @NonNull String iccid,
    @NonNull GetESimHistoryParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getESimHistoryConfig, requestConfig);
    Request request = this.buildGetESimHistoryRequest(iccid, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Get eSIM History
   *
   * @param iccid String
   * @param requestParameters {@link GetESimHistoryParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getESimHistoryAsync(
    @NonNull String iccid,
    @NonNull GetESimHistoryParameters requestParameters
  ) throws ApiError {
    return this.getESimHistoryAsync(iccid, requestParameters, null);
  }

  /**
   * Get eSIM History
   *
   * @param iccid String
   * @param requestParameters {@link GetESimHistoryParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getESimHistoryAsync(
    @NonNull String iccid,
    @NonNull GetESimHistoryParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getESimHistoryConfig, requestConfig);
    Request request = this.buildGetESimHistoryRequest(iccid, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetESimHistoryRequest(
    @NonNull String iccid,
    @NonNull GetESimHistoryParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "esim/{iccid}/history"
    )
      .setPathParameter("iccid", iccid)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
