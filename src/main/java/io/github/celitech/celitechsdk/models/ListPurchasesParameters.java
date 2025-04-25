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
public class ListPurchasesParameters {

  /**
   * ID of the eSIM
   */
  private String iccid;

  /**
   * Start date of the interval for filtering purchases in the format 'yyyy-MM-dd'
   */
  private String afterDate;

  /**
   * End date of the interval for filtering purchases in the format 'yyyy-MM-dd'
   */
  private String beforeDate;

  /**
   * The referenceId that was provided by the partner during the purchase or topup flow.
   */
  private String referenceId;

  /**
   * To get the next batch of results, use this parameter. It tells the API where to start fetching data after the last item you received. It helps you avoid repeats and efficiently browse through large sets of data.
   */
  private String afterCursor;

  /**
   * Maximum number of purchases to be returned in the response. The value must be greater than 0 and less than or equal to 100. If not provided, the default value is 20
   */
  private Double limit;

  /**
   * Epoch value representing the start of the time interval for filtering purchases
   */
  private Double after;

  /**
   * Epoch value representing the end of the time interval for filtering purchases
   */
  private Double before;
}
