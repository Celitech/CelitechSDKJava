package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.TopUpEsimParameters;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

/**
 * Validator implementation for TopUpEsimParameters model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class TopUpEsimParametersValidator extends AbstractModelValidator<TopUpEsimParameters> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public TopUpEsimParametersValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public TopUpEsimParametersValidator() {}

  /**
   * Validates the TopUpEsimParameters model's fields and constraints.
   *
   * @param requestParameters The model instance to validate
   * @return Array of violations found during validation
   */
  @java.lang.Override
  protected Violation[] validateModel(TopUpEsimParameters requestParameters) {
    return new ViolationAggregator()
      .add(
        new TopUpEsimRequestValidator("requestBody")
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
