package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.Token401Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for Token401Response errors.
 */
@Getter
public class Token401ResponseException extends ApiError {

  private final Token401Response error;

  public Token401ResponseException(Token401Response error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
