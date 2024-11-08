```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.models.ListPackagesOkResponse;
import io.github.celitech.celitechsdk.models.ListPackagesParameters;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = new Celitech();

    ListPackagesOkResponse response = celitech.packagesService.listPackages();

    System.out.println(response);
  }
}

```
