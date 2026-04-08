package net.celitech.celitechsdk.http.oauth;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.celitech.celitechsdk.config.CelitechConfig;
import net.celitech.celitechsdk.http.Environment;
import net.celitech.celitechsdk.models.GetAccessTokenOkResponse;
import net.celitech.celitechsdk.models.GetAccessTokenRequest;
import net.celitech.celitechsdk.models.GrantType;
import net.celitech.celitechsdk.services.OAuthService;
import okhttp3.OkHttpClient;

/**
 * Manages OAuth token lifecycle including acquisition, caching, validation, and refresh.
 * Handles token scoping and automatically refreshes expired tokens.
 */
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

  /**
   * Gets a valid access token for the specified scopes.
   * Returns the cached token if it's still valid and has the required scopes,
   * otherwise retrieves a new token from the OAuth endpoint.
   *
   * @param scopes The OAuth scopes required for the token
   * @return The access token string
   */
  public String getToken(Set<String> scopes) {
    Boolean tokenHasValue = this.token != null && !this.token.getAccessToken().isEmpty();
    Boolean tokenIsValid = false;
    if (tokenHasValue) {
      Long expiresIn = this.token.getExpiresIn();
      if (expiresIn != null) {
        long now = System.currentTimeMillis() / 1000L;
        long buffer = 0;
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

  /**
   * Clears the cached token, forcing the next getToken call to retrieve a fresh token.
   */
  public void clean() {
    this.token = null;
  }

  /**
   * Retrieves a new access token from the OAuth endpoint.
   *
   * @param scopes The OAuth scopes to request
   * @return The retrieved token model containing access token and metadata
   */
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
