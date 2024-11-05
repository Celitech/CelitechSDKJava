```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.models.GetEsimDeviceOkResponse;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = new Celitech();

    GetEsimDeviceOkResponse response = celitech.eSimService.getEsimDevice("1111222233334444555000");

    System.out.println(response);
  }
}

```
