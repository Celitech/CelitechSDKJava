package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
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
   * Indicates whether the eSIM is currently eligible for a top-up. This flag should be checked before attempting a top-up request.
   */
  @NonNull
  private Boolean isTopUpAllowed;

  /**
   * Status of the eSIM connectivity, possible values are 'ACTIVE' or 'NOT_ACTIVE'
   */
  @JsonProperty("connectivityStatus")
  private JsonNullable<String> connectivityStatus;

  @JsonIgnore
  public String getConnectivityStatus() {
    return connectivityStatus.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class GetEsimOkResponseEsimBuilder {

    private JsonNullable<String> connectivityStatus = JsonNullable.undefined();

    @JsonProperty("connectivityStatus")
    public GetEsimOkResponseEsimBuilder connectivityStatus(String value) {
      if (value == null) {
        throw new IllegalStateException("connectivityStatus cannot be null");
      }
      this.connectivityStatus = JsonNullable.of(value);
      return this;
    }
  }
}
