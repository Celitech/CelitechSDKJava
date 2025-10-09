package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.Unauthorized;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for Unauthorized errors.
 */
@Getter
public class UnauthorizedException extends ApiError {

  private final Unauthorized error;

  public UnauthorizedException(Unauthorized error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
