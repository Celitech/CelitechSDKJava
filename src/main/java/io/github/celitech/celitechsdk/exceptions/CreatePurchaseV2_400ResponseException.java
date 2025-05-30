package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.CreatePurchaseV2_400Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for CreatePurchaseV2_400Response errors.
 */
@Getter
public class CreatePurchaseV2_400ResponseException extends ApiError {

  private final CreatePurchaseV2_400Response error;

  public CreatePurchaseV2_400ResponseException(
    CreatePurchaseV2_400Response error,
    String message,
    int code,
    Response response
  ) {
    super(message, code, response);
    this.error = error;
  }
}
