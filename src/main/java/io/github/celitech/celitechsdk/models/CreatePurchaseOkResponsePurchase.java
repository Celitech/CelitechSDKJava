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
public class CreatePurchaseOkResponsePurchase {

  /**
   * ID of the purchase
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * ID of the package
   */
  @JsonProperty("packageId")
  private JsonNullable<String> packageId;

  /**
   * Start date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @JsonProperty("startDate")
  private JsonNullable<String> startDate;

  /**
   * End date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @JsonProperty("endDate")
  private JsonNullable<String> endDate;

  /**
   * Creation date of the purchase in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @JsonProperty("createdDate")
  private JsonNullable<String> createdDate;

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
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getPackageId() {
    return packageId.orElse(null);
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
  public String getCreatedDate() {
    return createdDate.orElse(null);
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
  public static class CreatePurchaseOkResponsePurchaseBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public CreatePurchaseOkResponsePurchaseBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> packageId = JsonNullable.undefined();

    @JsonProperty("packageId")
    public CreatePurchaseOkResponsePurchaseBuilder packageId(String value) {
      if (value == null) {
        throw new IllegalStateException("packageId cannot be null");
      }
      this.packageId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> startDate = JsonNullable.undefined();

    @JsonProperty("startDate")
    public CreatePurchaseOkResponsePurchaseBuilder startDate(String value) {
      if (value == null) {
        throw new IllegalStateException("startDate cannot be null");
      }
      this.startDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> endDate = JsonNullable.undefined();

    @JsonProperty("endDate")
    public CreatePurchaseOkResponsePurchaseBuilder endDate(String value) {
      if (value == null) {
        throw new IllegalStateException("endDate cannot be null");
      }
      this.endDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> createdDate = JsonNullable.undefined();

    @JsonProperty("createdDate")
    public CreatePurchaseOkResponsePurchaseBuilder createdDate(String value) {
      if (value == null) {
        throw new IllegalStateException("createdDate cannot be null");
      }
      this.createdDate = JsonNullable.of(value);
      return this;
    }

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
