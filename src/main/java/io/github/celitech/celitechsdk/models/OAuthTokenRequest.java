package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class OAuthTokenRequest {

  @NonNull
  @JsonProperty("grant_type")
  private GrantType grantType;

  @NonNull
  @JsonProperty("client_id")
  private String clientId;

  @NonNull
  @JsonProperty("client_secret")
  private String clientSecret;

  @NonNull
  private String scope;
}
