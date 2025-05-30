package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.GetEsim400Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for GetEsim400Response errors.
 */
@Getter
public class GetEsim400ResponseException extends ApiError {

  private final GetEsim400Response error;

  public GetEsim400ResponseException(GetEsim400Response error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
