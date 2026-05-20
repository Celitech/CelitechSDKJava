package io.github.celitech.celitechsdk;

import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.interceptors.DefaultHeadersInterceptor;
import io.github.celitech.celitechsdk.http.interceptors.OAuthInterceptor;
import io.github.celitech.celitechsdk.http.interceptors.RetryInterceptor;
import io.github.celitech.celitechsdk.http.oauth.TokenManager;
import io.github.celitech.celitechsdk.services.ConsumptionService;
import io.github.celitech.celitechsdk.services.DestinationsService;
import io.github.celitech.celitechsdk.services.DeviceService;
import io.github.celitech.celitechsdk.services.EditService;
import io.github.celitech.celitechsdk.services.EsimService;
import io.github.celitech.celitechsdk.services.HistoryService;
import io.github.celitech.celitechsdk.services.PackagesService;
import io.github.celitech.celitechsdk.services.PurchasesService;
import io.github.celitech.celitechsdk.services.TokenService;
import io.github.celitech.celitechsdk.services.TopupService;
import io.github.celitech.celitechsdk.services.V2Service;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/** Welcome to the CELITECH API documentation!

Useful links: [Homepage](https://www.celitech.com) | [Support email](mailto:support@celitech.com) | [Blog](https://www.celitech.com/blog/)


Contact Support:
 Name: CELITECH
 Email: support@celitech.com */
public class Celitech {

  public final DestinationsService destinations;
  public final PackagesService packages;
  public final V2Service v2;
  public final TopupService topup;
  public final EditService edit;
  public final ConsumptionService consumption;
  public final PurchasesService purchases;
  public final DeviceService device;
  public final HistoryService history;
  public final EsimService esim;
  public final TokenService token;

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

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(oauthInterceptor)
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.tokenManager = TokenManager.builder()
      .httpClient(httpClient)
      .config(config)
      .clientId(config.getClientId())
      .clientSecret(config.getClientSecret())
      .build();

    oauthInterceptor.setTokenManager(tokenManager);

    this.destinations = new DestinationsService(httpClient, config);
    this.packages = new PackagesService(httpClient, config);
    this.v2 = new V2Service(httpClient, config);
    this.topup = new TopupService(httpClient, config);
    this.edit = new EditService(httpClient, config);
    this.consumption = new ConsumptionService(httpClient, config);
    this.purchases = new PurchasesService(httpClient, config);
    this.device = new DeviceService(httpClient, config);
    this.history = new HistoryService(httpClient, config);
    this.esim = new EsimService(httpClient, config);
    this.token = new TokenService(httpClient, config);
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
