package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.GetEsimHistory400Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for GetEsimHistory400Response errors.
 */
@Getter
public class GetEsimHistory400ResponseException extends ApiError {

  private final GetEsimHistory400Response error;

  public GetEsimHistory400ResponseException(
    GetEsimHistory400Response error,
    String message,
    int code,
    Response response
  ) {
    super(message, code, response);
    this.error = error;
  }
}
