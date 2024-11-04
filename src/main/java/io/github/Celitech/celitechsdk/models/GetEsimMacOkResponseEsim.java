package io.github.Celitech.celitechsdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

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
  private String iccid;

  /**
   * SM-DP+ Address
   */
  private String smdpAddress;

  /**
   * The manual activation code
   */
  private String manualActivationCode;
}
