package io.github.celitech.celitechsdk.http.oauth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScopeManager {

  private Scope[] scopes;

  public ScopeManager() {
    this.scopes = new Scope[] {
      Scope.builder().method("GET").path("/destinations").scopes(new HashSet<String>()).build(),
      Scope.builder().method("GET").path("/packages").scopes(new HashSet<String>()).build(),
      Scope.builder().method("POST").path("/purchases/v2").scopes(new HashSet<String>()).build(),
      Scope.builder().method("GET").path("/purchases").scopes(new HashSet<String>()).build(),
      Scope.builder().method("POST").path("/purchases").scopes(new HashSet<String>()).build(),
      Scope.builder().method("POST").path("/purchases/topup").scopes(new HashSet<String>()).build(),
      Scope.builder().method("POST").path("/purchases/edit").scopes(new HashSet<String>()).build(),
      Scope.builder().method("GET").path("/purchases/{purchaseId}/consumption").scopes(new HashSet<String>()).build(),
      Scope.builder().method("GET").path("/esim").scopes(new HashSet<String>()).build(),
      Scope.builder().method("GET").path("/esim/{iccid}/device").scopes(new HashSet<String>()).build(),
      Scope.builder().method("GET").path("/esim/{iccid}/history").scopes(new HashSet<String>()).build(),
      Scope.builder().method("GET").path("/esim/{iccid}/mac").scopes(new HashSet<String>()).build(),
      Scope.builder().method("POST").path("/iframe/token").scopes(new HashSet<String>()).build(),
    };
  }

  public Set<String> getScopes(String method, String path) {
    Optional<Scope> matchingScopes = Arrays.stream(scopes).filter(scope -> scope.match(method, path)).findFirst();

    return matchingScopes.map(Scope::getScopes).orElse(null);
  }
}
