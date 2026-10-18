package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.ErrorResponse;
import java.util.List;
import java.util.Map;

/**
 * Error thrown for HTTP 503 responses.
 *
 * Part of the status-named exception hierarchy; extends {@link ApiError} and
 * exposes a typed {@code body()} for this status.
 */
public class ServiceUnavailableError extends ApiError {

  public ServiceUnavailableError(
    String message,
    ErrorResponse body,
    Map<String, List<String>> headers
  ) {
    super(message, 503, body, headers);
  }

  /**
   * @return The typed error body for this response.
   */
  @java.lang.Override
  public ErrorResponse body() {
    return (ErrorResponse) super.body();
  }
}
