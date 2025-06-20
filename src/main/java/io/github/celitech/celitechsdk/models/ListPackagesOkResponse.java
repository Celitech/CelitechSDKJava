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
public class ListPackagesOkResponse {

  @JsonProperty("packages")
  private JsonNullable<List<Packages>> packages;

  /**
   * The cursor value representing the end of the current page of results. Use this cursor value as the "afterCursor" parameter in your next request to retrieve the subsequent page of results. It ensures that you continue fetching data from where you left off, facilitating smooth pagination
   */
  @JsonProperty("afterCursor")
  private JsonNullable<String> afterCursor;

  @JsonIgnore
  public List<Packages> getPackages() {
    return packages.orElse(null);
  }

  @JsonIgnore
  public String getAfterCursor() {
    return afterCursor.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListPackagesOkResponseBuilder {

    private JsonNullable<List<Packages>> packages = JsonNullable.undefined();

    @JsonProperty("packages")
    public ListPackagesOkResponseBuilder packages(List<Packages> value) {
      if (value == null) {
        throw new IllegalStateException("packages cannot be null");
      }
      this.packages = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> afterCursor = JsonNullable.undefined();

    @JsonProperty("afterCursor")
    public ListPackagesOkResponseBuilder afterCursor(String value) {
      this.afterCursor = JsonNullable.of(value);
      return this;
    }
  }
}
