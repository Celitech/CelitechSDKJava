package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class GetEsimOkResponseEsim {

  /**
   * ID of the eSIM
   */
  @NonNull
  private String iccid;

  /**
   * SM-DP+ Address
   */
  @NonNull
  private String smdpAddress;

  /**
   * QR Code of the eSIM as base64
   */
  @NonNull
  private String activationCode;

  /**
   * The manual activation code
   */
  @NonNull
  private String manualActivationCode;

  /**
   * Status of the eSIM, possible values are 'RELEASED', 'DOWNLOADED', 'INSTALLED', 'ENABLED', 'DELETED', or 'ERROR'
   */
  @NonNull
  private String status;

  /**
   * Status of the eSIM connectivity, possible values are 'ACTIVE' or 'NOT_ACTIVE'
   */
  @NonNull
  private String connectivityStatus;

  /**
   * Indicates whether the eSIM is currently eligible for a top-up. This flag should be checked before attempting a top-up request.
   */
  @NonNull
  private Boolean isTopUpAllowed;

  // FSM-59: capture unknown JSON fields so they round-trip on re-serialize.
  // @Builder.Default keeps the empty-map default in the Lombok-generated builder; without it the
  // builder would leave the map null and the any-setter would NPE on the first unknown field.
  // Deserialization is wired via the builder's @JsonAnySetter (see the Builder below), NOT here:
  // Lombok @Jacksonized deserializes through the builder and does not copy a field-level
  // @JsonAnySetter across, so unknown fields would be silently dropped if it lived on this field.
  @Builder.Default
  private Map<String, Object> additionalProperties = new HashMap<>();

  // @JsonAnyGetter must sit on the getter (not the field) so Jackson inlines the unknown entries on
  // serialize. On the field it double-registers with the Lombok getter and leaks a literal
  // "additionalProperties" property into every request body and object parameter.
  // Declaring the getter here also stops Lombok @Data from generating its own.
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  // Overwrite lombok builder methods
  public static class GetEsimOkResponseEsimBuilder {

    @JsonAnySetter
    public GetEsimOkResponseEsimBuilder additionalProperties(String key, Object value) {
      if (this.additionalProperties$value == null) {
        this.additionalProperties$value = new HashMap<>();
      }
      this.additionalProperties$value.put(key, value);
      this.additionalProperties$set = true;
      return this;
    }
  }
}
