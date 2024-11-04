```java
import io.github.Celitech.celitechsdk.Celitech;
import io.github.Celitech.celitechsdk.config.CelitechConfig;
import io.github.Celitech.celitechsdk.models.ListPurchasesOkResponse;
import io.github.Celitech.celitechsdk.models.ListPurchasesParameters;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("client-id").clientSecret("client-secret").build();

    Celitech celitech = new Celitech(config);

    ListPurchasesOkResponse response = celitech.purchasesService.listPurchases();

    System.out.println(response);
  }
}

```
