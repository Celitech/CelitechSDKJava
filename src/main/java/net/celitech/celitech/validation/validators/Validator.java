package net.celitech.celitech.validation.validators;

import net.celitech.celitech.validation.Violation;

public interface Validator<T> {
  Violation[] validate(T value);
}
