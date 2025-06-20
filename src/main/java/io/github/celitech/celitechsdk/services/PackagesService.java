package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.exceptions.ListPackages400ResponseException;
import io.github.celitech.celitechsdk.exceptions.ListPackages401ResponseException;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.ListPackages400Response;
import io.github.celitech.celitechsdk.models.ListPackages401Response;
import io.github.celitech.celitechsdk.models.ListPackagesOkResponse;
import io.github.celitech.celitechsdk.models.ListPackagesParameters;
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

  public PackagesService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
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
  public ListPackagesOkResponse listPackages(@NonNull ListPackagesParameters requestParameters) throws ApiError {
    this.addErrorMapping(400, ListPackages400Response.class, ListPackages400ResponseException.class);
    this.addErrorMapping(401, ListPackages401Response.class, ListPackages401ResponseException.class);
    Request request = this.buildListPackagesRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ListPackagesOkResponse>() {});
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
  public CompletableFuture<ListPackagesOkResponse> listPackagesAsync(@NonNull ListPackagesParameters requestParameters)
    throws ApiError {
    this.addErrorMapping(400, ListPackages400Response.class, ListPackages400ResponseException.class);
    this.addErrorMapping(401, ListPackages401Response.class, ListPackages401ResponseException.class);
    Request request = this.buildListPackagesRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ListPackagesOkResponse>() {})
    );
  }

  private Request buildListPackagesRequest(@NonNull ListPackagesParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "packages"
    )
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
