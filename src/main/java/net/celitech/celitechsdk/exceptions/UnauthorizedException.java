package net.celitech.celitechsdk.exceptions;

import lombok.Getter;
import net.celitech.celitechsdk.models.Unauthorized;
import okhttp3.Response;

/**
 * Exception class for API errors with structured Unauthorized error details.
 * Extends ApiError to provide typed access to the error response model.
 * Thrown when the API returns an error response that can be deserialized to Unauthorized.
 */
@Getter
public class UnauthorizedException extends ApiError {

  /** The structured error details from the API response */
  private final Unauthorized error;

  /**
   * Creates a new exception with structured error details.
   *
   * @param error The deserialized error model
   * @param message The error message
   * @param code The HTTP status code
   * @param response The raw HTTP response
   */
  public UnauthorizedException(Unauthorized error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}
