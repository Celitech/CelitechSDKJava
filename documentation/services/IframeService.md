# IframeService

A list of all methods in the `IframeService` service. Click on the method name to view detailed information about that method.

| Methods         | Description                                   |
| :-------------- | :-------------------------------------------- |
| [token](#token) | Generate a new token to be used in the iframe |

## token

Generate a new token to be used in the iframe

- HTTP Method: `GET`
- Endpoint: `/iframe/token`

**Return Type**

`TokenOkResponse`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.TokenOkResponse;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("CLIENT_ID").clientSecret("CLIENT_SECRET").build();

    Celitech celitech = new Celitech(config);

    TokenOkResponse response = celitech.iframe.token();

    System.out.println(response);
  }
}

```
