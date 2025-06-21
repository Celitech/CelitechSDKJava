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
public class EditPurchaseRequest {

  /**
   * ID of the purchase
   */
  @NonNull
  private String purchaseId;

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
  public Double getStartTime() {
    return startTime.orElse(null);
  }

  @JsonIgnore
  public Double getEndTime() {
    return endTime.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class EditPurchaseRequestBuilder {

    private JsonNullable<Double> startTime = JsonNullable.undefined();

    @JsonProperty("startTime")
    public EditPurchaseRequestBuilder startTime(Double value) {
      if (value == null) {
        throw new IllegalStateException("startTime cannot be null");
      }
      this.startTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> endTime = JsonNullable.undefined();

    @JsonProperty("endTime")
    public EditPurchaseRequestBuilder endTime(Double value) {
      if (value == null) {
        throw new IllegalStateException("endTime cannot be null");
      }
      this.endTime = JsonNullable.of(value);
      return this;
    }
  }
}
