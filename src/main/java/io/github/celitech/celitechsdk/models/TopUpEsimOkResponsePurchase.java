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
public class TopUpEsimOkResponsePurchase {

  /**
   * ID of the purchase
   */
  @NonNull
  private String id;

  /**
   * ID of the package
   */
  @NonNull
  private String packageId;

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
  public Double getStartTime() {
    return startTime.orElse(null);
  }

  @JsonIgnore
  public Double getEndTime() {
    return endTime.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class TopUpEsimOkResponsePurchaseBuilder {

    /**
     * Flag to track if the startDate property has been set.
     */
    private boolean startDate$set = false;

    /**
     * Flag to track if the endDate property has been set.
     */
    private boolean endDate$set = false;

    public TopUpEsimOkResponsePurchaseBuilder startDate(OffsetDateTime startDate) {
      this.startDate$set = true;
      this.startDate = startDate;
      return this;
    }

    public TopUpEsimOkResponsePurchaseBuilder endDate(OffsetDateTime endDate) {
      this.endDate$set = true;
      this.endDate = endDate;
      return this;
    }

    private JsonNullable<Double> startTime = JsonNullable.undefined();

    @JsonProperty("startTime")
    public TopUpEsimOkResponsePurchaseBuilder startTime(Double value) {
      this.startTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> endTime = JsonNullable.undefined();

    @JsonProperty("endTime")
    public TopUpEsimOkResponsePurchaseBuilder endTime(Double value) {
      this.endTime = JsonNullable.of(value);
      return this;
    }

    @JsonAnySetter
    public TopUpEsimOkResponsePurchaseBuilder additionalProperties(String key, Object value) {
      if (this.additionalProperties$value == null) {
        this.additionalProperties$value = new HashMap<>();
      }
      this.additionalProperties$value.put(key, value);
      this.additionalProperties$set = true;
      return this;
    }

    public TopUpEsimOkResponsePurchase build() {
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
      return new TopUpEsimOkResponsePurchase(
        id,
        packageId,
        startDate,
        endDate,
        createdDate,
        startTime,
        endTime,
        additionalProperties$value
      );
    }
  }
}
