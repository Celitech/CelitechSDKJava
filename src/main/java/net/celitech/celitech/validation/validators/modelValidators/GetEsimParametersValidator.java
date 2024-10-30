package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.GetEsimParameters;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;
import net.celitech.celitech.validation.validators.StringValidator;

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
