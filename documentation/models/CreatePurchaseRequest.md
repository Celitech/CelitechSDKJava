# CreatePurchaseRequest

**Properties**

| Name          | Type   | Required | Description                                                                                                                                                            |
| :------------ | :----- | :------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| destination   | String | ✅       | ISO representation of the package's destination                                                                                                                        |
| dataLimitInGb | Double | ✅       | Size of the package in GB. The available options are 1, 2, 3, 5, 8, 20GB                                                                                               |
| startDate     | String | ✅       | Start date of the package's validity in the format 'yyyy-MM-dd'. This date can be set to the current day or any day within the next 12 months.                         |
| endDate       | String | ✅       | End date of the package's validity in the format 'yyyy-MM-dd'. End date can be maximum 90 days after Start date.                                                       |
| email         | String | ❌       | Email address where the purchase confirmation email will be sent (including QR Code & activation steps)                                                                |
| referenceId   | String | ❌       | An identifier provided by the partner to link this purchase to their booking or transaction for analytics and debugging purposes.                                      |
| networkBrand  | String | ❌       | Customize the network brand of the issued eSIM. This parameter is accessible to platforms with Diamond tier and requires an alphanumeric string of up to 15 characters |
| startTime     | Double | ❌       | Epoch value representing the start time of the package's validity. This timestamp can be set to the current time or any time within the next 12 months.                |
| endTime       | Double | ❌       | Epoch value representing the end time of the package's validity. End time can be maximum 90 days after Start time.                                                     |
