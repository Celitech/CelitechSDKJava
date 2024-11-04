package io.github.Celitech.celitechsdk.validation.validators.modelValidators;

import io.github.Celitech.celitechsdk.models.CreatePurchaseOkResponseProfile;
import io.github.Celitech.celitechsdk.validation.Violation;
import io.github.Celitech.celitechsdk.validation.ViolationAggregator;
import io.github.Celitech.celitechsdk.validation.validators.StringValidator;

public class CreatePurchaseOkResponseProfileValidator extends AbstractModelValidator<CreatePurchaseOkResponseProfile> {

  public CreatePurchaseOkResponseProfileValidator(String fieldName) {
    super(fieldName);
  }

  public CreatePurchaseOkResponseProfileValidator() {}

  @Override
  protected Violation[] validateModel(CreatePurchaseOkResponseProfile createPurchaseOkResponseProfile) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid")
          .minLength(18)
          .maxLength(22)
          .optional()
          .validate(createPurchaseOkResponseProfile.getIccid())
      )
      .add(
        new StringValidator("activationCode")
          .minLength(1000)
          .maxLength(8000)
          .optional()
          .validate(createPurchaseOkResponseProfile.getActivationCode())
      )
      .aggregate();
  }
}
