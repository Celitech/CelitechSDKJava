package io.github.celitech.celitechsdk.config;

import io.github.celitech.celitechsdk.http.Environment;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class CelitechConfig {

  @NonNull
  @Builder.Default
  private String userAgent = "celitechsdk/1.0.0";

  @NonNull
  @Builder.Default
  private String baseUrl = Environment.DEFAULT.getUrl();

  @NonNull
  @Builder.Default
  private RetryConfig retryConfig = RetryConfig.builder().build();

  @NonNull
  @Builder.Default
  private String baseOAuthUrl = Environment.DEFAULT_OAUTH.getUrl();

  private String clientId;
  private String clientSecret;

  /** Timeout in milliseconds */
  @Builder.Default
  private long timeout = 10_000;

  public void setEnvironment(Environment environment) {
    this.baseUrl = environment.getUrl();
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public void setBaseOAuthEnvironment(Environment environment) {
    this.baseOAuthUrl = environment.getUrl();
  }

  public void setBaseOAuthUrl(String baseOAuthUrl) {
    this.baseOAuthUrl = baseOAuthUrl;
  }
}
