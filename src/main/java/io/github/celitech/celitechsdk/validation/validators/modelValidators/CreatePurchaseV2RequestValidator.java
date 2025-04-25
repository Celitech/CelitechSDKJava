package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.CreatePurchaseV2Request;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.NumericValidator;

public class CreatePurchaseV2RequestValidator extends AbstractModelValidator<CreatePurchaseV2Request> {

  public CreatePurchaseV2RequestValidator(String fieldName) {
    super(fieldName);
  }

  public CreatePurchaseV2RequestValidator() {}

  @Override
  protected Violation[] validateModel(CreatePurchaseV2Request createPurchaseV2Request) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Double>("quantity")
          .min(1D)
          .max(5D)
          .required()
          .validate(createPurchaseV2Request.getQuantity())
      )
      .aggregate();
  }
}
