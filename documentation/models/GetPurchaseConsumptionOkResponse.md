# GetPurchaseConsumptionOkResponse

**Properties**

| Name                      | Type   | Required | Description                                                                     |
| :------------------------ | :----- | :------- | :------------------------------------------------------------------------------ |
| dataUsageRemainingInBytes | Double | ✅       | Remaining balance of the package in bytes. Returns `-1` for unlimited packages. |
| dataUsageRemainingInGb    | Double | ✅       | Remaining balance of the package in GB. Returns `-1` for unlimited packages.    |
| status                    | String | ✅       | Status of the connectivity, possible values are 'ACTIVE' or 'NOT_ACTIVE'        |
