package io.github.celitech.celitechsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.celitech.celitechsdk.exceptions.ApiException;
import io.github.celitech.celitechsdk.http.HttpMethod;
import io.github.celitech.celitechsdk.http.ModelConverter;
import io.github.celitech.celitechsdk.http.util.RequestBuilder;
import io.github.celitech.celitechsdk.models.TokenOkResponse;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * IframeService Service
 */
public class IframeService extends BaseService {

  public IframeService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * Generate Token
   *
   * @return response of {@code TokenOkResponse}
   */
  public TokenOkResponse token() throws ApiException {
    Request request = this.buildTokenRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<TokenOkResponse>() {});
  }

  /**
   * Generate Token
   *
   * @return response of {@code CompletableFuture<TokenOkResponse>}
   */
  public CompletableFuture<TokenOkResponse> tokenAsync() throws ApiException {
    Request request = this.buildTokenRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<TokenOkResponse>() {})
    );
  }

  private Request buildTokenRequest() {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "iframe/token").build();
  }
}
