package io.github.celitech.celitechsdk.models;

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
public class TopUpEsimRequest {

  /**
   * ID of the eSIM
   */
  @NonNull
  private String iccid;

  /**
   * Size of the package in GB.
   *
   * For **limited packages**, the available options are: **0.5, 1, 2, 3, 5, 8, 20GB** (supports `duration` or `startDate` / `endDate`).
   *
   * For **unlimited packages** (available to Region-3), please use **-1** as an identifier (supports `duration` only).
   *
   */
  @NonNull
  @JsonProperty("dataLimitInGB")
  private Double dataLimitInGb;

  /**
   * Start date of the package's validity in the format 'yyyy-MM-dd'. This date can be set to the current day or any day within the next 12 months.
   */
  private String startDate;

  /**
   * End date of the package's validity in the format 'yyyy-MM-dd'. End date can be maximum 90 days after Start date.
   */
  private String endDate;

  /**
   * It designates the number of days the eSIM is valid for within the 90-day validity period from the issuance date.
   *
   * For **limited packages**, the supported durations are: **1, 2, 7, 14, 30, 90 days**.
   *
   * For **unlimited packages**, all durations are supported **except 90 days**.
   *
   */
  private Double duration;

  /**
   * Email address where the purchase confirmation email will be sent (excluding QR Code & activation steps).
   */
  private String email;

  /**
   * An identifier provided by the partner to link this purchase to their booking or transaction for analytics and debugging purposes.
   */
  private String referenceId;

  /**
   * Customize the email subject brand. The `emailBrand` parameter cannot exceed 25 characters in length and must contain only letters, numbers, and spaces. This feature is available to platforms with Diamond tier only.
   */
  private String emailBrand;

  /**
   * Epoch value representing the start time of the package's validity. This timestamp can be set to the current time or any time within the next 12 months.
   */
  private Double startTime;

  /**
   * Epoch value representing the end time of the package's validity. End time can be maximum 90 days after Start time.
   */
  private Double endTime;
}
