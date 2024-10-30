package net.celitech.celitech.validation.validators.modelValidators;

import net.celitech.celitech.models.CreatePurchaseOkResponse;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.ViolationAggregator;

public class CreatePurchaseOkResponseValidator extends AbstractModelValidator<CreatePurchaseOkResponse> {

  public CreatePurchaseOkResponseValidator(String fieldName) {
    super(fieldName);
  }

  public CreatePurchaseOkResponseValidator() {}

  @Override
  protected Violation[] validateModel(CreatePurchaseOkResponse createPurchaseOkResponse) {
    return new ViolationAggregator()
      .add(
        new CreatePurchaseOkResponseProfileValidator("profile")
          .optional()
          .validate(createPurchaseOkResponse.getProfile())
      )
      .aggregate();
  }
}
