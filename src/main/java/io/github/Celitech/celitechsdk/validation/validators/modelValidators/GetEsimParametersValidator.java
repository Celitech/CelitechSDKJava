package io.github.Celitech.celitechsdk.validation.validators.modelValidators;

import io.github.Celitech.celitechsdk.models.GetEsimParameters;
import io.github.Celitech.celitechsdk.validation.Violation;
import io.github.Celitech.celitechsdk.validation.ViolationAggregator;
import io.github.Celitech.celitechsdk.validation.validators.StringValidator;

public class GetEsimParametersValidator extends AbstractModelValidator<GetEsimParameters> {

  public GetEsimParametersValidator(String fieldName) {
    super(fieldName);
  }

  public GetEsimParametersValidator() {}

  @Override
  protected Violation[] validateModel(GetEsimParameters requestParameters) {
    return new ViolationAggregator()
      .add(new StringValidator("iccid").minLength(18).maxLength(22).required().validate(requestParameters.getIccid()))
      .aggregate();
  }
}
