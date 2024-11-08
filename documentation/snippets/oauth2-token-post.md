```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.models.GetAccessTokenOkResponse;
import io.github.celitech.celitechsdk.models.GetAccessTokenRequest;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = new Celitech();

    GetAccessTokenRequest getAccessTokenRequest = GetAccessTokenRequest.builder().build();

    GetAccessTokenOkResponse response = celitech.oAuthService.getAccessToken(getAccessTokenRequest);

    System.out.println(response);
  }
}

```
