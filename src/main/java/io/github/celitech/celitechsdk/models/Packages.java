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
public class Packages {

  /**
   * ID of the package
   */
  private String id;

  /**
   * ISO representation of the package's destination.
   */
  private String destination;

  /**
   * Size of the package in bytes. For **limited packages**, this field will return the data limit in bytes. For **unlimited packages**, it will return **-1** as an identifier.
   *
   */
  private Double dataLimitInBytes;

  /**
   * Min number of days for the package
   */
  private Double minDays;

  /**
   * Max number of days for the package
   */
  private Double maxDays;

  /**
   * Price of the package in cents
   */
  private Double priceInCents;
}
