package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

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
  @NonNull
  private String id;

  /**
   * Size of the package in Bytes
   */
  @NonNull
  private Double dataLimitInBytes;

  /**
   * ISO3 representation of the package's destination.
   */
  @NonNull
  private String destination;

  /**
   * ISO2 representation of the package's destination.
   */
  @NonNull
  @JsonProperty("destinationISO2")
  private String destinationIso2;

  /**
   * Name of the package's destination
   */
  @NonNull
  private String destinationName;

  /**
   * Price of the package in cents
   */
  @NonNull
  private Double priceInCents;
}
