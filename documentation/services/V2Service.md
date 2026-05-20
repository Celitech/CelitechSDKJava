# V2Service

A list of all methods in the `V2Service` service. Click on the method name to view detailed information about that method.

| Methods                               | Description                                                                    |
| :------------------------------------ | :----------------------------------------------------------------------------- |
| [createPurchaseV2](#createpurchasev2) | This endpoint is used to purchase a new eSIM by providing the package details. |

## createPurchaseV2

This endpoint is used to purchase a new eSIM by providing the package details.

- HTTP Method: `POST`
- Endpoint: `/purchases/v2`

**Parameters**

| Name              | Type                                                                  | Required | Description               |
| :---------------- | :-------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [CreatePurchaseV2Parameters](../models/CreatePurchaseV2Parameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2Parameters;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2Request;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    CreatePurchaseV2Request createPurchaseV2Request = CreatePurchaseV2Request.builder().build();

    CreatePurchaseV2Parameters requestParameters = CreatePurchaseV2Parameters.builder()
      .accept("application/json")
      .requestBody(createPurchaseV2Request)
      .build();

    Object response = celitech.v2.createPurchaseV2(requestParameters);

    System.out.println(response);
  }
}

```
