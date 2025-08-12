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
public class Packages {

  /**
   * ID of the package
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

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
   * Size of the package in Bytes
   */
  @JsonProperty("dataLimitInBytes")
  private JsonNullable<Double> dataLimitInBytes;

  /**
   * Min number of days for the package
   */
  @JsonProperty("minDays")
  private JsonNullable<Double> minDays;

  /**
   * Max number of days for the package
   */
  @JsonProperty("maxDays")
  private JsonNullable<Double> maxDays;

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
  public String getDestination() {
    return destination.orElse(null);
  }

  @JsonIgnore
  public String getDestinationIso2() {
    return destinationIso2.orElse(null);
  }

  @JsonIgnore
  public Double getDataLimitInBytes() {
    return dataLimitInBytes.orElse(null);
  }

  @JsonIgnore
  public Double getMinDays() {
    return minDays.orElse(null);
  }

  @JsonIgnore
  public Double getMaxDays() {
    return maxDays.orElse(null);
  }

  @JsonIgnore
  public Double getPriceInCents() {
    return priceInCents.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class PackagesBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public PackagesBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> destination = JsonNullable.undefined();

    @JsonProperty("destination")
    public PackagesBuilder destination(String value) {
      if (value == null) {
        throw new IllegalStateException("destination cannot be null");
      }
      this.destination = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> destinationIso2 = JsonNullable.undefined();

    @JsonProperty("destinationISO2")
    public PackagesBuilder destinationIso2(String value) {
      if (value == null) {
        throw new IllegalStateException("destinationIso2 cannot be null");
      }
      this.destinationIso2 = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> dataLimitInBytes = JsonNullable.undefined();

    @JsonProperty("dataLimitInBytes")
    public PackagesBuilder dataLimitInBytes(Double value) {
      if (value == null) {
        throw new IllegalStateException("dataLimitInBytes cannot be null");
      }
      this.dataLimitInBytes = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> minDays = JsonNullable.undefined();

    @JsonProperty("minDays")
    public PackagesBuilder minDays(Double value) {
      if (value == null) {
        throw new IllegalStateException("minDays cannot be null");
      }
      this.minDays = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> maxDays = JsonNullable.undefined();

    @JsonProperty("maxDays")
    public PackagesBuilder maxDays(Double value) {
      if (value == null) {
        throw new IllegalStateException("maxDays cannot be null");
      }
      this.maxDays = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> priceInCents = JsonNullable.undefined();

    @JsonProperty("priceInCents")
    public PackagesBuilder priceInCents(Double value) {
      if (value == null) {
        throw new IllegalStateException("priceInCents cannot be null");
      }
      this.priceInCents = JsonNullable.of(value);
      return this;
    }
  }
}
