package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.EditPurchase401Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for EditPurchase401Response errors.
 */
@Getter
public class EditPurchase401ResponseException extends ApiError {

  private final EditPurchase401Response error;

  public EditPurchase401ResponseException(EditPurchase401Response error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
