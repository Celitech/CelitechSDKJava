package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.Purchases;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;

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
