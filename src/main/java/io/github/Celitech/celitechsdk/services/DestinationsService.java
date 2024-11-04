package io.github.Celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.Celitech.celitechsdk.exceptions.ApiException;
import io.github.Celitech.celitechsdk.http.HttpMethod;
import io.github.Celitech.celitechsdk.http.ModelConverter;
import io.github.Celitech.celitechsdk.http.util.RequestBuilder;
import io.github.Celitech.celitechsdk.models.ListDestinationsOkResponse;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * DestinationsService Service
 */
public class DestinationsService extends BaseService {

  public DestinationsService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * List Destinations
   *
   * @return response of {@code ListDestinationsOkResponse}
   */
  public ListDestinationsOkResponse listDestinations() throws ApiException {
    Request request = this.buildListDestinationsRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ListDestinationsOkResponse>() {});
  }

  /**
   * List Destinations
   *
   * @return response of {@code CompletableFuture<ListDestinationsOkResponse>}
   */
  public CompletableFuture<ListDestinationsOkResponse> listDestinationsAsync() throws ApiException {
    Request request = this.buildListDestinationsRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ListDestinationsOkResponse>() {})
    );
  }

  private Request buildListDestinationsRequest() {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "destinations").build();
  }
}
