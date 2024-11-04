package io.github.Celitech.celitechsdk.validation.validators.modelValidators;

import io.github.Celitech.celitechsdk.models.TopUpEsimOkResponseProfile;
import io.github.Celitech.celitechsdk.validation.Violation;
import io.github.Celitech.celitechsdk.validation.ViolationAggregator;
import io.github.Celitech.celitechsdk.validation.validators.StringValidator;

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
