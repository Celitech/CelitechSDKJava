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
public class EditPurchaseRequest {

  @JsonProperty("purchaseId")
  private JsonNullable<String> purchaseId;

  @JsonProperty("startDate")
  private JsonNullable<String> startDate;

  @JsonProperty("endDate")
  private JsonNullable<String> endDate;

  @JsonProperty("startTime")
  private JsonNullable<Double> startTime;

  @JsonProperty("endTime")
  private JsonNullable<Double> endTime;

  @JsonIgnore
  public String getPurchaseId() {
    return purchaseId.orElse(null);
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
  public Double getStartTime() {
    return startTime.orElse(null);
  }

  @JsonIgnore
  public Double getEndTime() {
    return endTime.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class EditPurchaseRequestBuilder {

    private JsonNullable<String> purchaseId = JsonNullable.undefined();

    @JsonProperty("purchaseId")
    public EditPurchaseRequestBuilder purchaseId(String value) {
      this.purchaseId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> startDate = JsonNullable.undefined();

    @JsonProperty("startDate")
    public EditPurchaseRequestBuilder startDate(String value) {
      this.startDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> endDate = JsonNullable.undefined();

    @JsonProperty("endDate")
    public EditPurchaseRequestBuilder endDate(String value) {
      this.endDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> startTime = JsonNullable.undefined();

    @JsonProperty("startTime")
    public EditPurchaseRequestBuilder startTime(Double value) {
      this.startTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> endTime = JsonNullable.undefined();

    @JsonProperty("endTime")
    public EditPurchaseRequestBuilder endTime(Double value) {
      this.endTime = JsonNullable.of(value);
      return this;
    }
  }
}
