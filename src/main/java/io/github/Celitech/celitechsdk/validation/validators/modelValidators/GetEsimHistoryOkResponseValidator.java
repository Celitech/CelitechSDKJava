package io.github.Celitech.celitechsdk.validation.validators.modelValidators;

import io.github.Celitech.celitechsdk.models.GetEsimHistoryOkResponse;
import io.github.Celitech.celitechsdk.validation.Violation;
import io.github.Celitech.celitechsdk.validation.ViolationAggregator;

public class GetEsimHistoryOkResponseValidator extends AbstractModelValidator<GetEsimHistoryOkResponse> {

  public GetEsimHistoryOkResponseValidator(String fieldName) {
    super(fieldName);
  }

  public GetEsimHistoryOkResponseValidator() {}

  @Override
  protected Violation[] validateModel(GetEsimHistoryOkResponse getEsimHistoryOkResponse) {
    return new ViolationAggregator()
      .add(new GetEsimHistoryOkResponseEsimValidator("esim").optional().validate(getEsimHistoryOkResponse.getEsim()))
      .aggregate();
  }
}
