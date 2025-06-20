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
public class GetEsimMacOkResponseEsim {

  /**
   * ID of the eSIM
   */
  @JsonProperty("iccid")
  private JsonNullable<String> iccid;

  /**
   * SM-DP+ Address
   */
  @JsonProperty("smdpAddress")
  private JsonNullable<String> smdpAddress;

  /**
   * The manual activation code
   */
  @JsonProperty("manualActivationCode")
  private JsonNullable<String> manualActivationCode;

  @JsonIgnore
  public String getIccid() {
    return iccid.orElse(null);
  }

  @JsonIgnore
  public String getSmdpAddress() {
    return smdpAddress.orElse(null);
  }

  @JsonIgnore
  public String getManualActivationCode() {
    return manualActivationCode.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class GetEsimMacOkResponseEsimBuilder {

    private JsonNullable<String> iccid = JsonNullable.undefined();

    @JsonProperty("iccid")
    public GetEsimMacOkResponseEsimBuilder iccid(String value) {
      if (value == null) {
        throw new IllegalStateException("iccid cannot be null");
      }
      this.iccid = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> smdpAddress = JsonNullable.undefined();

    @JsonProperty("smdpAddress")
    public GetEsimMacOkResponseEsimBuilder smdpAddress(String value) {
      if (value == null) {
        throw new IllegalStateException("smdpAddress cannot be null");
      }
      this.smdpAddress = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> manualActivationCode = JsonNullable.undefined();

    @JsonProperty("manualActivationCode")
    public GetEsimMacOkResponseEsimBuilder manualActivationCode(String value) {
      if (value == null) {
        throw new IllegalStateException("manualActivationCode cannot be null");
      }
      this.manualActivationCode = JsonNullable.of(value);
      return this;
    }
  }
}
