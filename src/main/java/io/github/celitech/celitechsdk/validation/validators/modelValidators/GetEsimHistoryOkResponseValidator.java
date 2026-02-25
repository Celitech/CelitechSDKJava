package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.GetEsimHistoryOkResponse;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;

/**
 * Validator implementation for GetEsimHistoryOkResponse model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class GetEsimHistoryOkResponseValidator extends AbstractModelValidator<GetEsimHistoryOkResponse> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public GetEsimHistoryOkResponseValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public GetEsimHistoryOkResponseValidator() {}

  /**
   * Validates the GetEsimHistoryOkResponse model's fields and constraints.
   *
   * @param getEsimHistoryOkResponse The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(GetEsimHistoryOkResponse getEsimHistoryOkResponse) {
    return new ViolationAggregator()
      .add(new GetEsimHistoryOkResponseEsimValidator("esim").required().validate(getEsimHistoryOkResponse.getEsim()))
      .aggregate();
  }
}
