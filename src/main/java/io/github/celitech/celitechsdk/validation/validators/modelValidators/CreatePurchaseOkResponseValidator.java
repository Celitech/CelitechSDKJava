package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.CreatePurchaseOkResponse;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;

public class CreatePurchaseOkResponseValidator extends AbstractModelValidator<CreatePurchaseOkResponse> {

  public CreatePurchaseOkResponseValidator(String fieldName) {
    super(fieldName);
  }

  public CreatePurchaseOkResponseValidator() {}

  @Override
  protected Violation[] validateModel(CreatePurchaseOkResponse createPurchaseOkResponse) {
    return new ViolationAggregator()
      .add(
        new CreatePurchaseOkResponseProfileValidator("profile")
          .optional()
          .validate(createPurchaseOkResponse.getProfile())
      )
      .aggregate();
  }
}