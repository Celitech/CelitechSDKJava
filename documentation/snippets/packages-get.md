```java
import io.github.Celitech.celitechsdk.Celitech;
import io.github.Celitech.celitechsdk.config.CelitechConfig;
import io.github.Celitech.celitechsdk.models.ListPackagesOkResponse;
import io.github.Celitech.celitechsdk.models.ListPackagesParameters;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("client-id").clientSecret("client-secret").build();

    Celitech celitech = new Celitech(config);

    ListPackagesOkResponse response = celitech.packagesService.listPackages();

    System.out.println(response);
  }
}

```
