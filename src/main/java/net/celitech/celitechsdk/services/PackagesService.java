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
import net.celitech.celitechsdk.models.ListPackagesOkResponse;
import net.celitech.celitechsdk.models.ListPackagesParameters;
import net.celitech.celitechsdk.models.Unauthorized;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * PackagesService Service
 */
public class PackagesService extends BaseService {

  private RequestConfig listPackagesConfig;

  /**
   * Constructs a new instance of PackagesService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public PackagesService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code listPackages}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public PackagesService setListPackagesConfig(RequestConfig config) {
    this.listPackagesConfig = config;
    return this;
  }

  /**
   * List Packages
   *
   * @return response of {@code ListPackagesOkResponse}
   */
  public ListPackagesOkResponse listPackages() throws ApiError {
    return this.listPackages(ListPackagesParameters.builder().build());
  }

  /**
   * List Packages
   *
   * @param requestParameters {@link ListPackagesParameters} Request Parameters Object
   * @return response of {@code ListPackagesOkResponse}
   */
  public ListPackagesOkResponse listPackages(@NonNull ListPackagesParameters requestParameters)
    throws ApiError {
    return this.listPackages(requestParameters, null);
  }

  /**
   * List Packages
   *
   * @param requestParameters {@link ListPackagesParameters} Request Parameters Object
   * @return response of {@code ListPackagesOkResponse}
   */
  public ListPackagesOkResponse listPackages(
    @NonNull ListPackagesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listPackagesConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildListPackagesRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<ListPackagesOkResponse>() {});
  }

  /**
   * List Packages
   *
   * @return response of {@code CompletableFuture<ListPackagesOkResponse>}
   */
  public CompletableFuture<ListPackagesOkResponse> listPackagesAsync() throws ApiError {
    return this.listPackagesAsync(ListPackagesParameters.builder().build());
  }

  /**
   * List Packages
   *
   * @param requestParameters {@link ListPackagesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ListPackagesOkResponse>}
   */
  public CompletableFuture<ListPackagesOkResponse> listPackagesAsync(
    @NonNull ListPackagesParameters requestParameters
  ) throws ApiError {
    return this.listPackagesAsync(requestParameters, null);
  }

  /**
   * List Packages
   *
   * @param requestParameters {@link ListPackagesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ListPackagesOkResponse>}
   */
  public CompletableFuture<ListPackagesOkResponse> listPackagesAsync(
    @NonNull ListPackagesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listPackagesConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildListPackagesRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<ListPackagesOkResponse>() {});
    });
  }

  private Request buildListPackagesRequest(
    @NonNull ListPackagesParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "packages"
    )
      .setOptionalQueryParameter("destination", requestParameters.getDestination())
      .setOptionalQueryParameter("startDate", requestParameters.getStartDate())
      .setOptionalQueryParameter("endDate", requestParameters.getEndDate())
      .setOptionalQueryParameter("afterCursor", requestParameters.getAfterCursor())
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("startTime", requestParameters.getStartTime())
      .setOptionalQueryParameter("endTime", requestParameters.getEndTime())
      .build();
  }
}
