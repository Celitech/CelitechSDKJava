package net.celitech.celitech.validation.exceptions;

import lombok.Getter;
import net.celitech.celitech.validation.Violation;

public class ValidationException extends RuntimeException {

  @Getter
  private final Violation[] violations;

  public ValidationException(Violation[] violations) {
    super();
    this.violations = violations;
  }

  @Override
  public String getMessage() {
    return "Validation failed with the following violations: " + this.buildViolationsString();
  }

  private String buildViolationsString() {
    StringBuilder sb = new StringBuilder();
    for (Violation violation : this.violations) {
      sb.append(violation.toString()).append("\n");
    }
    return sb.toString();
  }
}
