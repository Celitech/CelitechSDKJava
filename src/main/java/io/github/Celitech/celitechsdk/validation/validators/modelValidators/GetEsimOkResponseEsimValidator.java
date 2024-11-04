package io.github.Celitech.celitechsdk.validation.validators.modelValidators;

import io.github.Celitech.celitechsdk.models.GetEsimOkResponseEsim;
import io.github.Celitech.celitechsdk.validation.Violation;
import io.github.Celitech.celitechsdk.validation.ViolationAggregator;
import io.github.Celitech.celitechsdk.validation.validators.StringValidator;

public class GetEsimOkResponseEsimValidator extends AbstractModelValidator<GetEsimOkResponseEsim> {

  public GetEsimOkResponseEsimValidator(String fieldName) {
    super(fieldName);
  }

  public GetEsimOkResponseEsimValidator() {}

  @Override
  protected Violation[] validateModel(GetEsimOkResponseEsim getEsimOkResponseEsim) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid").minLength(18).maxLength(22).optional().validate(getEsimOkResponseEsim.getIccid())
      )
      .aggregate();
  }
}
