package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.GetEsimHistoryOkResponse;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;

public class GetEsimHistoryOkResponseValidator extends AbstractModelValidator<GetEsimHistoryOkResponse> {

  public GetEsimHistoryOkResponseValidator(String fieldName) {
    super(fieldName);
  }

  public GetEsimHistoryOkResponseValidator() {}

  @Override
  protected Violation[] validateModel(GetEsimHistoryOkResponse getEsimHistoryOkResponse) {
    return new ViolationAggregator()
      .add(new GetEsimHistoryOkResponseEsimValidator("esim").required().validate(getEsimHistoryOkResponse.getEsim()))
      .aggregate();
  }
}
