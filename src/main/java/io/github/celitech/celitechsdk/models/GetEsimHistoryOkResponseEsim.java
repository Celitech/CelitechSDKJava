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
public class GetEsimHistoryOkResponseEsim {

  /**
   * ID of the eSIM
   */
  @JsonProperty("iccid")
  private JsonNullable<String> iccid;

  @JsonProperty("history")
  private JsonNullable<List<History>> history;

  @JsonIgnore
  public String getIccid() {
    return iccid.orElse(null);
  }

  @JsonIgnore
  public List<History> getHistory() {
    return history.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class GetEsimHistoryOkResponseEsimBuilder {

    private JsonNullable<String> iccid = JsonNullable.undefined();

    @JsonProperty("iccid")
    public GetEsimHistoryOkResponseEsimBuilder iccid(String value) {
      if (value == null) {
        throw new IllegalStateException("iccid cannot be null");
      }
      this.iccid = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<History>> history = JsonNullable.undefined();

    @JsonProperty("history")
    public GetEsimHistoryOkResponseEsimBuilder history(List<History> value) {
      if (value == null) {
        throw new IllegalStateException("history cannot be null");
      }
      this.history = JsonNullable.of(value);
      return this;
    }
  }
}
