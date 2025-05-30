# GetPurchaseConsumptionOkResponse

**Properties**

| Name                      | Type   | Required | Description                                                                                                                                                                               |
| :------------------------ | :----- | :------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| dataUsageRemainingInBytes | Double | ❌       | Remaining balance of the package in byte. For **limited packages**, this field indicates the remaining data in bytes. For **unlimited packages**, it will return **-1** as an identifier. |
| status                    | String | ❌       | Status of the connectivity, possible values are 'ACTIVE' or 'NOT_ACTIVE'                                                                                                                  |
