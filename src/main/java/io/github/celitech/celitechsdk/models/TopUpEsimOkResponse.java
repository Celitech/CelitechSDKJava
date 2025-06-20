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
public class TopUpEsimOkResponse {

  @JsonProperty("purchase")
  private JsonNullable<TopUpEsimOkResponsePurchase> purchase;

  @JsonProperty("profile")
  private JsonNullable<TopUpEsimOkResponseProfile> profile;

  @JsonIgnore
  public TopUpEsimOkResponsePurchase getPurchase() {
    return purchase.orElse(null);
  }

  @JsonIgnore
  public TopUpEsimOkResponseProfile getProfile() {
    return profile.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class TopUpEsimOkResponseBuilder {

    private JsonNullable<TopUpEsimOkResponsePurchase> purchase = JsonNullable.undefined();

    @JsonProperty("purchase")
    public TopUpEsimOkResponseBuilder purchase(TopUpEsimOkResponsePurchase value) {
      if (value == null) {
        throw new IllegalStateException("purchase cannot be null");
      }
      this.purchase = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<TopUpEsimOkResponseProfile> profile = JsonNullable.undefined();

    @JsonProperty("profile")
    public TopUpEsimOkResponseBuilder profile(TopUpEsimOkResponseProfile value) {
      if (value == null) {
        throw new IllegalStateException("profile cannot be null");
      }
      this.profile = JsonNullable.of(value);
      return this;
    }
  }
}
