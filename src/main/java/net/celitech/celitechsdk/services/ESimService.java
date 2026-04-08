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
import net.celitech.celitechsdk.models.GetEsimDeviceOkResponse;
import net.celitech.celitechsdk.models.GetEsimHistoryOkResponse;
import net.celitech.celitechsdk.models.GetEsimOkResponse;
import net.celitech.celitechsdk.models.GetEsimParameters;
import net.celitech.celitechsdk.models.Unauthorized;
import net.celitech.celitechsdk.validation.ViolationAggregator;
import net.celitech.celitechsdk.validation.exceptions.ValidationException;
import net.celitech.celitechsdk.validation.validators.StringValidator;
import net.celitech.celitechsdk.validation.validators.modelValidators.GetEsimParametersValidator;
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
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getEsimConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildGetEsimRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<GetEsimOkResponse>() {});
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
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getEsimConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildGetEsimRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<GetEsimOkResponse>() {});
    });
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
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getEsimDeviceConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildGetEsimDeviceRequest(iccid, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<GetEsimDeviceOkResponse>() {});
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
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getEsimDeviceConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildGetEsimDeviceRequest(iccid, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<GetEsimDeviceOkResponse>() {});
    });
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
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getEsimHistoryConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildGetEsimHistoryRequest(iccid, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<GetEsimHistoryOkResponse>() {});
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
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getEsimHistoryConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildGetEsimHistoryRequest(iccid, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<GetEsimHistoryOkResponse>() {});
    });
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
}
