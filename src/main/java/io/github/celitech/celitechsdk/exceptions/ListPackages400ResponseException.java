package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.ListPackages400Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for ListPackages400Response errors.
 */
@Getter
public class ListPackages400ResponseException extends ApiError {

  private final ListPackages400Response error;

  public ListPackages400ResponseException(ListPackages400Response error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
