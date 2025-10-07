package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.CreatePurchaseV2OkResponse;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;

public class CreatePurchaseV2OkResponseValidator extends AbstractModelValidator<CreatePurchaseV2OkResponse> {

  public CreatePurchaseV2OkResponseValidator(String fieldName) {
    super(fieldName);
  }

  public CreatePurchaseV2OkResponseValidator() {}

  @Override
  protected Violation[] validateModel(CreatePurchaseV2OkResponse createPurchaseV2OkResponse) {
    return new ViolationAggregator()
      .add(
        new CreatePurchaseV2OkResponseProfileValidator("profile")
          .required()
          .validate(createPurchaseV2OkResponse.getProfile())
      )
      .aggregate();
  }
}
