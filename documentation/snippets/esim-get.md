```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.models.GetEsimOkResponse;
import io.github.celitech.celitechsdk.models.GetEsimParameters;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = new Celitech();

    GetEsimParameters requestParameters = GetEsimParameters.builder().iccid("1111222233334444555000").build();

    GetEsimOkResponse response = celitech.eSimService.getEsim(requestParameters);

    System.out.println(response);
  }
}

```
