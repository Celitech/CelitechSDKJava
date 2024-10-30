```java
import net.celitech.celitech.Celitech;
import net.celitech.celitech.config.CelitechConfig;
import net.celitech.celitech.models.GetAccessTokenOkResponse;
import net.celitech.celitech.models.GetAccessTokenRequest;

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
