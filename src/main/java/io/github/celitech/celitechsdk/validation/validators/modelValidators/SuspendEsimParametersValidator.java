package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.SuspendEsimParameters;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

/**
 * Validator implementation for SuspendEsimParameters model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class SuspendEsimParametersValidator extends AbstractModelValidator<SuspendEsimParameters> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public SuspendEsimParametersValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public SuspendEsimParametersValidator() {}

  /**
   * Validates the SuspendEsimParameters model's fields and constraints.
   *
   * @param requestParameters The model instance to validate
   * @return Array of violations found during validation
   */
  @java.lang.Override
  protected Violation[] validateModel(SuspendEsimParameters requestParameters) {
    return new ViolationAggregator()
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
