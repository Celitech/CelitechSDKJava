package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.CreatePurchase401Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for CreatePurchase401Response errors.
 */
@Getter
public class CreatePurchase401ResponseException extends ApiError {

  private final CreatePurchase401Response error;

  public CreatePurchase401ResponseException(
    CreatePurchase401Response error,
    String message,
    int code,
    Response response
  ) {
    super(message, code, response);
    this.error = error;
  }
}
