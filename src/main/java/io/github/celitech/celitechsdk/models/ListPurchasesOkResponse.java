package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ListPurchasesOkResponse {

  @NonNull
  private List<Purchases> purchases;

  /**
   * The cursor value representing the end of the current page of results. Use this cursor value as the "afterCursor" parameter in your next request to retrieve the subsequent page of results. It ensures that you continue fetching data from where you left off, facilitating smooth pagination.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String afterCursor;

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

  // Overwrite lombok builder methods
  public static class ListPurchasesOkResponseBuilder {

    /**
     * Flag to track if the afterCursor property has been set.
     */
    private boolean afterCursor$set = false;

    public ListPurchasesOkResponseBuilder afterCursor(String afterCursor) {
      this.afterCursor$set = true;
      this.afterCursor = afterCursor;
      return this;
    }

    @JsonAnySetter
    public ListPurchasesOkResponseBuilder additionalProperties(String key, Object value) {
      if (this.additionalProperties$value == null) {
        this.additionalProperties$value = new HashMap<>();
      }
      this.additionalProperties$value.put(key, value);
      this.additionalProperties$set = true;
      return this;
    }

    public ListPurchasesOkResponse build() {
      if (!afterCursor$set) {
        throw new IllegalStateException("afterCursor is required");
      }
      Map<String, Object> additionalProperties$value = this.additionalProperties$value;
      if (!additionalProperties$set) {
        additionalProperties$value = new HashMap<>();
      }
      return new ListPurchasesOkResponse(purchases, afterCursor, additionalProperties$value);
    }
  }
}
