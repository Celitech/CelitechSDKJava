# ConsumptionService

A list of all methods in the `ConsumptionService` service. Click on the method name to view detailed information about that method.

| Methods                                           | Description                                                                                                                                                                      |
| :------------------------------------------------ | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [getPurchaseConsumption](#getpurchaseconsumption) | This endpoint can be called for consumption notifications (e.g. every 1 hour or when the user clicks a button). It returns the data balance (consumption) of purchased packages. |

## getPurchaseConsumption

This endpoint can be called for consumption notifications (e.g. every 1 hour or when the user clicks a button). It returns the data balance (consumption) of purchased packages.

- HTTP Method: `GET`
- Endpoint: `/purchases/{purchaseId}/consumption`

**Parameters**

| Name              | Type                                                                              | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------------- | :------- | :------------------------ |
| purchaseId        | String                                                                            | ✅       |                           |
| requestParameters | [GetPurchaseConsumptionParameters](../models/GetPurchaseConsumptionParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GetPurchaseConsumptionParameters;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    GetPurchaseConsumptionParameters requestParameters = GetPurchaseConsumptionParameters.builder()
      .accept("application/json")
      .build();

    Object response = celitech.consumption.getPurchaseConsumption("purchaseId", requestParameters);

    System.out.println(response);
  }
}

```
