package io.github.celitech.celitechsdk.models;

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
   * Remaining balance of the package in byte.
   * For **limited packages**, this field indicates the remaining data in bytes.
   * For **unlimited packages**, it will return **-1** as an identifier.
   *
   */
  private Double dataUsageRemainingInBytes;

  /**
   * Status of the connectivity, possible values are 'ACTIVE' or 'NOT_ACTIVE'
   */
  private String status;
}
