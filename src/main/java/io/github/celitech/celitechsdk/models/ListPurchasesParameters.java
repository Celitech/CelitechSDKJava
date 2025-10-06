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
public class ListPurchasesParameters {

  /**
   * ID of the eSIM
   */
  @JsonProperty("iccid")
  private JsonNullable<String> iccid;

  /**
   * Start date of the interval for filtering purchases in the format 'yyyy-MM-dd'
   */
  @JsonProperty("afterDate")
  private JsonNullable<String> afterDate;

  /**
   * End date of the interval for filtering purchases in the format 'yyyy-MM-dd'
   */
  @JsonProperty("beforeDate")
  private JsonNullable<String> beforeDate;

  /**
   * Email associated to the purchase.
   */
  @JsonProperty("email")
  private JsonNullable<String> email;

  /**
   * The referenceId that was provided by the partner during the purchase or topup flow.
   */
  @JsonProperty("referenceId")
  private JsonNullable<String> referenceId;

  /**
   * To get the next batch of results, use this parameter. It tells the API where to start fetching data after the last item you received. It helps you avoid repeats and efficiently browse through large sets of data.
   */
  @JsonProperty("afterCursor")
  private JsonNullable<String> afterCursor;

  /**
   * Maximum number of purchases to be returned in the response. The value must be greater than 0 and less than or equal to 100. If not provided, the default value is 20
   */
  @JsonProperty("limit")
  private JsonNullable<Double> limit;

  /**
   * Epoch value representing the start of the time interval for filtering purchases
   */
  @JsonProperty("after")
  private JsonNullable<Double> after;

  /**
   * Epoch value representing the end of the time interval for filtering purchases
   */
  @JsonProperty("before")
  private JsonNullable<Double> before;

  @JsonIgnore
  public String getIccid() {
    return iccid.orElse(null);
  }

  @JsonIgnore
  public String getAfterDate() {
    return afterDate.orElse(null);
  }

  @JsonIgnore
  public String getBeforeDate() {
    return beforeDate.orElse(null);
  }

  @JsonIgnore
  public String getEmail() {
    return email.orElse(null);
  }

  @JsonIgnore
  public String getReferenceId() {
    return referenceId.orElse(null);
  }

  @JsonIgnore
  public String getAfterCursor() {
    return afterCursor.orElse(null);
  }

  @JsonIgnore
  public Double getLimit() {
    return limit.orElse(null);
  }

  @JsonIgnore
  public Double getAfter() {
    return after.orElse(null);
  }

  @JsonIgnore
  public Double getBefore() {
    return before.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListPurchasesParametersBuilder {

    private JsonNullable<String> iccid = JsonNullable.undefined();

    @JsonProperty("iccid")
    public ListPurchasesParametersBuilder iccid(String value) {
      if (value == null) {
        throw new IllegalStateException("iccid cannot be null");
      }
      this.iccid = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> afterDate = JsonNullable.undefined();

    @JsonProperty("afterDate")
    public ListPurchasesParametersBuilder afterDate(String value) {
      if (value == null) {
        throw new IllegalStateException("afterDate cannot be null");
      }
      this.afterDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> beforeDate = JsonNullable.undefined();

    @JsonProperty("beforeDate")
    public ListPurchasesParametersBuilder beforeDate(String value) {
      if (value == null) {
        throw new IllegalStateException("beforeDate cannot be null");
      }
      this.beforeDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> email = JsonNullable.undefined();

    @JsonProperty("email")
    public ListPurchasesParametersBuilder email(String value) {
      if (value == null) {
        throw new IllegalStateException("email cannot be null");
      }
      this.email = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> referenceId = JsonNullable.undefined();

    @JsonProperty("referenceId")
    public ListPurchasesParametersBuilder referenceId(String value) {
      if (value == null) {
        throw new IllegalStateException("referenceId cannot be null");
      }
      this.referenceId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> afterCursor = JsonNullable.undefined();

    @JsonProperty("afterCursor")
    public ListPurchasesParametersBuilder afterCursor(String value) {
      if (value == null) {
        throw new IllegalStateException("afterCursor cannot be null");
      }
      this.afterCursor = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> limit = JsonNullable.undefined();

    @JsonProperty("limit")
    public ListPurchasesParametersBuilder limit(Double value) {
      if (value == null) {
        throw new IllegalStateException("limit cannot be null");
      }
      this.limit = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> after = JsonNullable.undefined();

    @JsonProperty("after")
    public ListPurchasesParametersBuilder after(Double value) {
      if (value == null) {
        throw new IllegalStateException("after cannot be null");
      }
      this.after = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> before = JsonNullable.undefined();

    @JsonProperty("before")
    public ListPurchasesParametersBuilder before(Double value) {
      if (value == null) {
        throw new IllegalStateException("before cannot be null");
      }
      this.before = JsonNullable.of(value);
      return this;
    }
  }
}
