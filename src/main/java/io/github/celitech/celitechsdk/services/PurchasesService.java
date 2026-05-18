package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.config.RequestConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.exceptions.BadRequestException;
import io.github.celitech.celitechsdk.exceptions.UnauthorizedException;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.BadRequest;
import io.github.celitech.celitechsdk.models.CreatePurchaseOkResponse;
import io.github.celitech.celitechsdk.models.CreatePurchaseRequest;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2OkResponse;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2Request;
import io.github.celitech.celitechsdk.models.EditPurchaseOkResponse;
import io.github.celitech.celitechsdk.models.EditPurchaseRequest;
import io.github.celitech.celitechsdk.models.GetPurchaseConsumptionOkResponse;
import io.github.celitech.celitechsdk.models.ListPurchasesOkResponse;
import io.github.celitech.celitechsdk.models.ListPurchasesParameters;
import io.github.celitech.celitechsdk.models.TopUpEsimOkResponse;
import io.github.celitech.celitechsdk.models.TopUpEsimRequest;
import io.github.celitech.celitechsdk.models.Unauthorized;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.exceptions.ValidationException;
import io.github.celitech.celitechsdk.validation.validators.modelValidators.CreatePurchaseV2RequestValidator;
import io.github.celitech.celitechsdk.validation.validators.modelValidators.ListPurchasesParametersValidator;
import io.github.celitech.celitechsdk.validation.validators.modelValidators.TopUpEsimRequestValidator;
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
   * @param createPurchaseV2Request {@link CreatePurchaseV2Request} Request Body
   * @return response of {@code List<CreatePurchaseV2OkResponse>}
   */
  public List<CreatePurchaseV2OkResponse> createPurchaseV2(
    @NonNull CreatePurchaseV2Request createPurchaseV2Request
  ) throws ApiError, ValidationException {
    return this.createPurchaseV2(createPurchaseV2Request, null);
  }

  /**
   * Create Purchase V2
   *
   * @param createPurchaseV2Request {@link CreatePurchaseV2Request} Request Body
   * @return response of {@code List<CreatePurchaseV2OkResponse>}
   */
  public List<CreatePurchaseV2OkResponse> createPurchaseV2(
    @NonNull CreatePurchaseV2Request createPurchaseV2Request,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.createPurchaseV2Config, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildCreatePurchaseV2Request(createPurchaseV2Request, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(
      bodyBytes,
      new TypeReference<List<CreatePurchaseV2OkResponse>>() {}
    );
  }

  /**
   * Create Purchase V2
   *
   * @param createPurchaseV2Request {@link CreatePurchaseV2Request} Request Body
   * @return response of {@code CompletableFuture<List<CreatePurchaseV2OkResponse>>}
   */
  public CompletableFuture<List<CreatePurchaseV2OkResponse>> createPurchaseV2Async(
    @NonNull CreatePurchaseV2Request createPurchaseV2Request
  ) throws ApiError, ValidationException {
    return this.createPurchaseV2Async(createPurchaseV2Request, null);
  }

  /**
   * Create Purchase V2
   *
   * @param createPurchaseV2Request {@link CreatePurchaseV2Request} Request Body
   * @return response of {@code CompletableFuture<List<CreatePurchaseV2OkResponse>>}
   */
  public CompletableFuture<List<CreatePurchaseV2OkResponse>> createPurchaseV2Async(
    @NonNull CreatePurchaseV2Request createPurchaseV2Request,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.createPurchaseV2Config, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildCreatePurchaseV2Request(createPurchaseV2Request, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(
        bodyBytes,
        new TypeReference<List<CreatePurchaseV2OkResponse>>() {}
      );
    });
  }

  private Request buildCreatePurchaseV2Request(
    @NonNull CreatePurchaseV2Request createPurchaseV2Request,
    RequestConfig resolvedConfig
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new CreatePurchaseV2RequestValidator("createPurchaseV2Request")
          .required()
          .validate(createPurchaseV2Request)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "purchases/v2"
    )
      .setJsonContent(createPurchaseV2Request)
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
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listPurchasesConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildListPurchasesRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<ListPurchasesOkResponse>() {});
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
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listPurchasesConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildListPurchasesRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<ListPurchasesOkResponse>() {});
    });
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
   * @param createPurchaseRequest {@link CreatePurchaseRequest} Request Body
   * @return response of {@code CreatePurchaseOkResponse}
   */
  public CreatePurchaseOkResponse createPurchase(
    @NonNull CreatePurchaseRequest createPurchaseRequest
  ) throws ApiError {
    return this.createPurchase(createPurchaseRequest, null);
  }

  /**
   * Create Purchase
   *
   * @param createPurchaseRequest {@link CreatePurchaseRequest} Request Body
   * @return response of {@code CreatePurchaseOkResponse}
   */
  public CreatePurchaseOkResponse createPurchase(
    @NonNull CreatePurchaseRequest createPurchaseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createPurchaseConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildCreatePurchaseRequest(createPurchaseRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<CreatePurchaseOkResponse>() {});
  }

  /**
   * Create Purchase
   *
   * @param createPurchaseRequest {@link CreatePurchaseRequest} Request Body
   * @return response of {@code CompletableFuture<CreatePurchaseOkResponse>}
   */
  public CompletableFuture<CreatePurchaseOkResponse> createPurchaseAsync(
    @NonNull CreatePurchaseRequest createPurchaseRequest
  ) throws ApiError {
    return this.createPurchaseAsync(createPurchaseRequest, null);
  }

  /**
   * Create Purchase
   *
   * @param createPurchaseRequest {@link CreatePurchaseRequest} Request Body
   * @return response of {@code CompletableFuture<CreatePurchaseOkResponse>}
   */
  public CompletableFuture<CreatePurchaseOkResponse> createPurchaseAsync(
    @NonNull CreatePurchaseRequest createPurchaseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createPurchaseConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildCreatePurchaseRequest(createPurchaseRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<CreatePurchaseOkResponse>() {});
    });
  }

  private Request buildCreatePurchaseRequest(
    @NonNull CreatePurchaseRequest createPurchaseRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "purchases"
    )
      .setJsonContent(createPurchaseRequest)
      .build();
  }

  /**
   * Top-up eSIM
   *
   * @param topUpEsimRequest {@link TopUpEsimRequest} Request Body
   * @return response of {@code TopUpEsimOkResponse}
   */
  public TopUpEsimOkResponse topUpEsim(@NonNull TopUpEsimRequest topUpEsimRequest)
    throws ApiError, ValidationException {
    return this.topUpEsim(topUpEsimRequest, null);
  }

  /**
   * Top-up eSIM
   *
   * @param topUpEsimRequest {@link TopUpEsimRequest} Request Body
   * @return response of {@code TopUpEsimOkResponse}
   */
  public TopUpEsimOkResponse topUpEsim(
    @NonNull TopUpEsimRequest topUpEsimRequest,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.topUpEsimConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildTopUpEsimRequest(topUpEsimRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<TopUpEsimOkResponse>() {});
  }

  /**
   * Top-up eSIM
   *
   * @param topUpEsimRequest {@link TopUpEsimRequest} Request Body
   * @return response of {@code CompletableFuture<TopUpEsimOkResponse>}
   */
  public CompletableFuture<TopUpEsimOkResponse> topUpEsimAsync(
    @NonNull TopUpEsimRequest topUpEsimRequest
  ) throws ApiError, ValidationException {
    return this.topUpEsimAsync(topUpEsimRequest, null);
  }

  /**
   * Top-up eSIM
   *
   * @param topUpEsimRequest {@link TopUpEsimRequest} Request Body
   * @return response of {@code CompletableFuture<TopUpEsimOkResponse>}
   */
  public CompletableFuture<TopUpEsimOkResponse> topUpEsimAsync(
    @NonNull TopUpEsimRequest topUpEsimRequest,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.topUpEsimConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildTopUpEsimRequest(topUpEsimRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<TopUpEsimOkResponse>() {});
    });
  }

  private Request buildTopUpEsimRequest(
    @NonNull TopUpEsimRequest topUpEsimRequest,
    RequestConfig resolvedConfig
  ) throws ValidationException {
    new ViolationAggregator()
      .add(new TopUpEsimRequestValidator("topUpEsimRequest").required().validate(topUpEsimRequest))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "purchases/topup"
    )
      .setJsonContent(topUpEsimRequest)
      .build();
  }

  /**
   * Edit Purchase
   *
   * @param editPurchaseRequest {@link EditPurchaseRequest} Request Body
   * @return response of {@code EditPurchaseOkResponse}
   */
  public EditPurchaseOkResponse editPurchase(@NonNull EditPurchaseRequest editPurchaseRequest)
    throws ApiError {
    return this.editPurchase(editPurchaseRequest, null);
  }

  /**
   * Edit Purchase
   *
   * @param editPurchaseRequest {@link EditPurchaseRequest} Request Body
   * @return response of {@code EditPurchaseOkResponse}
   */
  public EditPurchaseOkResponse editPurchase(
    @NonNull EditPurchaseRequest editPurchaseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.editPurchaseConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildEditPurchaseRequest(editPurchaseRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<EditPurchaseOkResponse>() {});
  }

  /**
   * Edit Purchase
   *
   * @param editPurchaseRequest {@link EditPurchaseRequest} Request Body
   * @return response of {@code CompletableFuture<EditPurchaseOkResponse>}
   */
  public CompletableFuture<EditPurchaseOkResponse> editPurchaseAsync(
    @NonNull EditPurchaseRequest editPurchaseRequest
  ) throws ApiError {
    return this.editPurchaseAsync(editPurchaseRequest, null);
  }

  /**
   * Edit Purchase
   *
   * @param editPurchaseRequest {@link EditPurchaseRequest} Request Body
   * @return response of {@code CompletableFuture<EditPurchaseOkResponse>}
   */
  public CompletableFuture<EditPurchaseOkResponse> editPurchaseAsync(
    @NonNull EditPurchaseRequest editPurchaseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.editPurchaseConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildEditPurchaseRequest(editPurchaseRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<EditPurchaseOkResponse>() {});
    });
  }

  private Request buildEditPurchaseRequest(
    @NonNull EditPurchaseRequest editPurchaseRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "purchases/edit"
    )
      .setJsonContent(editPurchaseRequest)
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
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getPurchaseConsumptionConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildGetPurchaseConsumptionRequest(purchaseId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(
      bodyBytes,
      new TypeReference<GetPurchaseConsumptionOkResponse>() {}
    );
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
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getPurchaseConsumptionConfig, requestConfig);
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildGetPurchaseConsumptionRequest(purchaseId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(
        bodyBytes,
        new TypeReference<GetPurchaseConsumptionOkResponse>() {}
      );
    });
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
}
