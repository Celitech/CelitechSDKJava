package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.PurchasesEsim;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

/**
 * Validator implementation for PurchasesEsim model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class PurchasesEsimValidator extends AbstractModelValidator<PurchasesEsim> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public PurchasesEsimValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public PurchasesEsimValidator() {}

  /**
   * Validates the PurchasesEsim model's fields and constraints.
   *
   * @param purchasesEsim The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(PurchasesEsim purchasesEsim) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid")
          .minLength(18)
          .maxLength(22)
          .required()
          .validate(purchasesEsim.getIccid())
      )
      .aggregate();
  }
}
