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
public class GetESimParameters {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("Accept")
  private String accept;

  /**
   * ID of the eSIM
   */
  @JsonProperty("iccid")
  private JsonNullable<String> iccid;

  @JsonIgnore
  public String getIccid() {
    return iccid.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class GetESimParametersBuilder {

    /**
     * Flag to track if the accept property has been set.
     */
    private boolean accept$set = false;

    public GetESimParametersBuilder accept(String accept) {
      this.accept$set = true;
      this.accept = accept;
      return this;
    }

    private JsonNullable<String> iccid = JsonNullable.undefined();

    @JsonProperty("iccid")
    public GetESimParametersBuilder iccid(String value) {
      this.iccid = JsonNullable.of(value);
      return this;
    }

    public GetESimParameters build() {
      if (!accept$set) {
        throw new IllegalStateException("accept is required");
      }
      return new GetESimParameters(accept, iccid);
    }
  }
}
