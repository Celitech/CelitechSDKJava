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
public class TokenOkResponse {

  /**
   * The generated token
   */
  @JsonProperty("token")
  private JsonNullable<String> token;

  @JsonIgnore
  public String getToken() {
    return token.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class TokenOkResponseBuilder {

    private JsonNullable<String> token = JsonNullable.undefined();

    @JsonProperty("token")
    public TokenOkResponseBuilder token(String value) {
      if (value == null) {
        throw new IllegalStateException("token cannot be null");
      }
      this.token = JsonNullable.of(value);
      return this;
    }
  }
}
