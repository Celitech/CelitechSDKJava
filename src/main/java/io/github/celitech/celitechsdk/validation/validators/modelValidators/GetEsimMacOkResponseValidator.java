package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.GetEsimMacOkResponse;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;

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
