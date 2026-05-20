package io.github.celitech.celitechsdk.config;

import io.github.celitech.celitechsdk.http.Environment;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

/**
 * Configuration class for SDK client settings.
 * Provides builder pattern for configuring base URLs, authentication, timeouts, and retry behavior.
 * All configuration options have sensible defaults and can be customized as needed.
 */
@Builder
@Data
public class CelitechConfig {

  @NonNull
  @Builder.Default
  private String userAgent = "postman-codegen/1.1.2 celitechsdk/2.0.0 (java)";

  @Setter
  private String baseUrl;

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

  public void setBaseOAuthEnvironment(Environment environment) {
    this.baseOAuthUrl = environment.getUrl();
  }

  public void setBaseOAuthUrl(String baseOAuthUrl) {
    this.baseOAuthUrl = baseOAuthUrl;
  }
}
