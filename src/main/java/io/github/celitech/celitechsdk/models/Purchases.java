package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
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
  @NonNull
  private String id;

  /**
   * Start date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private OffsetDateTime startDate;

  /**
   * End date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private OffsetDateTime endDate;

  /**
   * Creation date of the purchase in the format 'yyyy-MM-ddThh:mm:ssZZ'
   */
  @NonNull
  private OffsetDateTime createdDate;

  @NonNull
  @JsonProperty("package")
  private Package_ package_;

  @NonNull
  private PurchasesEsim esim;

  /**
   * The `source` indicates whether the purchase was made from the API, dashboard, landing-page, promo-page or iframe. For purchases made before September 8, 2023, the value will be displayed as 'Not available'.
   */
  @NonNull
  private String source;

  /**
   * The `purchaseType` indicates whether this is the initial purchase that creates the eSIM (First Purchase) or a subsequent top-up on an existing eSIM (Top-up Purchase).
   */
  @NonNull
  private String purchaseType;

  /**
   * Duration of the package in days. Possible values are 1, 2, 7, 14, 30, or 90. `null` for unlimited (date-based) packages.
   */
  @JsonProperty("duration")
  private JsonNullable<Double> duration;

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

  /**
   * The `referenceId` that was provided by the partner during the purchase or top-up flow. This identifier can be used for analytics and debugging purposes.
   */
  @JsonProperty("referenceId")
  private JsonNullable<String> referenceId;

  // FSM-59: capture unknown JSON fields so they round-trip on re-serialize.
  // @Builder.Default keeps the empty-map default in the Lombok-generated builder; without it the
  // builder would leave the map null and the any-setter would NPE on the first unknown field.
  // Deserialization is wired via the builder's @JsonAnySetter (see the Builder below), NOT here:
  // Lombok @Jacksonized deserializes through the builder and does not copy a field-level
  // @JsonAnySetter across, so unknown fields would be silently dropped if it lived on this field.
  @Builder.Default
  private Map<String, Object> additionalProperties = new HashMap<>();

  // @JsonAnyGetter must sit on the getter (not the field) so Jackson inlines the unknown entries on
  // serialize. On the field it double-registers with the Lombok getter and leaks a literal
  // "additionalProperties" property into every request body and object parameter.
  // Declaring the getter here also stops Lombok @Data from generating its own.
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  @JsonIgnore
  public Double getDuration() {
    return duration.orElse(null);
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
  public String getReferenceId() {
    return referenceId.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class PurchasesBuilder {

    /**
     * Flag to track if the startDate property has been set.
     */
    private boolean startDate$set = false;

    /**
     * Flag to track if the endDate property has been set.
     */
    private boolean endDate$set = false;

    public PurchasesBuilder startDate(OffsetDateTime startDate) {
      this.startDate$set = true;
      this.startDate = startDate;
      return this;
    }

    public PurchasesBuilder endDate(OffsetDateTime endDate) {
      this.endDate$set = true;
      this.endDate = endDate;
      return this;
    }

    private JsonNullable<Double> duration = JsonNullable.undefined();

    @JsonProperty("duration")
    public PurchasesBuilder duration(Double value) {
      this.duration = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> startTime = JsonNullable.undefined();

    @JsonProperty("startTime")
    public PurchasesBuilder startTime(Double value) {
      this.startTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> endTime = JsonNullable.undefined();

    @JsonProperty("endTime")
    public PurchasesBuilder endTime(Double value) {
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

    private JsonNullable<String> referenceId = JsonNullable.undefined();

    @JsonProperty("referenceId")
    public PurchasesBuilder referenceId(String value) {
      this.referenceId = JsonNullable.of(value);
      return this;
    }

    @JsonAnySetter
    public PurchasesBuilder additionalProperties(String key, Object value) {
      if (this.additionalProperties$value == null) {
        this.additionalProperties$value = new HashMap<>();
      }
      this.additionalProperties$value.put(key, value);
      this.additionalProperties$set = true;
      return this;
    }

    public Purchases build() {
      if (!startDate$set) {
        throw new IllegalStateException("startDate is required");
      }
      if (!endDate$set) {
        throw new IllegalStateException("endDate is required");
      }
      Map<String, Object> additionalProperties$value = this.additionalProperties$value;
      if (!additionalProperties$set) {
        additionalProperties$value = new HashMap<>();
      }
      return new Purchases(
        id,
        startDate,
        endDate,
        createdDate,
        package_,
        esim,
        source,
        purchaseType,
        duration,
        startTime,
        endTime,
        createdAt,
        referenceId,
        additionalProperties$value
      );
    }
  }
}
