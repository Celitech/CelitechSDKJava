package net.celitech.celitechsdk.validation.validators.modelValidators;

import net.celitech.celitechsdk.models.CreatePurchaseOkResponseProfile;
import net.celitech.celitechsdk.validation.Violation;
import net.celitech.celitechsdk.validation.ViolationAggregator;
import net.celitech.celitechsdk.validation.validators.StringValidator;

/**
 * Validator implementation for CreatePurchaseOkResponseProfile model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class CreatePurchaseOkResponseProfileValidator
  extends AbstractModelValidator<CreatePurchaseOkResponseProfile> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public CreatePurchaseOkResponseProfileValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public CreatePurchaseOkResponseProfileValidator() {}

  /**
   * Validates the CreatePurchaseOkResponseProfile model's fields and constraints.
   *
   * @param createPurchaseOkResponseProfile The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(
    CreatePurchaseOkResponseProfile createPurchaseOkResponseProfile
  ) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid")
          .minLength(18)
          .maxLength(22)
          .required()
          .validate(createPurchaseOkResponseProfile.getIccid())
      )
      .add(
        new StringValidator("activationCode")
          .minLength(1000)
          .maxLength(8000)
          .required()
          .validate(createPurchaseOkResponseProfile.getActivationCode())
      )
      .aggregate();
  }
}
