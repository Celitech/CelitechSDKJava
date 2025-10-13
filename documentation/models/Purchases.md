# Purchases

**Properties**

| Name         | Type          | Required | Description                                                                                                                                                                                                    |
| :----------- | :------------ | :------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id           | String        | ✅       | ID of the purchase                                                                                                                                                                                             |
| startDate    | String        | ✅       | Start date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'                                                                                                                                     |
| endDate      | String        | ✅       | End date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'                                                                                                                                       |
| createdDate  | String        | ✅       | Creation date of the purchase in the format 'yyyy-MM-ddThh:mm:ssZZ'                                                                                                                                            |
| package\_    | Package\_     | ✅       |                                                                                                                                                                                                                |
| esim         | PurchasesEsim | ✅       |                                                                                                                                                                                                                |
| source       | String        | ✅       | The `source` indicates whether the purchase was made from the API, dashboard, landing-page, promo-page or iframe. For purchases made before September 8, 2023, the value will be displayed as 'Not available'. |
| purchaseType | String        | ✅       | The `purchaseType` indicates whether this is the initial purchase that creates the eSIM (First Purchase) or a subsequent top-up on an existing eSIM (Top-up Purchase).                                         |
| startTime    | Double        | ❌       | Epoch value representing the start time of the package's validity                                                                                                                                              |
| endTime      | Double        | ❌       | Epoch value representing the end time of the package's validity                                                                                                                                                |
| createdAt    | Double        | ❌       | Epoch value representing the date of creation of the purchase                                                                                                                                                  |
| referenceId  | String        | ❌       | The `referenceId` that was provided by the partner during the purchase or top-up flow. This identifier can be used for analytics and debugging purposes.                                                       |
