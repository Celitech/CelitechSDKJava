package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class ListPackagesParameters {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("Accept")
  private String accept;

  /**
   * ISO representation of the package's destination. Supports both ISO2 (e.g., 'FR') and ISO3 (e.g., 'FRA') country codes.
   */
  @JsonProperty("destination")
  private JsonNullable<String> destination;

  /**
   * Start date of the package's validity in the format 'yyyy-MM-dd'. This date can be set to the current day or any day within the next 12 months.
   */
  @JsonProperty("startDate")
  private JsonNullable<String> startDate;

  /**
   * End date of the package's validity in the format 'yyyy-MM-dd'. End date can be maximum 90 days after Start date.
   */
  @JsonProperty("endDate")
  private JsonNullable<String> endDate;

  /**
   * To get the next batch of results, use this parameter. It tells the API where to start fetching data after the last item you received. It helps you avoid repeats and efficiently browse through large sets of data.
   */
  @JsonProperty("afterCursor")
  private JsonNullable<String> afterCursor;

  /**
   * Maximum number of packages to be returned in the response. The value must be greater than 0 and less than or equal to 160. If not provided, the default value is 20
   */
  @JsonProperty("limit")
  private JsonNullable<String> limit;

  /**
   * Epoch value representing the start time of the package's validity. This timestamp can be set to the current time or any time within the next 12 months
   */
  @JsonProperty("startTime")
  private JsonNullable<String> startTime;

  /**
   * Epoch value representing the end time of the package's validity. End time can be maximum 90 days after Start time
   */
  @JsonProperty("endTime")
  private JsonNullable<String> endTime;

  @JsonIgnore
  public String getDestination() {
    return destination.orElse(null);
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
  public String getAfterCursor() {
    return afterCursor.orElse(null);
  }

  @JsonIgnore
  public String getLimit() {
    return limit.orElse(null);
  }

  @JsonIgnore
  public String getStartTime() {
    return startTime.orElse(null);
  }

  @JsonIgnore
  public String getEndTime() {
    return endTime.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListPackagesParametersBuilder {

    /**
     * Flag to track if the accept property has been set.
     */
    private boolean accept$set = false;

    public ListPackagesParametersBuilder accept(String accept) {
      this.accept$set = true;
      this.accept = accept;
      return this;
    }

    private JsonNullable<String> destination = JsonNullable.undefined();

    @JsonProperty("destination")
    public ListPackagesParametersBuilder destination(String value) {
      this.destination = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> startDate = JsonNullable.undefined();

    @JsonProperty("startDate")
    public ListPackagesParametersBuilder startDate(String value) {
      this.startDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> endDate = JsonNullable.undefined();

    @JsonProperty("endDate")
    public ListPackagesParametersBuilder endDate(String value) {
      this.endDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> afterCursor = JsonNullable.undefined();

    @JsonProperty("afterCursor")
    public ListPackagesParametersBuilder afterCursor(String value) {
      this.afterCursor = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> limit = JsonNullable.undefined();

    @JsonProperty("limit")
    public ListPackagesParametersBuilder limit(String value) {
      this.limit = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> startTime = JsonNullable.undefined();

    @JsonProperty("startTime")
    public ListPackagesParametersBuilder startTime(String value) {
      this.startTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> endTime = JsonNullable.undefined();

    @JsonProperty("endTime")
    public ListPackagesParametersBuilder endTime(String value) {
      this.endTime = JsonNullable.of(value);
      return this;
    }

    public ListPackagesParameters build() {
      if (!accept$set) {
        throw new IllegalStateException("accept is required");
      }
      return new ListPackagesParameters(
        accept,
        destination,
        startDate,
        endDate,
        afterCursor,
        limit,
        startTime,
        endTime
      );
    }
  }
}
