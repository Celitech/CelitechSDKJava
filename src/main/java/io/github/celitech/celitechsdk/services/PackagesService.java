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
import io.github.celitech.celitechsdk.models.ListPackagesOkResponse;
import io.github.celitech.celitechsdk.models.ListPackagesParameters;
import io.github.celitech.celitechsdk.models.Unauthorized;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
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
    return withRawResponse().listPackages(requestParameters, requestConfig).getData();
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
    return withRawResponse()
      .listPackagesAsync(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
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
      .setOptionalQueryParameter("dataLimitInGB", requestParameters.getDataLimitInGb())
      .setOptionalQueryParameter("startDate", requestParameters.getStartDate())
      .setOptionalQueryParameter("endDate", requestParameters.getEndDate())
      .setOptionalQueryParameter("afterCursor", requestParameters.getAfterCursor())
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("startTime", requestParameters.getStartTime())
      .setOptionalQueryParameter("endTime", requestParameters.getEndTime())
      .setOptionalQueryParameter("includeUnlimited", requestParameters.getIncludeUnlimited())
      .build();
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
   * Per-call accessor exposing raw-response variants of {@link PackagesService}'s methods.
   * Reuses the enclosing service's request builders and configuration.
   */
  public class WithRawResponse {

    /**
     * List Packages
     *
     * @return response of {@code CelitechResponse<ListPackagesOkResponse>}
     */
    public CelitechResponse<ListPackagesOkResponse> listPackages() throws ApiError {
      return this.listPackages(ListPackagesParameters.builder().build());
    }

    /**
     * List Packages
     *
     * @param requestParameters {@link ListPackagesParameters} Request Parameters Object
     * @return response of {@code CelitechResponse<ListPackagesOkResponse>}
     */
    public CelitechResponse<ListPackagesOkResponse> listPackages(
      @NonNull ListPackagesParameters requestParameters
    ) throws ApiError {
      return this.listPackages(requestParameters, null);
    }

    /**
     * List Packages
     *
     * @param requestParameters {@link ListPackagesParameters} Request Parameters Object
     * @return response of {@code CelitechResponse<ListPackagesOkResponse>}
     */
    public CelitechResponse<ListPackagesOkResponse> listPackages(
      @NonNull ListPackagesParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listPackagesConfig, requestConfig);
      addErrorMapping(400, BadRequest.class, (message, code, body, headers) ->
        new BadRequestError(message, (BadRequest) body, headers)
      );
      addErrorMapping(401, Unauthorized.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (Unauthorized) body, headers)
      );
      Request request = buildListPackagesRequest(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new CelitechResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<ListPackagesOkResponse>() {})
      );
    }

    /**
     * List Packages
     *
     * @return response of {@code CompletableFuture<CelitechResponse<ListPackagesOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<ListPackagesOkResponse>> listPackagesAsync()
      throws ApiError {
      return this.listPackagesAsync(ListPackagesParameters.builder().build());
    }

    /**
     * List Packages
     *
     * @param requestParameters {@link ListPackagesParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<CelitechResponse<ListPackagesOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<ListPackagesOkResponse>> listPackagesAsync(
      @NonNull ListPackagesParameters requestParameters
    ) throws ApiError {
      return this.listPackagesAsync(requestParameters, null);
    }

    /**
     * List Packages
     *
     * @param requestParameters {@link ListPackagesParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<CelitechResponse<ListPackagesOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<ListPackagesOkResponse>> listPackagesAsync(
      @NonNull ListPackagesParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listPackagesConfig, requestConfig);
      addErrorMapping(400, BadRequest.class, (message, code, body, headers) ->
        new BadRequestError(message, (BadRequest) body, headers)
      );
      addErrorMapping(401, Unauthorized.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (Unauthorized) body, headers)
      );
      Request request = buildListPackagesRequest(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new CelitechResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<ListPackagesOkResponse>() {})
        );
      });
    }
  }
}
