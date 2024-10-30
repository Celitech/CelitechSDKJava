package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.ListPurchasesParameters;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

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
