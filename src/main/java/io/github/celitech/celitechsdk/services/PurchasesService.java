package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.exceptions.BadRequestError;
import io.github.celitech.celitechsdk.exceptions.ConflictError;
import io.github.celitech.celitechsdk.exceptions.ServiceUnavailableError;
import io.github.celitech.celitechsdk.exceptions.UnauthorizedError;
import io.github.celitech.celitechsdk.exceptions.UnprocessableEntityError;
import io.github.celitech.celitechsdk.http.CelitechResponse;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.CreatePurchaseOkResponse;
import io.github.celitech.celitechsdk.models.CreatePurchaseParameters;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2OkResponse;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2Parameters;
import io.github.celitech.celitechsdk.models.EditPurchaseOkResponse;
import io.github.celitech.celitechsdk.models.EditPurchaseParameters;
import io.github.celitech.celitechsdk.models.ErrorResponse;
import io.github.celitech.celitechsdk.models.GetPurchaseConsumptionOkResponse;
import io.github.celitech.celitechsdk.models.ListPurchasesOkResponse;
import io.github.celitech.celitechsdk.models.ListPurchasesParameters;
import io.github.celitech.celitechsdk.models.TopUpEsimOkResponse;
import io.github.celitech.celitechsdk.models.TopUpEsimParameters;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.exceptions.ValidationException;
import io.github.celitech.celitechsdk.validation.validators.modelValidators.CreatePurchaseParametersValidator;
import io.github.celitech.celitechsdk.validation.validators.modelValidators.CreatePurchaseV2ParametersValidator;
import io.github.celitech.celitechsdk.validation.validators.modelValidators.EditPurchaseParametersValidator;
import io.github.celitech.celitechsdk.validation.validators.modelValidators.ListPurchasesParametersValidator;
import io.github.celitech.celitechsdk.validation.validators.modelValidators.TopUpEsimParametersValidator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * PurchasesService Service
 */
public class PurchasesService extends BaseService {

  private RequestConfig createPurchaseV2Config;
  private RequestConfig listPurchasesConfig;
  private RequestConfig createPurchaseConfig;
  private RequestConfig topUpEsimConfig;
  private RequestConfig editPurchaseConfig;
  private RequestConfig getPurchaseConsumptionConfig;

  /**
   * Constructs a new instance of PurchasesService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public PurchasesService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code createPurchaseV2}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public PurchasesService setCreatePurchaseV2Config(RequestConfig config) {
    this.createPurchaseV2Config = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listPurchases}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public PurchasesService setListPurchasesConfig(RequestConfig config) {
    this.listPurchasesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createPurchase}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public PurchasesService setCreatePurchaseConfig(RequestConfig config) {
    this.createPurchaseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code topUpEsim}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public PurchasesService setTopUpEsimConfig(RequestConfig config) {
    this.topUpEsimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code editPurchase}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public PurchasesService setEditPurchaseConfig(RequestConfig config) {
    this.editPurchaseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getPurchaseConsumption}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public PurchasesService setGetPurchaseConsumptionConfig(RequestConfig config) {
    this.getPurchaseConsumptionConfig = config;
    return this;
  }

  /**
   * Create Purchase V2
   *
   * @param requestParameters {@link CreatePurchaseV2Parameters} Request Parameters Object
   * @return response of {@code List<CreatePurchaseV2OkResponse>}
   */
  public List<CreatePurchaseV2OkResponse> createPurchaseV2(
    @NonNull CreatePurchaseV2Parameters requestParameters
  ) throws ApiError, ValidationException {
    return this.createPurchaseV2(requestParameters, null);
  }

  /**
   * Create Purchase V2
   *
   * @param requestParameters {@link CreatePurchaseV2Parameters} Request Parameters Object
   * @return response of {@code List<CreatePurchaseV2OkResponse>}
   */
  public List<CreatePurchaseV2OkResponse> createPurchaseV2(
    @NonNull CreatePurchaseV2Parameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse().createPurchaseV2(requestParameters, requestConfig).getData();
  }

  /**
   * Create Purchase V2
   *
   * @param requestParameters {@link CreatePurchaseV2Parameters} Request Parameters Object
   * @return response of {@code CompletableFuture<List<CreatePurchaseV2OkResponse>>}
   */
  public CompletableFuture<List<CreatePurchaseV2OkResponse>> createPurchaseV2Async(
    @NonNull CreatePurchaseV2Parameters requestParameters
  ) throws ApiError, ValidationException {
    return this.createPurchaseV2Async(requestParameters, null);
  }

  /**
   * Create Purchase V2
   *
   * @param requestParameters {@link CreatePurchaseV2Parameters} Request Parameters Object
   * @return response of {@code CompletableFuture<List<CreatePurchaseV2OkResponse>>}
   */
  public CompletableFuture<List<CreatePurchaseV2OkResponse>> createPurchaseV2Async(
    @NonNull CreatePurchaseV2Parameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse()
      .createPurchaseV2Async(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreatePurchaseV2Request(
    @NonNull CreatePurchaseV2Parameters requestParameters,
    RequestConfig resolvedConfig
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new CreatePurchaseV2ParametersValidator("requestParameters")
          .required()
          .validate(requestParameters)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "purchases/v2"
    )
      .setOptionalHeader("Idempotency-Key", requestParameters.getIdempotencyKey())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }

  /**
   * List Purchases
   *
   * @return response of {@code ListPurchasesOkResponse}
   */
  public ListPurchasesOkResponse listPurchases() throws ApiError, ValidationException {
    return this.listPurchases(ListPurchasesParameters.builder().build());
  }

  /**
   * List Purchases
   *
   * @param requestParameters {@link ListPurchasesParameters} Request Parameters Object
   * @return response of {@code ListPurchasesOkResponse}
   */
  public ListPurchasesOkResponse listPurchases(@NonNull ListPurchasesParameters requestParameters)
    throws ApiError, ValidationException {
    return this.listPurchases(requestParameters, null);
  }

  /**
   * List Purchases
   *
   * @param requestParameters {@link ListPurchasesParameters} Request Parameters Object
   * @return response of {@code ListPurchasesOkResponse}
   */
  public ListPurchasesOkResponse listPurchases(
    @NonNull ListPurchasesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse().listPurchases(requestParameters, requestConfig).getData();
  }

  /**
   * List Purchases
   *
   * @return response of {@code CompletableFuture<ListPurchasesOkResponse>}
   */
  public CompletableFuture<ListPurchasesOkResponse> listPurchasesAsync()
    throws ApiError, ValidationException {
    return this.listPurchasesAsync(ListPurchasesParameters.builder().build());
  }

  /**
   * List Purchases
   *
   * @param requestParameters {@link ListPurchasesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ListPurchasesOkResponse>}
   */
  public CompletableFuture<ListPurchasesOkResponse> listPurchasesAsync(
    @NonNull ListPurchasesParameters requestParameters
  ) throws ApiError, ValidationException {
    return this.listPurchasesAsync(requestParameters, null);
  }

  /**
   * List Purchases
   *
   * @param requestParameters {@link ListPurchasesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ListPurchasesOkResponse>}
   */
  public CompletableFuture<ListPurchasesOkResponse> listPurchasesAsync(
    @NonNull ListPurchasesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse()
      .listPurchasesAsync(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListPurchasesRequest(
    @NonNull ListPurchasesParameters requestParameters,
    RequestConfig resolvedConfig
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new ListPurchasesParametersValidator("requestParameters")
          .optional()
          .validate(requestParameters)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "purchases"
    )
      .setOptionalQueryParameter("purchaseId", requestParameters.getPurchaseId())
      .setOptionalQueryParameter("iccid", requestParameters.getIccid())
      .setOptionalQueryParameter("afterDate", requestParameters.getAfterDate())
      .setOptionalQueryParameter("beforeDate", requestParameters.getBeforeDate())
      .setOptionalQueryParameter("email", requestParameters.getEmail())
      .setOptionalQueryParameter("referenceId", requestParameters.getReferenceId())
      .setOptionalQueryParameter("afterCursor", requestParameters.getAfterCursor())
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("after", requestParameters.getAfter())
      .setOptionalQueryParameter("before", requestParameters.getBefore())
      .build();
  }

  /**
   * Create Purchase
   *
   * @param requestParameters {@link CreatePurchaseParameters} Request Parameters Object
   * @return response of {@code CreatePurchaseOkResponse}
   */
  public CreatePurchaseOkResponse createPurchase(
    @NonNull CreatePurchaseParameters requestParameters
  ) throws ApiError, ValidationException {
    return this.createPurchase(requestParameters, null);
  }

  /**
   * Create Purchase
   *
   * @param requestParameters {@link CreatePurchaseParameters} Request Parameters Object
   * @return response of {@code CreatePurchaseOkResponse}
   */
  public CreatePurchaseOkResponse createPurchase(
    @NonNull CreatePurchaseParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse().createPurchase(requestParameters, requestConfig).getData();
  }

  /**
   * Create Purchase
   *
   * @param requestParameters {@link CreatePurchaseParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<CreatePurchaseOkResponse>}
   */
  public CompletableFuture<CreatePurchaseOkResponse> createPurchaseAsync(
    @NonNull CreatePurchaseParameters requestParameters
  ) throws ApiError, ValidationException {
    return this.createPurchaseAsync(requestParameters, null);
  }

  /**
   * Create Purchase
   *
   * @param requestParameters {@link CreatePurchaseParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<CreatePurchaseOkResponse>}
   */
  public CompletableFuture<CreatePurchaseOkResponse> createPurchaseAsync(
    @NonNull CreatePurchaseParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse()
      .createPurchaseAsync(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreatePurchaseRequest(
    @NonNull CreatePurchaseParameters requestParameters,
    RequestConfig resolvedConfig
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new CreatePurchaseParametersValidator("requestParameters")
          .required()
          .validate(requestParameters)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "purchases"
    )
      .setOptionalHeader("Idempotency-Key", requestParameters.getIdempotencyKey())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }

  /**
   * Top-up eSIM
   *
   * @param requestParameters {@link TopUpEsimParameters} Request Parameters Object
   * @return response of {@code TopUpEsimOkResponse}
   */
  public TopUpEsimOkResponse topUpEsim(@NonNull TopUpEsimParameters requestParameters)
    throws ApiError, ValidationException {
    return this.topUpEsim(requestParameters, null);
  }

  /**
   * Top-up eSIM
   *
   * @param requestParameters {@link TopUpEsimParameters} Request Parameters Object
   * @return response of {@code TopUpEsimOkResponse}
   */
  public TopUpEsimOkResponse topUpEsim(
    @NonNull TopUpEsimParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse().topUpEsim(requestParameters, requestConfig).getData();
  }

  /**
   * Top-up eSIM
   *
   * @param requestParameters {@link TopUpEsimParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<TopUpEsimOkResponse>}
   */
  public CompletableFuture<TopUpEsimOkResponse> topUpEsimAsync(
    @NonNull TopUpEsimParameters requestParameters
  ) throws ApiError, ValidationException {
    return this.topUpEsimAsync(requestParameters, null);
  }

  /**
   * Top-up eSIM
   *
   * @param requestParameters {@link TopUpEsimParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<TopUpEsimOkResponse>}
   */
  public CompletableFuture<TopUpEsimOkResponse> topUpEsimAsync(
    @NonNull TopUpEsimParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse()
      .topUpEsimAsync(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildTopUpEsimRequest(
    @NonNull TopUpEsimParameters requestParameters,
    RequestConfig resolvedConfig
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new TopUpEsimParametersValidator("requestParameters").required().validate(requestParameters)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "purchases/topup"
    )
      .setOptionalHeader("Idempotency-Key", requestParameters.getIdempotencyKey())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }

  /**
   * Edit Purchase
   *
   * @param requestParameters {@link EditPurchaseParameters} Request Parameters Object
   * @return response of {@code EditPurchaseOkResponse}
   */
  public EditPurchaseOkResponse editPurchase(@NonNull EditPurchaseParameters requestParameters)
    throws ApiError, ValidationException {
    return this.editPurchase(requestParameters, null);
  }

  /**
   * Edit Purchase
   *
   * @param requestParameters {@link EditPurchaseParameters} Request Parameters Object
   * @return response of {@code EditPurchaseOkResponse}
   */
  public EditPurchaseOkResponse editPurchase(
    @NonNull EditPurchaseParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse().editPurchase(requestParameters, requestConfig).getData();
  }

  /**
   * Edit Purchase
   *
   * @param requestParameters {@link EditPurchaseParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<EditPurchaseOkResponse>}
   */
  public CompletableFuture<EditPurchaseOkResponse> editPurchaseAsync(
    @NonNull EditPurchaseParameters requestParameters
  ) throws ApiError, ValidationException {
    return this.editPurchaseAsync(requestParameters, null);
  }

  /**
   * Edit Purchase
   *
   * @param requestParameters {@link EditPurchaseParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<EditPurchaseOkResponse>}
   */
  public CompletableFuture<EditPurchaseOkResponse> editPurchaseAsync(
    @NonNull EditPurchaseParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    return withRawResponse()
      .editPurchaseAsync(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildEditPurchaseRequest(
    @NonNull EditPurchaseParameters requestParameters,
    RequestConfig resolvedConfig
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new EditPurchaseParametersValidator("requestParameters")
          .required()
          .validate(requestParameters)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "purchases/edit"
    )
      .setOptionalHeader("Idempotency-Key", requestParameters.getIdempotencyKey())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }

  /**
   * Get Purchase Consumption
   *
   * @param purchaseId String ID of the purchase
   * @return response of {@code GetPurchaseConsumptionOkResponse}
   */
  public GetPurchaseConsumptionOkResponse getPurchaseConsumption(@NonNull String purchaseId)
    throws ApiError {
    return this.getPurchaseConsumption(purchaseId, null);
  }

  /**
   * Get Purchase Consumption
   *
   * @param purchaseId String ID of the purchase
   * @return response of {@code GetPurchaseConsumptionOkResponse}
   */
  public GetPurchaseConsumptionOkResponse getPurchaseConsumption(
    @NonNull String purchaseId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().getPurchaseConsumption(purchaseId, requestConfig).getData();
  }

  /**
   * Get Purchase Consumption
   *
   * @param purchaseId String ID of the purchase
   * @return response of {@code CompletableFuture<GetPurchaseConsumptionOkResponse>}
   */
  public CompletableFuture<GetPurchaseConsumptionOkResponse> getPurchaseConsumptionAsync(
    @NonNull String purchaseId
  ) throws ApiError {
    return this.getPurchaseConsumptionAsync(purchaseId, null);
  }

  /**
   * Get Purchase Consumption
   *
   * @param purchaseId String ID of the purchase
   * @return response of {@code CompletableFuture<GetPurchaseConsumptionOkResponse>}
   */
  public CompletableFuture<GetPurchaseConsumptionOkResponse> getPurchaseConsumptionAsync(
    @NonNull String purchaseId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .getPurchaseConsumptionAsync(purchaseId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetPurchaseConsumptionRequest(
    @NonNull String purchaseId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "purchases/{purchaseId}/consumption"
    )
      .setPathParameter("purchaseId", purchaseId)
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
   * Per-call accessor exposing raw-response variants of {@link PurchasesService}'s methods.
   * Reuses the enclosing service's request builders and configuration.
   */
  public class WithRawResponse {

    /**
     * Create Purchase V2
     *
     * @param requestParameters {@link CreatePurchaseV2Parameters} Request Parameters Object
     * @return response of {@code CelitechResponse<List<CreatePurchaseV2OkResponse>>}
     */
    public CelitechResponse<List<CreatePurchaseV2OkResponse>> createPurchaseV2(
      @NonNull CreatePurchaseV2Parameters requestParameters
    ) throws ApiError, ValidationException {
      return this.createPurchaseV2(requestParameters, null);
    }

    /**
     * Create Purchase V2
     *
     * @param requestParameters {@link CreatePurchaseV2Parameters} Request Parameters Object
     * @return response of {@code CelitechResponse<List<CreatePurchaseV2OkResponse>>}
     */
    public CelitechResponse<List<CreatePurchaseV2OkResponse>> createPurchaseV2(
      @NonNull CreatePurchaseV2Parameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(createPurchaseV2Config, requestConfig);
      addErrorMapping(400, ErrorResponse.class, (message, code, body, headers) ->
        new BadRequestError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(401, ErrorResponse.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(409, ErrorResponse.class, (message, code, body, headers) ->
        new ConflictError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(422, ErrorResponse.class, (message, code, body, headers) ->
        new UnprocessableEntityError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(503, ErrorResponse.class, (message, code, body, headers) ->
        new ServiceUnavailableError(message, (ErrorResponse) body, headers)
      );
      Request request = buildCreatePurchaseV2Request(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new CelitechResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<List<CreatePurchaseV2OkResponse>>() {})
      );
    }

    /**
     * Create Purchase V2
     *
     * @param requestParameters {@link CreatePurchaseV2Parameters} Request Parameters Object
     * @return response of {@code CompletableFuture<CelitechResponse<List<CreatePurchaseV2OkResponse>>>}
     */
    public CompletableFuture<
      CelitechResponse<List<CreatePurchaseV2OkResponse>>
    > createPurchaseV2Async(@NonNull CreatePurchaseV2Parameters requestParameters)
      throws ApiError, ValidationException {
      return this.createPurchaseV2Async(requestParameters, null);
    }

    /**
     * Create Purchase V2
     *
     * @param requestParameters {@link CreatePurchaseV2Parameters} Request Parameters Object
     * @return response of {@code CompletableFuture<CelitechResponse<List<CreatePurchaseV2OkResponse>>>}
     */
    public CompletableFuture<
      CelitechResponse<List<CreatePurchaseV2OkResponse>>
    > createPurchaseV2Async(
      @NonNull CreatePurchaseV2Parameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(createPurchaseV2Config, requestConfig);
      addErrorMapping(400, ErrorResponse.class, (message, code, body, headers) ->
        new BadRequestError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(401, ErrorResponse.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(409, ErrorResponse.class, (message, code, body, headers) ->
        new ConflictError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(422, ErrorResponse.class, (message, code, body, headers) ->
        new UnprocessableEntityError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(503, ErrorResponse.class, (message, code, body, headers) ->
        new ServiceUnavailableError(message, (ErrorResponse) body, headers)
      );
      Request request = buildCreatePurchaseV2Request(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new CelitechResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(
            bodyBytes,
            new TypeReference<List<CreatePurchaseV2OkResponse>>() {}
          )
        );
      });
    }

    /**
     * List Purchases
     *
     * @return response of {@code CelitechResponse<ListPurchasesOkResponse>}
     */
    public CelitechResponse<ListPurchasesOkResponse> listPurchases()
      throws ApiError, ValidationException {
      return this.listPurchases(ListPurchasesParameters.builder().build());
    }

    /**
     * List Purchases
     *
     * @param requestParameters {@link ListPurchasesParameters} Request Parameters Object
     * @return response of {@code CelitechResponse<ListPurchasesOkResponse>}
     */
    public CelitechResponse<ListPurchasesOkResponse> listPurchases(
      @NonNull ListPurchasesParameters requestParameters
    ) throws ApiError, ValidationException {
      return this.listPurchases(requestParameters, null);
    }

    /**
     * List Purchases
     *
     * @param requestParameters {@link ListPurchasesParameters} Request Parameters Object
     * @return response of {@code CelitechResponse<ListPurchasesOkResponse>}
     */
    public CelitechResponse<ListPurchasesOkResponse> listPurchases(
      @NonNull ListPurchasesParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(listPurchasesConfig, requestConfig);
      addErrorMapping(400, ErrorResponse.class, (message, code, body, headers) ->
        new BadRequestError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(401, ErrorResponse.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(409, ErrorResponse.class, (message, code, body, headers) ->
        new ConflictError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(422, ErrorResponse.class, (message, code, body, headers) ->
        new UnprocessableEntityError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(503, ErrorResponse.class, (message, code, body, headers) ->
        new ServiceUnavailableError(message, (ErrorResponse) body, headers)
      );
      Request request = buildListPurchasesRequest(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new CelitechResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<ListPurchasesOkResponse>() {})
      );
    }

    /**
     * List Purchases
     *
     * @return response of {@code CompletableFuture<CelitechResponse<ListPurchasesOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<ListPurchasesOkResponse>> listPurchasesAsync()
      throws ApiError, ValidationException {
      return this.listPurchasesAsync(ListPurchasesParameters.builder().build());
    }

    /**
     * List Purchases
     *
     * @param requestParameters {@link ListPurchasesParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<CelitechResponse<ListPurchasesOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<ListPurchasesOkResponse>> listPurchasesAsync(
      @NonNull ListPurchasesParameters requestParameters
    ) throws ApiError, ValidationException {
      return this.listPurchasesAsync(requestParameters, null);
    }

    /**
     * List Purchases
     *
     * @param requestParameters {@link ListPurchasesParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<CelitechResponse<ListPurchasesOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<ListPurchasesOkResponse>> listPurchasesAsync(
      @NonNull ListPurchasesParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(listPurchasesConfig, requestConfig);
      addErrorMapping(400, ErrorResponse.class, (message, code, body, headers) ->
        new BadRequestError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(401, ErrorResponse.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(409, ErrorResponse.class, (message, code, body, headers) ->
        new ConflictError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(422, ErrorResponse.class, (message, code, body, headers) ->
        new UnprocessableEntityError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(503, ErrorResponse.class, (message, code, body, headers) ->
        new ServiceUnavailableError(message, (ErrorResponse) body, headers)
      );
      Request request = buildListPurchasesRequest(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new CelitechResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<ListPurchasesOkResponse>() {})
        );
      });
    }

    /**
     * Create Purchase
     *
     * @param requestParameters {@link CreatePurchaseParameters} Request Parameters Object
     * @return response of {@code CelitechResponse<CreatePurchaseOkResponse>}
     */
    public CelitechResponse<CreatePurchaseOkResponse> createPurchase(
      @NonNull CreatePurchaseParameters requestParameters
    ) throws ApiError, ValidationException {
      return this.createPurchase(requestParameters, null);
    }

    /**
     * Create Purchase
     *
     * @param requestParameters {@link CreatePurchaseParameters} Request Parameters Object
     * @return response of {@code CelitechResponse<CreatePurchaseOkResponse>}
     */
    public CelitechResponse<CreatePurchaseOkResponse> createPurchase(
      @NonNull CreatePurchaseParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(createPurchaseConfig, requestConfig);
      addErrorMapping(400, ErrorResponse.class, (message, code, body, headers) ->
        new BadRequestError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(401, ErrorResponse.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(409, ErrorResponse.class, (message, code, body, headers) ->
        new ConflictError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(422, ErrorResponse.class, (message, code, body, headers) ->
        new UnprocessableEntityError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(503, ErrorResponse.class, (message, code, body, headers) ->
        new ServiceUnavailableError(message, (ErrorResponse) body, headers)
      );
      Request request = buildCreatePurchaseRequest(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new CelitechResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<CreatePurchaseOkResponse>() {})
      );
    }

    /**
     * Create Purchase
     *
     * @param requestParameters {@link CreatePurchaseParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<CelitechResponse<CreatePurchaseOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<CreatePurchaseOkResponse>> createPurchaseAsync(
      @NonNull CreatePurchaseParameters requestParameters
    ) throws ApiError, ValidationException {
      return this.createPurchaseAsync(requestParameters, null);
    }

    /**
     * Create Purchase
     *
     * @param requestParameters {@link CreatePurchaseParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<CelitechResponse<CreatePurchaseOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<CreatePurchaseOkResponse>> createPurchaseAsync(
      @NonNull CreatePurchaseParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(createPurchaseConfig, requestConfig);
      addErrorMapping(400, ErrorResponse.class, (message, code, body, headers) ->
        new BadRequestError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(401, ErrorResponse.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(409, ErrorResponse.class, (message, code, body, headers) ->
        new ConflictError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(422, ErrorResponse.class, (message, code, body, headers) ->
        new UnprocessableEntityError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(503, ErrorResponse.class, (message, code, body, headers) ->
        new ServiceUnavailableError(message, (ErrorResponse) body, headers)
      );
      Request request = buildCreatePurchaseRequest(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new CelitechResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<CreatePurchaseOkResponse>() {})
        );
      });
    }

    /**
     * Top-up eSIM
     *
     * @param requestParameters {@link TopUpEsimParameters} Request Parameters Object
     * @return response of {@code CelitechResponse<TopUpEsimOkResponse>}
     */
    public CelitechResponse<TopUpEsimOkResponse> topUpEsim(
      @NonNull TopUpEsimParameters requestParameters
    ) throws ApiError, ValidationException {
      return this.topUpEsim(requestParameters, null);
    }

    /**
     * Top-up eSIM
     *
     * @param requestParameters {@link TopUpEsimParameters} Request Parameters Object
     * @return response of {@code CelitechResponse<TopUpEsimOkResponse>}
     */
    public CelitechResponse<TopUpEsimOkResponse> topUpEsim(
      @NonNull TopUpEsimParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(topUpEsimConfig, requestConfig);
      addErrorMapping(400, ErrorResponse.class, (message, code, body, headers) ->
        new BadRequestError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(401, ErrorResponse.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(409, ErrorResponse.class, (message, code, body, headers) ->
        new ConflictError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(422, ErrorResponse.class, (message, code, body, headers) ->
        new UnprocessableEntityError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(503, ErrorResponse.class, (message, code, body, headers) ->
        new ServiceUnavailableError(message, (ErrorResponse) body, headers)
      );
      Request request = buildTopUpEsimRequest(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new CelitechResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<TopUpEsimOkResponse>() {})
      );
    }

    /**
     * Top-up eSIM
     *
     * @param requestParameters {@link TopUpEsimParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<CelitechResponse<TopUpEsimOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<TopUpEsimOkResponse>> topUpEsimAsync(
      @NonNull TopUpEsimParameters requestParameters
    ) throws ApiError, ValidationException {
      return this.topUpEsimAsync(requestParameters, null);
    }

    /**
     * Top-up eSIM
     *
     * @param requestParameters {@link TopUpEsimParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<CelitechResponse<TopUpEsimOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<TopUpEsimOkResponse>> topUpEsimAsync(
      @NonNull TopUpEsimParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(topUpEsimConfig, requestConfig);
      addErrorMapping(400, ErrorResponse.class, (message, code, body, headers) ->
        new BadRequestError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(401, ErrorResponse.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(409, ErrorResponse.class, (message, code, body, headers) ->
        new ConflictError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(422, ErrorResponse.class, (message, code, body, headers) ->
        new UnprocessableEntityError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(503, ErrorResponse.class, (message, code, body, headers) ->
        new ServiceUnavailableError(message, (ErrorResponse) body, headers)
      );
      Request request = buildTopUpEsimRequest(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new CelitechResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<TopUpEsimOkResponse>() {})
        );
      });
    }

    /**
     * Edit Purchase
     *
     * @param requestParameters {@link EditPurchaseParameters} Request Parameters Object
     * @return response of {@code CelitechResponse<EditPurchaseOkResponse>}
     */
    public CelitechResponse<EditPurchaseOkResponse> editPurchase(
      @NonNull EditPurchaseParameters requestParameters
    ) throws ApiError, ValidationException {
      return this.editPurchase(requestParameters, null);
    }

    /**
     * Edit Purchase
     *
     * @param requestParameters {@link EditPurchaseParameters} Request Parameters Object
     * @return response of {@code CelitechResponse<EditPurchaseOkResponse>}
     */
    public CelitechResponse<EditPurchaseOkResponse> editPurchase(
      @NonNull EditPurchaseParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(editPurchaseConfig, requestConfig);
      addErrorMapping(400, ErrorResponse.class, (message, code, body, headers) ->
        new BadRequestError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(401, ErrorResponse.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(409, ErrorResponse.class, (message, code, body, headers) ->
        new ConflictError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(422, ErrorResponse.class, (message, code, body, headers) ->
        new UnprocessableEntityError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(503, ErrorResponse.class, (message, code, body, headers) ->
        new ServiceUnavailableError(message, (ErrorResponse) body, headers)
      );
      Request request = buildEditPurchaseRequest(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new CelitechResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<EditPurchaseOkResponse>() {})
      );
    }

    /**
     * Edit Purchase
     *
     * @param requestParameters {@link EditPurchaseParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<CelitechResponse<EditPurchaseOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<EditPurchaseOkResponse>> editPurchaseAsync(
      @NonNull EditPurchaseParameters requestParameters
    ) throws ApiError, ValidationException {
      return this.editPurchaseAsync(requestParameters, null);
    }

    /**
     * Edit Purchase
     *
     * @param requestParameters {@link EditPurchaseParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<CelitechResponse<EditPurchaseOkResponse>>}
     */
    public CompletableFuture<CelitechResponse<EditPurchaseOkResponse>> editPurchaseAsync(
      @NonNull EditPurchaseParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError, ValidationException {
      RequestConfig resolvedConfig = getResolvedConfig(editPurchaseConfig, requestConfig);
      addErrorMapping(400, ErrorResponse.class, (message, code, body, headers) ->
        new BadRequestError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(401, ErrorResponse.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(409, ErrorResponse.class, (message, code, body, headers) ->
        new ConflictError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(422, ErrorResponse.class, (message, code, body, headers) ->
        new UnprocessableEntityError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(503, ErrorResponse.class, (message, code, body, headers) ->
        new ServiceUnavailableError(message, (ErrorResponse) body, headers)
      );
      Request request = buildEditPurchaseRequest(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new CelitechResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<EditPurchaseOkResponse>() {})
        );
      });
    }

    /**
     * Get Purchase Consumption
     *
     * @param purchaseId String ID of the purchase
     * @return response of {@code CelitechResponse<GetPurchaseConsumptionOkResponse>}
     */
    public CelitechResponse<GetPurchaseConsumptionOkResponse> getPurchaseConsumption(
      @NonNull String purchaseId
    ) throws ApiError {
      return this.getPurchaseConsumption(purchaseId, null);
    }

    /**
     * Get Purchase Consumption
     *
     * @param purchaseId String ID of the purchase
     * @return response of {@code CelitechResponse<GetPurchaseConsumptionOkResponse>}
     */
    public CelitechResponse<GetPurchaseConsumptionOkResponse> getPurchaseConsumption(
      @NonNull String purchaseId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getPurchaseConsumptionConfig, requestConfig);
      addErrorMapping(400, ErrorResponse.class, (message, code, body, headers) ->
        new BadRequestError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(401, ErrorResponse.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(409, ErrorResponse.class, (message, code, body, headers) ->
        new ConflictError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(422, ErrorResponse.class, (message, code, body, headers) ->
        new UnprocessableEntityError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(503, ErrorResponse.class, (message, code, body, headers) ->
        new ServiceUnavailableError(message, (ErrorResponse) body, headers)
      );
      Request request = buildGetPurchaseConsumptionRequest(purchaseId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new CelitechResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<GetPurchaseConsumptionOkResponse>() {})
      );
    }

    /**
     * Get Purchase Consumption
     *
     * @param purchaseId String ID of the purchase
     * @return response of {@code CompletableFuture<CelitechResponse<GetPurchaseConsumptionOkResponse>>}
     */
    public CompletableFuture<
      CelitechResponse<GetPurchaseConsumptionOkResponse>
    > getPurchaseConsumptionAsync(@NonNull String purchaseId) throws ApiError {
      return this.getPurchaseConsumptionAsync(purchaseId, null);
    }

    /**
     * Get Purchase Consumption
     *
     * @param purchaseId String ID of the purchase
     * @return response of {@code CompletableFuture<CelitechResponse<GetPurchaseConsumptionOkResponse>>}
     */
    public CompletableFuture<
      CelitechResponse<GetPurchaseConsumptionOkResponse>
    > getPurchaseConsumptionAsync(@NonNull String purchaseId, RequestConfig requestConfig)
      throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getPurchaseConsumptionConfig, requestConfig);
      addErrorMapping(400, ErrorResponse.class, (message, code, body, headers) ->
        new BadRequestError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(401, ErrorResponse.class, (message, code, body, headers) ->
        new UnauthorizedError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(409, ErrorResponse.class, (message, code, body, headers) ->
        new ConflictError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(422, ErrorResponse.class, (message, code, body, headers) ->
        new UnprocessableEntityError(message, (ErrorResponse) body, headers)
      );
      addErrorMapping(503, ErrorResponse.class, (message, code, body, headers) ->
        new ServiceUnavailableError(message, (ErrorResponse) body, headers)
      );
      Request request = buildGetPurchaseConsumptionRequest(purchaseId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new CelitechResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(
            bodyBytes,
            new TypeReference<GetPurchaseConsumptionOkResponse>() {}
          )
        );
      });
    }
  }
}
