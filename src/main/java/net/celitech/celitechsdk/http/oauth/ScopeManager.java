package net.celitech.celitechsdk.http.oauth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Manages OAuth scopes for API endpoints.
 * Maps HTTP methods and paths to their required OAuth scopes for authorization.
 */
public class ScopeManager {

  private Scope[] scopes;

  /**
   * Constructs a new ScopeManager with predefined endpoint scopes.
   */
  public ScopeManager() {
    this.scopes = new Scope[] {
      Scope.builder().method("GET").path("/destinations").scopes(new HashSet<String>()).build(),
      Scope.builder().method("GET").path("/packages").scopes(new HashSet<String>()).build(),
      Scope.builder().method("POST").path("/purchases/v2").scopes(new HashSet<String>()).build(),
      Scope.builder().method("GET").path("/purchases").scopes(new HashSet<String>()).build(),
      Scope.builder().method("POST").path("/purchases").scopes(new HashSet<String>()).build(),
      Scope.builder().method("POST").path("/purchases/topup").scopes(new HashSet<String>()).build(),
      Scope.builder().method("POST").path("/purchases/edit").scopes(new HashSet<String>()).build(),
      Scope.builder()
        .method("GET")
        .path("/purchases/{purchaseId}/consumption")
        .scopes(new HashSet<String>())
        .build(),
      Scope.builder().method("GET").path("/esim").scopes(new HashSet<String>()).build(),
      Scope.builder()
        .method("GET")
        .path("/esim/{iccid}/device")
        .scopes(new HashSet<String>())
        .build(),
      Scope.builder()
        .method("GET")
        .path("/esim/{iccid}/history")
        .scopes(new HashSet<String>())
        .build(),
      Scope.builder().method("POST").path("/iframe/token").scopes(new HashSet<String>()).build(),
    };
  }

  /**
   * Gets the required OAuth scopes for a specific endpoint.
   *
   * @param method The HTTP method (e.g., GET, POST)
   * @param path The request path/URL
   * @return The set of required scopes, or null if the endpoint doesn't require OAuth
   */
  public Set<String> getScopes(String method, String path) {
    Optional<Scope> matchingScopes = Arrays.stream(scopes)
      .filter(scope -> scope.match(method, path))
      .findFirst();

    return matchingScopes.map(Scope::getScopes).orElse(null);
  }
}
