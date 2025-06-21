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
public class GetAccessTokenOkResponse {

  @JsonProperty("access_token")
  private JsonNullable<String> accessToken;

  @JsonProperty("token_type")
  private JsonNullable<String> tokenType;

  @JsonProperty("expires_in")
  private JsonNullable<Long> expiresIn;

  @JsonIgnore
  public String getAccessToken() {
    return accessToken.orElse(null);
  }

  @JsonIgnore
  public String getTokenType() {
    return tokenType.orElse(null);
  }

  @JsonIgnore
  public Long getExpiresIn() {
    return expiresIn.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class GetAccessTokenOkResponseBuilder {

    private JsonNullable<String> accessToken = JsonNullable.undefined();

    @JsonProperty("access_token")
    public GetAccessTokenOkResponseBuilder accessToken(String value) {
      if (value == null) {
        throw new IllegalStateException("accessToken cannot be null");
      }
      this.accessToken = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> tokenType = JsonNullable.undefined();

    @JsonProperty("token_type")
    public GetAccessTokenOkResponseBuilder tokenType(String value) {
      if (value == null) {
        throw new IllegalStateException("tokenType cannot be null");
      }
      this.tokenType = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> expiresIn = JsonNullable.undefined();

    @JsonProperty("expires_in")
    public GetAccessTokenOkResponseBuilder expiresIn(Long value) {
      if (value == null) {
        throw new IllegalStateException("expiresIn cannot be null");
      }
      this.expiresIn = JsonNullable.of(value);
      return this;
    }
  }
}
