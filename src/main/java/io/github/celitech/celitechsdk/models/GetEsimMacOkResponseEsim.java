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
public class GetEsimMacOkResponseEsim {

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
}
