package io.github.Celitech.celitechsdk.validation.validators.modelValidators;

import io.github.Celitech.celitechsdk.models.GetEsimOkResponse;
import io.github.Celitech.celitechsdk.validation.Violation;
import io.github.Celitech.celitechsdk.validation.ViolationAggregator;

public class GetEsimOkResponseValidator extends AbstractModelValidator<GetEsimOkResponse> {

  public GetEsimOkResponseValidator(String fieldName) {
    super(fieldName);
  }

  public GetEsimOkResponseValidator() {}

  @Override
  protected Violation[] validateModel(GetEsimOkResponse getEsimOkResponse) {
    return new ViolationAggregator()
      .add(new GetEsimOkResponseEsimValidator("esim").optional().validate(getEsimOkResponse.getEsim()))
      .aggregate();
  }
}
