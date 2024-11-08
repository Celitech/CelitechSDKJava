```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GetAccessTokenOkResponse;
import io.github.celitech.celitechsdk.models.GetAccessTokenRequest;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("client-id").clientSecret("client-secret").build();

    Celitech celitech = new Celitech(config);

    GetAccessTokenRequest getAccessTokenRequest = GetAccessTokenRequest.builder().build();

    GetAccessTokenOkResponse response = celitech.oAuthService.getAccessToken(getAccessTokenRequest);

    System.out.println(response);
  }
}

```
