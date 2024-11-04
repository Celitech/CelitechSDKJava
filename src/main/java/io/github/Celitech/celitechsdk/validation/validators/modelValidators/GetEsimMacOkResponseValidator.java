package io.github.Celitech.celitechsdk.validation.validators.modelValidators;

import io.github.Celitech.celitechsdk.models.GetEsimMacOkResponse;
import io.github.Celitech.celitechsdk.validation.Violation;
import io.github.Celitech.celitechsdk.validation.ViolationAggregator;

public class GetEsimMacOkResponseValidator extends AbstractModelValidator<GetEsimMacOkResponse> {

  public GetEsimMacOkResponseValidator(String fieldName) {
    super(fieldName);
  }

  public GetEsimMacOkResponseValidator() {}

  @Override
  protected Violation[] validateModel(GetEsimMacOkResponse getEsimMacOkResponse) {
    return new ViolationAggregator()
      .add(new GetEsimMacOkResponseEsimValidator("esim").optional().validate(getEsimMacOkResponse.getEsim()))
      .aggregate();
  }
}
