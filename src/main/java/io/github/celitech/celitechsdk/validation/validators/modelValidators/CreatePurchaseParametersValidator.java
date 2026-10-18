package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.CreatePurchaseParameters;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

/**
 * Validator implementation for CreatePurchaseParameters model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class CreatePurchaseParametersValidator
  extends AbstractModelValidator<CreatePurchaseParameters> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public CreatePurchaseParametersValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public CreatePurchaseParametersValidator() {}

  /**
   * Validates the CreatePurchaseParameters model's fields and constraints.
   *
   * @param requestParameters The model instance to validate
   * @return Array of violations found during validation
   */
  @java.lang.Override
  protected Violation[] validateModel(CreatePurchaseParameters requestParameters) {
    return new ViolationAggregator()
      .add(
        new CreatePurchaseRequestValidator("requestBody")
          .required()
          .validate(requestParameters.getRequestBody())
      )
      .add(
        new StringValidator("idempotencyKey")
          .minLength(1)
          .maxLength(255)
          .optional()
          .validate(requestParameters.getIdempotencyKey())
      )
      .aggregate();
  }
}
