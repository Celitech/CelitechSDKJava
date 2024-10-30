package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.TopUpEsimOkResponseProfile;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;
import net.celitech.celitech.validation.validators.StringValidator;

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
