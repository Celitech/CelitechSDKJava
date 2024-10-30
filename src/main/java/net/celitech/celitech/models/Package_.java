package net.celitech.celitech.models;

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
   * Size of the package in Bytes
   */
  private Double dataLimitInBytes;

  /**
   * ISO representation of the package's destination
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
