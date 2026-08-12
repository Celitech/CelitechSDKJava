package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Language of the confirmation email sent to the customer.
 */
public final class CreatePurchaseRequestLanguage {

  public static final CreatePurchaseRequestLanguage EN = new CreatePurchaseRequestLanguage(
    Value.EN,
    "en"
  );
  public static final CreatePurchaseRequestLanguage ES = new CreatePurchaseRequestLanguage(
    Value.ES,
    "es"
  );
  public static final CreatePurchaseRequestLanguage FR = new CreatePurchaseRequestLanguage(
    Value.FR,
    "fr"
  );
  public static final CreatePurchaseRequestLanguage DE = new CreatePurchaseRequestLanguage(
    Value.DE,
    "de"
  );
  public static final CreatePurchaseRequestLanguage PT_BR = new CreatePurchaseRequestLanguage(
    Value.PT_BR,
    "pt-br"
  );

  private final Value value;

  private final String string;

  CreatePurchaseRequestLanguage(Value value, String string) {
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
      (other instanceof CreatePurchaseRequestLanguage &&
        this.string.equals(((CreatePurchaseRequestLanguage) other).string))
    );
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case EN:
        return visitor.visitEn();
      case ES:
        return visitor.visitEs();
      case FR:
        return visitor.visitFr();
      case DE:
        return visitor.visitDe();
      case PT_BR:
        return visitor.visitPtBr();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public static CreatePurchaseRequestLanguage valueOf(String value) {
    if (value == null) {
      return null;
    }
    switch (value) {
      case "en":
        return EN;
      case "es":
        return ES;
      case "fr":
        return FR;
      case "de":
        return DE;
      case "pt-br":
        return PT_BR;
      default:
        return new CreatePurchaseRequestLanguage(Value.UNKNOWN, value);
    }
  }

  public enum Value {
    EN,
    ES,
    FR,
    DE,
    PT_BR,
    UNKNOWN,
  }

  public interface Visitor<T> {
    T visitEn();
    T visitEs();
    T visitFr();
    T visitDe();
    T visitPtBr();
    T visitUnknown(String unknownType);
  }
}
