package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.GetEsimHistoryOkResponseEsim;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.StringValidator;

/**
 * Validator implementation for GetEsimHistoryOkResponseEsim model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class GetEsimHistoryOkResponseEsimValidator extends AbstractModelValidator<GetEsimHistoryOkResponseEsim> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public GetEsimHistoryOkResponseEsimValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public GetEsimHistoryOkResponseEsimValidator() {}

  /**
   * Validates the GetEsimHistoryOkResponseEsim model's fields and constraints.
   *
   * @param getEsimHistoryOkResponseEsim The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(GetEsimHistoryOkResponseEsim getEsimHistoryOkResponseEsim) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid")
          .minLength(18)
          .maxLength(22)
          .required()
          .validate(getEsimHistoryOkResponseEsim.getIccid())
      )
      .aggregate();
  }
}
