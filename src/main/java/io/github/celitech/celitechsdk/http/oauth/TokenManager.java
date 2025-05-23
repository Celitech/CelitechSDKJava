package io.github.celitech.celitechsdk.http.oauth;

import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.models.GetAccessTokenRequest;
import io.github.celitech.celitechsdk.models.GrantType;
import io.github.celitech.celitechsdk.services.OAuthService;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import okhttp3.OkHttpClient;

@Builder
public class TokenManager {

  @NonNull
  private OkHttpClient httpClient;

  @Getter
  @Setter
  @NonNull
  private CelitechConfig config;

  @Getter
  @Setter
  private String clientId;

  @Getter
  @Setter
  private String clientSecret;

  private String token;
  private Set<String> scopes;

  public String getToken(Set<String> scopes) {
    if (this.token != null && !this.token.isEmpty() && this.scopes.containsAll(scopes)) {
      return this.token;
    }

    return this.retrieveAccessToken(scopes);
  }

  public void clean() {
    this.token = null;
  }

  private String retrieveAccessToken(Set<String> scopes) {
    OAuthService oAuth = new OAuthService(this.httpClient, this.config);

    GetAccessTokenRequest requestBody = GetAccessTokenRequest.builder()
      .grantType(GrantType.CLIENT_CREDENTIALS)
      .clientId(this.clientId)
      .clientSecret(this.clientSecret)
      .build();

    return oAuth.getAccessToken(requestBody).getAccessToken();
  }
}
