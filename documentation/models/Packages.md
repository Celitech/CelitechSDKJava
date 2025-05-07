# Packages

**Properties**

| Name             | Type   | Required | Description                                                                                                                                                                 |
| :--------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id               | String | ❌       | ID of the package                                                                                                                                                           |
| destination      | String | ❌       | ISO representation of the package's destination.                                                                                                                            |
| dataLimitInBytes | Double | ❌       | Size of the package in bytes. For **limited packages**, this field will return the data limit in bytes. For **unlimited packages**, it will return **-1** as an identifier. |
| minDays          | Double | ❌       | Min number of days for the package                                                                                                                                          |
| maxDays          | Double | ❌       | Max number of days for the package                                                                                                                                          |
| priceInCents     | Double | ❌       | Price of the package in cents                                                                                                                                               |
