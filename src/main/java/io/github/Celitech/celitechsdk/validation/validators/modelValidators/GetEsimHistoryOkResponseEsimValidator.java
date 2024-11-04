package io.github.Celitech.celitechsdk.validation.validators.modelValidators;

import io.github.Celitech.celitechsdk.models.GetEsimHistoryOkResponseEsim;
import io.github.Celitech.celitechsdk.validation.Violation;
import io.github.Celitech.celitechsdk.validation.ViolationAggregator;
import io.github.Celitech.celitechsdk.validation.validators.StringValidator;

public class GetEsimHistoryOkResponseEsimValidator extends AbstractModelValidator<GetEsimHistoryOkResponseEsim> {

  public GetEsimHistoryOkResponseEsimValidator(String fieldName) {
    super(fieldName);
  }

  public GetEsimHistoryOkResponseEsimValidator() {}

  @Override
  protected Violation[] validateModel(GetEsimHistoryOkResponseEsim getEsimHistoryOkResponseEsim) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid")
          .minLength(18)
          .maxLength(22)
          .optional()
          .validate(getEsimHistoryOkResponseEsim.getIccid())
      )
      .aggregate();
  }
}
