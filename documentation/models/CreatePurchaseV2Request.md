# CreatePurchaseV2Request

**Properties**

| Name          | Type   | Required | Description                                                                                                                                                                                                                  |
| :------------ | :----- | :------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| destination   | String | ✅       | ISO representation of the package's destination                                                                                                                                                                              |
| dataLimitInGb | Double | ✅       | Size of the package in GB. The available options are 1, 2, 3, 5, 8, 20GB                                                                                                                                                     |
| startDate     | String | ✅       | Start date of the package's validity in the format 'yyyy-MM-dd'. This date can be set to the current day or any day within the next 12 months.                                                                               |
| endDate       | String | ✅       | End date of the package's validity in the format 'yyyy-MM-dd'. End date can be maximum 90 days after Start date.                                                                                                             |
| quantity      | Double | ✅       | Number of eSIMs to purchase.                                                                                                                                                                                                 |
| email         | String | ❌       | Email address where the purchase confirmation email will be sent (including QR Code & activation steps)                                                                                                                      |
| referenceId   | String | ❌       | An identifier provided by the partner to link this purchase to their booking or transaction for analytics and debugging purposes.                                                                                            |
| networkBrand  | String | ❌       | Customize the network brand of the issued eSIM. The `networkBrand` parameter cannot exceed 15 characters in length and must contain only letters and numbers. This feature is available to platforms with Diamond tier only. |
| emailBrand    | String | ❌       | Customize the email subject brand. The `emailBrand` parameter cannot exceed 25 characters in length and must contain only letters, numbers, and spaces. This feature is available to platforms with Diamond tier only.       |
