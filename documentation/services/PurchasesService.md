# PurchasesService

A list of all methods in the `PurchasesService` service. Click on the method name to view detailed information about that method.

| Methods                                           | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| :------------------------------------------------ | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [createPurchaseV2](#createpurchasev2)             | This endpoint is used to purchase a new eSIM by providing the package details.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [listPurchases](#listpurchases)                   | This endpoint can be used to list all the successful purchases made between a given interval.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| [createPurchase](#createpurchase)                 | This endpoint is used to purchase a new eSIM by providing the package details.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [topUpEsim](#topupesim)                           | This endpoint is used to top-up an existing eSIM with the previously associated destination by providing its ICCID and package details. To determine if an eSIM can be topped up, use the Get eSIM endpoint, which returns the `isTopUpAllowed` flag.                                                                                                                                                                                                                                                                                                                                                                                                    |
| [editPurchase](#editpurchase)                     | This endpoint allows you to modify the validity dates of an existing purchase. **Behavior:** - If the purchase has **not yet been activated**, both the start and end dates can be updated. - If the purchase is **already active**, only the **end date** can be updated, while the **start date must remain unchanged** (and should be passed as originally set). - Updates must comply with the same pricing structure; the modification cannot alter the package size or change its duration category. The end date can be extended or shortened as long as it adheres to the same pricing category and does not exceed the allowed duration limits. |
| [getPurchaseConsumption](#getpurchaseconsumption) | This endpoint can be called for consumption notifications (e.g. every 1 hour or when the user clicks a button). It returns the data balance (consumption) of purchased packages.                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |

## createPurchaseV2

This endpoint is used to purchase a new eSIM by providing the package details.

- HTTP Method: `POST`
- Endpoint: `/purchases/v2`

**Parameters**

| Name           | Type                                                                                                    | Required | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| :------------- | :------------------------------------------------------------------------------------------------------ | :------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| destination    | String                                                                                                  | ✅        | ISO representation of the package's destination. Supports both ISO2 (e.g., 'FR') and ISO3 (e.g., 'FRA') country codes.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| dataLimitInGb  | Double                                                                                                  | ✅        | Size of the package in GB. The available options are 0.5, 1, 2, 3, 5, 8, 20, 50GB. Use `-1` to purchase an unlimited (date-based) package — provide `startDate`/`endDate` spanning 3 to 30 days (`duration` is not supported for unlimited packages).                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| startDate      | String                                                                                                  | ❌        | Start date of the package's validity in the format 'yyyy-MM-dd'. This date can be set to the current day or any day within the next 12 months.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| endDate        | String                                                                                                  | ❌        | End date of the package's validity in the format 'yyyy-MM-dd'. End date can be maximum 90 days after Start date.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| duration       | Double                                                                                                  | ❌        | Duration of the package in days. Available values are 1, 2, 7, 14, 30, or 90. Either provide startDate/endDate or duration. Not supported for unlimited packages (`dataLimitInGB` = -1), which are date-based — provide startDate/endDate instead.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| quantity       | Double                                                                                                  | ✅        | Number of eSIMs to purchase.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| email          | String                                                                                                  | ❌        | Email address where the purchase confirmation email will be sent (including QR Code & activation steps)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| referenceId    | String                                                                                                  | ❌        | An identifier provided by the partner to link this purchase to their booking or transaction for analytics and debugging purposes. Letters, digits, `-`, `_`, `.`, `@` and `+` are allowed (so an email address works), up to 255 characters.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| networkBrand   | String                                                                                                  | ❌        | Customize the network brand of the issued eSIM. The `networkBrand` parameter cannot exceed 15 characters in length and must contain only letters, numbers, dots (.), ampersands (&), and spaces. This feature is available to platforms with Diamond tier only.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| emailBrand     | String                                                                                                  | ❌        | Customize the email subject brand. The `emailBrand` parameter cannot exceed 25 characters in length and must contain only letters, numbers, and spaces. This feature is available to platforms with Diamond tier only.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| language       | [CreatePurchaseV2RequestLanguage](../models/CreatePurchaseV2Request.md#createpurchasev2requestlanguage) | ❌        | Language of the confirmation email sent to the customer.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| idempotencyKey | String                                                                                                  | ❌        | Optional. A unique value (for example a UUID) that makes this request safe to retry. If a request with the same `Idempotency-Key` and the same body succeeds, repeating it returns the original response instead of performing the action again, and the response includes the header `Idempotent-Replayed: true`. Keys are scoped to your credentials and remembered for 3 days. Only successful (2xx) responses are remembered, so a request that failed can be retried with the same key. Reusing a key with a different request returns `422`; sending it while the original request is still being processed returns `409`. If the idempotency store is temporarily unavailable, the request is not processed and returns `503`; retry it. Must be 1 to 255 printable ASCII characters, without spaces. |

**Return Type**

[`List<CreatePurchaseV2ResponseItem>`](../models/CreatePurchaseV2ResponseItem.md)

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.resources.purchases.requests.CreatePurchaseV2Request;
import io.github.celitech.celitechsdk.resources.purchases.types.CreatePurchaseV2ResponseItem;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = Celitech.builder().token("ACCESS_TOKEN").build();

    CreatePurchaseV2Request createPurchaseV2Request = CreatePurchaseV2Request.builder()
      .destination("FRA")
      .dataLimitInGb(1)
      .quantity(1)
      .build();

    List<CreatePurchaseV2ResponseItem> response = celitech.purchases().createPurchaseV2(createPurchaseV2Request);

    System.out.println(response);
  }
}
```

## listPurchases

This endpoint can be used to list all the successful purchases made between a given interval.

- HTTP Method: `GET`
- Endpoint: `/purchases`

**Parameters**

| Name        | Type   | Required | Description                                                                                                                                                                                                         |
| :---------- | :----- | :------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| purchaseId  | String | ❌        | ID of the purchase                                                                                                                                                                                                  |
| iccid       | String | ❌        | ID of the eSIM                                                                                                                                                                                                      |
| afterDate   | String | ❌        | Start date of the interval for filtering purchases in the format 'yyyy-MM-dd'                                                                                                                                       |
| beforeDate  | String | ❌        | End date of the interval for filtering purchases in the format 'yyyy-MM-dd'                                                                                                                                         |
| email       | String | ❌        | Email associated to the purchase.                                                                                                                                                                                   |
| referenceId | String | ❌        | The referenceId that was provided by the partner during the purchase or topup flow.                                                                                                                                 |
| afterCursor | String | ❌        | To get the next batch of results, use this parameter. It tells the API where to start fetching data after the last item you received. It helps you avoid repeats and efficiently browse through large sets of data. |
| limit       | Double | ❌        | Maximum number of purchases to be returned in the response. The value must be greater than 0 and less than or equal to 100. If not provided, the default value is 20                                                |
| after       | Double | ❌        | Epoch value representing the start of the time interval for filtering purchases                                                                                                                                     |
| before      | Double | ❌        | Epoch value representing the end of the time interval for filtering purchases                                                                                                                                       |

**Return Type**

[`ListPurchasesResponse`](../models/ListPurchasesResponse.md)

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.resources.purchases.types.ListPurchasesResponse;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = Celitech.builder().token("ACCESS_TOKEN").build();

    ListPurchasesResponse response = celitech.purchases().listPurchases();

    System.out.println(response);
  }
}
```

## createPurchase

This endpoint is used to purchase a new eSIM by providing the package details.

- HTTP Method: `POST`
- Endpoint: `/purchases`

**Parameters**

| Name           | Type                                                                                              | Required | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| :------------- | :------------------------------------------------------------------------------------------------ | :------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| destination    | String                                                                                            | ✅        | ISO representation of the package's destination. Supports both ISO2 (e.g., 'FR') and ISO3 (e.g., 'FRA') country codes.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| dataLimitInGb  | Double                                                                                            | ✅        | Size of the package in GB. The available options are 0.5, 1, 2, 3, 5, 8, 20, 50GB. Use `-1` to purchase an unlimited (date-based) package — provide `startDate`/`endDate` spanning 3 to 30 days.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| startDate      | String                                                                                            | ✅        | Start date of the package's validity in the format 'yyyy-MM-dd'. This date can be set to the current day or any day within the next 12 months.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| endDate        | String                                                                                            | ✅        | End date of the package's validity in the format 'yyyy-MM-dd'. End date can be maximum 90 days after Start date.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| email          | String                                                                                            | ❌        | Email address where the purchase confirmation email will be sent (including QR Code & activation steps)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| referenceId    | String                                                                                            | ❌        | An identifier provided by the partner to link this purchase to their booking or transaction for analytics and debugging purposes. Letters, digits, `-`, `_`, `.`, `@` and `+` are allowed (so an email address works), up to 255 characters.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| networkBrand   | String                                                                                            | ❌        | Customize the network brand of the issued eSIM. The `networkBrand` parameter cannot exceed 15 characters in length and must contain only letters, numbers, dots (.), ampersands (&), and spaces. This feature is available to platforms with Diamond tier only.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| emailBrand     | String                                                                                            | ❌        | Customize the email subject brand. The `emailBrand` parameter cannot exceed 25 characters in length and must contain only letters, numbers, and spaces. This feature is available to platforms with Diamond tier only.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| language       | [CreatePurchaseRequestLanguage](../models/CreatePurchaseRequest.md#createpurchaserequestlanguage) | ❌        | Language of the confirmation email sent to the customer.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| startTime      | Double                                                                                            | ❌        | Epoch value representing the start time of the package's validity. This timestamp can be set to the current time or any time within the next 12 months.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| endTime        | Double                                                                                            | ❌        | Epoch value representing the end time of the package's validity. End time can be maximum 90 days after Start time.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| idempotencyKey | String                                                                                            | ❌        | Optional. A unique value (for example a UUID) that makes this request safe to retry. If a request with the same `Idempotency-Key` and the same body succeeds, repeating it returns the original response instead of performing the action again, and the response includes the header `Idempotent-Replayed: true`. Keys are scoped to your credentials and remembered for 3 days. Only successful (2xx) responses are remembered, so a request that failed can be retried with the same key. Reusing a key with a different request returns `422`; sending it while the original request is still being processed returns `409`. If the idempotency store is temporarily unavailable, the request is not processed and returns `503`; retry it. Must be 1 to 255 printable ASCII characters, without spaces. |

**Return Type**

[`CreatePurchaseResponse`](../models/CreatePurchaseResponse.md)

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.resources.purchases.requests.CreatePurchaseRequest;
import io.github.celitech.celitechsdk.resources.purchases.types.CreatePurchaseResponse;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = Celitech.builder().token("ACCESS_TOKEN").build();

    CreatePurchaseRequest createPurchaseRequest = CreatePurchaseRequest.builder()
      .destination("FRA")
      .dataLimitInGb(1)
      .startDate("2023-11-01")
      .endDate("2023-11-20")
      .build();

    CreatePurchaseResponse response = celitech.purchases().createPurchase(createPurchaseRequest);

    System.out.println(response);
  }
}
```

## topUpEsim

This endpoint is used to top-up an existing eSIM with the previously associated destination by providing its ICCID and package details. To determine if an eSIM can be topped up, use the Get eSIM endpoint, which returns the `isTopUpAllowed` flag.

- HTTP Method: `POST`
- Endpoint: `/purchases/topup`

**Parameters**

| Name           | Type   | Required | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| :------------- | :----- | :------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| iccid          | String | ✅        | ID of the eSIM                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| dataLimitInGb  | Double | ✅        | Size of the package in GB. The available options are 0.5, 1, 2, 3, 5, 8, 20, 50GB. Use `-1` to top up with an unlimited (date-based) package — provide `startDate`/`endDate` spanning 3 to 30 days (`duration` is not supported for unlimited packages).                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| startDate      | String | ❌        | Start date of the package's validity in the format 'yyyy-MM-dd'. This date can be set to the current day or any day within the next 12 months.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| endDate        | String | ❌        | End date of the package's validity in the format 'yyyy-MM-dd'. End date can be maximum 90 days after Start date.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| duration       | Double | ❌        | Duration of the package in days. Available values are 1, 2, 7, 14, 30, or 90. Either provide startDate/endDate or duration. Not supported for unlimited packages (`dataLimitInGB` = -1), which are date-based — provide startDate/endDate instead.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| email          | String | ❌        | Email address where the purchase confirmation email will be sent (excluding QR Code & activation steps).                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| referenceId    | String | ❌        | An identifier provided by the partner to link this purchase to their booking or transaction for analytics and debugging purposes. Letters, digits, `-`, `_`, `.`, `@` and `+` are allowed (so an email address works), up to 255 characters.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| emailBrand     | String | ❌        | Customize the email subject brand. The `emailBrand` parameter cannot exceed 25 characters in length and must contain only letters, numbers, and spaces. This feature is available to platforms with Diamond tier only.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| startTime      | Double | ❌        | Epoch value representing the start time of the package's validity. This timestamp can be set to the current time or any time within the next 12 months.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| endTime        | Double | ❌        | Epoch value representing the end time of the package's validity. End time can be maximum 90 days after Start time.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| idempotencyKey | String | ❌        | Optional. A unique value (for example a UUID) that makes this request safe to retry. If a request with the same `Idempotency-Key` and the same body succeeds, repeating it returns the original response instead of performing the action again, and the response includes the header `Idempotent-Replayed: true`. Keys are scoped to your credentials and remembered for 3 days. Only successful (2xx) responses are remembered, so a request that failed can be retried with the same key. Reusing a key with a different request returns `422`; sending it while the original request is still being processed returns `409`. If the idempotency store is temporarily unavailable, the request is not processed and returns `503`; retry it. Must be 1 to 255 printable ASCII characters, without spaces. |

**Return Type**

[`TopUpEsimResponse`](../models/TopUpEsimResponse.md)

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.resources.purchases.requests.TopUpEsimRequest;
import io.github.celitech.celitechsdk.resources.purchases.types.TopUpEsimResponse;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = Celitech.builder().token("ACCESS_TOKEN").build();

    TopUpEsimRequest topUpEsimRequest = TopUpEsimRequest.builder()
      .iccid("1111222233334444555000")
      .dataLimitInGb(1)
      .build();

    TopUpEsimResponse response = celitech.purchases().topUpEsim(topUpEsimRequest);

    System.out.println(response);
  }
}
```

## editPurchase

This endpoint allows you to modify the validity dates of an existing purchase.  

**Behavior:**
- If the purchase has **not yet been activated**, both the start and end dates can be updated.  
- If the purchase is **already active**, only the **end date** can be updated, while the **start date must remain unchanged** (and should be passed as originally set).  
- Updates must comply with the same pricing structure; the modification cannot alter the package size or change its duration category.  

The end date can be extended or shortened as long as it adheres to the same pricing category and does not exceed the allowed duration limits.

- HTTP Method: `POST`
- Endpoint: `/purchases/edit`

**Parameters**

| Name           | Type   | Required | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| :------------- | :----- | :------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| purchaseId     | String | ✅        | ID of the purchase                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| startDate      | String | ✅        | Start date of the package's validity in the format 'yyyy-MM-dd'. This date can be set to the current day or any day within the next 12 months.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| endDate        | String | ✅        | End date of the package's validity in the format 'yyyy-MM-dd'. End date can be maximum 90 days after Start date.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| startTime      | Double | ❌        | Epoch value representing the start time of the package's validity. This timestamp can be set to the current time or any time within the next 12 months.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| endTime        | Double | ❌        | Epoch value representing the end time of the package's validity. End time can be maximum 90 days after Start time.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| idempotencyKey | String | ❌        | Optional. A unique value (for example a UUID) that makes this request safe to retry. If a request with the same `Idempotency-Key` and the same body succeeds, repeating it returns the original response instead of performing the action again, and the response includes the header `Idempotent-Replayed: true`. Keys are scoped to your credentials and remembered for 3 days. Only successful (2xx) responses are remembered, so a request that failed can be retried with the same key. Reusing a key with a different request returns `422`; sending it while the original request is still being processed returns `409`. If the idempotency store is temporarily unavailable, the request is not processed and returns `503`; retry it. Must be 1 to 255 printable ASCII characters, without spaces. |

**Return Type**

[`EditPurchaseResponse`](../models/EditPurchaseResponse.md)

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.resources.purchases.requests.EditPurchaseRequest;
import io.github.celitech.celitechsdk.resources.purchases.types.EditPurchaseResponse;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = Celitech.builder().token("ACCESS_TOKEN").build();

    EditPurchaseRequest editPurchaseRequest = EditPurchaseRequest.builder()
      .purchaseId("ae471106-c8b4-42cf-b83a-b061291f2922")
      .startDate("2023-11-01")
      .endDate("2023-11-20")
      .build();

    EditPurchaseResponse response = celitech.purchases().editPurchase(editPurchaseRequest);

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
| purchaseId | String | ✅        | ID of the purchase |

**Return Type**

[`GetPurchaseConsumptionResponse`](../models/GetPurchaseConsumptionResponse.md)

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.resources.purchases.types.GetPurchaseConsumptionResponse;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = Celitech.builder().token("ACCESS_TOKEN").build();

    GetPurchaseConsumptionResponse response = celitech.purchases().getPurchaseConsumption("4973fa15-6979-4daa-9cf3-672620df819c");

    System.out.println(response);
  }
}
```
