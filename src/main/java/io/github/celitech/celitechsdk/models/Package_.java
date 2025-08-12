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
public class Package_ {

  /**
   * ID of the package
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Size of the package in Bytes
   */
  @JsonProperty("dataLimitInBytes")
  private JsonNullable<Double> dataLimitInBytes;

  /**
   * ISO3 representation of the package's destination.
   */
  @JsonProperty("destination")
  private JsonNullable<String> destination;

  /**
   * ISO2 representation of the package's destination.
   */
  @JsonProperty("destinationISO2")
  private JsonNullable<String> destinationIso2;

  /**
   * Name of the package's destination
   */
  @JsonProperty("destinationName")
  private JsonNullable<String> destinationName;

  /**
   * Price of the package in cents
   */
  @JsonProperty("priceInCents")
  private JsonNullable<Double> priceInCents;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public Double getDataLimitInBytes() {
    return dataLimitInBytes.orElse(null);
  }

  @JsonIgnore
  public String getDestination() {
    return destination.orElse(null);
  }

  @JsonIgnore
  public String getDestinationIso2() {
    return destinationIso2.orElse(null);
  }

  @JsonIgnore
  public String getDestinationName() {
    return destinationName.orElse(null);
  }

  @JsonIgnore
  public Double getPriceInCents() {
    return priceInCents.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class Package_Builder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public Package_Builder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> dataLimitInBytes = JsonNullable.undefined();

    @JsonProperty("dataLimitInBytes")
    public Package_Builder dataLimitInBytes(Double value) {
      if (value == null) {
        throw new IllegalStateException("dataLimitInBytes cannot be null");
      }
      this.dataLimitInBytes = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> destination = JsonNullable.undefined();

    @JsonProperty("destination")
    public Package_Builder destination(String value) {
      if (value == null) {
        throw new IllegalStateException("destination cannot be null");
      }
      this.destination = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> destinationIso2 = JsonNullable.undefined();

    @JsonProperty("destinationISO2")
    public Package_Builder destinationIso2(String value) {
      if (value == null) {
        throw new IllegalStateException("destinationIso2 cannot be null");
      }
      this.destinationIso2 = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> destinationName = JsonNullable.undefined();

    @JsonProperty("destinationName")
    public Package_Builder destinationName(String value) {
      if (value == null) {
        throw new IllegalStateException("destinationName cannot be null");
      }
      this.destinationName = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> priceInCents = JsonNullable.undefined();

    @JsonProperty("priceInCents")
    public Package_Builder priceInCents(Double value) {
      if (value == null) {
        throw new IllegalStateException("priceInCents cannot be null");
      }
      this.priceInCents = JsonNullable.of(value);
      return this;
    }
  }
}
