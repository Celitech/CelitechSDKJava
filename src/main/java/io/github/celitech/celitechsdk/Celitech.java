package io.github.celitech.celitechsdk;

import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.interceptors.DefaultHeadersInterceptor;
import io.github.celitech.celitechsdk.http.interceptors.LoggingInterceptor;
import io.github.celitech.celitechsdk.http.interceptors.OAuthInterceptor;
import io.github.celitech.celitechsdk.http.interceptors.RetryInterceptor;
import io.github.celitech.celitechsdk.http.oauth.TokenManager;
import io.github.celitech.celitechsdk.logging.Logger;
import io.github.celitech.celitechsdk.services.DestinationsService;
import io.github.celitech.celitechsdk.services.ESimService;
import io.github.celitech.celitechsdk.services.IFrameService;
import io.github.celitech.celitechsdk.services.PackagesService;
import io.github.celitech.celitechsdk.services.PurchasesService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/**
 * Welcome to the CELITECH API documentation!
 *
 * Useful links: [Homepage](https://www.celitech.com) | [Support email](mailto:devops@celitech.com) | [Blog](https://www.celitech.com/blog/)
 *
 * # Introduction
 *
 * This guide is your go-to resource for the CELITECH API, with full documentation and schemas.
 *
 * Need help? Email us at devops@celitech.com.
 *
 * "Partners" refers to online service providers that use our eSIM API. Access levels include Gold, Platinum, and Diamond.
 *
 * ## API
 *
 * The CELITECH API is designed for use by partner platforms, including both web and mobile applications. It's assumed all endpoint calls are initiated from the backend of an integrated platform.
 *
 * API URL: `https://api.celitech.net/v1`
 *
 * ## Authentication &amp; Authorization
 * CELITECH API uses the OAuth 2.0 protocol for authentication and authorization.
 * The endpoints are protected using client credentials flow which is based on a token exchange. The token has a defined life span (typically 1 hour), after which a new token must be obtained.
 *
 * To begin, obtain OAuth 2.0 client credentials ( **CLIENT_ID** &amp; **CLIENT_SECRET** ) from the [CELITECH Dashboard](https://www.dashboard.celitech.com/). Then your client application requests an access token from the CELITECH Authorization Server, extracts a token from the response, and sends the token to the CELITECH API that you want to access.
 *
 * Security Scheme Type: `OAuth2`
 *
 * Flow type: `clientCredentials`
 *
 * Token URL: `https://auth.celitech.net/oauth2/token`
 */
public class Celitech {

  public final DestinationsService destinations;
  public final PackagesService packages;
  public final PurchasesService purchases;
  public final ESimService eSim;
  public final IFrameService iFrame;

  private final CelitechConfig config;

  private final TokenManager tokenManager;

  /**
   * Constructs a new instance of Celitech with default configuration.
   */
  public Celitech() {
    // Default configs
    this(CelitechConfig.builder().build());
  }

  /**
   * Constructs a new instance of Celitech with custom configuration.
   * Initializes all services, HTTP client, and optional OAuth token manager.
   *
   * @param config The SDK configuration including base URL, authentication, timeout, and retry settings
   */
  public Celitech(CelitechConfig config) {
    this.config = config;

    OAuthInterceptor oauthInterceptor = new OAuthInterceptor();

    // A user-supplied client is augmented (not replaced): the SDK derives its client from
    // the injected instance so its transport settings and interceptors are preserved, then
    // layers the SDK's own interceptors on top.
    final OkHttpClient customHttpClient = config.getHttpClient();
    final OkHttpClient.Builder httpClientBuilder =
      (customHttpClient != null
          ? customHttpClient.newBuilder()
          : new OkHttpClient.Builder()).addInterceptor(new DefaultHeadersInterceptor(config))
        .addInterceptor(oauthInterceptor)
        .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
        // Logging is added last so it observes the fully-decorated request (auth headers
        // included, then redacted). Silent by default — see LogConfig.
        .addInterceptor(new LoggingInterceptor(Logger.from(config.getLogConfig())));

    // Only apply the SDK's default read timeout when building the client ourselves; a
    // user-supplied client owns its own transport (timeout) settings.
    if (customHttpClient == null) {
      httpClientBuilder.readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS);
    }

    final OkHttpClient httpClient = httpClientBuilder.build();

    this.tokenManager = TokenManager.builder()
      .httpClient(httpClient)
      .config(config)
      .clientId(config.getClientId())
      .clientSecret(config.getClientSecret())
      .build();

    oauthInterceptor.setTokenManager(tokenManager);

    this.destinations = new DestinationsService(httpClient, config);
    this.packages = new PackagesService(httpClient, config);
    this.purchases = new PurchasesService(httpClient, config);
    this.eSim = new ESimService(httpClient, config);
    this.iFrame = new IFrameService(httpClient, config);
  }

  /**
   * Sets the environment for all API requests.
   *
   * @param environment The environment to use (e.g., DEFAULT, PRODUCTION, STAGING)
   */
  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  /**
   * Sets the base URL for all API requests.
   *
   * @param baseUrl The base URL to use for API requests
   */
  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }

  /**
   * Sets the OAuth environment for token requests.
   *
   * @param environment The OAuth environment to use
   */
  public void setBaseOAuthEnvironment(Environment environment) {
    setBaseOAuthUrl(environment.getUrl());
  }

  /**
   * Sets the base URL for OAuth token requests.
   *
   * @param baseOAuthUrl The base URL for OAuth endpoints
   */
  public void setBaseOAuthUrl(String baseOAuthUrl) {
    this.config.setBaseOAuthUrl(baseOAuthUrl);
  }

  public void setClientId(String clientId) {
    this.tokenManager.setClientId(clientId);
  }

  public void setClientSecret(String clientSecret) {
    this.tokenManager.setClientSecret(clientSecret);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
