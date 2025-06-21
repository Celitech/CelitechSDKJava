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
public class GetPurchaseConsumptionOkResponse {

  /**
   * Remaining balance of the package in bytes
   */
  @JsonProperty("dataUsageRemainingInBytes")
  private JsonNullable<Double> dataUsageRemainingInBytes;

  /**
   * Status of the connectivity, possible values are 'ACTIVE' or 'NOT_ACTIVE'
   */
  @JsonProperty("status")
  private JsonNullable<String> status;

  @JsonIgnore
  public Double getDataUsageRemainingInBytes() {
    return dataUsageRemainingInBytes.orElse(null);
  }

  @JsonIgnore
  public String getStatus() {
    return status.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class GetPurchaseConsumptionOkResponseBuilder {

    private JsonNullable<Double> dataUsageRemainingInBytes = JsonNullable.undefined();

    @JsonProperty("dataUsageRemainingInBytes")
    public GetPurchaseConsumptionOkResponseBuilder dataUsageRemainingInBytes(Double value) {
      if (value == null) {
        throw new IllegalStateException("dataUsageRemainingInBytes cannot be null");
      }
      this.dataUsageRemainingInBytes = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> status = JsonNullable.undefined();

    @JsonProperty("status")
    public GetPurchaseConsumptionOkResponseBuilder status(String value) {
      if (value == null) {
        throw new IllegalStateException("status cannot be null");
      }
      this.status = JsonNullable.of(value);
      return this;
    }
  }
}
