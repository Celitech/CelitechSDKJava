package net.celitech.celitech.services;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import net.celitech.celitech.exceptions.ApiException;
import net.celitech.celitech.http.HttpMethod;
import net.celitech.celitech.http.ModelConverter;
import net.celitech.celitech.http.util.RequestBuilder;
import net.celitech.celitech.models.GetAccessTokenOkResponse;
import net.celitech.celitech.models.GetAccessTokenRequest;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OAuthService Service
 */
public class OAuthService extends BaseService {

  public OAuthService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * Get Access Token
   *
   * @param getAccessTokenRequest {@link GetAccessTokenRequest} Request Body
   * @return response of {@code GetAccessTokenOkResponse}
   */
  public GetAccessTokenOkResponse getAccessToken(@NonNull GetAccessTokenRequest getAccessTokenRequest)
    throws ApiException {
    Request request = this.buildGetAccessTokenRequest(getAccessTokenRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<GetAccessTokenOkResponse>() {});
  }

  /**
   * Get Access Token
   *
   * @param getAccessTokenRequest {@link GetAccessTokenRequest} Request Body
   * @return response of {@code GetAccessTokenOkResponse}
   */
  public CompletableFuture<GetAccessTokenOkResponse> getAccessTokenAsync(
    @NonNull GetAccessTokenRequest getAccessTokenRequest
  ) throws ApiException {
    Request request = this.buildGetAccessTokenRequest(getAccessTokenRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<GetAccessTokenOkResponse>() {});
    });
  }

  private Request buildGetAccessTokenRequest(@NonNull GetAccessTokenRequest getAccessTokenRequest) {
    FormBody.Builder formBodyBuilder = new FormBody.Builder()
      .add("client_id", getAccessTokenRequest.getClientId())
      .add("client_secret", getAccessTokenRequest.getClientSecret());
    if (getAccessTokenRequest.getGrantType() != null) {
      formBodyBuilder.add("grant_type", getAccessTokenRequest.getGrantType().getValue());
    }
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "oauth2/token").setBody(formBodyBuilder.build()).build();
  }
}
