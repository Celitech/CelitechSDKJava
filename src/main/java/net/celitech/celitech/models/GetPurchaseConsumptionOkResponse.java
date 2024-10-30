package net.celitech.celitech.models;

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
public class GetPurchaseConsumptionOkResponse {

  /**
   * Remaining balance of the package in bytes
   */
  private Double dataUsageRemainingInBytes;

  /**
   * Status of the connectivity, possible values are 'ACTIVE' or 'NOT_ACTIVE'
   */
  private String status;
}
