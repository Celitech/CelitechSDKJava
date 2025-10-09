package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.TopUpEsimOkResponse;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;

public class TopUpEsimOkResponseValidator extends AbstractModelValidator<TopUpEsimOkResponse> {

  public TopUpEsimOkResponseValidator(String fieldName) {
    super(fieldName);
  }

  public TopUpEsimOkResponseValidator() {}

  @Override
  protected Violation[] validateModel(TopUpEsimOkResponse topUpEsimOkResponse) {
    return new ViolationAggregator()
      .add(new TopUpEsimOkResponseProfileValidator("profile").required().validate(topUpEsimOkResponse.getProfile()))
      .aggregate();
  }
}
