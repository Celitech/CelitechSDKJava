package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.GetEsimOkResponse;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;

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
