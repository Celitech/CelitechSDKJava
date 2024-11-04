package io.github.Celitech.celitechsdk.validation.validators.modelValidators;

import io.github.Celitech.celitechsdk.models.PurchasesEsim;
import io.github.Celitech.celitechsdk.validation.Violation;
import io.github.Celitech.celitechsdk.validation.ViolationAggregator;
import io.github.Celitech.celitechsdk.validation.validators.StringValidator;

public class PurchasesEsimValidator extends AbstractModelValidator<PurchasesEsim> {

  public PurchasesEsimValidator(String fieldName) {
    super(fieldName);
  }

  public PurchasesEsimValidator() {}

  @Override
  protected Violation[] validateModel(PurchasesEsim purchasesEsim) {
    return new ViolationAggregator()
      .add(new StringValidator("iccid").minLength(18).maxLength(22).optional().validate(purchasesEsim.getIccid()))
      .aggregate();
  }
}
