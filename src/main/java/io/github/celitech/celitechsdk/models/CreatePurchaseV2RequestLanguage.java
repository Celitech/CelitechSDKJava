package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Language of the confirmation email sent to the customer.
 */
@Getter
@AllArgsConstructor
public enum CreatePurchaseV2RequestLanguage {
  EN("en"),
  ES("es"),
  FR("fr"),
  DE("de"),
  PT_BR("pt-br");

  @JsonValue
  private final String value;

  @JsonCreator
  public static CreatePurchaseV2RequestLanguage fromValue(String value) {
    return Arrays.stream(CreatePurchaseV2RequestLanguage.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
