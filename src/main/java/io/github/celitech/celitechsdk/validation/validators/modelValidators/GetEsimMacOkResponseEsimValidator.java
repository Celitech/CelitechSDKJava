package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.GetEsimMacOkResponseEsim;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

public class GetEsimMacOkResponseEsimValidator extends AbstractModelValidator<GetEsimMacOkResponseEsim> {

  public GetEsimMacOkResponseEsimValidator(String fieldName) {
    super(fieldName);
  }

  public GetEsimMacOkResponseEsimValidator() {}

  @Override
  protected Violation[] validateModel(GetEsimMacOkResponseEsim getEsimMacOkResponseEsim) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid")
          .minLength(18)
          .maxLength(22)
          .optional()
          .validate(getEsimMacOkResponseEsim.getIccid())
      )
      .aggregate();
  }
}