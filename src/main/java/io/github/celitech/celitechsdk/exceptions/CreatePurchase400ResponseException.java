package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.CreatePurchase400Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for CreatePurchase400Response errors.
 */
@Getter
public class CreatePurchase400ResponseException extends ApiError {

  private final CreatePurchase400Response error;

  public CreatePurchase400ResponseException(
    CreatePurchase400Response error,
    String message,
    int code,
    Response response
  ) {
    super(message, code, response);
    this.error = error;
  }
}
