package io.github.celitech.celitechsdk.models;

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
}
