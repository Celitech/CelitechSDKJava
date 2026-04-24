package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.ListPurchasesParameters;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

/**
 * Validator implementation for ListPurchasesParameters model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ListPurchasesParametersValidator
  extends AbstractModelValidator<ListPurchasesParameters> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ListPurchasesParametersValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ListPurchasesParametersValidator() {}

  /**
   * Validates the ListPurchasesParameters model's fields and constraints.
   *
   * @param requestParameters The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ListPurchasesParameters requestParameters) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid")
          .minLength(18)
          .maxLength(22)
          .optional()
          .validate(requestParameters.getIccid())
      )
      .aggregate();
  }
}
