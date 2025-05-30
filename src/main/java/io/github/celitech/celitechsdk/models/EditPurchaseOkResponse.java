package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class EditPurchaseOkResponse {

  /**
   * ID of the purchase
   */
  private String purchaseId;

  /**
   * Start date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String newStartDate;

  /**
   * End date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String newEndDate;

  /**
   * Epoch value representing the new start time of the package's validity
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Double newStartTime;

  /**
   * Epoch value representing the new end time of the package's validity
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Double newEndTime;
}
