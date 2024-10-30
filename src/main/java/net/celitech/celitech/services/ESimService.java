package net.celitech.celitech.services;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import net.celitech.celitech.exceptions.ApiException;
import net.celitech.celitech.http.HttpMethod;
import net.celitech.celitech.http.ModelConverter;
import net.celitech.celitech.http.util.RequestBuilder;
import net.celitech.celitech.models.GetEsimDeviceOkResponse;
import net.celitech.celitech.models.GetEsimHistoryOkResponse;
import net.celitech.celitech.models.GetEsimMacOkResponse;
import net.celitech.celitech.models.GetEsimOkResponse;
import net.celitech.celitech.models.GetEsimParameters;
import net.celitech.celitech.validation.ViolationAggregator;
import net.celitech.celitech.validation.exceptions.ValidationException;
import net.celitech.celitech.validation.validators.StringValidator;
import net.celitech.celitech.validation.validators.modelValidators.GetEsimParametersValidator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ESimService Service
 */
public class ESimService extends BaseService {

  public ESimService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * Get eSIM Status
   *
   * @param requestParameters {@link GetEsimParameters} Request Parameters Object
   * @return response of {@code GetEsimOkResponse}
   */
  public GetEsimOkResponse getEsim(@NonNull GetEsimParameters requestParameters)
    throws ApiException, ValidationException {
    Request request = this.buildGetEsimRequest(requestParameters);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<GetEsimOkResponse>() {});
  }

  /**
   * Get eSIM Status
   *
   * @param requestParameters {@link GetEsimParameters} Request Parameters Object
   * @return response of {@code GetEsimOkResponse}
   */
  public CompletableFuture<GetEsimOkResponse> getEsimAsync(@NonNull GetEsimParameters requestParameters)
    throws ApiException, ValidationException {
    Request request = this.buildGetEsimRequest(requestParameters);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<GetEsimOkResponse>() {});
    });
  }

  private Request buildGetEsimRequest(@NonNull GetEsimParameters requestParameters) throws ValidationException {
    new ViolationAggregator()
      .add(new GetEsimParametersValidator("requestParameters").required().validate(requestParameters))
      .validateAll();

    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "esim")
      .setQueryParameter("iccid", requestParameters.getIccid())
      .build();
  }

  /**
   * Get eSIM Device
   *
   * @param iccid String ID of the eSIM
   * @return response of {@code GetEsimDeviceOkResponse}
   */
  public GetEsimDeviceOkResponse getEsimDevice(@NonNull String iccid) throws ApiException, ValidationException {
    Request request = this.buildGetEsimDeviceRequest(iccid);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<GetEsimDeviceOkResponse>() {});
  }

  /**
   * Get eSIM Device
   *
   * @param iccid String ID of the eSIM
   * @return response of {@code GetEsimDeviceOkResponse}
   */
  public CompletableFuture<GetEsimDeviceOkResponse> getEsimDeviceAsync(@NonNull String iccid)
    throws ApiException, ValidationException {
    Request request = this.buildGetEsimDeviceRequest(iccid);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<GetEsimDeviceOkResponse>() {});
    });
  }

  private Request buildGetEsimDeviceRequest(@NonNull String iccid) throws ValidationException {
    new ViolationAggregator()
      .add(new StringValidator("iccid").minLength(18).maxLength(22).required().validate(iccid))
      .validateAll();

    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "esim/{iccid}/device")
      .setPathParameter("iccid", iccid)
      .build();
  }

  /**
   * Get eSIM History
   *
   * @param iccid String ID of the eSIM
   * @return response of {@code GetEsimHistoryOkResponse}
   */
  public GetEsimHistoryOkResponse getEsimHistory(@NonNull String iccid) throws ApiException, ValidationException {
    Request request = this.buildGetEsimHistoryRequest(iccid);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<GetEsimHistoryOkResponse>() {});
  }

  /**
   * Get eSIM History
   *
   * @param iccid String ID of the eSIM
   * @return response of {@code GetEsimHistoryOkResponse}
   */
  public CompletableFuture<GetEsimHistoryOkResponse> getEsimHistoryAsync(@NonNull String iccid)
    throws ApiException, ValidationException {
    Request request = this.buildGetEsimHistoryRequest(iccid);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<GetEsimHistoryOkResponse>() {});
    });
  }

  private Request buildGetEsimHistoryRequest(@NonNull String iccid) throws ValidationException {
    new ViolationAggregator()
      .add(new StringValidator("iccid").minLength(18).maxLength(22).required().validate(iccid))
      .validateAll();

    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "esim/{iccid}/history")
      .setPathParameter("iccid", iccid)
      .build();
  }

  /**
   * Get eSIM MAC
   *
   * @param iccid String ID of the eSIM
   * @return response of {@code GetEsimMacOkResponse}
   */
  public GetEsimMacOkResponse getEsimMac(@NonNull String iccid) throws ApiException, ValidationException {
    Request request = this.buildGetEsimMacRequest(iccid);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<GetEsimMacOkResponse>() {});
  }

  /**
   * Get eSIM MAC
   *
   * @param iccid String ID of the eSIM
   * @return response of {@code GetEsimMacOkResponse}
   */
  public CompletableFuture<GetEsimMacOkResponse> getEsimMacAsync(@NonNull String iccid)
    throws ApiException, ValidationException {
    Request request = this.buildGetEsimMacRequest(iccid);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<GetEsimMacOkResponse>() {});
    });
  }

  private Request buildGetEsimMacRequest(@NonNull String iccid) throws ValidationException {
    new ViolationAggregator()
      .add(new StringValidator("iccid").minLength(18).maxLength(22).required().validate(iccid))
      .validateAll();

    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "esim/{iccid}/mac")
      .setPathParameter("iccid", iccid)
      .build();
  }
}
