package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.ListDestinationsParameters;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * DestinationsService Service
 */
public class DestinationsService extends BaseService {

  private RequestConfig listDestinationsConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();

  /**
   * Constructs a new instance of DestinationsService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public DestinationsService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code listDestinations}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public DestinationsService setListDestinationsConfig(RequestConfig config) {
    this.listDestinationsConfig = config;
    return this;
  }

  /**
   * List Destinations
   *
   * @param requestParameters {@link ListDestinationsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listDestinations(@NonNull ListDestinationsParameters requestParameters)
    throws ApiError {
    return this.listDestinations(requestParameters, null);
  }

  /**
   * List Destinations
   *
   * @param requestParameters {@link ListDestinationsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listDestinations(
    @NonNull ListDestinationsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.listDestinationsConfig, requestConfig);
    Request request = this.buildListDestinationsRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * List Destinations
   *
   * @param requestParameters {@link ListDestinationsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listDestinationsAsync(
    @NonNull ListDestinationsParameters requestParameters
  ) throws ApiError {
    return this.listDestinationsAsync(requestParameters, null);
  }

  /**
   * List Destinations
   *
   * @param requestParameters {@link ListDestinationsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listDestinationsAsync(
    @NonNull ListDestinationsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.listDestinationsConfig, requestConfig);
    Request request = this.buildListDestinationsRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildListDestinationsRequest(
    @NonNull ListDestinationsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "destinations"
    )
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
