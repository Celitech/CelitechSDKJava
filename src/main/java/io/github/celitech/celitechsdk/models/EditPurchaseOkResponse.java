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
public class EditPurchaseOkResponse {

  /**
   * ID of the purchase
   */
  @JsonProperty("purchaseId")
  private JsonNullable<String> purchaseId;

  /**
   * Start date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @JsonProperty("newStartDate")
  private JsonNullable<String> newStartDate;

  /**
   * End date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @JsonProperty("newEndDate")
  private JsonNullable<String> newEndDate;

  /**
   * Epoch value representing the new start time of the package's validity
   */
  @JsonProperty("newStartTime")
  private JsonNullable<Double> newStartTime;

  /**
   * Epoch value representing the new end time of the package's validity
   */
  @JsonProperty("newEndTime")
  private JsonNullable<Double> newEndTime;

  @JsonIgnore
  public String getPurchaseId() {
    return purchaseId.orElse(null);
  }

  @JsonIgnore
  public String getNewStartDate() {
    return newStartDate.orElse(null);
  }

  @JsonIgnore
  public String getNewEndDate() {
    return newEndDate.orElse(null);
  }

  @JsonIgnore
  public Double getNewStartTime() {
    return newStartTime.orElse(null);
  }

  @JsonIgnore
  public Double getNewEndTime() {
    return newEndTime.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class EditPurchaseOkResponseBuilder {

    private JsonNullable<String> purchaseId = JsonNullable.undefined();

    @JsonProperty("purchaseId")
    public EditPurchaseOkResponseBuilder purchaseId(String value) {
      if (value == null) {
        throw new IllegalStateException("purchaseId cannot be null");
      }
      this.purchaseId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> newStartDate = JsonNullable.undefined();

    @JsonProperty("newStartDate")
    public EditPurchaseOkResponseBuilder newStartDate(String value) {
      if (value == null) {
        throw new IllegalStateException("newStartDate cannot be null");
      }
      this.newStartDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> newEndDate = JsonNullable.undefined();

    @JsonProperty("newEndDate")
    public EditPurchaseOkResponseBuilder newEndDate(String value) {
      if (value == null) {
        throw new IllegalStateException("newEndDate cannot be null");
      }
      this.newEndDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> newStartTime = JsonNullable.undefined();

    @JsonProperty("newStartTime")
    public EditPurchaseOkResponseBuilder newStartTime(Double value) {
      if (value == null) {
        throw new IllegalStateException("newStartTime cannot be null");
      }
      this.newStartTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> newEndTime = JsonNullable.undefined();

    @JsonProperty("newEndTime")
    public EditPurchaseOkResponseBuilder newEndTime(Double value) {
      if (value == null) {
        throw new IllegalStateException("newEndTime cannot be null");
      }
      this.newEndTime = JsonNullable.of(value);
      return this;
    }
  }
}
