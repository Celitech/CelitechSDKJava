```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.models.GetEsimMacOkResponse;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = new Celitech();

    GetEsimMacOkResponse response = celitech.eSimService.getEsimMac("1111222233334444555000");

    System.out.println(response);
  }
}

```
