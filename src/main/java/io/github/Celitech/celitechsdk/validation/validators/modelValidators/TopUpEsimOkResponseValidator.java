package io.github.Celitech.celitechsdk.validation.validators.modelValidators;

import io.github.Celitech.celitechsdk.models.TopUpEsimOkResponse;
import io.github.Celitech.celitechsdk.validation.Violation;
import io.github.Celitech.celitechsdk.validation.ViolationAggregator;

public class TopUpEsimOkResponseValidator extends AbstractModelValidator<TopUpEsimOkResponse> {

  public TopUpEsimOkResponseValidator(String fieldName) {
    super(fieldName);
  }

  public TopUpEsimOkResponseValidator() {}

  @Override
  protected Violation[] validateModel(TopUpEsimOkResponse topUpEsimOkResponse) {
    return new ViolationAggregator()
      .add(new TopUpEsimOkResponseProfileValidator("profile").optional().validate(topUpEsimOkResponse.getProfile()))
      .aggregate();
  }
}
