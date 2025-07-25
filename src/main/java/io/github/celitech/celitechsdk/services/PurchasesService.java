package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.exceptions.CreatePurchase400ResponseException;
import io.github.celitech.celitechsdk.exceptions.CreatePurchase401ResponseException;
import io.github.celitech.celitechsdk.exceptions.CreatePurchaseV2_400ResponseException;
import io.github.celitech.celitechsdk.exceptions.CreatePurchaseV2_401ResponseException;
import io.github.celitech.celitechsdk.exceptions.EditPurchase400ResponseException;
import io.github.celitech.celitechsdk.exceptions.EditPurchase401ResponseException;
import io.github.celitech.celitechsdk.exceptions.GetPurchaseConsumption400ResponseException;
import io.github.celitech.celitechsdk.exceptions.GetPurchaseConsumption401ResponseException;
import io.github.celitech.celitechsdk.exceptions.ListPurchases400ResponseException;
import io.github.celitech.celitechsdk.exceptions.ListPurchases401ResponseException;
import io.github.celitech.celitechsdk.exceptions.TopUpEsim400ResponseException;
import io.github.celitech.celitechsdk.exceptions.TopUpEsim401ResponseException;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.CreatePurchase400Response;
import io.github.celitech.celitechsdk.models.CreatePurchase401Response;
import io.github.celitech.celitechsdk.models.CreatePurchaseOkResponse;
import io.github.celitech.celitechsdk.models.CreatePurchaseRequest;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2OkResponse;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2Request;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2_400Response;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2_401Response;
import io.github.celitech.celitechsdk.models.EditPurchase400Response;
import io.github.celitech.celitechsdk.models.EditPurchase401Response;
import io.github.celitech.celitechsdk.models.EditPurchaseOkResponse;
import io.github.celitech.celitechsdk.models.EditPurchaseRequest;
import io.github.celitech.celitechsdk.models.GetPurchaseConsumption400Response;
import io.github.celitech.celitechsdk.models.GetPurchaseConsumption401Response;
import io.github.celitech.celitechsdk.models.GetPurchaseConsumptionOkResponse;
import io.github.celitech.celitechsdk.models.ListPurchases400Response;
import io.github.celitech.celitechsdk.models.ListPurchases401Response;
import io.github.celitech.celitechsdk.models.ListPurchasesOkResponse;
import io.github.celitech.celitechsdk.models.ListPurchasesParameters;
import io.github.celitech.celitechsdk.models.TopUpEsim400Response;
import io.github.celitech.celitechsdk.models.TopUpEsim401Response;
import io.github.celitech.celitechsdk.models.TopUpEsimOkResponse;
import io.github.celitech.celitechsdk.models.TopUpEsimRequest;
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

  public PurchasesService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Create Purchase V2
   *
   * @param createPurchaseV2Request {@link CreatePurchaseV2Request} Request Body
   * @return response of {@code List<CreatePurchaseV2OkResponse>}
   */
  public List<CreatePurchaseV2OkResponse> createPurchaseV2(@NonNull CreatePurchaseV2Request createPurchaseV2Request)
    throws ApiError, ValidationException {
    this.addErrorMapping(400, CreatePurchaseV2_400Response.class, CreatePurchaseV2_400ResponseException.class);
    this.addErrorMapping(401, CreatePurchaseV2_401Response.class, CreatePurchaseV2_401ResponseException.class);
    Request request = this.buildCreatePurchaseV2Request(createPurchaseV2Request);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<List<CreatePurchaseV2OkResponse>>() {});
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
    this.addErrorMapping(400, CreatePurchaseV2_400Response.class, CreatePurchaseV2_400ResponseException.class);
    this.addErrorMapping(401, CreatePurchaseV2_401Response.class, CreatePurchaseV2_401ResponseException.class);
    Request request = this.buildCreatePurchaseV2Request(createPurchaseV2Request);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<List<CreatePurchaseV2OkResponse>>() {})
    );
  }

  private Request buildCreatePurchaseV2Request(@NonNull CreatePurchaseV2Request createPurchaseV2Request)
    throws ValidationException {
    new ViolationAggregator()
      .add(new CreatePurchaseV2RequestValidator("createPurchaseV2Request").required().validate(createPurchaseV2Request))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
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
    this.addErrorMapping(400, ListPurchases400Response.class, ListPurchases400ResponseException.class);
    this.addErrorMapping(401, ListPurchases401Response.class, ListPurchases401ResponseException.class);
    Request request = this.buildListPurchasesRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ListPurchasesOkResponse>() {});
  }

  /**
   * List Purchases
   *
   * @return response of {@code CompletableFuture<ListPurchasesOkResponse>}
   */
  public CompletableFuture<ListPurchasesOkResponse> listPurchasesAsync() throws ApiError, ValidationException {
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
    this.addErrorMapping(400, ListPurchases400Response.class, ListPurchases400ResponseException.class);
    this.addErrorMapping(401, ListPurchases401Response.class, ListPurchases401ResponseException.class);
    Request request = this.buildListPurchasesRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ListPurchasesOkResponse>() {})
    );
  }

  private Request buildListPurchasesRequest(@NonNull ListPurchasesParameters requestParameters)
    throws ValidationException {
    new ViolationAggregator()
      .add(new ListPurchasesParametersValidator("requestParameters").optional().validate(requestParameters))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "purchases"
    )
      .setOptionalQueryParameter("iccid", requestParameters.getIccid())
      .setOptionalQueryParameter("afterDate", requestParameters.getAfterDate())
      .setOptionalQueryParameter("beforeDate", requestParameters.getBeforeDate())
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
  public CreatePurchaseOkResponse createPurchase(@NonNull CreatePurchaseRequest createPurchaseRequest) throws ApiError {
    this.addErrorMapping(400, CreatePurchase400Response.class, CreatePurchase400ResponseException.class);
    this.addErrorMapping(401, CreatePurchase401Response.class, CreatePurchase401ResponseException.class);
    Request request = this.buildCreatePurchaseRequest(createPurchaseRequest);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<CreatePurchaseOkResponse>() {});
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
    this.addErrorMapping(400, CreatePurchase400Response.class, CreatePurchase400ResponseException.class);
    this.addErrorMapping(401, CreatePurchase401Response.class, CreatePurchase401ResponseException.class);
    Request request = this.buildCreatePurchaseRequest(createPurchaseRequest);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<CreatePurchaseOkResponse>() {})
    );
  }

  private Request buildCreatePurchaseRequest(@NonNull CreatePurchaseRequest createPurchaseRequest) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
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
    this.addErrorMapping(400, TopUpEsim400Response.class, TopUpEsim400ResponseException.class);
    this.addErrorMapping(401, TopUpEsim401Response.class, TopUpEsim401ResponseException.class);
    Request request = this.buildTopUpEsimRequest(topUpEsimRequest);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<TopUpEsimOkResponse>() {});
  }

  /**
   * Top-up eSIM
   *
   * @param topUpEsimRequest {@link TopUpEsimRequest} Request Body
   * @return response of {@code CompletableFuture<TopUpEsimOkResponse>}
   */
  public CompletableFuture<TopUpEsimOkResponse> topUpEsimAsync(@NonNull TopUpEsimRequest topUpEsimRequest)
    throws ApiError, ValidationException {
    this.addErrorMapping(400, TopUpEsim400Response.class, TopUpEsim400ResponseException.class);
    this.addErrorMapping(401, TopUpEsim401Response.class, TopUpEsim401ResponseException.class);
    Request request = this.buildTopUpEsimRequest(topUpEsimRequest);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<TopUpEsimOkResponse>() {})
    );
  }

  private Request buildTopUpEsimRequest(@NonNull TopUpEsimRequest topUpEsimRequest) throws ValidationException {
    new ViolationAggregator()
      .add(new TopUpEsimRequestValidator("topUpEsimRequest").required().validate(topUpEsimRequest))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
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
  public EditPurchaseOkResponse editPurchase(@NonNull EditPurchaseRequest editPurchaseRequest) throws ApiError {
    this.addErrorMapping(400, EditPurchase400Response.class, EditPurchase400ResponseException.class);
    this.addErrorMapping(401, EditPurchase401Response.class, EditPurchase401ResponseException.class);
    Request request = this.buildEditPurchaseRequest(editPurchaseRequest);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<EditPurchaseOkResponse>() {});
  }

  /**
   * Edit Purchase
   *
   * @param editPurchaseRequest {@link EditPurchaseRequest} Request Body
   * @return response of {@code CompletableFuture<EditPurchaseOkResponse>}
   */
  public CompletableFuture<EditPurchaseOkResponse> editPurchaseAsync(@NonNull EditPurchaseRequest editPurchaseRequest)
    throws ApiError {
    this.addErrorMapping(400, EditPurchase400Response.class, EditPurchase400ResponseException.class);
    this.addErrorMapping(401, EditPurchase401Response.class, EditPurchase401ResponseException.class);
    Request request = this.buildEditPurchaseRequest(editPurchaseRequest);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<EditPurchaseOkResponse>() {})
    );
  }

  private Request buildEditPurchaseRequest(@NonNull EditPurchaseRequest editPurchaseRequest) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
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
  public GetPurchaseConsumptionOkResponse getPurchaseConsumption(@NonNull String purchaseId) throws ApiError {
    this.addErrorMapping(
        400,
        GetPurchaseConsumption400Response.class,
        GetPurchaseConsumption400ResponseException.class
      );
    this.addErrorMapping(
        401,
        GetPurchaseConsumption401Response.class,
        GetPurchaseConsumption401ResponseException.class
      );
    Request request = this.buildGetPurchaseConsumptionRequest(purchaseId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetPurchaseConsumptionOkResponse>() {});
  }

  /**
   * Get Purchase Consumption
   *
   * @param purchaseId String ID of the purchase
   * @return response of {@code CompletableFuture<GetPurchaseConsumptionOkResponse>}
   */
  public CompletableFuture<GetPurchaseConsumptionOkResponse> getPurchaseConsumptionAsync(@NonNull String purchaseId)
    throws ApiError {
    this.addErrorMapping(
        400,
        GetPurchaseConsumption400Response.class,
        GetPurchaseConsumption400ResponseException.class
      );
    this.addErrorMapping(
        401,
        GetPurchaseConsumption401Response.class,
        GetPurchaseConsumption401ResponseException.class
      );
    Request request = this.buildGetPurchaseConsumptionRequest(purchaseId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetPurchaseConsumptionOkResponse>() {})
    );
  }

  private Request buildGetPurchaseConsumptionRequest(@NonNull String purchaseId) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "purchases/{purchaseId}/consumption"
    )
      .setPathParameter("purchaseId", purchaseId)
      .build();
  }
}
