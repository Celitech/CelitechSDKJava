package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.GetEsimOkResponse;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;

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
