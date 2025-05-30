package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.GetEsimMac400Response;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for GetEsimMac400Response errors.
 */
@Getter
public class GetEsimMac400ResponseException extends ApiError {

  private final GetEsimMac400Response error;

  public GetEsimMac400ResponseException(GetEsimMac400Response error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
