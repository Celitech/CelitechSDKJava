package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.ListDestinations401Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for ListDestinations401Response errors.
 */
@Getter
public class ListDestinations401ResponseException extends ApiError {

  private final ListDestinations401Response error;

  public ListDestinations401ResponseException(
    ListDestinations401Response error,
    String message,
    int code,
    Response response
  ) {
    super(message, code, response);
    this.error = error;
  }
}
