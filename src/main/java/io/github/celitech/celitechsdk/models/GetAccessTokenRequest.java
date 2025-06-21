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
public class GetAccessTokenRequest {

  @JsonProperty("grant_type")
  private JsonNullable<GrantType> grantType;

  @JsonProperty("client_id")
  private JsonNullable<String> clientId;

  @JsonProperty("client_secret")
  private JsonNullable<String> clientSecret;

  @JsonIgnore
  public GrantType getGrantType() {
    return grantType.orElse(null);
  }

  @JsonIgnore
  public String getClientId() {
    return clientId.orElse(null);
  }

  @JsonIgnore
  public String getClientSecret() {
    return clientSecret.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class GetAccessTokenRequestBuilder {

    private JsonNullable<GrantType> grantType = JsonNullable.undefined();

    @JsonProperty("grant_type")
    public GetAccessTokenRequestBuilder grantType(GrantType value) {
      if (value == null) {
        throw new IllegalStateException("grantType cannot be null");
      }
      this.grantType = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> clientId = JsonNullable.undefined();

    @JsonProperty("client_id")
    public GetAccessTokenRequestBuilder clientId(String value) {
      if (value == null) {
        throw new IllegalStateException("clientId cannot be null");
      }
      this.clientId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> clientSecret = JsonNullable.undefined();

    @JsonProperty("client_secret")
    public GetAccessTokenRequestBuilder clientSecret(String value) {
      if (value == null) {
        throw new IllegalStateException("clientSecret cannot be null");
      }
      this.clientSecret = JsonNullable.of(value);
      return this;
    }
  }
}
