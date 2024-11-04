```java
import io.github.Celitech.celitechsdk.Celitech;
import io.github.Celitech.celitechsdk.config.CelitechConfig;
import io.github.Celitech.celitechsdk.models.GetPurchaseConsumptionOkResponse;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("client-id").clientSecret("client-secret").build();

    Celitech celitech = new Celitech(config);

    GetPurchaseConsumptionOkResponse response = celitech.purchasesService.getPurchaseConsumption(
      "4973fa15-6979-4daa-9cf3-672620df819c"
    );

    System.out.println(response);
  }
}

```
