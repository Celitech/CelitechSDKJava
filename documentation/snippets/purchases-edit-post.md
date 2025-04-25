```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.EditPurchaseOkResponse;
import io.github.celitech.celitechsdk.models.EditPurchaseRequest;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("CLIENT_ID").clientSecret("CLIENT_SECRET").build();

    Celitech celitech = new Celitech(config);

    EditPurchaseRequest editPurchaseRequest = EditPurchaseRequest.builder()
      .purchaseId("ae471106-c8b4-42cf-b83a-b061291f2922")
      .startDate("2023-11-01")
      .endDate("2023-11-20")
      .build();

    EditPurchaseOkResponse response = celitech.purchases.editPurchase(editPurchaseRequest);

    System.out.println(response);
  }
}

```
