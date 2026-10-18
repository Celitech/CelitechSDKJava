package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.CreatePurchaseRequest;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

/**
 * Validator implementation for CreatePurchaseRequest model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class CreatePurchaseRequestValidator extends AbstractModelValidator<CreatePurchaseRequest> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public CreatePurchaseRequestValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public CreatePurchaseRequestValidator() {}

  /**
   * Validates the CreatePurchaseRequest model's fields and constraints.
   *
   * @param createPurchaseRequest The model instance to validate
   * @return Array of violations found during validation
   */
  @java.lang.Override
  protected Violation[] validateModel(CreatePurchaseRequest createPurchaseRequest) {
    return new ViolationAggregator()
      .add(
        new StringValidator("referenceId")
          .maxLength(255)
          .pattern("^[a-zA-Z0-9\\-_.@+]+$")
          .optional()
          .validate(createPurchaseRequest.getReferenceId())
      )
      .aggregate();
  }
}
