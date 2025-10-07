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
public class EditPurchaseOkResponse {

  /**
   * ID of the purchase
   */
  @NonNull
  private String purchaseId;

  /**
   * Start date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @NonNull
  private String newStartDate;

  /**
   * End date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @NonNull
  private String newEndDate;

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
  public Double getNewStartTime() {
    return newStartTime.orElse(null);
  }

  @JsonIgnore
  public Double getNewEndTime() {
    return newEndTime.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class EditPurchaseOkResponseBuilder {

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
