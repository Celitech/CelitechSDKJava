package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.exceptions.BadRequestError;
import io.github.celitech.celitechsdk.exceptions.UnauthorizedError;
import io.github.celitech.celitechsdk.http.CelitechResponse;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.BadRequest;
import io.github.celitech.celitechsdk.models.ListDestinationsOkResponse;
import io.github.celitech.celitechsdk.models.Unauthorized;
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

  private RequestConfig listDestinationsConfig;

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
   * @return response of {@code ListDestinationsOkResponse}
   */
  public ListDestinationsOkResponse listDestinations() throws ApiError {
    return this.listDestinations(null);
  }

  /**
   * List Destinations
   *
   * @return response of {@code ListDestinationsOkResponse}
   */
  public ListDestinationsOkResponse listDestinations(RequestConfig requestConfig) throws ApiError {
    return withRawResponse().listDestinations(requestConfig).getData();
  }

  /**
   * List Destinations
   *
   * @return response of {@code CompletableFuture<ListDestinationsOkResponse>}
   */
  public CompletableFuture<ListDestinationsOkResponse> listDestinationsAsync() throws ApiError {
    return this.listDestinationsAsync(null);
  }

  /**
   * List Destinations
   *
   * @return response of {@code CompletableFuture<ListDestinationsOkResponse>}
   */
  public CompletableFuture<ListDestinationsOkResponse> listDestinationsAsync(
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .listDestinationsAsync(requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListDestinationsRequest(RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "destinations"
    ).build();
  }

  /**
   * Returns an accessor whose methods mirror this service but return the full HTTP response
   * (status code, headers, and raw body) wrapped alongside the parsed data.
   *
   * @return An accessor exposing raw-response variants of this service's methods
   */
  public WithRawResponse withRawResponse() {
    return new WithRawResponse();
  }

  /**
   * Per-call accessor exposing raw-response variants of {@link DestinationsService}'s methods.
   * Reuses the enclosing service's request builders and configuration.
   */
  public class WithRawResponse {

    /**
     * List Destinations
     *
     * @return response of {@code CelitechResponse<ListDestinationsOkResponse>}
     */
    public CelitechResponse<ListDestinationsOkResponse> listDestinations() throws ApiError {
      return this.listDestinations(null);
    }

    /**
     * List Destinations
     *
     * @return response of {@code CelitechResponse<ListDestinationsOkResponse>}
     */
    public CelitechResponse<ListDestinationsOkResponse> listDestinations(
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listDestinationsConfig, requestConfig);
      addErrorMapping(400, BadRequest.class, (message, code, body, headers) ->
        new BadRequestError(message, (BadRequest) body, headers)
      );
      addErrorMapping(401, Unauthorized.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (Unauthorized) body, headers)
      );
      Request request = buildListDestinationsRequest(resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new CelitechResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<ListDestinationsOkResponse>() {})
      );
    }

    /**
     * List Destinations
     *
     * @return response of {@code CompletableFuture<CelitechResponse<ListDestinationsOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<ListDestinationsOkResponse>> listDestinationsAsync()
      throws ApiError {
      return this.listDestinationsAsync(null);
    }

    /**
     * List Destinations
     *
     * @return response of {@code CompletableFuture<CelitechResponse<ListDestinationsOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<ListDestinationsOkResponse>> listDestinationsAsync(
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listDestinationsConfig, requestConfig);
      addErrorMapping(400, BadRequest.class, (message, code, body, headers) ->
        new BadRequestError(message, (BadRequest) body, headers)
      );
      addErrorMapping(401, Unauthorized.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (Unauthorized) body, headers)
      );
      Request request = buildListDestinationsRequest(resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new CelitechResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<ListDestinationsOkResponse>() {})
        );
      });
    }
  }
}
