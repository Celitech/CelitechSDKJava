package net.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import net.celitech.celitechsdk.config.CelitechConfig;
import net.celitech.celitechsdk.config.RequestConfig;
import net.celitech.celitechsdk.exceptions.ApiError;
import net.celitech.celitechsdk.exceptions.BadRequestException;
import net.celitech.celitechsdk.exceptions.UnauthorizedException;
import net.celitech.celitechsdk.http.Environment;
import net.celitech.celitechsdk.http.HttpMethod;
import net.celitech.celitechsdk.http.ModelConverter;
import net.celitech.celitechsdk.http.util.RequestBuilder;
import net.celitech.celitechsdk.models.BadRequest;
import net.celitech.celitechsdk.models.ListDestinationsOkResponse;
import net.celitech.celitechsdk.models.Unauthorized;
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
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.listDestinationsConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildListDestinationsRequest(resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<ListDestinationsOkResponse>() {});
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
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.listDestinationsConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildListDestinationsRequest(resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<ListDestinationsOkResponse>() {});
    });
  }

  private Request buildListDestinationsRequest(RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "destinations"
    ).build();
  }
}
