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
public class Purchases {

  /**
   * ID of the purchase
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Start date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @JsonProperty("startDate")
  private JsonNullable<String> startDate;

  /**
   * End date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @JsonProperty("endDate")
  private JsonNullable<String> endDate;

  /**
   * Creation date of the purchase in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @JsonProperty("createdDate")
  private JsonNullable<String> createdDate;

  /**
   * Epoch value representing the start time of the package's validity
   */
  @JsonProperty("startTime")
  private JsonNullable<Double> startTime;

  /**
   * Epoch value representing the end time of the package's validity
   */
  @JsonProperty("endTime")
  private JsonNullable<Double> endTime;

  /**
   * Epoch value representing the date of creation of the purchase
   */
  @JsonProperty("createdAt")
  private JsonNullable<Double> createdAt;

  @JsonProperty("package")
  private JsonNullable<Package_> package_;

  @JsonProperty("esim")
  private JsonNullable<PurchasesEsim> esim;

  /**
   * The `source` indicates whether the purchase was made from the API, dashboard, landing-page, promo-page or iframe. For purchases made before September 8, 2023, the value will be displayed as 'Not available'.
   */
  @JsonProperty("source")
  private JsonNullable<String> source;

  /**
   * The `purchaseType` indicates whether this is the initial purchase that creates the eSIM (First Purchase) or a subsequent top-up on an existing eSIM (Top-up Purchase).
   */
  @JsonProperty("purchaseType")
  private JsonNullable<String> purchaseType;

  /**
   * The `referenceId` that was provided by the partner during the purchase or top-up flow. This identifier can be used for analytics and debugging purposes.
   */
  @JsonProperty("referenceId")
  private JsonNullable<String> referenceId;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getStartDate() {
    return startDate.orElse(null);
  }

  @JsonIgnore
  public String getEndDate() {
    return endDate.orElse(null);
  }

  @JsonIgnore
  public String getCreatedDate() {
    return createdDate.orElse(null);
  }

  @JsonIgnore
  public Double getStartTime() {
    return startTime.orElse(null);
  }

  @JsonIgnore
  public Double getEndTime() {
    return endTime.orElse(null);
  }

  @JsonIgnore
  public Double getCreatedAt() {
    return createdAt.orElse(null);
  }

  @JsonIgnore
  public Package_ getPackage_() {
    return package_.orElse(null);
  }

  @JsonIgnore
  public PurchasesEsim getEsim() {
    return esim.orElse(null);
  }

  @JsonIgnore
  public String getSource() {
    return source.orElse(null);
  }

  @JsonIgnore
  public String getPurchaseType() {
    return purchaseType.orElse(null);
  }

  @JsonIgnore
  public String getReferenceId() {
    return referenceId.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class PurchasesBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public PurchasesBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> startDate = JsonNullable.undefined();

    @JsonProperty("startDate")
    public PurchasesBuilder startDate(String value) {
      if (value == null) {
        throw new IllegalStateException("startDate cannot be null");
      }
      this.startDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> endDate = JsonNullable.undefined();

    @JsonProperty("endDate")
    public PurchasesBuilder endDate(String value) {
      if (value == null) {
        throw new IllegalStateException("endDate cannot be null");
      }
      this.endDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> createdDate = JsonNullable.undefined();

    @JsonProperty("createdDate")
    public PurchasesBuilder createdDate(String value) {
      if (value == null) {
        throw new IllegalStateException("createdDate cannot be null");
      }
      this.createdDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> startTime = JsonNullable.undefined();

    @JsonProperty("startTime")
    public PurchasesBuilder startTime(Double value) {
      if (value == null) {
        throw new IllegalStateException("startTime cannot be null");
      }
      this.startTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> endTime = JsonNullable.undefined();

    @JsonProperty("endTime")
    public PurchasesBuilder endTime(Double value) {
      if (value == null) {
        throw new IllegalStateException("endTime cannot be null");
      }
      this.endTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> createdAt = JsonNullable.undefined();

    @JsonProperty("createdAt")
    public PurchasesBuilder createdAt(Double value) {
      if (value == null) {
        throw new IllegalStateException("createdAt cannot be null");
      }
      this.createdAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Package_> package_ = JsonNullable.undefined();

    @JsonProperty("package")
    public PurchasesBuilder package_(Package_ value) {
      if (value == null) {
        throw new IllegalStateException("package_ cannot be null");
      }
      this.package_ = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PurchasesEsim> esim = JsonNullable.undefined();

    @JsonProperty("esim")
    public PurchasesBuilder esim(PurchasesEsim value) {
      if (value == null) {
        throw new IllegalStateException("esim cannot be null");
      }
      this.esim = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> source = JsonNullable.undefined();

    @JsonProperty("source")
    public PurchasesBuilder source(String value) {
      if (value == null) {
        throw new IllegalStateException("source cannot be null");
      }
      this.source = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> purchaseType = JsonNullable.undefined();

    @JsonProperty("purchaseType")
    public PurchasesBuilder purchaseType(String value) {
      if (value == null) {
        throw new IllegalStateException("purchaseType cannot be null");
      }
      this.purchaseType = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> referenceId = JsonNullable.undefined();

    @JsonProperty("referenceId")
    public PurchasesBuilder referenceId(String value) {
      if (value == null) {
        throw new IllegalStateException("referenceId cannot be null");
      }
      this.referenceId = JsonNullable.of(value);
      return this;
    }
  }
}
