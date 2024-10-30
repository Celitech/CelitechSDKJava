package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.GetEsimHistoryOkResponseEsim;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;
import net.celitech.celitech.validation.validators.StringValidator;

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
