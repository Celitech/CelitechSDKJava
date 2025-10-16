package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.Purchases;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;

public class PurchasesValidator extends AbstractModelValidator<Purchases> {

  public PurchasesValidator(String fieldName) {
    super(fieldName);
  }

  public PurchasesValidator() {}

  @Override
  protected Violation[] validateModel(Purchases purchases) {
    return new ViolationAggregator()
      .add(new PurchasesEsimValidator("esim").required().validate(purchases.getEsim()))
      .aggregate();
  }
}
