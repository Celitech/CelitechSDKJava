package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.CreatePurchaseV2Request;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.NumericValidator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

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
  @java.lang.Override
  protected Violation[] validateModel(CreatePurchaseV2Request createPurchaseV2Request) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Double>("quantity")
          .min(1D)
          .max(5D)
          .required()
          .validate(createPurchaseV2Request.getQuantity())
      )
      .add(
        new StringValidator("referenceId")
          .maxLength(255)
          .pattern("^[a-zA-Z0-9\\-_.@+]+$")
          .optional()
          .validate(createPurchaseV2Request.getReferenceId())
      )
      .aggregate();
  }
}
