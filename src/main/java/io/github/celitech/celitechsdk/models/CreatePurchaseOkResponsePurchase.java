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
public class CreatePurchaseOkResponsePurchase {

  /**
   * ID of the purchase
   */
  @NonNull
  private String id;

  /**
   * ID of the package
   */
  @NonNull
  private String packageId;

  /**
   * Start date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @NonNull
  private String startDate;

  /**
   * End date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @NonNull
  private String endDate;

  /**
   * Creation date of the purchase in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @NonNull
  private String createdDate;

  /**
   * Epoch value representing the start time of the package's validity
   */
  @JsonProperty("startTime")
  private JsonNullable<Double> startTime;

  /**
   * Epoch value representing the end time of the package's validity
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
  public static class CreatePurchaseOkResponsePurchaseBuilder {

    private JsonNullable<Double> startTime = JsonNullable.undefined();

    @JsonProperty("startTime")
    public CreatePurchaseOkResponsePurchaseBuilder startTime(Double value) {
      if (value == null) {
        throw new IllegalStateException("startTime cannot be null");
      }
      this.startTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> endTime = JsonNullable.undefined();

    @JsonProperty("endTime")
    public CreatePurchaseOkResponsePurchaseBuilder endTime(Double value) {
      if (value == null) {
        throw new IllegalStateException("endTime cannot be null");
      }
      this.endTime = JsonNullable.of(value);
      return this;
    }
  }
}
