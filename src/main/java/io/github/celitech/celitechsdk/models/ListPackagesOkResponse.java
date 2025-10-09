package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class ListPackagesOkResponse {

  @NonNull
  private List<Packages> packages;

  /**
   * The cursor value representing the end of the current page of results. Use this cursor value as the "afterCursor" parameter in your next request to retrieve the subsequent page of results. It ensures that you continue fetching data from where you left off, facilitating smooth pagination
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String afterCursor;

  // Overwrite lombok builder methods
  public static class ListPackagesOkResponseBuilder {

    /**
     * Flag to track if the afterCursor property has been set.
     */
    private boolean afterCursor$set = false;

    public ListPackagesOkResponseBuilder afterCursor(String afterCursor) {
      this.afterCursor$set = true;
      this.afterCursor = afterCursor;
      return this;
    }

    public ListPackagesOkResponse build() {
      if (!afterCursor$set) {
        throw new IllegalStateException("afterCursor is required");
      }
      return new ListPackagesOkResponse(packages, afterCursor);
    }
  }
}
