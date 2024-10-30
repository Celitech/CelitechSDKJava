package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.GetEsimMacOkResponse;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;

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
