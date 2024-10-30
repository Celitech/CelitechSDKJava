# Purchases

**Properties**

| Name        | Type          | Required | Description                                                                                                                                                                                                       |
| :---------- | :------------ | :------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id          | String        | ❌       | ID of the purchase                                                                                                                                                                                                |
| startDate   | String        | ❌       | Start date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'                                                                                                                                        |
| endDate     | String        | ❌       | End date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'                                                                                                                                          |
| createdDate | String        | ❌       | Creation date of the purchase in the format 'yyyy-MM-ddThh:mm:ssZZ'                                                                                                                                               |
| startTime   | Double        | ❌       | Epoch value representing the start time of the package's validity                                                                                                                                                 |
| endTime     | Double        | ❌       | Epoch value representing the end time of the package's validity                                                                                                                                                   |
| createdAt   | Double        | ❌       | Epoch value representing the date of creation of the purchase                                                                                                                                                     |
| package\_   | Package\_     | ❌       |                                                                                                                                                                                                                   |
| esim        | PurchasesEsim | ❌       |                                                                                                                                                                                                                   |
| source      | String        | ❌       | The source indicates where the eSIM was purchased, which can be from the API, dashboard, landing-page or promo-page. For purchases made before September 8, 2023, the value will be displayed as 'Not available'. |
| referenceId | String        | ❌       | The referenceId that was provided by the partner during the purchase or topup flow. This identifier can be used for analytics and debugging purposes.                                                             |
