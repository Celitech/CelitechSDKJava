package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.TopUpEsimOkResponseProfile;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

public class TopUpEsimOkResponseProfileValidator extends AbstractModelValidator<TopUpEsimOkResponseProfile> {

  public TopUpEsimOkResponseProfileValidator(String fieldName) {
    super(fieldName);
  }

  public TopUpEsimOkResponseProfileValidator() {}

  @Override
  protected Violation[] validateModel(TopUpEsimOkResponseProfile topUpEsimOkResponseProfile) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid")
          .minLength(18)
          .maxLength(22)
          .optional()
          .validate(topUpEsimOkResponseProfile.getIccid())
      )
      .aggregate();
  }
}
