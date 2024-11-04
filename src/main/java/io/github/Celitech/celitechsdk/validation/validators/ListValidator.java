package io.github.Celitech.celitechsdk.validation.validators;

import io.github.Celitech.celitechsdk.validation.Violation;
import java.util.ArrayList;
import java.util.List;

public class ListValidator<T> extends AbstractValidator<List<T>> {

  private AbstractValidator<T> itemValidator;
  private Integer minLength;
  private Integer maxLength;
  private Boolean uniqueItems;

  public ListValidator(String fieldName) {
    super(fieldName);
  }

  public ListValidator() {}

  public ListValidator<T> minLength(Integer minLength) {
    this.minLength = minLength;
    return this;
  }

  public ListValidator<T> maxLength(Integer maxLength) {
    this.maxLength = maxLength;
    return this;
  }

  public ListValidator<T> uniqueItems(Boolean uniqueItems) {
    this.uniqueItems = uniqueItems;
    return this;
  }

  public ListValidator<T> itemValidator(AbstractValidator<T> itemValidator) {
    this.itemValidator = itemValidator;
    return this;
  }

  @Override
  public Violation[] validate(List<T> list) {
    Violation requiredViolation = validateRequired(list);
    if (requiredViolation != null) {
      return new Violation[] { requiredViolation };
    }
    if (list == null) {
      return new Violation[0];
    }

    List<Violation> violations = new ArrayList<>();

    if (minLength != null && list.size() < minLength) {
      violations.add(new Violation(getFieldName(), String.format("must have at least %d items", minLength)));
    }

    if (maxLength != null && list.size() > maxLength) {
      violations.add(new Violation(getFieldName(), String.format("must have at most %d items", maxLength)));
    }

    if (uniqueItems != null && list.stream().distinct().count() != list.size()) {
      violations.add(new Violation(getFieldName(), "must have unique items"));
    }

    if (itemValidator != null) {
      for (int i = 0; i < list.size(); i++) {
        T item = list.get(i);
        Violation[] itemViolations = itemValidator.setFieldName(String.valueOf(i)).validate(item);
        for (Violation itemViolation : itemViolations) {
          violations.add(
            new Violation(
              String.format("%s[%s]", getFieldName(), itemValidator.getFieldName()),
              itemViolation.getMessage()
            )
          );
        }
      }
    }

    return violations.toArray(new Violation[0]);
  }
}