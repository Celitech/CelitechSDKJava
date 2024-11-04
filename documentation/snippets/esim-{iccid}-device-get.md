```java
import io.github.Celitech.celitechsdk.Celitech;
import io.github.Celitech.celitechsdk.config.CelitechConfig;
import io.github.Celitech.celitechsdk.models.GetEsimDeviceOkResponse;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("client-id").clientSecret("client-secret").build();

    Celitech celitech = new Celitech(config);

    GetEsimDeviceOkResponse response = celitech.eSimService.getEsimDevice("1111222233334444555000");

    System.out.println(response);
  }
}

```
