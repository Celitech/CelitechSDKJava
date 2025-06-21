package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreatePurchaseOkResponseProfile {

  /**
   * ID of the eSIM
   */
  @JsonProperty("iccid")
  private JsonNullable<String> iccid;

  /**
   * QR Code of the eSIM as base64
   */
  @JsonProperty("activationCode")
  private JsonNullable<String> activationCode;

  /**
   * Manual Activation Code of the eSIM
   */
  @JsonProperty("manualActivationCode")
  private JsonNullable<String> manualActivationCode;

  @JsonIgnore
  public String getIccid() {
    return iccid.orElse(null);
  }

  @JsonIgnore
  public String getActivationCode() {
    return activationCode.orElse(null);
  }

  @JsonIgnore
  public String getManualActivationCode() {
    return manualActivationCode.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreatePurchaseOkResponseProfileBuilder {

    private JsonNullable<String> iccid = JsonNullable.undefined();

    @JsonProperty("iccid")
    public CreatePurchaseOkResponseProfileBuilder iccid(String value) {
      if (value == null) {
        throw new IllegalStateException("iccid cannot be null");
      }
      this.iccid = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> activationCode = JsonNullable.undefined();

    @JsonProperty("activationCode")
    public CreatePurchaseOkResponseProfileBuilder activationCode(String value) {
      if (value == null) {
        throw new IllegalStateException("activationCode cannot be null");
      }
      this.activationCode = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> manualActivationCode = JsonNullable.undefined();

    @JsonProperty("manualActivationCode")
    public CreatePurchaseOkResponseProfileBuilder manualActivationCode(String value) {
      if (value == null) {
        throw new IllegalStateException("manualActivationCode cannot be null");
      }
      this.manualActivationCode = JsonNullable.of(value);
      return this;
    }
  }
}
