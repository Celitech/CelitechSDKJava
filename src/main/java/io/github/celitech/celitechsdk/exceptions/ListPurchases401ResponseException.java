package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.ListPurchases401Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for ListPurchases401Response errors.
 */
@Getter
public class ListPurchases401ResponseException extends ApiError {

  private final ListPurchases401Response error;

  public ListPurchases401ResponseException(
    ListPurchases401Response error,
    String message,
    int code,
    Response response
  ) {
    super(message, code, response);
    this.error = error;
  }
}
