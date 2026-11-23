# IFrameService

A list of all methods in the `IFrameService` service. Click on the method name to view detailed information about that method.

| Methods         | Description                                   |
| :-------------- | :-------------------------------------------- |
| [token](#token) | Generate a new token to be used in the iFrame |

## token

Generate a new token to be used in the iFrame

- HTTP Method: `POST`
- Endpoint: `/iframe/token`

**Return Type**

[`TokenResponse`](../models/TokenResponse.md)

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.resources.iframe.types.TokenResponse;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = Celitech.builder().token("ACCESS_TOKEN").build();

    TokenResponse response = celitech.iFrame().token();

    System.out.println(response);
  }
}
```
