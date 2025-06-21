package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class Destinations {

  /**
   * Name of the destination
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  /**
   * ISO representation of the destination
   */
  @JsonProperty("destination")
  private JsonNullable<String> destination;

  /**
   * This array indicates the geographical area covered by a specific destination. If the destination represents a single country, the array will include that country. However, if the destination represents a broader regional scope, the array will be populated with the names of the countries belonging to that region.
   */
  @JsonProperty("supportedCountries")
  private JsonNullable<List<String>> supportedCountries;

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getDestination() {
    return destination.orElse(null);
  }

  @JsonIgnore
  public List<String> getSupportedCountries() {
    return supportedCountries.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class DestinationsBuilder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public DestinationsBuilder name(String value) {
      if (value == null) {
        throw new IllegalStateException("name cannot be null");
      }
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> destination = JsonNullable.undefined();

    @JsonProperty("destination")
    public DestinationsBuilder destination(String value) {
      if (value == null) {
        throw new IllegalStateException("destination cannot be null");
      }
      this.destination = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> supportedCountries = JsonNullable.undefined();

    @JsonProperty("supportedCountries")
    public DestinationsBuilder supportedCountries(List<String> value) {
      if (value == null) {
        throw new IllegalStateException("supportedCountries cannot be null");
      }
      this.supportedCountries = JsonNullable.of(value);
      return this;
    }
  }
}
