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
public class CreatePurchaseV2OkResponse {

  @JsonProperty("purchase")
  private JsonNullable<CreatePurchaseV2OkResponsePurchase> purchase;

  @JsonProperty("profile")
  private JsonNullable<CreatePurchaseV2OkResponseProfile> profile;

  @JsonIgnore
  public CreatePurchaseV2OkResponsePurchase getPurchase() {
    return purchase.orElse(null);
  }

  @JsonIgnore
  public CreatePurchaseV2OkResponseProfile getProfile() {
    return profile.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreatePurchaseV2OkResponseBuilder {

    private JsonNullable<CreatePurchaseV2OkResponsePurchase> purchase = JsonNullable.undefined();

    @JsonProperty("purchase")
    public CreatePurchaseV2OkResponseBuilder purchase(CreatePurchaseV2OkResponsePurchase value) {
      if (value == null) {
        throw new IllegalStateException("purchase cannot be null");
      }
      this.purchase = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<CreatePurchaseV2OkResponseProfile> profile = JsonNullable.undefined();

    @JsonProperty("profile")
    public CreatePurchaseV2OkResponseBuilder profile(CreatePurchaseV2OkResponseProfile value) {
      if (value == null) {
        throw new IllegalStateException("profile cannot be null");
      }
      this.profile = JsonNullable.of(value);
      return this;
    }
  }
}
