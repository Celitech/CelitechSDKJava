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
public class Device {

  /**
   * Name of the OEM
   */
  @NonNull
  private String oem;

  /**
   * Name of the Device
   */
  @NonNull
  private String hardwareName;

  /**
   * Model of the Device
   */
  @NonNull
  private String hardwareModel;

  /**
   * Serial Number of the eSIM
   */
  @NonNull
  private String eid;
}
