package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
public class CreatePurchaseV2_400Response {

  /**
   * Message of the error
   */
  @JsonProperty("message")
  private JsonNullable<String> message;

  @JsonIgnore
  public String getMessage() {
    return message.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreatePurchaseV2_400ResponseBuilder {

    private JsonNullable<String> message = JsonNullable.undefined();

    @JsonProperty("message")
    public CreatePurchaseV2_400ResponseBuilder message(String value) {
      if (value == null) {
        throw new IllegalStateException("message cannot be null");
      }
      this.message = JsonNullable.of(value);
      return this;
    }
  }
}
