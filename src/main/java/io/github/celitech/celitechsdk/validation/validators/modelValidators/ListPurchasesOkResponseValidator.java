package io.github.celitech.celitechsdk.validation.validators.modelValidators;

import io.github.celitech.celitechsdk.models.ListPurchasesOkResponse;
import io.github.celitech.celitechsdk.models.Purchases;
import io.github.celitech.celitechsdk.validation.Violation;
import io.github.celitech.celitechsdk.validation.ViolationAggregator;
import io.github.celitech.celitechsdk.validation.validators.ListValidator;

/**
 * Validator implementation for ListPurchasesOkResponse model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ListPurchasesOkResponseValidator
  extends AbstractModelValidator<ListPurchasesOkResponse> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ListPurchasesOkResponseValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ListPurchasesOkResponseValidator() {}

  /**
   * Validates the ListPurchasesOkResponse model's fields and constraints.
   *
   * @param listPurchasesOkResponse The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ListPurchasesOkResponse listPurchasesOkResponse) {
    return new ViolationAggregator()
      .add(
        new ListValidator<Purchases>("purchases")
          .itemValidator(new PurchasesValidator().required())
          .required()
          .validate(listPurchasesOkResponse.getPurchases())
      )
      .aggregate();
  }
}
