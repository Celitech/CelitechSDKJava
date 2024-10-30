package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.GetEsimOkResponseEsim;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;
import net.celitech.celitech.validation.validators.StringValidator;

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
