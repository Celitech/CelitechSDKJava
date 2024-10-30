package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.GetEsimHistoryOkResponse;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;

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
