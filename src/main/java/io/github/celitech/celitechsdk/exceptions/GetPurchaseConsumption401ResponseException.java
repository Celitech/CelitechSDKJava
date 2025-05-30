package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.GetPurchaseConsumption401Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for GetPurchaseConsumption401Response errors.
 */
@Getter
public class GetPurchaseConsumption401ResponseException extends ApiError {

  private final GetPurchaseConsumption401Response error;

  public GetPurchaseConsumption401ResponseException(
    GetPurchaseConsumption401Response error,
    String message,
    int code,
    Response response
  ) {
    super(message, code, response);
    this.error = error;
  }
}
