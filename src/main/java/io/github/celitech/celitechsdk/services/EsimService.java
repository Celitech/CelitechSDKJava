package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.GetESimParameters;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * EsimService Service
 */
public class EsimService extends BaseService {

  private RequestConfig getESimConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();

  /**
   * Constructs a new instance of EsimService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public EsimService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getESim}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public EsimService setGetESimConfig(RequestConfig config) {
    this.getESimConfig = config;
    return this;
  }

  /**
   * Get eSIM
   *
   * @param requestParameters {@link GetESimParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getESim(@NonNull GetESimParameters requestParameters) throws ApiError {
    return this.getESim(requestParameters, null);
  }

  /**
   * Get eSIM
   *
   * @param requestParameters {@link GetESimParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getESim(@NonNull GetESimParameters requestParameters, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getESimConfig, requestConfig);
    Request request = this.buildGetESimRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Get eSIM
   *
   * @param requestParameters {@link GetESimParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getESimAsync(@NonNull GetESimParameters requestParameters)
    throws ApiError {
    return this.getESimAsync(requestParameters, null);
  }

  /**
   * Get eSIM
   *
   * @param requestParameters {@link GetESimParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getESimAsync(
    @NonNull GetESimParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getESimConfig, requestConfig);
    Request request = this.buildGetESimRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetESimRequest(
    @NonNull GetESimParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "esim"
    )
      .setHeader("Accept", requestParameters.getAccept())
      .setOptionalQueryParameter("iccid", requestParameters.getIccid())
      .build();
  }
}
