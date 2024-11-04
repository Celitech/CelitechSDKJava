```java
import io.github.Celitech.celitechsdk.Celitech;
import io.github.Celitech.celitechsdk.config.CelitechConfig;
import io.github.Celitech.celitechsdk.models.TopUpEsimOkResponse;
import io.github.Celitech.celitechsdk.models.TopUpEsimRequest;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("client-id").clientSecret("client-secret").build();

    Celitech celitech = new Celitech(config);

    TopUpEsimRequest topUpEsimRequest = TopUpEsimRequest
      .builder()
      .iccid("1111222233334444555000")
      .dataLimitInGb(1D)
      .startDate("2023-11-01")
      .endDate("2023-11-20")
      .build();

    TopUpEsimOkResponse response = celitech.purchasesService.topUpEsim(topUpEsimRequest);

    System.out.println(response);
  }
}

```
