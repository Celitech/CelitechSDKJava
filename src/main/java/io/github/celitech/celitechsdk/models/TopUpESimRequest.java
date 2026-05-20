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
public class TopUpESimRequest {

  @JsonProperty("iccid")
  private JsonNullable<String> iccid;

  @JsonProperty("dataLimitInGB")
  private JsonNullable<Double> dataLimitInGb;

  @JsonProperty("startDate")
  private JsonNullable<String> startDate;

  @JsonProperty("endDate")
  private JsonNullable<String> endDate;

  @JsonProperty("duration")
  private JsonNullable<Double> duration;

  @JsonProperty("email")
  private JsonNullable<String> email;

  @JsonProperty("referenceId")
  private JsonNullable<String> referenceId;

  @JsonProperty("emailBrand")
  private JsonNullable<String> emailBrand;

  @JsonProperty("startTime")
  private JsonNullable<Double> startTime;

  @JsonProperty("endTime")
  private JsonNullable<Double> endTime;

  @JsonIgnore
  public String getIccid() {
    return iccid.orElse(null);
  }

  @JsonIgnore
  public Double getDataLimitInGb() {
    return dataLimitInGb.orElse(null);
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
  public Double getDuration() {
    return duration.orElse(null);
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
  public String getEmailBrand() {
    return emailBrand.orElse(null);
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
  public static class TopUpESimRequestBuilder {

    private JsonNullable<String> iccid = JsonNullable.undefined();

    @JsonProperty("iccid")
    public TopUpESimRequestBuilder iccid(String value) {
      this.iccid = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> dataLimitInGb = JsonNullable.undefined();

    @JsonProperty("dataLimitInGB")
    public TopUpESimRequestBuilder dataLimitInGb(Double value) {
      this.dataLimitInGb = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> startDate = JsonNullable.undefined();

    @JsonProperty("startDate")
    public TopUpESimRequestBuilder startDate(String value) {
      this.startDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> endDate = JsonNullable.undefined();

    @JsonProperty("endDate")
    public TopUpESimRequestBuilder endDate(String value) {
      this.endDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> duration = JsonNullable.undefined();

    @JsonProperty("duration")
    public TopUpESimRequestBuilder duration(Double value) {
      this.duration = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> email = JsonNullable.undefined();

    @JsonProperty("email")
    public TopUpESimRequestBuilder email(String value) {
      this.email = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> referenceId = JsonNullable.undefined();

    @JsonProperty("referenceId")
    public TopUpESimRequestBuilder referenceId(String value) {
      this.referenceId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> emailBrand = JsonNullable.undefined();

    @JsonProperty("emailBrand")
    public TopUpESimRequestBuilder emailBrand(String value) {
      this.emailBrand = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> startTime = JsonNullable.undefined();

    @JsonProperty("startTime")
    public TopUpESimRequestBuilder startTime(Double value) {
      this.startTime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> endTime = JsonNullable.undefined();

    @JsonProperty("endTime")
    public TopUpESimRequestBuilder endTime(Double value) {
      this.endTime = JsonNullable.of(value);
      return this;
    }
  }
}
