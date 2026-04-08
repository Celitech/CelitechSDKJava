package net.celitech.celitechsdk.http.oauth;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * Represents required OAuth scopes for a specific endpoint.
 * Maps an HTTP method and path pattern to a set of required OAuth scopes.
 */
@Builder
public class Scope {

  @NonNull
  private String method;

  @Getter
  @NonNull
  private Set<String> scopes;

  @NonNull
  private String path;

  /**
   * Checks if this scope definition matches the given HTTP method and path.
   * Path parameters (enclosed in braces) are treated as wildcards.
   *
   * @param method The HTTP method to match (case-insensitive)
   * @param path The request path to match
   * @return true if this scope definition applies to the given method and path
   */
  public boolean match(String method, String path) {
    String pathPattern = this.getPathAsPattern();
    return this.method.equalsIgnoreCase(method) && path.matches(pathPattern);
  }

  /**
   * Converts the path template to a regex pattern for matching.
   * Replaces path parameters (e.g., {id}) with wildcards.
   *
   * @return A regex pattern for matching request paths
   */
  private String getPathAsPattern() {
    return ".*" + this.path.replaceAll("\\{.*\\}", ".*") + ".*";
  }
}
