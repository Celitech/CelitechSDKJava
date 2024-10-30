package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.ListPurchasesParameters;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;
import net.celitech.celitech.validation.validators.StringValidator;

public class ListPurchasesParametersValidator extends AbstractModelValidator<ListPurchasesParameters> {

  public ListPurchasesParametersValidator(String fieldName) {
    super(fieldName);
  }

  public ListPurchasesParametersValidator() {}

  @Override
  protected Violation[] validateModel(ListPurchasesParameters requestParameters) {
    return new ViolationAggregator()
      .add(new StringValidator("iccid").minLength(18).maxLength(22).optional().validate(requestParameters.getIccid()))
      .aggregate();
  }
}
