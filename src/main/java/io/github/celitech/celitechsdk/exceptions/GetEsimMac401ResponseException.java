package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.GetEsimMac401Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for GetEsimMac401Response errors.
 */
@Getter
public class GetEsimMac401ResponseException extends ApiError {

  private final GetEsimMac401Response error;

  public GetEsimMac401ResponseException(GetEsimMac401Response error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
