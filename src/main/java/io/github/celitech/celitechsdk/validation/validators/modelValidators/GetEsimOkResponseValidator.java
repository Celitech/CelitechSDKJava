package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.GetEsimOkResponse;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;

/**
 * Validator implementation for GetEsimOkResponse model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class GetEsimOkResponseValidator extends AbstractModelValidator<GetEsimOkResponse> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public GetEsimOkResponseValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public GetEsimOkResponseValidator() {}

  /**
   * Validates the GetEsimOkResponse model's fields and constraints.
   *
   * @param getEsimOkResponse The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(GetEsimOkResponse getEsimOkResponse) {
    return new ViolationAggregator()
      .add(
        new GetEsimOkResponseEsimValidator("esim").required().validate(getEsimOkResponse.getEsim())
      )
      .aggregate();
  }
}
