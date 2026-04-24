package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.TopUpEsimOkResponse;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;

/**
 * Validator implementation for TopUpEsimOkResponse model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class TopUpEsimOkResponseValidator extends AbstractModelValidator<TopUpEsimOkResponse> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public TopUpEsimOkResponseValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public TopUpEsimOkResponseValidator() {}

  /**
   * Validates the TopUpEsimOkResponse model's fields and constraints.
   *
   * @param topUpEsimOkResponse The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(TopUpEsimOkResponse topUpEsimOkResponse) {
    return new ViolationAggregator()
      .add(
        new TopUpEsimOkResponseProfileValidator("profile")
          .required()
          .validate(topUpEsimOkResponse.getProfile())
      )
      .aggregate();
  }
}
