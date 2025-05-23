package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.PurchasesEsim;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

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
