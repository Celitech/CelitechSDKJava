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
public class CreatePurchaseRequest {

  /**
   * ISO representation of the package's destination. Supports both ISO2 (e.g., 'FR') and ISO3 (e.g., 'FRA') country codes.
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

  /**
   * Epoch value representing the start time of the package's validity. This timestamp can be set to the current time or any time within the next 12 months.
   */
  @JsonProperty("startTime")
  private JsonNullable<Double> startTime;

  /**
   * Epoch value representing the end time of the package's validity. End time can be maximum 90 days after Start time.
   */
  @JsonProperty("endTime")
  private JsonNullable<Double> endTime;

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

  @JsonIgnore
  public Double getStartTime() {
    return startTime.orElse(null);
  }

  @JsonIgnore
  public Double getEndTime() {
    return endTime.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreatePurchaseRequestBuilder {

    private JsonNullable<String> email = JsonNullable.undefined();

    @JsonProperty("email")
    public CreatePurchaseRequestBuilder email(String value) {
      if (value == null) {
        throw new IllegalStateException("email cannot be null");
      }
      this.email = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> referenceId = JsonNullable.undefined();

    @JsonProperty("referenceId")
    public CreatePurchaseRequestBuilder referenceId(String value) {
      if (value == null) {
        throw new IllegalStateException("referenceId cannot be null");
      }
      this.referenceId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> networkBrand = JsonNullable.undefined();

    @JsonProperty("networkBrand")
    public CreatePurchaseRequestBuilder networkBrand(String value) {
      if (value == null) {
        throw new IllegalStateException("networkBrand cannot be null");
      }
      this.networkBrand = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> emailBrand = JsonNullable.undefined();

    @JsonProperty("emailBrand")
    public CreatePurchaseRequestBuilder emailBrand(String value) {
      if (value == null) {
        throw new IllegalStateException("emailBrand cannot be null");
      }
      this.emailBrand = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> startTime = JsonNullable.undefined();

    @JsonProperty("startTime")
    public CreatePurchaseRequestBuilder startTime(Double value) {
      if (value == null) {
        throw new IllegalStateException("startTime cannot be null");
      }
      this.startTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> endTime = JsonNullable.undefined();

    @JsonProperty("endTime")
    public CreatePurchaseRequestBuilder endTime(Double value) {
      if (value == null) {
        throw new IllegalStateException("endTime cannot be null");
      }
      this.endTime = JsonNullable.of(value);
      return this;
    }
  }
}
