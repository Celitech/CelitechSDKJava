package io.github.Celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.Celitech.celitechsdk.exceptions.ApiException;
import io.github.Celitech.celitechsdk.http.HttpMethod;
import io.github.Celitech.celitechsdk.http.ModelConverter;
import io.github.Celitech.celitechsdk.http.util.RequestBuilder;
import io.github.Celitech.celitechsdk.models.CreatePurchaseOkResponse;
import io.github.Celitech.celitechsdk.models.CreatePurchaseRequest;
import io.github.Celitech.celitechsdk.models.EditPurchaseOkResponse;
import io.github.Celitech.celitechsdk.models.EditPurchaseRequest;
import io.github.Celitech.celitechsdk.models.GetPurchaseConsumptionOkResponse;
import io.github.Celitech.celitechsdk.models.ListPurchasesOkResponse;
import io.github.Celitech.celitechsdk.models.ListPurchasesParameters;
import io.github.Celitech.celitechsdk.models.TopUpEsimOkResponse;
import io.github.Celitech.celitechsdk.models.TopUpEsimRequest;
import io.github.Celitech.celitechsdk.validation.ViolationAggregator;
import io.github.Celitech.celitechsdk.validation.exceptions.ValidationException;
import io.github.Celitech.celitechsdk.validation.validators.modelValidators.ListPurchasesParametersValidator;
import io.github.Celitech.celitechsdk.validation.validators.modelValidators.TopUpEsimRequestValidator;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * PurchasesService Service
 */
public class PurchasesService extends BaseService {

  public PurchasesService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * List Purchases
   *
   * @return response of {@code ListPurchasesOkResponse}
   */
  public ListPurchasesOkResponse listPurchases() throws ApiException, ValidationException {
    return this.listPurchases(ListPurchasesParameters.builder().build());
  }

  /**
   * List Purchases
   *
   * @param requestParameters {@link ListPurchasesParameters} Request Parameters Object
   * @return response of {@code ListPurchasesOkResponse}
   */
  public ListPurchasesOkResponse listPurchases(@NonNull ListPurchasesParameters requestParameters)
    throws ApiException, ValidationException {
    Request request = this.buildListPurchasesRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ListPurchasesOkResponse>() {});
  }

  /**
   * List Purchases
   *
   * @return response of {@code CompletableFuture<ListPurchasesOkResponse>}
   */
  public CompletableFuture<ListPurchasesOkResponse> listPurchasesAsync() throws ApiException, ValidationException {
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
  ) throws ApiException, ValidationException {
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
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "purchases")
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
  public CreatePurchaseOkResponse createPurchase(@NonNull CreatePurchaseRequest createPurchaseRequest)
    throws ApiException {
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
  ) throws ApiException {
    Request request = this.buildCreatePurchaseRequest(createPurchaseRequest);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<CreatePurchaseOkResponse>() {})
    );
  }

  private Request buildCreatePurchaseRequest(@NonNull CreatePurchaseRequest createPurchaseRequest) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "purchases")
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
    throws ApiException, ValidationException {
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
    throws ApiException, ValidationException {
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
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "purchases/topup")
      .setJsonContent(topUpEsimRequest)
      .build();
  }

  /**
   * Edit Purchase
   *
   * @param editPurchaseRequest {@link EditPurchaseRequest} Request Body
   * @return response of {@code EditPurchaseOkResponse}
   */
  public EditPurchaseOkResponse editPurchase(@NonNull EditPurchaseRequest editPurchaseRequest) throws ApiException {
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
    throws ApiException {
    Request request = this.buildEditPurchaseRequest(editPurchaseRequest);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<EditPurchaseOkResponse>() {})
    );
  }

  private Request buildEditPurchaseRequest(@NonNull EditPurchaseRequest editPurchaseRequest) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "purchases/edit")
      .setJsonContent(editPurchaseRequest)
      .build();
  }

  /**
   * Get Purchase Consumption
   *
   * @param purchaseId String ID of the purchase
   * @return response of {@code GetPurchaseConsumptionOkResponse}
   */
  public GetPurchaseConsumptionOkResponse getPurchaseConsumption(@NonNull String purchaseId) throws ApiException {
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
    throws ApiException {
    Request request = this.buildGetPurchaseConsumptionRequest(purchaseId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetPurchaseConsumptionOkResponse>() {})
    );
  }

  private Request buildGetPurchaseConsumptionRequest(@NonNull String purchaseId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "purchases/{purchaseId}/consumption")
      .setPathParameter("purchaseId", purchaseId)
      .build();
  }
}
