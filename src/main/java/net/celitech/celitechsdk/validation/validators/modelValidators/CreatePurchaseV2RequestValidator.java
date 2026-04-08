package net.celitech.celitechsdk.validation.validators.modelValidators;

import net.celitech.celitechsdk.models.CreatePurchaseV2Request;
import net.celitech.celitechsdk.validation.Violation;
import net.celitech.celitechsdk.validation.ViolationAggregator;
import net.celitech.celitechsdk.validation.validators.NumericValidator;

/**
 * Validator implementation for CreatePurchaseV2Request model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class CreatePurchaseV2RequestValidator
  extends AbstractModelValidator<CreatePurchaseV2Request> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public CreatePurchaseV2RequestValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public CreatePurchaseV2RequestValidator() {}

  /**
   * Validates the CreatePurchaseV2Request model's fields and constraints.
   *
   * @param createPurchaseV2Request The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(CreatePurchaseV2Request createPurchaseV2Request) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Double>("quantity")
          .min(1D)
          .max(5D)
          .required()
          .validate(createPurchaseV2Request.getQuantity())
      )
      .aggregate();
  }
}
