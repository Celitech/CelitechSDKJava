package io.github.celitech.celitechsdk.http.interceptors;

import io.github.celitech.celitechsdk.http.oauth.ScopeManager;
import io.github.celitech.celitechsdk.http.oauth.TokenManager;
import java.io.IOException;
import java.util.Set;
import lombok.Setter;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttp interceptor that automatically adds OAuth tokens to requests.
 * Determines the required scopes for each endpoint and acquires appropriate tokens.
 */
public class OAuthInterceptor implements Interceptor {

  @Setter
  private TokenManager tokenManager;

  private ScopeManager scopeManager;

  /**
   * Constructs a new OAuthInterceptor with an empty scope manager.
   */
  public OAuthInterceptor() {
    this.scopeManager = new ScopeManager();
  }

  /**
   * Intercepts an HTTP request to add OAuth authentication.
   * Determines the required scopes for the endpoint, acquires a token,
   * and adds it to the Authorization header.
   *
   * @param chain The OkHttp interceptor chain
   * @return The HTTP response
   * @throws IOException if an I/O error occurs during request execution
   */
  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();

    Set<String> scopes = this.scopeManager.getScopes(request.method(), request.url().toString());
    if (scopes == null) {
      return chain.proceed(request);
    }

    String token = tokenManager.getToken(scopes);
    return chain.proceed(this.addTokenToRequest(request, token));
  }

  /**
   * Adds an OAuth token to a request's Authorization header.
   *
   * @param request The HTTP request to modify
   * @param token The OAuth access token
   * @return The modified request with the Authorization header, or the original request if token is empty
   */
  private Request addTokenToRequest(Request request, String token) {
    if (token == null || token.isEmpty()) {
      return request;
    }

    String value = "Bearer " + token;
    return request.newBuilder().addHeader("Authorization", value).build();
  }
}
