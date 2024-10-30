package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.GetEsimMacOkResponseEsim;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;
import net.celitech.celitech.validation.validators.StringValidator;

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
