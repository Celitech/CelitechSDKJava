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
public class History {

  /**
   * The status of the eSIM at a given time, possible values are 'RELEASED', 'DOWNLOADED', 'INSTALLED', 'ENABLED', 'DELETED', or 'ERROR'
   */
  @JsonProperty("status")
  private JsonNullable<String> status;

  /**
   * The date when the eSIM status changed in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @JsonProperty("statusDate")
  private JsonNullable<String> statusDate;

  /**
   * Epoch value representing the date when the eSIM status changed
   */
  @JsonProperty("date")
  private JsonNullable<Double> date;

  @JsonIgnore
  public String getStatus() {
    return status.orElse(null);
  }

  @JsonIgnore
  public String getStatusDate() {
    return statusDate.orElse(null);
  }

  @JsonIgnore
  public Double getDate() {
    return date.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class HistoryBuilder {

    private JsonNullable<String> status = JsonNullable.undefined();

    @JsonProperty("status")
    public HistoryBuilder status(String value) {
      if (value == null) {
        throw new IllegalStateException("status cannot be null");
      }
      this.status = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> statusDate = JsonNullable.undefined();

    @JsonProperty("statusDate")
    public HistoryBuilder statusDate(String value) {
      if (value == null) {
        throw new IllegalStateException("statusDate cannot be null");
      }
      this.statusDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> date = JsonNullable.undefined();

    @JsonProperty("date")
    public HistoryBuilder date(Double value) {
      if (value == null) {
        throw new IllegalStateException("date cannot be null");
      }
      this.date = JsonNullable.of(value);
      return this;
    }
  }
}
