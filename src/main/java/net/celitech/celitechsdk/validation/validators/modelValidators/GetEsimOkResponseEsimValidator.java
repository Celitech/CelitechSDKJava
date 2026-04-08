package net.celitech.celitechsdk.validation.validators.modelValidators;

import net.celitech.celitechsdk.models.GetEsimOkResponseEsim;
import net.celitech.celitechsdk.validation.Violation;
import net.celitech.celitechsdk.validation.ViolationAggregator;
import net.celitech.celitechsdk.validation.validators.StringValidator;

/**
 * Validator implementation for GetEsimOkResponseEsim model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class GetEsimOkResponseEsimValidator extends AbstractModelValidator<GetEsimOkResponseEsim> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public GetEsimOkResponseEsimValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public GetEsimOkResponseEsimValidator() {}

  /**
   * Validates the GetEsimOkResponseEsim model's fields and constraints.
   *
   * @param getEsimOkResponseEsim The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(GetEsimOkResponseEsim getEsimOkResponseEsim) {
    return new ViolationAggregator()
      .add(
        new StringValidator("iccid")
          .minLength(18)
          .maxLength(22)
          .required()
          .validate(getEsimOkResponseEsim.getIccid())
      )
      .add(
        new StringValidator("activationCode")
          .minLength(1000)
          .maxLength(8000)
          .required()
          .validate(getEsimOkResponseEsim.getActivationCode())
      )
      .aggregate();
  }
}
