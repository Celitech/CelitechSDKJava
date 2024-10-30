```java
import net.celitech.celitech.Celitech;
import net.celitech.celitech.config.CelitechConfig;
import net.celitech.celitech.models.GetEsimOkResponse;
import net.celitech.celitech.models.GetEsimParameters;

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
