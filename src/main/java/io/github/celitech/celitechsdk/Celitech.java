package io.github.celitech.celitechsdk;

import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.interceptors.DefaultHeadersInterceptor;
import io.github.celitech.celitechsdk.http.interceptors.OAuthInterceptor;
import io.github.celitech.celitechsdk.http.interceptors.RetryInterceptor;
import io.github.celitech.celitechsdk.http.oauth.TokenManager;
import io.github.celitech.celitechsdk.services.DestinationsService;
import io.github.celitech.celitechsdk.services.ESimService;
import io.github.celitech.celitechsdk.services.IframeService;
import io.github.celitech.celitechsdk.services.OAuthService;
import io.github.celitech.celitechsdk.services.PackagesService;
import io.github.celitech.celitechsdk.services.PurchasesService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/** Welcome to the CELITECH API documentation!  Useful links: [Homepage](https://www.celitech.com) | [Support email](mailto:support@celitech.com) | [Blog](https://www.celitech.com/blog/)  */
public class Celitech {

  public final OAuthService oAuth;
  public final DestinationsService destinations;
  public final PackagesService packages;
  public final PurchasesService purchases;
  public final ESimService eSim;
  public final IframeService iframe;

  private final TokenManager tokenManager;

  public Celitech() {
    // Default configs
    this(CelitechConfig.builder().build());
  }

  public Celitech(CelitechConfig config) {
    final String serverUrl = config.getEnvironment().getUrl();

    OAuthInterceptor oauthInterceptor = new OAuthInterceptor();

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(oauthInterceptor)
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.tokenManager =
      TokenManager
        .builder()
        .httpClient(httpClient)
        .baseOAuthUrl(config.getBaseOAuthUrl().getUrl())
        .clientId(config.getClientId())
        .clientSecret(config.getClientSecret())
        .build();

    oauthInterceptor.setTokenManager(tokenManager);

    this.oAuth = new OAuthService(httpClient, serverUrl);
    this.destinations = new DestinationsService(httpClient, serverUrl);
    this.packages = new PackagesService(httpClient, serverUrl);
    this.purchases = new PurchasesService(httpClient, serverUrl);
    this.eSim = new ESimService(httpClient, serverUrl);
    this.iframe = new IframeService(httpClient, serverUrl);
  }

  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  public void setBaseUrl(String baseUrl) {
    this.oAuth.setBaseUrl(baseUrl);
    this.destinations.setBaseUrl(baseUrl);
    this.packages.setBaseUrl(baseUrl);
    this.purchases.setBaseUrl(baseUrl);
    this.eSim.setBaseUrl(baseUrl);
    this.iframe.setBaseUrl(baseUrl);
  }

  public void setBaseOAuthEnvironment(Environment environment) {
    this.tokenManager.setBaseOAuthUrl(environment.getUrl());
  }

  public void setBaseOAuthUrl(String baseOAuthUrl) {
    this.tokenManager.setBaseOAuthUrl(baseOAuthUrl);
  }

  public void setClientId(String clientId) {
    this.tokenManager.setClientId(clientId);
  }

  public void setClientSecret(String clientSecret) {
    this.tokenManager.setClientSecret(clientSecret);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
