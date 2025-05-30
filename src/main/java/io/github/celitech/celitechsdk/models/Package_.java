package io.github.celitech.celitechsdk.models;

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
public class Package_ {

  /**
   * ID of the package
   */
  private String id;

  /**
   * Size of the package in bytes. For **limited packages**, this field will return the data limit in bytes. For **unlimited packages**, it will return **-1** as an identifier.
   *
   */
  private Double dataLimitInBytes;

  /**
   * ISO representation of the package's destination.
   */
  private String destination;

  /**
   * Name of the package's destination
   */
  private String destinationName;

  /**
   * Price of the package in cents
   */
  private Double priceInCents;
}
