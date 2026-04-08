package net.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class GetPurchaseConsumptionOkResponse {

  /**
   * Remaining balance of the package in bytes
   */
  @NonNull
  private Double dataUsageRemainingInBytes;

  /**
   * Remaining balance of the package in GB
   */
  @NonNull
  @JsonProperty("dataUsageRemainingInGB")
  private Double dataUsageRemainingInGb;

  /**
   * Status of the connectivity, possible values are 'ACTIVE' or 'NOT_ACTIVE'
   */
  @NonNull
  private String status;
}
