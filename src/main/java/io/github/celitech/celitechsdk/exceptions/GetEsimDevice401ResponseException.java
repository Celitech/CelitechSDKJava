package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.GetEsimDevice401Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for GetEsimDevice401Response errors.
 */
@Getter
public class GetEsimDevice401ResponseException extends ApiError {

  private final GetEsimDevice401Response error;

  public GetEsimDevice401ResponseException(
    GetEsimDevice401Response error,
    String message,
    int code,
    Response response
  ) {
    super(message, code, response);
    this.error = error;
  }
}
