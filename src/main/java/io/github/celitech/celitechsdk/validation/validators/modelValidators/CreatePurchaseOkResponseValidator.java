package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.CreatePurchaseOkResponse;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;

/**
 * Validator implementation for CreatePurchaseOkResponse model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class CreatePurchaseOkResponseValidator extends AbstractModelValidator<CreatePurchaseOkResponse> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public CreatePurchaseOkResponseValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public CreatePurchaseOkResponseValidator() {}

  /**
   * Validates the CreatePurchaseOkResponse model's fields and constraints.
   *
   * @param createPurchaseOkResponse The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(CreatePurchaseOkResponse createPurchaseOkResponse) {
    return new ViolationAggregator()
      .add(
        new CreatePurchaseOkResponseProfileValidator("profile")
          .required()
          .validate(createPurchaseOkResponse.getProfile())
      )
      .aggregate();
  }
}
