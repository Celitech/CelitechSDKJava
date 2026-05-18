package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.CreatePurchaseV2OkResponseProfile;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

/**
 * Validator implementation for CreatePurchaseV2OkResponseProfile model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class CreatePurchaseV2OkResponseProfileValidator
  extends AbstractModelValidator<CreatePurchaseV2OkResponseProfile> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public CreatePurchaseV2OkResponseProfileValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public CreatePurchaseV2OkResponseProfileValidator() {}

  /**
   * Validates the CreatePurchaseV2OkResponseProfile model's fields and constraints.
   *
   * @param createPurchaseV2OkResponseProfile The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(
    CreatePurchaseV2OkResponseProfile createPurchaseV2OkResponseProfile
  ) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid")
          .minLength(18)
          .maxLength(22)
          .required()
          .validate(createPurchaseV2OkResponseProfile.getIccid())
      )
      .add(
        new StringValidator("activationCode")
          .minLength(1000)
          .maxLength(8000)
          .required()
          .validate(createPurchaseV2OkResponseProfile.getActivationCode())
      )
      .aggregate();
  }
}
