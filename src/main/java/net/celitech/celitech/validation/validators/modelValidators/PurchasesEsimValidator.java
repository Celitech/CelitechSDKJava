package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.PurchasesEsim;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;
import net.celitech.celitech.validation.validators.StringValidator;

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
