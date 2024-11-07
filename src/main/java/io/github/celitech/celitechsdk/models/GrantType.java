package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GrantType {
  CLIENT_CREDENTIALS("client_credentials");

  @JsonValue
  private final String value;

  @JsonCreator
  public static GrantType fromValue(String value) {
    return Arrays.stream(GrantType.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}