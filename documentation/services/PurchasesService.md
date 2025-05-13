# PurchasesService

A list of all methods in the `PurchasesService` service. Click on the method name to view detailed information about that method.

| Methods                                           | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| :------------------------------------------------ | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [createPurchaseV2](#createpurchasev2)             | This endpoint lets you purchase a new eSIM by providing the package details. You must include **either**: - Both `startDate` and `endDate` (to set a fixed date range), **or** - `duration` (to set how many days the eSIM will be active). These options cannot be used together, only one of them should be provided.                                                                                                                                                                                                                                                                    |
| [listPurchases](#listpurchases)                   | This endpoint can be used to list all the successful purchases made between a given interval.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| [topUpEsim](#topupesim)                           | This endpoint lets you top up an existing eSIM by providing its ICCID and the new package details. The destination must be the same as the one used in the original purchase. Top-up is only allowed for eSIMs that are in the **"ENABLED"** or **"INSTALLED"** state. You can check the current state using the **Get eSIM Status** endpoint. You must include **either**: - Both `startDate` and `endDate` (to set a fixed date range), **or** - `duration` (to set how many days the eSIM will be active). These options cannot be used together — only one of them should be provided. |
| [editPurchase](#editpurchase)                     | This endpoint allows you to modify the dates of an existing package with a future activation start time. Editing can only be performed for packages that have not been activated, and it cannot change the package size. The modification must not change the package duration category to ensure pricing consistency. Duration based packages cannot be edited.                                                                                                                                                                                                                           |
| [getPurchaseConsumption](#getpurchaseconsumption) | This endpoint can be called for consumption notifications (e.g. every 1 hour or when the user clicks a button). It returns the data balance (consumption) of purchased packages.                                                                                                                                                                                                                                                                                                                                                                                                           |

## createPurchaseV2

This endpoint lets you purchase a new eSIM by providing the package details. You must include **either**: - Both `startDate` and `endDate` (to set a fixed date range), **or** - `duration` (to set how many days the eSIM will be active). These options cannot be used together, only one of them should be provided.

- HTTP Method: `POST`
- Endpoint: `/purchases/v2`

**Parameters**

| Name                    | Type                                                            | Required | Description  |
| :---------------------- | :-------------------------------------------------------------- | :------- | :----------- |
| createPurchaseV2Request | [CreatePurchaseV2Request](../models/CreatePurchaseV2Request.md) | ✅       | Request Body |

**Return Type**

`List<CreatePurchaseV2OkResponse>`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2OkResponse;
import io.github.celitech.celitechsdk.models.CreatePurchaseV2Request;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("CLIENT_ID").clientSecret("CLIENT_SECRET").build();

    Celitech celitech = new Celitech(config);

    CreatePurchaseV2Request createPurchaseV2Request = CreatePurchaseV2Request.builder()
      .destination("FRA")
      .dataLimitInGb(1D)
      .quantity(1D)
      .build();

    List<CreatePurchaseV2OkResponse> response = celitech.purchases.createPurchaseV2(createPurchaseV2Request);

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
| requestParameters | [ListPurchasesParameters](../models/ListPurchasesParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ListPurchasesOkResponse`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.ListPurchasesOkResponse;
import io.github.celitech.celitechsdk.models.ListPurchasesParameters;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("CLIENT_ID").clientSecret("CLIENT_SECRET").build();

    Celitech celitech = new Celitech(config);

    ListPurchasesOkResponse response = celitech.purchases.listPurchases();

    System.out.println(response);
  }
}

```

## topUpEsim

This endpoint lets you top up an existing eSIM by providing its ICCID and the new package details. The destination must be the same as the one used in the original purchase. Top-up is only allowed for eSIMs that are in the **"ENABLED"** or **"INSTALLED"** state. You can check the current state using the **Get eSIM Status** endpoint. You must include **either**: - Both `startDate` and `endDate` (to set a fixed date range), **or** - `duration` (to set how many days the eSIM will be active). These options cannot be used together — only one of them should be provided.

- HTTP Method: `POST`
- Endpoint: `/purchases/topup`

**Parameters**

| Name             | Type                                              | Required | Description  |
| :--------------- | :------------------------------------------------ | :------- | :----------- |
| topUpEsimRequest | [TopUpEsimRequest](../models/TopUpEsimRequest.md) | ✅       | Request Body |

**Return Type**

`TopUpEsimOkResponse`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.TopUpEsimOkResponse;
import io.github.celitech.celitechsdk.models.TopUpEsimRequest;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("CLIENT_ID").clientSecret("CLIENT_SECRET").build();

    Celitech celitech = new Celitech(config);

    TopUpEsimRequest topUpEsimRequest = TopUpEsimRequest.builder()
      .iccid("1111222233334444555000")
      .dataLimitInGb(1D)
      .build();

    TopUpEsimOkResponse response = celitech.purchases.topUpEsim(topUpEsimRequest);

    System.out.println(response);
  }
}

```

## editPurchase

This endpoint allows you to modify the dates of an existing package with a future activation start time. Editing can only be performed for packages that have not been activated, and it cannot change the package size. The modification must not change the package duration category to ensure pricing consistency. Duration based packages cannot be edited.

- HTTP Method: `POST`
- Endpoint: `/purchases/edit`

**Parameters**

| Name                | Type                                                    | Required | Description  |
| :------------------ | :------------------------------------------------------ | :------- | :----------- |
| editPurchaseRequest | [EditPurchaseRequest](../models/EditPurchaseRequest.md) | ✅       | Request Body |

**Return Type**

`EditPurchaseOkResponse`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.EditPurchaseOkResponse;
import io.github.celitech.celitechsdk.models.EditPurchaseRequest;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("CLIENT_ID").clientSecret("CLIENT_SECRET").build();

    Celitech celitech = new Celitech(config);

    EditPurchaseRequest editPurchaseRequest = EditPurchaseRequest.builder()
      .purchaseId("ae471106-c8b4-42cf-b83a-b061291f2922")
      .startDate("2023-11-01")
      .endDate("2023-11-20")
      .build();

    EditPurchaseOkResponse response = celitech.purchases.editPurchase(editPurchaseRequest);

    System.out.println(response);
  }
}

```

## getPurchaseConsumption

This endpoint can be called for consumption notifications (e.g. every 1 hour or when the user clicks a button). It returns the data balance (consumption) of purchased packages.

- HTTP Method: `GET`
- Endpoint: `/purchases/{purchaseId}/consumption`

**Parameters**

| Name       | Type   | Required | Description        |
| :--------- | :----- | :------- | :----------------- |
| purchaseId | String | ✅       | ID of the purchase |

**Return Type**

`GetPurchaseConsumptionOkResponse`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GetPurchaseConsumptionOkResponse;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("CLIENT_ID").clientSecret("CLIENT_SECRET").build();

    Celitech celitech = new Celitech(config);

    GetPurchaseConsumptionOkResponse response = celitech.purchases.getPurchaseConsumption(
      "4973fa15-6979-4daa-9cf3-672620df819c"
    );

    System.out.println(response);
  }
}

```
