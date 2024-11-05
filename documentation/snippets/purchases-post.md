```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.models.CreatePurchaseOkResponse;
import io.github.celitech.celitechsdk.models.CreatePurchaseRequest;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = new Celitech();

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
