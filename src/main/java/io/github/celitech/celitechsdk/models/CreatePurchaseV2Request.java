package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
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

  @JsonProperty("destination")
  private JsonNullable<String> destination;

  @JsonProperty("dataLimitInGB")
  private JsonNullable<Double> dataLimitInGb;

  @JsonProperty("quantity")
  private JsonNullable<Double> quantity;

  @JsonProperty("startDate")
  private JsonNullable<String> startDate;

  @JsonProperty("endDate")
  private JsonNullable<String> endDate;

  @JsonProperty("duration")
  private JsonNullable<Double> duration;

  @JsonProperty("email")
  private JsonNullable<String> email;

  @JsonProperty("referenceId")
  private JsonNullable<String> referenceId;

  @JsonProperty("networkBrand")
  private JsonNullable<String> networkBrand;

  @JsonProperty("emailBrand")
  private JsonNullable<String> emailBrand;

  @JsonProperty("language")
  private JsonNullable<String> language;

  @JsonIgnore
  public String getDestination() {
    return destination.orElse(null);
  }

  @JsonIgnore
  public Double getDataLimitInGb() {
    return dataLimitInGb.orElse(null);
  }

  @JsonIgnore
  public Double getQuantity() {
    return quantity.orElse(null);
  }

  @JsonIgnore
  public String getStartDate() {
    return startDate.orElse(null);
  }

  @JsonIgnore
  public String getEndDate() {
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
  public String getLanguage() {
    return language.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreatePurchaseV2RequestBuilder {

    private JsonNullable<String> destination = JsonNullable.undefined();

    @JsonProperty("destination")
    public CreatePurchaseV2RequestBuilder destination(String value) {
      this.destination = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> dataLimitInGb = JsonNullable.undefined();

    @JsonProperty("dataLimitInGB")
    public CreatePurchaseV2RequestBuilder dataLimitInGb(Double value) {
      this.dataLimitInGb = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> quantity = JsonNullable.undefined();

    @JsonProperty("quantity")
    public CreatePurchaseV2RequestBuilder quantity(Double value) {
      this.quantity = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> startDate = JsonNullable.undefined();

    @JsonProperty("startDate")
    public CreatePurchaseV2RequestBuilder startDate(String value) {
      this.startDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> endDate = JsonNullable.undefined();

    @JsonProperty("endDate")
    public CreatePurchaseV2RequestBuilder endDate(String value) {
      this.endDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> duration = JsonNullable.undefined();

    @JsonProperty("duration")
    public CreatePurchaseV2RequestBuilder duration(Double value) {
      this.duration = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> email = JsonNullable.undefined();

    @JsonProperty("email")
    public CreatePurchaseV2RequestBuilder email(String value) {
      this.email = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> referenceId = JsonNullable.undefined();

    @JsonProperty("referenceId")
    public CreatePurchaseV2RequestBuilder referenceId(String value) {
      this.referenceId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> networkBrand = JsonNullable.undefined();

    @JsonProperty("networkBrand")
    public CreatePurchaseV2RequestBuilder networkBrand(String value) {
      this.networkBrand = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> emailBrand = JsonNullable.undefined();

    @JsonProperty("emailBrand")
    public CreatePurchaseV2RequestBuilder emailBrand(String value) {
      this.emailBrand = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> language = JsonNullable.undefined();

    @JsonProperty("language")
    public CreatePurchaseV2RequestBuilder language(String value) {
      this.language = JsonNullable.of(value);
      return this;
    }
  }
}
