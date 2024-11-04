package io.github.celitech.celitechsdk.models;

import java.util.List;
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
public class GetEsimHistoryOkResponseEsim {

  /**
   * ID of the eSIM
   */
  private String iccid;

  private List<History> history;
}
