# TopUpEsimOkResponsePurchase

**Properties**

| Name        | Type           | Required | Description                                                                |
| :---------- | :------------- | :------- | :------------------------------------------------------------------------- |
| id          | String         | ✅       | ID of the purchase                                                         |
| packageId   | String         | ✅       | ID of the package                                                          |
| startDate   | OffsetDateTime | ✅       | Start date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ' |
| endDate     | OffsetDateTime | ✅       | End date of the package's validity in the format 'yyyy-MM-ddThh:mm:ssZZ'   |
| createdDate | OffsetDateTime | ✅       | Creation date of the purchase in the format 'yyyy-MM-ddThh:mm:ssZZ'        |
| startTime   | Double         | ❌       | Epoch value representing the start time of the package's validity          |
| endTime     | Double         | ❌       | Epoch value representing the end time of the package's validity            |
