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
public class GetEsimOkResponseEsim {

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

  /**
   * Status of the eSIM, possible values are 'RELEASED', 'DOWNLOADED', 'INSTALLED', 'ENABLED', 'DELETED', or 'ERROR'
   */
  @JsonProperty("status")
  private JsonNullable<String> status;

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

  @JsonIgnore
  public String getStatus() {
    return status.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class GetEsimOkResponseEsimBuilder {

    private JsonNullable<String> iccid = JsonNullable.undefined();

    @JsonProperty("iccid")
    public GetEsimOkResponseEsimBuilder iccid(String value) {
      if (value == null) {
        throw new IllegalStateException("iccid cannot be null");
      }
      this.iccid = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> smdpAddress = JsonNullable.undefined();

    @JsonProperty("smdpAddress")
    public GetEsimOkResponseEsimBuilder smdpAddress(String value) {
      if (value == null) {
        throw new IllegalStateException("smdpAddress cannot be null");
      }
      this.smdpAddress = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> manualActivationCode = JsonNullable.undefined();

    @JsonProperty("manualActivationCode")
    public GetEsimOkResponseEsimBuilder manualActivationCode(String value) {
      if (value == null) {
        throw new IllegalStateException("manualActivationCode cannot be null");
      }
      this.manualActivationCode = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> status = JsonNullable.undefined();

    @JsonProperty("status")
    public GetEsimOkResponseEsimBuilder status(String value) {
      if (value == null) {
        throw new IllegalStateException("status cannot be null");
      }
      this.status = JsonNullable.of(value);
      return this;
    }
  }
}
