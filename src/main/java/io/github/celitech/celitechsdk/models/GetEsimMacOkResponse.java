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
public class GetEsimMacOkResponse {

  @JsonProperty("esim")
  private JsonNullable<GetEsimMacOkResponseEsim> esim;

  @JsonIgnore
  public GetEsimMacOkResponseEsim getEsim() {
    return esim.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class GetEsimMacOkResponseBuilder {

    private JsonNullable<GetEsimMacOkResponseEsim> esim = JsonNullable.undefined();

    @JsonProperty("esim")
    public GetEsimMacOkResponseBuilder esim(GetEsimMacOkResponseEsim value) {
      if (value == null) {
        throw new IllegalStateException("esim cannot be null");
      }
      this.esim = JsonNullable.of(value);
      return this;
    }
  }
}
