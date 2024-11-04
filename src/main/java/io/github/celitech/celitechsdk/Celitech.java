package io.github.celitech.celitechsdk;

import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.hook.CustomHook;
import io.github.celitech.celitechsdk.http.Environment;
import io.github.celitech.celitechsdk.http.interceptors.DefaultHeadersInterceptor;
import io.github.celitech.celitechsdk.http.interceptors.HookInterceptor;
import io.github.celitech.celitechsdk.http.interceptors.RetryInterceptor;
import io.github.celitech.celitechsdk.services.DestinationsService;
import io.github.celitech.celitechsdk.services.ESimService;
import io.github.celitech.celitechsdk.services.PackagesService;
import io.github.celitech.celitechsdk.services.PurchasesService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/** Welcome to the CELITECH API documentation!  Useful links: [Homepage](https://www.celitech.com) | [Support email](mailto:support@celitech.com) | [Blog](https://www.celitech.com/blog/)  */
public class Celitech {

  public final DestinationsService destinationsService;
  public final PackagesService packagesService;
  public final PurchasesService purchasesService;
  public final ESimService eSimService;

  private final HookInterceptor hookInterceptor;

  public Celitech() {
    // Default configs
    this(CelitechConfig.builder().build());
  }

  public Celitech(CelitechConfig config) {
    final String serverUrl = config.getEnvironment().getUrl();

    this.hookInterceptor = new HookInterceptor(new CustomHook(), config);

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(hookInterceptor)
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.destinationsService = new DestinationsService(httpClient, serverUrl);
    this.packagesService = new PackagesService(httpClient, serverUrl);
    this.purchasesService = new PurchasesService(httpClient, serverUrl);
    this.eSimService = new ESimService(httpClient, serverUrl);
  }

  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  public void setBaseUrl(String baseUrl) {
    this.destinationsService.setBaseUrl(baseUrl);
    this.packagesService.setBaseUrl(baseUrl);
    this.purchasesService.setBaseUrl(baseUrl);
    this.eSimService.setBaseUrl(baseUrl);
  }

  public void setClientId(String clientId) {
    this.hookInterceptor.setClientId(clientId);
  }

  public void setClientSecret(String clientSecret) {
    this.hookInterceptor.setClientSecret(clientSecret);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
