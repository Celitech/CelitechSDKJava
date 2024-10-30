```java
import net.celitech.celitech.Celitech;
import net.celitech.celitech.config.CelitechConfig;
import net.celitech.celitech.models.CreatePurchaseOkResponse;
import net.celitech.celitech.models.CreatePurchaseRequest;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("client-id").clientSecret("client-secret").build();

    Celitech celitech = new Celitech(config);

    CreatePurchaseRequest createPurchaseRequest = CreatePurchaseRequest
      .builder()
      .destination("FRA")
      .dataLimitInGb(1D)
      .startDate("2023-11-01")
      .endDate("2023-11-20")
      .build();

    CreatePurchaseOkResponse response = celitech.purchasesService.createPurchase(createPurchaseRequest);

    System.out.println(response);
  }
}

```
