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
public class OAuthTokenResponse {

  @JsonProperty("access_token")
  private JsonNullable<String> accessToken;

  @JsonProperty("expires_in")
  private JsonNullable<Long> expiresIn;

  @JsonIgnore
  public String getAccessToken() {
    return accessToken.orElse(null);
  }

  @JsonIgnore
  public Long getExpiresIn() {
    return expiresIn.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class OAuthTokenResponseBuilder {

    private JsonNullable<String> accessToken = JsonNullable.undefined();

    @JsonProperty("access_token")
    public OAuthTokenResponseBuilder accessToken(String value) {
      if (value == null) {
        throw new IllegalStateException("accessToken cannot be null");
      }
      this.accessToken = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> expiresIn = JsonNullable.undefined();

    @JsonProperty("expires_in")
    public OAuthTokenResponseBuilder expiresIn(Long value) {
      this.expiresIn = JsonNullable.of(value);
      return this;
    }
  }
}
