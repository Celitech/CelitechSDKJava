package net.celitech.celitech.http.oauth;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.celitech.celitech.http.Environment;
import net.celitech.celitech.models.GetAccessTokenRequest;
import net.celitech.celitech.models.GrantType;
import net.celitech.celitech.services.OAuthService;
import okhttp3.OkHttpClient;

@Builder
public class TokenManager {

  @NonNull
  private OkHttpClient httpClient;

  @Getter
  @Setter
  @NonNull
  private String baseOAuthUrl;

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
    OAuthService oAuthService = new OAuthService(this.httpClient, this.baseOAuthUrl);

    GetAccessTokenRequest requestBody = GetAccessTokenRequest
      .builder()
      .grantType(GrantType.CLIENT_CREDENTIALS)
      .clientId(this.clientId)
      .clientSecret(this.clientSecret)
      .build();

    return oAuthService.getAccessToken(requestBody).getAccessToken();
  }
}
