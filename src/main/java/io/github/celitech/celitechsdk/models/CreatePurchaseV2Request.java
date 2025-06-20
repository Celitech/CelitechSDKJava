package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreatePurchaseV2Request {

  /**
   * ISO representation of the package's destination.
   */
  @NonNull
  private String destination;

  /**
   * Size of the package in GB. The available options are 0.5, 1, 2, 3, 5, 8, 20GB
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
  @JsonProperty("email")
  private JsonNullable<String> email;

  /**
   * An identifier provided by the partner to link this purchase to their booking or transaction for analytics and debugging purposes.
   */
  @JsonProperty("referenceId")
  private JsonNullable<String> referenceId;

  /**
   * Customize the network brand of the issued eSIM. The `networkBrand` parameter cannot exceed 15 characters in length and must contain only letters and numbers. This feature is available to platforms with Diamond tier only.
   */
  @JsonProperty("networkBrand")
  private JsonNullable<String> networkBrand;

  /**
   * Customize the email subject brand. The `emailBrand` parameter cannot exceed 25 characters in length and must contain only letters, numbers, and spaces. This feature is available to platforms with Diamond tier only.
   */
  @JsonProperty("emailBrand")
  private JsonNullable<String> emailBrand;

  @JsonIgnore
  public String getEmail() {
    return email.orElse(null);
  }

  @JsonIgnore
  public String getReferenceId() {
    return referenceId.orElse(null);
  }

  @JsonIgnore
  public String getNetworkBrand() {
    return networkBrand.orElse(null);
  }

  @JsonIgnore
  public String getEmailBrand() {
    return emailBrand.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreatePurchaseV2RequestBuilder {

    private JsonNullable<String> email = JsonNullable.undefined();

    @JsonProperty("email")
    public CreatePurchaseV2RequestBuilder email(String value) {
      if (value == null) {
        throw new IllegalStateException("email cannot be null");
      }
      this.email = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> referenceId = JsonNullable.undefined();

    @JsonProperty("referenceId")
    public CreatePurchaseV2RequestBuilder referenceId(String value) {
      if (value == null) {
        throw new IllegalStateException("referenceId cannot be null");
      }
      this.referenceId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> networkBrand = JsonNullable.undefined();

    @JsonProperty("networkBrand")
    public CreatePurchaseV2RequestBuilder networkBrand(String value) {
      if (value == null) {
        throw new IllegalStateException("networkBrand cannot be null");
      }
      this.networkBrand = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> emailBrand = JsonNullable.undefined();

    @JsonProperty("emailBrand")
    public CreatePurchaseV2RequestBuilder emailBrand(String value) {
      if (value == null) {
        throw new IllegalStateException("emailBrand cannot be null");
      }
      this.emailBrand = JsonNullable.of(value);
      return this;
    }
  }
}
