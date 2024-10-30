```java
import net.celitech.celitech.Celitech;
import net.celitech.celitech.config.CelitechConfig;
import net.celitech.celitech.models.TopUpEsimOkResponse;
import net.celitech.celitech.models.TopUpEsimRequest;

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
