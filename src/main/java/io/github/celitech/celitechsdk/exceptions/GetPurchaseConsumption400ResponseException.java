package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.GetPurchaseConsumption400Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for GetPurchaseConsumption400Response errors.
 */
@Getter
public class GetPurchaseConsumption400ResponseException extends ApiError {

  private final GetPurchaseConsumption400Response error;

  public GetPurchaseConsumption400ResponseException(
    GetPurchaseConsumption400Response error,
    String message,
    int code,
    Response response
  ) {
    super(message, code, response);
    this.error = error;
  }
}
