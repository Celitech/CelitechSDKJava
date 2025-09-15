package io.github.celitech.celitechsdk.http.oauth;

import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.models.GetAccessTokenOkResponse;
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

  private GetAccessTokenOkResponse token;
  private Set<String> scopes;

  public String getToken(Set<String> scopes) {
    Boolean tokenHasValue = this.token != null && !this.token.getAccessToken().isEmpty();
    Boolean tokenIsValid = false;
    if (tokenHasValue) {
      Long expiresIn = this.token.getExpiresIn();
      if (expiresIn != null) {
        long now = System.currentTimeMillis() / 1000L;
        long buffer = 5000;
        if ((expiresIn - now) > buffer) {
          tokenIsValid = true;
        }
      } else {
        tokenIsValid = true;
      }
    }

    if (tokenIsValid && this.scopes.containsAll(scopes)) {
      return this.token.getAccessToken();
    }

    return this.retrieveAccessToken(scopes).getAccessToken();
  }

  public void clean() {
    this.token = null;
  }

  private GetAccessTokenOkResponse retrieveAccessToken(Set<String> scopes) {
    OAuthService oAuth = new OAuthService(this.httpClient, this.config);

    GetAccessTokenRequest requestBody = GetAccessTokenRequest.builder()
      .grantType(GrantType.CLIENT_CREDENTIALS)
      .clientId(this.clientId)
      .clientSecret(this.clientSecret)
      .build();

    this.token = oAuth.getAccessToken(requestBody);
    return this.token;
  }
}
