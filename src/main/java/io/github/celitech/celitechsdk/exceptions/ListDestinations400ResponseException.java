package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.ListDestinations400Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for ListDestinations400Response errors.
 */
@Getter
public class ListDestinations400ResponseException extends ApiError {

  private final ListDestinations400Response error;

  public ListDestinations400ResponseException(
    ListDestinations400Response error,
    String message,
    int code,
    Response response
  ) {
    super(message, code, response);
    this.error = error;
  }
}
