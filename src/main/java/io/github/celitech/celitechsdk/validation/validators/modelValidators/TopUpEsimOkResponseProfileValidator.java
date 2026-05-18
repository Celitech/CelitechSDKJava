package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.TopUpEsimOkResponseProfile;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

/**
 * Validator implementation for TopUpEsimOkResponseProfile model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class TopUpEsimOkResponseProfileValidator
  extends AbstractModelValidator<TopUpEsimOkResponseProfile> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public TopUpEsimOkResponseProfileValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public TopUpEsimOkResponseProfileValidator() {}

  /**
   * Validates the TopUpEsimOkResponseProfile model's fields and constraints.
   *
   * @param topUpEsimOkResponseProfile The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(TopUpEsimOkResponseProfile topUpEsimOkResponseProfile) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid")
          .minLength(18)
          .maxLength(22)
          .required()
          .validate(topUpEsimOkResponseProfile.getIccid())
      )
      .aggregate();
  }
}
