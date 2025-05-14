# Package\_

**Properties**

| Name             | Type   | Required | Description                                                                                                                                                                 |
| :--------------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id               | String | ❌       | ID of the package                                                                                                                                                           |
| dataLimitInBytes | Double | ❌       | Size of the package in bytes. For **limited packages**, this field will return the data limit in bytes. For **unlimited packages**, it will return **-1** as an identifier. |
| destination      | String | ❌       | ISO representation of the package's destination.                                                                                                                            |
| destinationName  | String | ❌       | Name of the package's destination                                                                                                                                           |
| priceInCents     | Double | ❌       | Price of the package in cents                                                                                                                                               |
