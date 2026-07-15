# Package\_

**Properties**

| Name             | Type   | Required | Description                                                                             |
| :--------------- | :----- | :------- | :-------------------------------------------------------------------------------------- |
| id               | String | ✅       | ID of the package                                                                       |
| dataLimitInBytes | Double | ✅       | Size of the package in Bytes. A value of `-1` indicates an unlimited package.           |
| dataLimitInGb    | Double | ✅       | Size of the package in GB. A value of `-1` indicates an unlimited (date-based) package. |
| destination      | String | ✅       | ISO3 representation of the package's destination.                                       |
| destinationIso2  | String | ✅       | ISO2 representation of the package's destination.                                       |
| destinationName  | String | ✅       | Name of the package's destination                                                       |
| priceInCents     | Double | ✅       | Price of the package in cents                                                           |
