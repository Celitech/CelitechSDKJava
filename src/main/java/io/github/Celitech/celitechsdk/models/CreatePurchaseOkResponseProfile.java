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
public class CreatePurchaseOkResponseProfile {

  /**
   * ID of the eSIM
   */
  private String iccid;

  /**
   * QR Code of the eSIM as base64
   */
  private String activationCode;

  /**
   * Manual Activation Code of the eSIM
   */
  private String manualActivationCode;
}
