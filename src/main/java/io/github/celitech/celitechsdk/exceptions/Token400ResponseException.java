package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.Token400Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for Token400Response errors.
 */
@Getter
public class Token400ResponseException extends ApiError {

  private final Token400Response error;

  public Token400ResponseException(Token400Response error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
