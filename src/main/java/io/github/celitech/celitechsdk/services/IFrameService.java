package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.exceptions.Token400ResponseException;
import io.github.celitech.celitechsdk.exceptions.Token401ResponseException;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.Token400Response;
import io.github.celitech.celitechsdk.models.Token401Response;
import io.github.celitech.celitechsdk.models.TokenOkResponse;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * IFrameService Service
 */
public class IFrameService extends BaseService {

  public IFrameService(@NonNull OkHttpClient httpClient, CelitechConfig config) {
    super(httpClient, config);
  }

  /**
   * Generate Token
   *
   * @return response of {@code TokenOkResponse}
   */
  public TokenOkResponse token() throws ApiError {
    this.addErrorMapping(400, Token400Response.class, Token400ResponseException.class);
    this.addErrorMapping(401, Token401Response.class, Token401ResponseException.class);
    Request request = this.buildTokenRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<TokenOkResponse>() {});
  }

  /**
   * Generate Token
   *
   * @return response of {@code CompletableFuture<TokenOkResponse>}
   */
  public CompletableFuture<TokenOkResponse> tokenAsync() throws ApiError {
    this.addErrorMapping(400, Token400Response.class, Token400ResponseException.class);
    this.addErrorMapping(401, Token401Response.class, Token401ResponseException.class);
    Request request = this.buildTokenRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<TokenOkResponse>() {})
    );
  }

  private Request buildTokenRequest() {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "iframe/token"
    ).build();
  }
}
