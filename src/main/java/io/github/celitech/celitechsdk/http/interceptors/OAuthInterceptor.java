package io.github.celitech.celitechsdk.http.interceptors;

import io.github.celitech.celitechsdk.http.oauth.ScopeManager;
import io.github.celitech.celitechsdk.http.oauth.TokenManager;
import java.io.IOException;
import java.util.Set;
import lombok.Setter;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OAuthInterceptor implements Interceptor {

  @Setter
  private TokenManager tokenManager;

  private ScopeManager scopeManager;

  public OAuthInterceptor() {
    this.scopeManager = new ScopeManager();
  }

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

  private Request addTokenToRequest(Request request, String token) {
    if (token == null || token.isEmpty()) {
      return request;
    }

    String value = "Bearer " + token;
    return request.newBuilder().addHeader("Authorization", value).build();
  }
}
