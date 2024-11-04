package io.github.Celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Purchases {

  /**
   * ID of the purchase
   */
  private String id;

  /**
   * Start date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  private String startDate;

  /**
   * End date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  private String endDate;

  /**
   * Creation date of the purchase in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  private String createdDate;

  /**
   * Epoch value representing the start time of the package's validity
   */
  private Double startTime;

  /**
   * Epoch value representing the end time of the package's validity
   */
  private Double endTime;

  /**
   * Epoch value representing the date of creation of the purchase
   */
  private Double createdAt;

  @JsonProperty("package")
  private Package_ package_;

  private PurchasesEsim esim;

  /**
   * The source indicates where the eSIM was purchased, which can be from the API, dashboard, landing-page or promo-page. For purchases made before September 8, 2023, the value will be displayed as 'Not available'.
   */
  private String source;

  /**
   * The referenceId that was provided by the partner during the purchase or topup flow. This identifier can be used for analytics and debugging purposes.
   */
  private String referenceId;
}
