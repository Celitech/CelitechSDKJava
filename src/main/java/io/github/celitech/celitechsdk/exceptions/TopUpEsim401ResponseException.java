package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.TopUpEsim401Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for TopUpEsim401Response errors.
 */
@Getter
public class TopUpEsim401ResponseException extends ApiError {

  private final TopUpEsim401Response error;

  public TopUpEsim401ResponseException(TopUpEsim401Response error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
