# TokenService

A list of all methods in the `TokenService` service. Click on the method name to view detailed information about that method.

| Methods                         | Description                                   |
| :------------------------------ | :-------------------------------------------- |
| [generateToken](#generatetoken) | Generate a new token to be used in the iFrame |

## generateToken

Generate a new token to be used in the iFrame

- HTTP Method: `POST`
- Endpoint: `/iframe/token`

**Parameters**

| Name              | Type                                                            | Required | Description               |
| :---------------- | :-------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [GenerateTokenParameters](../models/GenerateTokenParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GenerateTokenParameters;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    GenerateTokenParameters requestParameters = GenerateTokenParameters.builder()
      .accept("application/json")
      .build();

    Object response = celitech.token.generateToken(requestParameters);

    System.out.println(response);
  }
}

```
