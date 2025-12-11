package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Duration of the package in days. Available values are 1, 2, 7, 14, 30, or 90. Either provide startDate/endDate or duration.
 */
@Getter
@AllArgsConstructor
public enum TopUpEsimRequestDuration {
  _1(1),
  _2(2),
  _7(7),
  _14(14),
  _30(30),
  _90(90);

  @JsonValue
  private final double value;

  @JsonCreator
  public static TopUpEsimRequestDuration fromValue(String value) {
    return Arrays.stream(TopUpEsimRequestDuration.values())
      .filter(item -> String.valueOf(item.value).equals(value))
      .findFirst()
      .orElse(null);
  }
}
