package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.CreatePurchaseOkResponseProfile;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;
import net.celitech.celitech.validation.validators.StringValidator;

public class CreatePurchaseOkResponseProfileValidator extends AbstractModelValidator<CreatePurchaseOkResponseProfile> {

  public CreatePurchaseOkResponseProfileValidator(String fieldName) {
    super(fieldName);
  }

  public CreatePurchaseOkResponseProfileValidator() {}

  @Override
  protected Violation[] validateModel(CreatePurchaseOkResponseProfile createPurchaseOkResponseProfile) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid")
          .minLength(18)
          .maxLength(22)
          .optional()
          .validate(createPurchaseOkResponseProfile.getIccid())
      )
      .add(
        new StringValidator("activationCode")
          .minLength(1000)
          .maxLength(8000)
          .optional()
          .validate(createPurchaseOkResponseProfile.getActivationCode())
      )
      .aggregate();
  }
}
