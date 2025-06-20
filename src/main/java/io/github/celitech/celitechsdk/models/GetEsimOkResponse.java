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
public class GetEsimOkResponse {

  @JsonProperty("esim")
  private JsonNullable<GetEsimOkResponseEsim> esim;

  @JsonIgnore
  public GetEsimOkResponseEsim getEsim() {
    return esim.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class GetEsimOkResponseBuilder {

    private JsonNullable<GetEsimOkResponseEsim> esim = JsonNullable.undefined();

    @JsonProperty("esim")
    public GetEsimOkResponseBuilder esim(GetEsimOkResponseEsim value) {
      if (value == null) {
        throw new IllegalStateException("esim cannot be null");
      }
      this.esim = JsonNullable.of(value);
      return this;
    }
  }
}
