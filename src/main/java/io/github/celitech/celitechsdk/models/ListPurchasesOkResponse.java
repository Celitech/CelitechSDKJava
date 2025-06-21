package io.github.celitech.celitechsdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class ListPurchasesOkResponse {

  @JsonProperty("purchases")
  private JsonNullable<List<Purchases>> purchases;

  /**
   * The cursor value representing the end of the current page of results. Use this cursor value as the "afterCursor" parameter in your next request to retrieve the subsequent page of results. It ensures that you continue fetching data from where you left off, facilitating smooth pagination.
   */
  @JsonProperty("afterCursor")
  private JsonNullable<String> afterCursor;

  @JsonIgnore
  public List<Purchases> getPurchases() {
    return purchases.orElse(null);
  }

  @JsonIgnore
  public String getAfterCursor() {
    return afterCursor.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListPurchasesOkResponseBuilder {

    private JsonNullable<List<Purchases>> purchases = JsonNullable.undefined();

    @JsonProperty("purchases")
    public ListPurchasesOkResponseBuilder purchases(List<Purchases> value) {
      if (value == null) {
        throw new IllegalStateException("purchases cannot be null");
      }
      this.purchases = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> afterCursor = JsonNullable.undefined();

    @JsonProperty("afterCursor")
    public ListPurchasesOkResponseBuilder afterCursor(String value) {
      this.afterCursor = JsonNullable.of(value);
      return this;
    }
  }
}
