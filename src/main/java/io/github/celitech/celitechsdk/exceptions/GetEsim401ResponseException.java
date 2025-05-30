package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.GetEsim401Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for GetEsim401Response errors.
 */
@Getter
public class GetEsim401ResponseException extends ApiError {

  private final GetEsim401Response error;

  public GetEsim401ResponseException(GetEsim401Response error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
