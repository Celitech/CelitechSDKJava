```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.models.TopUpEsimOkResponse;
import io.github.celitech.celitechsdk.models.TopUpEsimRequest;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = new Celitech();

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
