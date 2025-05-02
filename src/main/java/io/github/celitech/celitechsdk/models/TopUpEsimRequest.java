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
   * - **Limited Packages (1, 2, 3, 5, 8, 20GB):** supports `duration` or `startDate` `endDate`.
   * - **Unlimited Packages (Region-3 only)** support `duration` only. Use **-1** for unlimited.
   *
   */
  @NonNull
  @JsonProperty("dataLimitInGB")
  private Double dataLimitInGb;

  /**
   * Start date of the package validity in the format `yyyy-MM-dd`. This date can be set to the current day or any day within the enxt 12 months.
   * - **Required** if `duration` is **not** provided.
   * - **Optional** must not passed if `duration` is provided.
   *
   */
  private String startDate;

  /**
   * End date of the package validity in the format `yyyy-MM-dd`. End date can be maximum 90 days after Start date.
   * - **Required** if `duration` is **not** provided.
   * - **Optional** must not passed if `duration` is provided.
   *
   */
  private String endDate;

  /**
   * Defines the number of days the eSIM package remains active. Available options: **1, 2, 7, 14, 30**
   * - **Required** if `startDate` and `endDate` are **not** provided.
   * - **Optional** must not passed if `startDate` and `endDate` are provided.
   *
   */
  private Double duration;

  /**
   * Email address where the purchase confirmation email will be sent (excluding QR Code & activation steps)
   */
  private String email;

  /**
   * An identifier provided by the partner to link this purchase to their booking or transaction for analytics and debugging purposes.
   */
  private String referenceId;

  /**
   * Epoch value representing the start time of the package's validity. This timestamp can be set to the current time or any time within the next 12 months.
   */
  private Double startTime;

  /**
   * Epoch value representing the end time of the package's validity. End time can be maximum 90 days after Start time.
   */
  private Double endTime;
}
