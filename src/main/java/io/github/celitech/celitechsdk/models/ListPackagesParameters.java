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

  /**
   * ISO representation of the package's destination. Supports both ISO2 (e.g., 'FR') and ISO3 (e.g., 'FRA') country codes.
   */
  @JsonProperty("destination")
  private JsonNullable<String> destination;

  /**
   * Filter packages by data limit in GB. When provided, only packages with this exact data limit are returned. Use `-1` together with `includeUnlimited=true` to return only unlimited packages. A value of `0` is ignored.
   */
  @JsonProperty("dataLimitInGB")
  private JsonNullable<Double> dataLimitInGb;

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
   * To get the next batch of results, use this parameter. It tells the API where to start fetching data after the last item you received. It helps you avoid repeats and efficiently browse through large sets of data.
   */
  @JsonProperty("afterCursor")
  private JsonNullable<String> afterCursor;

  /**
   * Maximum number of packages to be returned in the response. The value must be greater than 0 and less than or equal to 160. If not provided, the default value is 20
   */
  @JsonProperty("limit")
  private JsonNullable<Double> limit;

  /**
   * Epoch value representing the start time of the package's validity. This timestamp can be set to the current time or any time within the next 12 months
   */
  @JsonProperty("startTime")
  private JsonNullable<Long> startTime;

  /**
   * Epoch value representing the end time of the package's validity. End time can be maximum 90 days after Start time
   */
  @JsonProperty("endTime")
  private JsonNullable<Long> endTime;

  /**
   * Whether to include unlimited (date-based) packages in the results. Unlimited packages are excluded by default; set this to `true` to include them. An unlimited package has `dataLimitInGB` and `dataLimitInBytes` equal to `-1`, and is offered for 3 to 30 days with `minDays` equal to `maxDays`.
   */
  @JsonProperty("includeUnlimited")
  private JsonNullable<Boolean> includeUnlimited;

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
  public String getDestination() {
    return destination.orElse(null);
  }

  @JsonIgnore
  public Double getDataLimitInGb() {
    return dataLimitInGb.orElse(null);
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
  public String getAfterCursor() {
    return afterCursor.orElse(null);
  }

  @JsonIgnore
  public Double getLimit() {
    return limit.orElse(null);
  }

  @JsonIgnore
  public Long getStartTime() {
    return startTime.orElse(null);
  }

  @JsonIgnore
  public Long getEndTime() {
    return endTime.orElse(null);
  }

  @JsonIgnore
  public Boolean getIncludeUnlimited() {
    return includeUnlimited.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListPackagesParametersBuilder {

    private JsonNullable<String> destination = JsonNullable.undefined();

    @JsonProperty("destination")
    public ListPackagesParametersBuilder destination(String value) {
      if (value == null) {
        throw new IllegalStateException("destination cannot be null");
      }
      this.destination = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> dataLimitInGb = JsonNullable.undefined();

    @JsonProperty("dataLimitInGB")
    public ListPackagesParametersBuilder dataLimitInGb(Double value) {
      if (value == null) {
        throw new IllegalStateException("dataLimitInGb cannot be null");
      }
      this.dataLimitInGb = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<LocalDate> startDate = JsonNullable.undefined();

    @JsonProperty("startDate")
    public ListPackagesParametersBuilder startDate(LocalDate value) {
      if (value == null) {
        throw new IllegalStateException("startDate cannot be null");
      }
      this.startDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<LocalDate> endDate = JsonNullable.undefined();

    @JsonProperty("endDate")
    public ListPackagesParametersBuilder endDate(LocalDate value) {
      if (value == null) {
        throw new IllegalStateException("endDate cannot be null");
      }
      this.endDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> afterCursor = JsonNullable.undefined();

    @JsonProperty("afterCursor")
    public ListPackagesParametersBuilder afterCursor(String value) {
      if (value == null) {
        throw new IllegalStateException("afterCursor cannot be null");
      }
      this.afterCursor = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> limit = JsonNullable.undefined();

    @JsonProperty("limit")
    public ListPackagesParametersBuilder limit(Double value) {
      if (value == null) {
        throw new IllegalStateException("limit cannot be null");
      }
      this.limit = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> startTime = JsonNullable.undefined();

    @JsonProperty("startTime")
    public ListPackagesParametersBuilder startTime(Long value) {
      if (value == null) {
        throw new IllegalStateException("startTime cannot be null");
      }
      this.startTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> endTime = JsonNullable.undefined();

    @JsonProperty("endTime")
    public ListPackagesParametersBuilder endTime(Long value) {
      if (value == null) {
        throw new IllegalStateException("endTime cannot be null");
      }
      this.endTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> includeUnlimited = JsonNullable.undefined();

    @JsonProperty("includeUnlimited")
    public ListPackagesParametersBuilder includeUnlimited(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("includeUnlimited cannot be null");
      }
      this.includeUnlimited = JsonNullable.of(value);
      return this;
    }

    @JsonAnySetter
    public ListPackagesParametersBuilder additionalProperties(String key, Object value) {
      if (this.additionalProperties$value == null) {
        this.additionalProperties$value = new HashMap<>();
      }
      this.additionalProperties$value.put(key, value);
      this.additionalProperties$set = true;
      return this;
    }
  }
}
