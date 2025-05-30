package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.TopUpEsim400Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for TopUpEsim400Response errors.
 */
@Getter
public class TopUpEsim400ResponseException extends ApiError {

  private final TopUpEsim400Response error;

  public TopUpEsim400ResponseException(TopUpEsim400Response error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
