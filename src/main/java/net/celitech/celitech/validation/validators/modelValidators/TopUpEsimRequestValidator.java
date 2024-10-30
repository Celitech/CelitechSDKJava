package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.TopUpEsimRequest;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;
import net.celitech.celitech.validation.validators.StringValidator;

public class TopUpEsimRequestValidator extends AbstractModelValidator<TopUpEsimRequest> {

  public TopUpEsimRequestValidator(String fieldName) {
    super(fieldName);
  }

  public TopUpEsimRequestValidator() {}

  @Override
  protected Violation[] validateModel(TopUpEsimRequest topUpEsimRequest) {
    return new ViolationAggregator()
      .add(new StringValidator("iccid").minLength(18).maxLength(22).required().validate(topUpEsimRequest.getIccid()))
      .aggregate();
  }
}
