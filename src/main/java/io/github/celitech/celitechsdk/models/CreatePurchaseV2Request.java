package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
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
   * ISO representation of the package's destination. Supports both ISO2 (e.g., 'FR') and ISO3 (e.g., 'FRA') country codes.
   */
  @NonNull
  private String destination;

  /**
   * Size of the package in GB. The available options are 0.5, 1, 2, 3, 5, 8, 20, 50GB. Use `-1` to purchase an unlimited (date-based) package — provide `startDate`/`endDate` spanning 3 to 30 days (`duration` is not supported for unlimited packages).
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
   * Start date of the package's validity in the format 'yyyy-MM-dd'. This date can be set to the current day or any day within the next 12 months.
   */
  @JsonProperty("startDate")
  private JsonNullable<LocalDate> startDate;

  /**
   * End date of the package's validity in the format 'yyyy-MM-dd'. End date can be maximum 90 days after Start date.
   */
  @JsonProperty("endDate")
  private JsonNullable<LocalDate> endDate;

  /**
   * Duration of the package in days. Available values are 1, 2, 7, 14, 30, or 90. Either provide startDate/endDate or duration. Not supported for unlimited packages (`dataLimitInGB` = -1), which are date-based — provide startDate/endDate instead.
   */
  @JsonProperty("duration")
  private JsonNullable<Double> duration;

  /**
   * Email address where the purchase confirmation email will be sent (including QR Code &amp; activation steps)
   */
  @JsonProperty("email")
  private JsonNullable<String> email;

  /**
   * An identifier provided by the partner to link this purchase to their booking or transaction for analytics and debugging purposes.
   */
  @JsonProperty("referenceId")
  private JsonNullable<String> referenceId;

  /**
   * Customize the network brand of the issued eSIM. The `networkBrand` parameter cannot exceed 15 characters in length and must contain only letters, numbers, dots (.), ampersands (&amp;), and spaces. This feature is available to platforms with Diamond tier only.
   */
  @JsonProperty("networkBrand")
  private JsonNullable<String> networkBrand;

  /**
   * Customize the email subject brand. The `emailBrand` parameter cannot exceed 25 characters in length and must contain only letters, numbers, and spaces. This feature is available to platforms with Diamond tier only.
   */
  @JsonProperty("emailBrand")
  private JsonNullable<String> emailBrand;

  /**
   * Language of the confirmation email sent to the customer.
   */
  @JsonProperty("language")
  private JsonNullable<CreatePurchaseV2RequestLanguage> language;

  // FSM-59: capture unknown JSON fields so they round-trip on re-serialize.
  // @Builder.Default keeps the empty-map default in the Lombok-generated builder; without it the
  // builder would leave the map null and the any-setter would NPE on the first unknown field.
  // Deserialization is wired via the builder's @JsonAnySetter (see the Builder below), NOT here:
  // Lombok @Jacksonized deserializes through the builder and does not copy a field-level
  // @JsonAnySetter across, so unknown fields would be silently dropped if it lived on this field.
  @Builder.Default
  private Map<String, Object> additionalProperties = new HashMap<>();

  // @JsonAnyGetter must sit on the getter (not the field) so Jackson inlines the unknown entries on
  // serialize. On the field it double-registers with the Lombok getter and leaks a literal
  // "additionalProperties" property into every request body and object parameter.
  // Declaring the getter here also stops Lombok @Data from generating its own.
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  @JsonIgnore
  public LocalDate getStartDate() {
    return startDate.orElse(null);
  }

  @JsonIgnore
  public LocalDate getEndDate() {
    return endDate.orElse(null);
  }

  @JsonIgnore
  public Double getDuration() {
    return duration.orElse(null);
  }

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
  public CreatePurchaseV2RequestLanguage getLanguage() {
    return language.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreatePurchaseV2RequestBuilder {

    private JsonNullable<LocalDate> startDate = JsonNullable.undefined();

    @JsonProperty("startDate")
    public CreatePurchaseV2RequestBuilder startDate(LocalDate value) {
      if (value == null) {
        throw new IllegalStateException("startDate cannot be null");
      }
      this.startDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<LocalDate> endDate = JsonNullable.undefined();

    @JsonProperty("endDate")
    public CreatePurchaseV2RequestBuilder endDate(LocalDate value) {
      if (value == null) {
        throw new IllegalStateException("endDate cannot be null");
      }
      this.endDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> duration = JsonNullable.undefined();

    @JsonProperty("duration")
    public CreatePurchaseV2RequestBuilder duration(Double value) {
      if (value == null) {
        throw new IllegalStateException("duration cannot be null");
      }
      this.duration = JsonNullable.of(value);
      return this;
    }

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

    private JsonNullable<CreatePurchaseV2RequestLanguage> language = JsonNullable.undefined();

    @JsonProperty("language")
    public CreatePurchaseV2RequestBuilder language(CreatePurchaseV2RequestLanguage value) {
      if (value == null) {
        throw new IllegalStateException("language cannot be null");
      }
      this.language = JsonNullable.of(value);
      return this;
    }

    @JsonAnySetter
    public CreatePurchaseV2RequestBuilder additionalProperties(String key, Object value) {
      if (this.additionalProperties$value == null) {
        this.additionalProperties$value = new HashMap<>();
      }
      this.additionalProperties$value.put(key, value);
      this.additionalProperties$set = true;
      return this;
    }
  }
}
