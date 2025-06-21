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
public class CreatePurchaseOkResponse {

  @JsonProperty("purchase")
  private JsonNullable<CreatePurchaseOkResponsePurchase> purchase;

  @JsonProperty("profile")
  private JsonNullable<CreatePurchaseOkResponseProfile> profile;

  @JsonIgnore
  public CreatePurchaseOkResponsePurchase getPurchase() {
    return purchase.orElse(null);
  }

  @JsonIgnore
  public CreatePurchaseOkResponseProfile getProfile() {
    return profile.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreatePurchaseOkResponseBuilder {

    private JsonNullable<CreatePurchaseOkResponsePurchase> purchase = JsonNullable.undefined();

    @JsonProperty("purchase")
    public CreatePurchaseOkResponseBuilder purchase(CreatePurchaseOkResponsePurchase value) {
      if (value == null) {
        throw new IllegalStateException("purchase cannot be null");
      }
      this.purchase = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<CreatePurchaseOkResponseProfile> profile = JsonNullable.undefined();

    @JsonProperty("profile")
    public CreatePurchaseOkResponseBuilder profile(CreatePurchaseOkResponseProfile value) {
      if (value == null) {
        throw new IllegalStateException("profile cannot be null");
      }
      this.profile = JsonNullable.of(value);
      return this;
    }
  }
}
