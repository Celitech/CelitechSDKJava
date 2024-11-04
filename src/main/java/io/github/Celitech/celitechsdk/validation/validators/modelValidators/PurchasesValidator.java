package io.github.Celitech.celitechsdk.validation.validators.modelValidators;

import io.github.Celitech.celitechsdk.models.Purchases;
import io.github.Celitech.celitechsdk.validation.Violation;
import io.github.Celitech.celitechsdk.validation.ViolationAggregator;

public class PurchasesValidator extends AbstractModelValidator<Purchases> {

  public PurchasesValidator(String fieldName) {
    super(fieldName);
  }

  public PurchasesValidator() {}

  @Override
  protected Violation[] validateModel(Purchases purchases) {
    return new ViolationAggregator()
      .add(new PurchasesEsimValidator("esim").optional().validate(purchases.getEsim()))
      .aggregate();
  }
}
