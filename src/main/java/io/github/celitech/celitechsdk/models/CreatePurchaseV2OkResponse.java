package io.github.celitech.celitechsdk.models;

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
public class CreatePurchaseV2OkResponse {

  @NonNull
  private CreatePurchaseV2OkResponsePurchase purchase;

  @NonNull
  private CreatePurchaseV2OkResponseProfile profile;
}
