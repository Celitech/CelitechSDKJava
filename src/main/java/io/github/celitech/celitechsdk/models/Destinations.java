package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

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
  @NonNull
  private String name;

  /**
   * ISO3 representation of the destination
   */
  @NonNull
  private String destination;

  /**
   * ISO2 representation of the destination
   */
  @NonNull
  @JsonProperty("destinationISO2")
  private String destinationIso2;

  /**
   * This array indicates the geographical area covered by a specific destination. If the destination represents a single country, the array will include that country. However, if the destination represents a broader regional scope, the array will be populated with the names of the countries belonging to that region.
   */
  @NonNull
  private List<String> supportedCountries;
}
