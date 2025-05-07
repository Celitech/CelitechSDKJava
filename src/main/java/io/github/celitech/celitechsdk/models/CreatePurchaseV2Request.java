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
   * Size of the package in GB. The available options are 1, 2, 3, 5, 8, 20GB
   */
  @NonNull
  @JsonProperty("dataLimitInGB")
  private Double dataLimitInGb;

  /**
   * Start date of the package's validity in the format 'yyyy-MM-dd'. This date can be set to the current day or any day within the next 12 months.
   */
  @NonNull
  private String startDate;

  /**
   * End date of the package's validity in the format 'yyyy-MM-dd'. End date can be maximum 90 days after Start date.
   */
  @NonNull
  private String endDate;

  /**
   * Number of eSIMs to purchase.
   */
  @NonNull
  private Double quantity;

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
