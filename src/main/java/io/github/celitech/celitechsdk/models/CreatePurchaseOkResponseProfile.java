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
public class CreatePurchaseOkResponseProfile {

  /**
   * ID of the eSIM
   */
  @NonNull
  private String iccid;

  /**
   * QR Code of the eSIM as base64
   */
  @NonNull
  private String activationCode;

  /**
   * Manual Activation Code of the eSIM
   */
  @NonNull
  private String manualActivationCode;
}
