package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.GetEsimDevice400Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for GetEsimDevice400Response errors.
 */
@Getter
public class GetEsimDevice400ResponseException extends ApiError {

  private final GetEsimDevice400Response error;

  public GetEsimDevice400ResponseException(
    GetEsimDevice400Response error,
    String message,
    int code,
    Response response
  ) {
    super(message, code, response);
    this.error = error;
  }
}
