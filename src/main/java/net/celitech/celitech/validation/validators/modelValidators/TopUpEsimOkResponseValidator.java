package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.TopUpEsimOkResponse;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;

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
