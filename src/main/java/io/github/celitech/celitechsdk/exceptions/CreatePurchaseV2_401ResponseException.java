package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.CreatePurchaseV2_401Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for CreatePurchaseV2_401Response errors.
 */
@Getter
public class CreatePurchaseV2_401ResponseException extends ApiError {

  private final CreatePurchaseV2_401Response error;

  public CreatePurchaseV2_401ResponseException(
    CreatePurchaseV2_401Response error,
    String message,
    int code,
    Response response
  ) {
    super(message, code, response);
    this.error = error;
  }
}
