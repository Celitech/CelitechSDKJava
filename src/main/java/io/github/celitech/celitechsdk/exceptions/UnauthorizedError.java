package io.github.celitech.celitechsdk.exceptions;

import io.github.celitech.celitechsdk.models.Unauthorized;
import java.util.List;
import java.util.Map;

/**
 * Error thrown for HTTP 401 responses.
 *
 * Part of the status-named exception hierarchy; extends {@link ApiError} and
 * exposes a typed {@code body()} for this status.
 */
public class UnauthorizedError extends ApiError {

  public UnauthorizedError(String message, Unauthorized body, Map<String, List<String>> headers) {
    super(message, 401, body, headers);
  }

  /**
   * @return The typed error body for this response.
   */
  @Override
  public Unauthorized body() {
    return (Unauthorized) super.body();
  }
}
