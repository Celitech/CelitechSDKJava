package net.celitech.celitechsdk.validation.validators.modelValidators;

import net.celitech.celitechsdk.models.Purchases;
import net.celitech.celitechsdk.validation.Violation;
import net.celitech.celitechsdk.validation.ViolationAggregator;

/**
 * Validator implementation for Purchases model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class PurchasesValidator extends AbstractModelValidator<Purchases> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public PurchasesValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public PurchasesValidator() {}

  /**
   * Validates the Purchases model's fields and constraints.
   *
   * @param purchases The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(Purchases purchases) {
    return new ViolationAggregator()
      .add(new PurchasesEsimValidator("esim").required().validate(purchases.getEsim()))
      .aggregate();
  }
}
