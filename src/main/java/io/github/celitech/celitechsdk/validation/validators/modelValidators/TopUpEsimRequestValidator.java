package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.TopUpEsimRequest;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

/**
 * Validator implementation for TopUpEsimRequest model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class TopUpEsimRequestValidator extends AbstractModelValidator<TopUpEsimRequest> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public TopUpEsimRequestValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public TopUpEsimRequestValidator() {}

  /**
   * Validates the TopUpEsimRequest model's fields and constraints.
   *
   * @param topUpEsimRequest The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(TopUpEsimRequest topUpEsimRequest) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid")
          .minLength(18)
          .maxLength(22)
          .required()
          .validate(topUpEsimRequest.getIccid())
      )
      .aggregate();
  }
}
