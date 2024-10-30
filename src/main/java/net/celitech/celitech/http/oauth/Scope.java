package net.celitech.celitech.http.oauth;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
public class Scope {

  @NonNull
  private String method;

  @Getter
  @NonNull
  private Set<String> scopes;

  @NonNull
  private String path;

  public boolean match(String method, String path) {
    String pathPattern = this.getPathAsPattern();
    return this.method.equalsIgnoreCase(method) && path.matches(pathPattern);
  }

  private String getPathAsPattern() {
    return ".*" + this.path.replaceAll("\\{.*\\}", ".*") + ".*";
  }
}
