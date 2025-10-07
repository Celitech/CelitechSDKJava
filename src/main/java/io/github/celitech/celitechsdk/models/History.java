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
public class History {

  /**
   * The status of the eSIM at a given time, possible values are 'RELEASED', 'DOWNLOADED', 'INSTALLED', 'ENABLED', 'DELETED', or 'ERROR'
   */
  @NonNull
  private String status;

  /**
   * The date when the eSIM status changed in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @NonNull
  private String statusDate;

  /**
   * Epoch value representing the date when the eSIM status changed
   */
  @JsonProperty("date")
  private JsonNullable<Double> date;

  @JsonIgnore
  public Double getDate() {
    return date.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class HistoryBuilder {

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
