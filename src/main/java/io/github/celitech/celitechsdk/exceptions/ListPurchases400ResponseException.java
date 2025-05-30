package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.ListPurchases400Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for ListPurchases400Response errors.
 */
@Getter
public class ListPurchases400ResponseException extends ApiError {

  private final ListPurchases400Response error;

  public ListPurchases400ResponseException(
    ListPurchases400Response error,
    String message,
    int code,
    Response response
  ) {
    super(message, code, response);
    this.error = error;
  }
}
