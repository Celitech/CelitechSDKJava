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
public class GetEsimDeviceOkResponse {

  @JsonProperty("device")
  private JsonNullable<Device> device;

  @JsonIgnore
  public Device getDevice() {
    return device.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class GetEsimDeviceOkResponseBuilder {

    private JsonNullable<Device> device = JsonNullable.undefined();

    @JsonProperty("device")
    public GetEsimDeviceOkResponseBuilder device(Device value) {
      if (value == null) {
        throw new IllegalStateException("device cannot be null");
      }
      this.device = JsonNullable.of(value);
      return this;
    }
  }
}
