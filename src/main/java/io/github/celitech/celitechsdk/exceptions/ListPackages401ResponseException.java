package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.ListPackages401Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for ListPackages401Response errors.
 */
@Getter
public class ListPackages401ResponseException extends ApiError {

  private final ListPackages401Response error;

  public ListPackages401ResponseException(ListPackages401Response error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
