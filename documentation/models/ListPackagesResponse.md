# ListPackagesResponse

**Properties**

| Name        | Type                                                                        | Required | Description                                                                                                                                                                                                                                                                                    |
| :---------- | :-------------------------------------------------------------------------- | :------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| packages    | [List<ListPackagesResponsePackagesItem>](#listpackagesresponsepackagesitem) | ✅        |                                                                                                                                                                                                                                                                                                |
| afterCursor | String                                                                      | ✅        | The cursor value representing the end of the current page of results. Use this cursor value as the "afterCursor" parameter in your next request to retrieve the subsequent page of results. It ensures that you continue fetching data from where you left off, facilitating smooth pagination |

# ListPackagesResponsePackagesItem

**Properties**

| Name             | Type   | Required | Description                                                                             |
| :--------------- | :----- | :------- | :-------------------------------------------------------------------------------------- |
| id               | String | ✅        | ID of the package                                                                       |
| destination      | String | ✅        | ISO3 representation of the package's destination.                                       |
| destinationIso2  | String | ✅        | ISO2 representation of the package's destination.                                       |
| dataLimitInBytes | Double | ✅        | Size of the package in Bytes. A value of `-1` indicates an unlimited package.           |
| dataLimitInGb    | Double | ✅        | Size of the package in GB. A value of `-1` indicates an unlimited (date-based) package. |
| minDays          | Double | ✅        | Min number of days for the package                                                      |
| maxDays          | Double | ✅        | Max number of days for the package                                                      |
| priceInCents     | Double | ✅        | Price of the package in cents                                                           |
