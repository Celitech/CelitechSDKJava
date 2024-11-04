package io.github.Celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.Celitech.celitechsdk.exceptions.ApiException;
import io.github.Celitech.celitechsdk.http.HttpMethod;
import io.github.Celitech.celitechsdk.http.ModelConverter;
import io.github.Celitech.celitechsdk.http.util.RequestBuilder;
import io.github.Celitech.celitechsdk.models.ListPackagesOkResponse;
import io.github.Celitech.celitechsdk.models.ListPackagesParameters;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * PackagesService Service
 */
public class PackagesService extends BaseService {

  public PackagesService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * List Packages
   *
   * @return response of {@code ListPackagesOkResponse}
   */
  public ListPackagesOkResponse listPackages() throws ApiException {
    return this.listPackages(ListPackagesParameters.builder().build());
  }

  /**
   * List Packages
   *
   * @param requestParameters {@link ListPackagesParameters} Request Parameters Object
   * @return response of {@code ListPackagesOkResponse}
   */
  public ListPackagesOkResponse listPackages(@NonNull ListPackagesParameters requestParameters) throws ApiException {
    Request request = this.buildListPackagesRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ListPackagesOkResponse>() {});
  }

  /**
   * List Packages
   *
   * @return response of {@code CompletableFuture<ListPackagesOkResponse>}
   */
  public CompletableFuture<ListPackagesOkResponse> listPackagesAsync() throws ApiException {
    return this.listPackagesAsync(ListPackagesParameters.builder().build());
  }

  /**
   * List Packages
   *
   * @param requestParameters {@link ListPackagesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ListPackagesOkResponse>}
   */
  public CompletableFuture<ListPackagesOkResponse> listPackagesAsync(@NonNull ListPackagesParameters requestParameters)
    throws ApiException {
    Request request = this.buildListPackagesRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ListPackagesOkResponse>() {})
    );
  }

  private Request buildListPackagesRequest(@NonNull ListPackagesParameters requestParameters) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "packages")
      .setOptionalQueryParameter("destination", requestParameters.getDestination())
      .setOptionalQueryParameter("startDate", requestParameters.getStartDate())
      .setOptionalQueryParameter("endDate", requestParameters.getEndDate())
      .setOptionalQueryParameter("afterCursor", requestParameters.getAfterCursor())
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("startTime", requestParameters.getStartTime())
      .setOptionalQueryParameter("endTime", requestParameters.getEndTime())
      .setOptionalQueryParameter("duration", requestParameters.getDuration())
      .build();
  }
}
