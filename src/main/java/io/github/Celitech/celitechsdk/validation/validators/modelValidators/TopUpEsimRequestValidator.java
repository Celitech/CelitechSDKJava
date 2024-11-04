package io.github.Celitech.celitechsdk.validation.validators.modelValidators;

import io.github.Celitech.celitechsdk.models.TopUpEsimRequest;
import io.github.Celitech.celitechsdk.validation.Violation;
import io.github.Celitech.celitechsdk.validation.ViolationAggregator;
import io.github.Celitech.celitechsdk.validation.validators.StringValidator;

public class TopUpEsimRequestValidator extends AbstractModelValidator<TopUpEsimRequest> {

  public TopUpEsimRequestValidator(String fieldName) {
    super(fieldName);
  }

  public TopUpEsimRequestValidator() {}

  @Override
  protected Violation[] validateModel(TopUpEsimRequest topUpEsimRequest) {
    return new ViolationAggregator()
      .add(new StringValidator("iccid").minLength(18).maxLength(22).required().validate(topUpEsimRequest.getIccid()))
      .aggregate();
  }
}
