package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.GetEsimHistory401Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for GetEsimHistory401Response errors.
 */
@Getter
public class GetEsimHistory401ResponseException extends ApiError {

  private final GetEsimHistory401Response error;

  public GetEsimHistory401ResponseException(
    GetEsimHistory401Response error,
    String message,
    int code,
    Response response
  ) {
    super(message, code, response);
    this.error = error;
  }
}
