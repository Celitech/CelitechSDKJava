package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.CreatePurchaseV2OkResponse;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;

/**
 * Validator implementation for CreatePurchaseV2OkResponse model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class CreatePurchaseV2OkResponseValidator extends AbstractModelValidator<CreatePurchaseV2OkResponse> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public CreatePurchaseV2OkResponseValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public CreatePurchaseV2OkResponseValidator() {}

  /**
   * Validates the CreatePurchaseV2OkResponse model's fields and constraints.
   *
   * @param createPurchaseV2OkResponse The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(CreatePurchaseV2OkResponse createPurchaseV2OkResponse) {
    return new ViolationAggregator()
      .add(
        new CreatePurchaseV2OkResponseProfileValidator("profile")
          .required()
          .validate(createPurchaseV2OkResponse.getProfile())
      )
      .aggregate();
  }
}
