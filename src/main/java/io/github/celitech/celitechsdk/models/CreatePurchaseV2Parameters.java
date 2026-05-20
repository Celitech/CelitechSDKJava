package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreatePurchaseV2Parameters {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("Accept")
  private String accept;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private CreatePurchaseV2Request requestBody;

  // Overwrite lombok builder methods
  public static class CreatePurchaseV2ParametersBuilder {

    /**
     * Flag to track if the accept property has been set.
     */
    private boolean accept$set = false;

    /**
     * Flag to track if the requestBody property has been set.
     */
    private boolean requestBody$set = false;

    public CreatePurchaseV2ParametersBuilder accept(String accept) {
      this.accept$set = true;
      this.accept = accept;
      return this;
    }

    public CreatePurchaseV2ParametersBuilder requestBody(CreatePurchaseV2Request requestBody) {
      this.requestBody$set = true;
      this.requestBody = requestBody;
      return this;
    }

    public CreatePurchaseV2Parameters build() {
      if (!accept$set) {
        throw new IllegalStateException("accept is required");
      }
      if (!requestBody$set) {
        throw new IllegalStateException("requestBody is required");
      }
      return new CreatePurchaseV2Parameters(accept, requestBody);
    }
  }
}
