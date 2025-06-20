package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
public class CreatePurchaseV2OkResponsePurchase {

  /**
   * ID of the purchase
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * ID of the package
   */
  @JsonProperty("packageId")
  private JsonNullable<String> packageId;

  /**
   * Creation date of the purchase in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @JsonProperty("createdDate")
  private JsonNullable<String> createdDate;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getPackageId() {
    return packageId.orElse(null);
  }

  @JsonIgnore
  public String getCreatedDate() {
    return createdDate.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreatePurchaseV2OkResponsePurchaseBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public CreatePurchaseV2OkResponsePurchaseBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> packageId = JsonNullable.undefined();

    @JsonProperty("packageId")
    public CreatePurchaseV2OkResponsePurchaseBuilder packageId(String value) {
      if (value == null) {
        throw new IllegalStateException("packageId cannot be null");
      }
      this.packageId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> createdDate = JsonNullable.undefined();

    @JsonProperty("createdDate")
    public CreatePurchaseV2OkResponsePurchaseBuilder createdDate(String value) {
      if (value == null) {
        throw new IllegalStateException("createdDate cannot be null");
      }
      this.createdDate = JsonNullable.of(value);
      return this;
    }
  }
}
