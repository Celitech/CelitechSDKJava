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
public class CreatePurchaseV2Request {

  /**
   * ISO representation of the package's destination
   */
  @NonNull
  private String destination;

  /**
   * Size of the package in GB.
   * - **Limited Packages (0.5, 1, 2, 3, 5, 8, 20GB):** supports `duration` or `startDate` / `endDate`.
   * - **Unlimited Packages (available for Region-3):** supports `duration` only. Use **-1** for unlimited.
   *
   */
  @NonNull
  @JsonProperty("dataLimitInGB")
  private Double dataLimitInGb;

  /**
   * Number of eSIMs to purchase.
   */
  @NonNull
  private Double quantity;

  /**
   * Start date of the package validity in the format yyyy-MM-dd. This date can be set to the current day or any day within the next 12 months.
   *
   * Exactly one of the following must be provided:
   * - Both `startDate` and `endDate` together
   * - Or `duration` alone
   *
   * These options are mutually exclusive — do not include `duration` with `startDate` or `endDate`.
   *
   */
  private String startDate;

  /**
   * End date of the package validity in the format yyyy-MM-dd. End date can be maximum 90 days after Start date.
   *
   * Exactly one of the following must be provided:
   * - Both `startDate` and `endDate` together
   * - Or `duration` alone
   *
   * These options are mutually exclusive — do not include `duration` with `startDate` or `endDate`.
   *
   */
  private String endDate;

  /**
   * It designates the number of days the eSIM is valid for within 90-day validity from issuance date.
   * - **For limited packages** (0.5, 1, 2, 3, 5, 8, 20GB): The available options are 1, 2, 7, 14, 30 days (following the pricing of 0-30 days) and 90 days (following the pricing of 0-90 days)
   * - **For unlimited package** (available for Region-3): The available options are for 1, 2, 7, 14, 30 days (following a custom pricing).
   *
   * Exactly one of the following must be provided:
   * - Both `startDate` and `endDate` together
   * - Or `duration` alone
   *
   * These options are mutually exclusive — do not include `duration` with `startDate` or `endDate`.
   *
   */
  private Double duration;

  /**
   * Email address where the purchase confirmation email will be sent (including QR Code & activation steps)
   */
  private String email;

  /**
   * An identifier provided by the partner to link this purchase to their booking or transaction for analytics and debugging purposes.
   */
  private String referenceId;

  /**
   * Customize the network brand of the issued eSIM. This parameter is accessible to platforms with Diamond tier and requires an alphanumeric string of up to 15 characters.
   */
  private String networkBrand;

  /**
   * Customize the email brand. This parameter is accessible to platforms with Diamond tier and requires an alphanumeric string of up to 25 characters.
   */
  private String emailBrand;
}
