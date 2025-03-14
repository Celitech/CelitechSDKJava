package io.github.celitech.celitechsdk.validation.validators;

import io.github.celitech.celitechsdk.validation.Violation;

public interface Validator<T> {
  Violation[] validate(T value);
}
