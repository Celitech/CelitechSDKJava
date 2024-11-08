```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.models.GetEsimHistoryOkResponse;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = new Celitech();

    GetEsimHistoryOkResponse response = celitech.eSimService.getEsimHistory("1111222233334444555000");

    System.out.println(response);
  }
}

```
