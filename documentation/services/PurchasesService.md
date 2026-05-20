# PurchasesService

A list of all methods in the `PurchasesService` service. Click on the method name to view detailed information about that method.

| Methods                           | Description                                                                                   |
| :-------------------------------- | :-------------------------------------------------------------------------------------------- |
| [createPurchase](#createpurchase) | This endpoint is used to purchase a new eSIM by providing the package details.                |
| [listPurchases](#listpurchases)   | This endpoint can be used to list all the successful purchases made between a given interval. |

## createPurchase

This endpoint is used to purchase a new eSIM by providing the package details.

- HTTP Method: `POST`
- Endpoint: `/purchases`

**Parameters**

| Name              | Type                                                              | Required | Description               |
| :---------------- | :---------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [CreatePurchaseParameters](../models/CreatePurchaseParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.CreatePurchaseParameters;
import io.github.celitech.celitechsdk.models.CreatePurchaseRequest;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    CreatePurchaseRequest createPurchaseRequest = CreatePurchaseRequest.builder().build();

    CreatePurchaseParameters requestParameters = CreatePurchaseParameters.builder()
      .accept("application/json")
      .requestBody(createPurchaseRequest)
      .build();

    Object response = celitech.purchases.createPurchase(requestParameters);

    System.out.println(response);
  }
}

```

## listPurchases

This endpoint can be used to list all the successful purchases made between a given interval.

- HTTP Method: `GET`
- Endpoint: `/purchases`

**Parameters**

| Name              | Type                                                            | Required | Description               |
| :---------------- | :-------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListPurchasesParameters](../models/ListPurchasesParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.ListPurchasesParameters;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    ListPurchasesParameters requestParameters = ListPurchasesParameters.builder()
      .accept("application/json")
      .build();

    Object response = celitech.purchases.listPurchases(requestParameters);

    System.out.println(response);
  }
}

```
