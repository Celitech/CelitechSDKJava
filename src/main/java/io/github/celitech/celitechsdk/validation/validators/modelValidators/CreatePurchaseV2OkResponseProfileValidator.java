package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.CreatePurchaseV2OkResponseProfile;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

public class CreatePurchaseV2OkResponseProfileValidator
  extends AbstractModelValidator<CreatePurchaseV2OkResponseProfile> {

  public CreatePurchaseV2OkResponseProfileValidator(String fieldName) {
    super(fieldName);
  }

  public CreatePurchaseV2OkResponseProfileValidator() {}

  @Override
  protected Violation[] validateModel(CreatePurchaseV2OkResponseProfile createPurchaseV2OkResponseProfile) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid")
          .minLength(18)
          .maxLength(22)
          .optional()
          .validate(createPurchaseV2OkResponseProfile.getIccid())
      )
      .aggregate();
  }
}
