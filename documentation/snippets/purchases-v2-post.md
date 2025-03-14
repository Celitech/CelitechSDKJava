```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2OkResponse;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2Request;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("CLIENT_ID").clientSecret("CLIENT_SECRET").build();

    Celitech celitech = new Celitech(config);

    CreatePurchaseV2Request createPurchaseV2Request = CreatePurchaseV2Request
      .builder()
      .destination("FRA")
      .dataLimitInGb(1D)
      .startDate("2023-11-01")
      .endDate("2023-11-20")
      .quantity(1D)
      .build();

    List<CreatePurchaseV2OkResponse> response = celitech.purchases.createPurchaseV2(createPurchaseV2Request);

    System.out.println(response);
  }
}

```
