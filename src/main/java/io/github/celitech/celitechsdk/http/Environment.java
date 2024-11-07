package io.github.celitech.celitechsdk.http;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * SDK Environments
 */
@Getter
@RequiredArgsConstructor
public enum Environment {
  DEFAULT("https://api.celitech.net/v1"),
  DEFAULT_OAUTH("https://auth.celitech.net");

  private final String url;
}
