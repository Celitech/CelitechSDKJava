package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.exceptions.BadRequestException;
import io.github.celitech.celitechsdk.exceptions.UnauthorizedException;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.BadRequest;
import io.github.celitech.celitechsdk.models.ListDestinationsOkResponse;
import io.github.celitech.celitechsdk.models.Unauthorized;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * DestinationsService Service
 */
public class DestinationsService extends BaseService {

  public DestinationsService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * List Destinations
   *
   * @return response of {@code ListDestinationsOkResponse}
   */
  public ListDestinationsOkResponse listDestinations() throws ApiError {
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildListDestinationsRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ListDestinationsOkResponse>() {});
  }

  /**
   * List Destinations
   *
   * @return response of {@code CompletableFuture<ListDestinationsOkResponse>}
   */
  public CompletableFuture<ListDestinationsOkResponse> listDestinationsAsync() throws ApiError {
    this.addErrorMapping(400, BadRequest.class, BadRequestException.class);
    this.addErrorMapping(401, Unauthorized.class, UnauthorizedException.class);
    Request request = this.buildListDestinationsRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ListDestinationsOkResponse>() {})
    );
  }

  private Request buildListDestinationsRequest() {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "destinations"
    ).build();
  }
}
