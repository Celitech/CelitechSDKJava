package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.GetESimDeviceParameters;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * DeviceService Service
 */
public class DeviceService extends BaseService {

  private RequestConfig getESimDeviceConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();

  /**
   * Constructs a new instance of DeviceService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public DeviceService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getESimDevice}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public DeviceService setGetESimDeviceConfig(RequestConfig config) {
    this.getESimDeviceConfig = config;
    return this;
  }

  /**
   * Get eSIM Device
   *
   * @param iccid String
   * @param requestParameters {@link GetESimDeviceParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getESimDevice(
    @NonNull String iccid,
    @NonNull GetESimDeviceParameters requestParameters
  ) throws ApiError {
    return this.getESimDevice(iccid, requestParameters, null);
  }

  /**
   * Get eSIM Device
   *
   * @param iccid String
   * @param requestParameters {@link GetESimDeviceParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getESimDevice(
    @NonNull String iccid,
    @NonNull GetESimDeviceParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getESimDeviceConfig, requestConfig);
    Request request = this.buildGetESimDeviceRequest(iccid, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Get eSIM Device
   *
   * @param iccid String
   * @param requestParameters {@link GetESimDeviceParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getESimDeviceAsync(
    @NonNull String iccid,
    @NonNull GetESimDeviceParameters requestParameters
  ) throws ApiError {
    return this.getESimDeviceAsync(iccid, requestParameters, null);
  }

  /**
   * Get eSIM Device
   *
   * @param iccid String
   * @param requestParameters {@link GetESimDeviceParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getESimDeviceAsync(
    @NonNull String iccid,
    @NonNull GetESimDeviceParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getESimDeviceConfig, requestConfig);
    Request request = this.buildGetESimDeviceRequest(iccid, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetESimDeviceRequest(
    @NonNull String iccid,
    @NonNull GetESimDeviceParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "esim/{iccid}/device"
    )
      .setPathParameter("iccid", iccid)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
