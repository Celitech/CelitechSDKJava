package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
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

  // FSM-59: capture unknown JSON fields so they round-trip on re-serialize.
  // @Builder.Default keeps the empty-map default in the Lombok-generated builder; without it the
  // builder would leave the map null and the any-setter would NPE on the first unknown field.
  // Deserialization is wired via the builder's @JsonAnySetter (see the Builder below), NOT here:
  // Lombok @Jacksonized deserializes through the builder and does not copy a field-level
  // @JsonAnySetter across, so unknown fields would be silently dropped if it lived on this field.
  @Builder.Default
  private Map<String, Object> additionalProperties = new HashMap<>();

  // @JsonAnyGetter must sit on the getter (not the field) so Jackson inlines the unknown entries on
  // serialize. On the field it double-registers with the Lombok getter and leaks a literal
  // "additionalProperties" property into every request body and object parameter.
  // Declaring the getter here also stops Lombok @Data from generating its own.
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

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

    @JsonAnySetter
    public OAuthTokenResponseBuilder additionalProperties(String key, Object value) {
      if (this.additionalProperties$value == null) {
        this.additionalProperties$value = new HashMap<>();
      }
      this.additionalProperties$value.put(key, value);
      this.additionalProperties$set = true;
      return this;
    }
  }
}
