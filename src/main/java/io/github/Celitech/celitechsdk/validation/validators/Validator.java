package io.github.Celitech.celitechsdk.validation.validators;

import io.github.Celitech.celitechsdk.validation.Violation;

public interface Validator<T> {
  Violation[] validate(T value);
}
