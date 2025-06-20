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
public class Device {

  /**
   * Name of the OEM
   */
  @JsonProperty("oem")
  private JsonNullable<String> oem;

  /**
   * Name of the Device
   */
  @JsonProperty("hardwareName")
  private JsonNullable<String> hardwareName;

  /**
   * Model of the Device
   */
  @JsonProperty("hardwareModel")
  private JsonNullable<String> hardwareModel;

  /**
   * Serial Number of the eSIM
   */
  @JsonProperty("eid")
  private JsonNullable<String> eid;

  @JsonIgnore
  public String getOem() {
    return oem.orElse(null);
  }

  @JsonIgnore
  public String getHardwareName() {
    return hardwareName.orElse(null);
  }

  @JsonIgnore
  public String getHardwareModel() {
    return hardwareModel.orElse(null);
  }

  @JsonIgnore
  public String getEid() {
    return eid.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class DeviceBuilder {

    private JsonNullable<String> oem = JsonNullable.undefined();

    @JsonProperty("oem")
    public DeviceBuilder oem(String value) {
      if (value == null) {
        throw new IllegalStateException("oem cannot be null");
      }
      this.oem = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> hardwareName = JsonNullable.undefined();

    @JsonProperty("hardwareName")
    public DeviceBuilder hardwareName(String value) {
      if (value == null) {
        throw new IllegalStateException("hardwareName cannot be null");
      }
      this.hardwareName = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> hardwareModel = JsonNullable.undefined();

    @JsonProperty("hardwareModel")
    public DeviceBuilder hardwareModel(String value) {
      if (value == null) {
        throw new IllegalStateException("hardwareModel cannot be null");
      }
      this.hardwareModel = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> eid = JsonNullable.undefined();

    @JsonProperty("eid")
    public DeviceBuilder eid(String value) {
      if (value == null) {
        throw new IllegalStateException("eid cannot be null");
      }
      this.eid = JsonNullable.of(value);
      return this;
    }
  }
}
