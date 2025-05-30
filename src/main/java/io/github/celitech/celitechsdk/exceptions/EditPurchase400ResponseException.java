package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.EditPurchase400Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for EditPurchase400Response errors.
 */
@Getter
public class EditPurchase400ResponseException extends ApiError {

  private final EditPurchase400Response error;

  public EditPurchase400ResponseException(EditPurchase400Response error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
