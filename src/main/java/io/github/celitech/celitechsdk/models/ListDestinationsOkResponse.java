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
public class ListDestinationsOkResponse {

  @JsonProperty("destinations")
  private JsonNullable<List<Destinations>> destinations;

  @JsonIgnore
  public List<Destinations> getDestinations() {
    return destinations.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListDestinationsOkResponseBuilder {

    private JsonNullable<List<Destinations>> destinations = JsonNullable.undefined();

    @JsonProperty("destinations")
    public ListDestinationsOkResponseBuilder destinations(List<Destinations> value) {
      if (value == null) {
        throw new IllegalStateException("destinations cannot be null");
      }
      this.destinations = JsonNullable.of(value);
      return this;
    }
  }
}
