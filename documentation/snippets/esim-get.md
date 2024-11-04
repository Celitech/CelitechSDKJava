```java
import io.github.Celitech.celitechsdk.Celitech;
import io.github.Celitech.celitechsdk.config.CelitechConfig;
import io.github.Celitech.celitechsdk.models.GetEsimOkResponse;
import io.github.Celitech.celitechsdk.models.GetEsimParameters;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("client-id").clientSecret("client-secret").build();

    Celitech celitech = new Celitech(config);

    GetEsimParameters requestParameters = GetEsimParameters.builder().iccid("1111222233334444555000").build();

    GetEsimOkResponse response = celitech.eSimService.getEsim(requestParameters);

    System.out.println(response);
  }
}

```
