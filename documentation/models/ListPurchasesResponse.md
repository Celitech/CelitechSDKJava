# ListPurchasesResponse

**Properties**

| Name        | Type                                                                            | Required | Description                                                                                                                                                                                                                                                                                     |
| :---------- | :------------------------------------------------------------------------------ | :------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| purchases   | [List<ListPurchasesResponsePurchasesItem>](#listpurchasesresponsepurchasesitem) | ✅        |                                                                                                                                                                                                                                                                                                 |
| afterCursor | String                                                                          | ✅        | The cursor value representing the end of the current page of results. Use this cursor value as the "afterCursor" parameter in your next request to retrieve the subsequent page of results. It ensures that you continue fetching data from where you left off, facilitating smooth pagination. |

# ListPurchasesResponsePurchasesItem

**Properties**

| Name         | Type                                                                                    | Required | Description                                                                                                                                                                                                    |
| :----------- | :-------------------------------------------------------------------------------------- | :------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id           | String                                                                                  | ✅        | ID of the purchase                                                                                                                                                                                             |
| startDate    | OffsetDateTime                                                                          | ✅        | Start date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'                                                                                                                                     |
| endDate      | OffsetDateTime                                                                          | ✅        | End date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'                                                                                                                                       |
| duration     | Double                                                                                  | ❌        | Duration of the package in days. Possible values are 1, 2, 7, 14, 30, or 90. `null` for unlimited (date-based) packages.                                                                                       |
| createdDate  | OffsetDateTime                                                                          | ✅        | Creation date of the purchase in the format 'yyyy-MM-ddThh:mm:ssZZ'                                                                                                                                            |
| startTime    | Double                                                                                  | ❌        | Epoch value representing the start time of the package's validity                                                                                                                                              |
| endTime      | Double                                                                                  | ❌        | Epoch value representing the end time of the package's validity                                                                                                                                                |
| createdAt    | Double                                                                                  | ❌        | Epoch value representing the date of creation of the purchase                                                                                                                                                  |
| package      | [ListPurchasesResponsePurchasesItemPackage](#listpurchasesresponsepurchasesitempackage) | ✅        |                                                                                                                                                                                                                |
| esim         | [ListPurchasesResponsePurchasesItemEsim](#listpurchasesresponsepurchasesitemesim)       | ✅        |                                                                                                                                                                                                                |
| source       | String                                                                                  | ✅        | The `source` indicates whether the purchase was made from the API, dashboard, landing-page, promo-page or iframe. For purchases made before September 8, 2023, the value will be displayed as 'Not available'. |
| purchaseType | String                                                                                  | ✅        | The `purchaseType` indicates whether this is the initial purchase that creates the eSIM (First Purchase) or a subsequent top-up on an existing eSIM (Top-up Purchase).                                         |
| referenceId  | String                                                                                  | ❌        | The `referenceId` that was provided by the partner during the purchase or top-up flow. This identifier can be used for analytics and debugging purposes.                                                       |

# ListPurchasesResponsePurchasesItemPackage

**Properties**

| Name             | Type   | Required | Description                                                                             |
| :--------------- | :----- | :------- | :-------------------------------------------------------------------------------------- |
| id               | String | ✅        | ID of the package                                                                       |
| dataLimitInBytes | Double | ✅        | Size of the package in Bytes. A value of `-1` indicates an unlimited package.           |
| dataLimitInGb    | Double | ✅        | Size of the package in GB. A value of `-1` indicates an unlimited (date-based) package. |
| destination      | String | ✅        | ISO3 representation of the package's destination.                                       |
| destinationIso2  | String | ✅        | ISO2 representation of the package's destination.                                       |
| destinationName  | String | ✅        | Name of the package's destination                                                       |
| priceInCents     | Double | ✅        | Price of the package in cents                                                           |

# ListPurchasesResponsePurchasesItemEsim

**Properties**

| Name  | Type   | Required | Description    |
| :---- | :----- | :------- | :------------- |
| iccid | String | ✅        | ID of the eSIM |
