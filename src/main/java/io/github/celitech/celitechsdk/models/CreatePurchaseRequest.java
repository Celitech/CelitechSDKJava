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
public class CreatePurchaseRequest {

  @JsonProperty("destination")
  private JsonNullable<String> destination;

  @JsonProperty("dataLimitInGB")
  private JsonNullable<Double> dataLimitInGb;

  @JsonProperty("startDate")
  private JsonNullable<String> startDate;

  @JsonProperty("endDate")
  private JsonNullable<String> endDate;

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

  @JsonProperty("startTime")
  private JsonNullable<Double> startTime;

  @JsonProperty("endTime")
  private JsonNullable<Double> endTime;

  @JsonIgnore
  public String getDestination() {
    return destination.orElse(null);
  }

  @JsonIgnore
  public Double getDataLimitInGb() {
    return dataLimitInGb.orElse(null);
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

    private JsonNullable<String> destination = JsonNullable.undefined();

    @JsonProperty("destination")
    public CreatePurchaseRequestBuilder destination(String value) {
      this.destination = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> dataLimitInGb = JsonNullable.undefined();

    @JsonProperty("dataLimitInGB")
    public CreatePurchaseRequestBuilder dataLimitInGb(Double value) {
      this.dataLimitInGb = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> startDate = JsonNullable.undefined();

    @JsonProperty("startDate")
    public CreatePurchaseRequestBuilder startDate(String value) {
      this.startDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> endDate = JsonNullable.undefined();

    @JsonProperty("endDate")
    public CreatePurchaseRequestBuilder endDate(String value) {
      this.endDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> email = JsonNullable.undefined();

    @JsonProperty("email")
    public CreatePurchaseRequestBuilder email(String value) {
      this.email = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> referenceId = JsonNullable.undefined();

    @JsonProperty("referenceId")
    public CreatePurchaseRequestBuilder referenceId(String value) {
      this.referenceId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> networkBrand = JsonNullable.undefined();

    @JsonProperty("networkBrand")
    public CreatePurchaseRequestBuilder networkBrand(String value) {
      this.networkBrand = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> emailBrand = JsonNullable.undefined();

    @JsonProperty("emailBrand")
    public CreatePurchaseRequestBuilder emailBrand(String value) {
      this.emailBrand = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> language = JsonNullable.undefined();

    @JsonProperty("language")
    public CreatePurchaseRequestBuilder language(String value) {
      this.language = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> startTime = JsonNullable.undefined();

    @JsonProperty("startTime")
    public CreatePurchaseRequestBuilder startTime(Double value) {
      this.startTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> endTime = JsonNullable.undefined();

    @JsonProperty("endTime")
    public CreatePurchaseRequestBuilder endTime(Double value) {
      this.endTime = JsonNullable.of(value);
      return this;
    }
  }
}
