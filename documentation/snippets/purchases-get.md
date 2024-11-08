```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.models.ListPurchasesOkResponse;
import io.github.celitech.celitechsdk.models.ListPurchasesParameters;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = new Celitech();

    ListPurchasesOkResponse response = celitech.purchasesService.listPurchases();

    System.out.println(response);
  }
}

```
