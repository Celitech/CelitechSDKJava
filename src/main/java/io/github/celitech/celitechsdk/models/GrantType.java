package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class GrantType {

  public static final GrantType CLIENT_CREDENTIALS = new GrantType(
    Value.CLIENT_CREDENTIALS,
    "client_credentials"
  );

  private final Value value;

  private final String string;

  GrantType(Value value, String string) {
    this.value = value;
    this.string = string;
  }

  public Value getEnumValue() {
    return value;
  }

  @Override
  @JsonValue
  public String toString() {
    return this.string;
  }

  @Override
  public boolean equals(Object other) {
    return (
      (this == other) ||
      (other instanceof GrantType && this.string.equals(((GrantType) other).string))
    );
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case CLIENT_CREDENTIALS:
        return visitor.visitClientCredentials();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public static GrantType valueOf(String value) {
    if (value == null) {
      return null;
    }
    switch (value) {
      case "client_credentials":
        return CLIENT_CREDENTIALS;
      default:
        return new GrantType(Value.UNKNOWN, value);
    }
  }

  public enum Value {
    CLIENT_CREDENTIALS,
    UNKNOWN,
  }

  public interface Visitor<T> {
    T visitClientCredentials();
    T visitUnknown(String unknownType);
  }
}
