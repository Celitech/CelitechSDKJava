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
import io.github.celitech.celitechsdk.models.GetEsimDeviceOkResponse;
import io.github.celitech.celitechsdk.models.GetEsimHistoryOkResponse;
import io.github.celitech.celitechsdk.models.GetEsimOkResponse;
import io.github.celitech.celitechsdk.models.GetEsimParameters;
import io.github.celitech.celitechsdk.models.Unauthorized;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.exceptions.ValidationException;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;
import io.github.celitech.celitechsdk.validation.validators.modelValidators.GetEsimParametersValidator;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ESimService Service
 */
public class ESimService extends BaseService {

  private RequestConfig getEsimConfig;
  private RequestConfig getEsimDeviceConfig;
  private RequestConfig getEsimHistoryConfig;

  /**
   * Constructs a new instance of ESimService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public ESimService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getEsim}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ESimService setGetEsimConfig(RequestConfig config) {
    this.getEsimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getEsimDevice}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ESimService setGetEsimDeviceConfig(RequestConfig config) {
    this.getEsimDeviceConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getEsimHistory}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ESimService setGetEsimHistoryConfig(RequestConfig config) {
    this.getEsimHistoryConfig = config;
    return this;
  }

  /**
   * Get eSIM
   *
   * @param requestParameters {@link GetEsimParameters} Request Parameters Object
   * @return response of {@code GetEsimOkResponse}
   */
  public GetEsimOkResponse getEsim(@NonNull GetEsimParameters requestParameters)
    throws ApiError, ValidationException {
    return this.getEsim(requestParameters, null);
  }

  /**
   * Get eSIM
   *
   * @param requestParameters {@link GetEsimParameters} Request Parameters Object
   * @return response of {@code GetEsimOkResponse}
   */
  public GetEsimOkResponse getEsim(
    @NonNull GetEsimParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse().getEsim(requestParameters, requestConfig).getData();
  }

  /**
   * Get eSIM
   *
   * @param requestParameters {@link GetEsimParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<GetEsimOkResponse>}
   */
  public CompletableFuture<GetEsimOkResponse> getEsimAsync(
    @NonNull GetEsimParameters requestParameters
  ) throws ApiError, ValidationException {
    return this.getEsimAsync(requestParameters, null);
  }

  /**
   * Get eSIM
   *
   * @param requestParameters {@link GetEsimParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<GetEsimOkResponse>}
   */
  public CompletableFuture<GetEsimOkResponse> getEsimAsync(
    @NonNull GetEsimParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse()
      .getEsimAsync(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetEsimRequest(
    @NonNull GetEsimParameters requestParameters,
    RequestConfig resolvedConfig
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new GetEsimParametersValidator("requestParameters").required().validate(requestParameters)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "esim"
    )
      .setQueryParameter("iccid", requestParameters.getIccid())
      .build();
  }

  /**
   * Get eSIM Device
   *
   * @param iccid String ID of the eSIM
   * @return response of {@code GetEsimDeviceOkResponse}
   */
  public GetEsimDeviceOkResponse getEsimDevice(@NonNull String iccid)
    throws ApiError, ValidationException {
    return this.getEsimDevice(iccid, null);
  }

  /**
   * Get eSIM Device
   *
   * @param iccid String ID of the eSIM
   * @return response of {@code GetEsimDeviceOkResponse}
   */
  public GetEsimDeviceOkResponse getEsimDevice(@NonNull String iccid, RequestConfig requestConfig)
    throws ApiError, ValidationException {
    return withRawResponse().getEsimDevice(iccid, requestConfig).getData();
  }

  /**
   * Get eSIM Device
   *
   * @param iccid String ID of the eSIM
   * @return response of {@code CompletableFuture<GetEsimDeviceOkResponse>}
   */
  public CompletableFuture<GetEsimDeviceOkResponse> getEsimDeviceAsync(@NonNull String iccid)
    throws ApiError, ValidationException {
    return this.getEsimDeviceAsync(iccid, null);
  }

  /**
   * Get eSIM Device
   *
   * @param iccid String ID of the eSIM
   * @return response of {@code CompletableFuture<GetEsimDeviceOkResponse>}
   */
  public CompletableFuture<GetEsimDeviceOkResponse> getEsimDeviceAsync(
    @NonNull String iccid,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse()
      .getEsimDeviceAsync(iccid, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetEsimDeviceRequest(@NonNull String iccid, RequestConfig resolvedConfig)
    throws ValidationException {
    new ViolationAggregator()
      .add(new StringValidator("iccid").minLength(18).maxLength(22).required().validate(iccid))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "esim/{iccid}/device"
    )
      .setPathParameter("iccid", iccid)
      .build();
  }

  /**
   * Get eSIM History
   *
   * @param iccid String ID of the eSIM
   * @return response of {@code GetEsimHistoryOkResponse}
   */
  public GetEsimHistoryOkResponse getEsimHistory(@NonNull String iccid)
    throws ApiError, ValidationException {
    return this.getEsimHistory(iccid, null);
  }

  /**
   * Get eSIM History
   *
   * @param iccid String ID of the eSIM
   * @return response of {@code GetEsimHistoryOkResponse}
   */
  public GetEsimHistoryOkResponse getEsimHistory(
    @NonNull String iccid,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse().getEsimHistory(iccid, requestConfig).getData();
  }

  /**
   * Get eSIM History
   *
   * @param iccid String ID of the eSIM
   * @return response of {@code CompletableFuture<GetEsimHistoryOkResponse>}
   */
  public CompletableFuture<GetEsimHistoryOkResponse> getEsimHistoryAsync(@NonNull String iccid)
    throws ApiError, ValidationException {
    return this.getEsimHistoryAsync(iccid, null);
  }

  /**
   * Get eSIM History
   *
   * @param iccid String ID of the eSIM
   * @return response of {@code CompletableFuture<GetEsimHistoryOkResponse>}
   */
  public CompletableFuture<GetEsimHistoryOkResponse> getEsimHistoryAsync(
    @NonNull String iccid,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse()
      .getEsimHistoryAsync(iccid, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetEsimHistoryRequest(@NonNull String iccid, RequestConfig resolvedConfig)
    throws ValidationException {
    new ViolationAggregator()
      .add(new StringValidator("iccid").minLength(18).maxLength(22).required().validate(iccid))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "esim/{iccid}/history"
    )
      .setPathParameter("iccid", iccid)
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
   * Per-call accessor exposing raw-response variants of {@link ESimService}'s methods.
   * Reuses the enclosing service's request builders and configuration.
   */
  public class WithRawResponse {

    /**
     * Get eSIM
     *
     * @param requestParameters {@link GetEsimParameters} Request Parameters Object
     * @return response of {@code CelitechResponse<GetEsimOkResponse>}
     */
    public CelitechResponse<GetEsimOkResponse> getEsim(
      @NonNull GetEsimParameters requestParameters
    ) throws ApiError, ValidationException {
      return this.getEsim(requestParameters, null);
    }

    /**
     * Get eSIM
     *
     * @param requestParameters {@link GetEsimParameters} Request Parameters Object
     * @return response of {@code CelitechResponse<GetEsimOkResponse>}
     */
    public CelitechResponse<GetEsimOkResponse> getEsim(
      @NonNull GetEsimParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(getEsimConfig, requestConfig);
      addErrorMapping(400, BadRequest.class, (message, code, body, headers) ->
        new BadRequestError(message, (BadRequest) body, headers)
      );
      addErrorMapping(401, Unauthorized.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (Unauthorized) body, headers)
      );
      Request request = buildGetEsimRequest(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new CelitechResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<GetEsimOkResponse>() {})
      );
    }

    /**
     * Get eSIM
     *
     * @param requestParameters {@link GetEsimParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<CelitechResponse<GetEsimOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<GetEsimOkResponse>> getEsimAsync(
      @NonNull GetEsimParameters requestParameters
    ) throws ApiError, ValidationException {
      return this.getEsimAsync(requestParameters, null);
    }

    /**
     * Get eSIM
     *
     * @param requestParameters {@link GetEsimParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<CelitechResponse<GetEsimOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<GetEsimOkResponse>> getEsimAsync(
      @NonNull GetEsimParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(getEsimConfig, requestConfig);
      addErrorMapping(400, BadRequest.class, (message, code, body, headers) ->
        new BadRequestError(message, (BadRequest) body, headers)
      );
      addErrorMapping(401, Unauthorized.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (Unauthorized) body, headers)
      );
      Request request = buildGetEsimRequest(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new CelitechResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<GetEsimOkResponse>() {})
        );
      });
    }

    /**
     * Get eSIM Device
     *
     * @param iccid String ID of the eSIM
     * @return response of {@code CelitechResponse<GetEsimDeviceOkResponse>}
     */
    public CelitechResponse<GetEsimDeviceOkResponse> getEsimDevice(@NonNull String iccid)
      throws ApiError, ValidationException {
      return this.getEsimDevice(iccid, null);
    }

    /**
     * Get eSIM Device
     *
     * @param iccid String ID of the eSIM
     * @return response of {@code CelitechResponse<GetEsimDeviceOkResponse>}
     */
    public CelitechResponse<GetEsimDeviceOkResponse> getEsimDevice(
      @NonNull String iccid,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(getEsimDeviceConfig, requestConfig);
      addErrorMapping(400, BadRequest.class, (message, code, body, headers) ->
        new BadRequestError(message, (BadRequest) body, headers)
      );
      addErrorMapping(401, Unauthorized.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (Unauthorized) body, headers)
      );
      Request request = buildGetEsimDeviceRequest(iccid, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new CelitechResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<GetEsimDeviceOkResponse>() {})
      );
    }

    /**
     * Get eSIM Device
     *
     * @param iccid String ID of the eSIM
     * @return response of {@code CompletableFuture<CelitechResponse<GetEsimDeviceOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<GetEsimDeviceOkResponse>> getEsimDeviceAsync(
      @NonNull String iccid
    ) throws ApiError, ValidationException {
      return this.getEsimDeviceAsync(iccid, null);
    }

    /**
     * Get eSIM Device
     *
     * @param iccid String ID of the eSIM
     * @return response of {@code CompletableFuture<CelitechResponse<GetEsimDeviceOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<GetEsimDeviceOkResponse>> getEsimDeviceAsync(
      @NonNull String iccid,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(getEsimDeviceConfig, requestConfig);
      addErrorMapping(400, BadRequest.class, (message, code, body, headers) ->
        new BadRequestError(message, (BadRequest) body, headers)
      );
      addErrorMapping(401, Unauthorized.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (Unauthorized) body, headers)
      );
      Request request = buildGetEsimDeviceRequest(iccid, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new CelitechResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<GetEsimDeviceOkResponse>() {})
        );
      });
    }

    /**
     * Get eSIM History
     *
     * @param iccid String ID of the eSIM
     * @return response of {@code CelitechResponse<GetEsimHistoryOkResponse>}
     */
    public CelitechResponse<GetEsimHistoryOkResponse> getEsimHistory(@NonNull String iccid)
      throws ApiError, ValidationException {
      return this.getEsimHistory(iccid, null);
    }

    /**
     * Get eSIM History
     *
     * @param iccid String ID of the eSIM
     * @return response of {@code CelitechResponse<GetEsimHistoryOkResponse>}
     */
    public CelitechResponse<GetEsimHistoryOkResponse> getEsimHistory(
      @NonNull String iccid,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(getEsimHistoryConfig, requestConfig);
      addErrorMapping(400, BadRequest.class, (message, code, body, headers) ->
        new BadRequestError(message, (BadRequest) body, headers)
      );
      addErrorMapping(401, Unauthorized.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (Unauthorized) body, headers)
      );
      Request request = buildGetEsimHistoryRequest(iccid, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new CelitechResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<GetEsimHistoryOkResponse>() {})
      );
    }

    /**
     * Get eSIM History
     *
     * @param iccid String ID of the eSIM
     * @return response of {@code CompletableFuture<CelitechResponse<GetEsimHistoryOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<GetEsimHistoryOkResponse>> getEsimHistoryAsync(
      @NonNull String iccid
    ) throws ApiError, ValidationException {
      return this.getEsimHistoryAsync(iccid, null);
    }

    /**
     * Get eSIM History
     *
     * @param iccid String ID of the eSIM
     * @return response of {@code CompletableFuture<CelitechResponse<GetEsimHistoryOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<GetEsimHistoryOkResponse>> getEsimHistoryAsync(
      @NonNull String iccid,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(getEsimHistoryConfig, requestConfig);
      addErrorMapping(400, BadRequest.class, (message, code, body, headers) ->
        new BadRequestError(message, (BadRequest) body, headers)
      );
      addErrorMapping(401, Unauthorized.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (Unauthorized) body, headers)
      );
      Request request = buildGetEsimHistoryRequest(iccid, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new CelitechResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<GetEsimHistoryOkResponse>() {})
        );
      });
    }
  }
}
