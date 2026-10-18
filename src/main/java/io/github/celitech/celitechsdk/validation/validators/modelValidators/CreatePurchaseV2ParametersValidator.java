package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.CreatePurchaseV2Parameters;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

/**
 * Validator implementation for CreatePurchaseV2Parameters model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class CreatePurchaseV2ParametersValidator
  extends AbstractModelValidator<CreatePurchaseV2Parameters> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public CreatePurchaseV2ParametersValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public CreatePurchaseV2ParametersValidator() {}

  /**
   * Validates the CreatePurchaseV2Parameters model's fields and constraints.
   *
   * @param requestParameters The model instance to validate
   * @return Array of violations found during validation
   */
  @java.lang.Override
  protected Violation[] validateModel(CreatePurchaseV2Parameters requestParameters) {
    return new ViolationAggregator()
      .add(
        new CreatePurchaseV2RequestValidator("requestBody")
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
