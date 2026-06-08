package io.github.celitech.celitechsdk.http;

import lombok.Getter;

/**
 * Predefined environment configurations for the SDK.
 * Each environment represents a different base URL (e.g., production, staging, development).
 */
@Getter
public enum Environment {
  DEFAULT("https://api.celitech.net/v1"),
  DEFAULT_OAUTH("https://auth.celitech.net");

  private final String url;

  Environment(String url) {
    this.url = url;
  }
}
