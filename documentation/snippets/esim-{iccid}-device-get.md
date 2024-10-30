```java
import net.celitech.celitech.Celitech;
import net.celitech.celitech.config.CelitechConfig;
import net.celitech.celitech.models.GetEsimDeviceOkResponse;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("client-id").clientSecret("client-secret").build();

    Celitech celitech = new Celitech(config);

    GetEsimDeviceOkResponse response = celitech.eSimService.getEsimDevice("1111222233334444555000");

    System.out.println(response);
  }
}

```
