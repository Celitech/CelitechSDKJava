package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.BadRequest;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for BadRequest errors.
 */
@Getter
public class BadRequestException extends ApiError {

  private final BadRequest error;

  public BadRequestException(BadRequest error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
