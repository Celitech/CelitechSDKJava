# TopupService

A list of all methods in the `TopupService` service. Click on the method name to view detailed information about that method.

| Methods                 | Description                                                                                                                                                                                                                                           |
| :---------------------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [topUpESim](#topupesim) | This endpoint is used to top-up an existing eSIM with the previously associated destination by providing its ICCID and package details. To determine if an eSIM can be topped up, use the Get eSIM endpoint, which returns the `isTopUpAllowed` flag. |

## topUpESim

This endpoint is used to top-up an existing eSIM with the previously associated destination by providing its ICCID and package details. To determine if an eSIM can be topped up, use the Get eSIM endpoint, which returns the `isTopUpAllowed` flag.

- HTTP Method: `POST`
- Endpoint: `/purchases/topup`

**Parameters**

| Name              | Type                                                    | Required | Description               |
| :---------------- | :------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [TopUpESimParameters](../models/TopUpESimParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.TopUpESimParameters;
import io.github.celitech.celitechsdk.models.TopUpESimRequest;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    TopUpESimRequest topUpESimRequest = TopUpESimRequest.builder().build();

    TopUpESimParameters requestParameters = TopUpESimParameters.builder()
      .accept("application/json")
      .requestBody(topUpESimRequest)
      .build();

    Object response = celitech.topup.topUpESim(requestParameters);

    System.out.println(response);
  }
}

```
