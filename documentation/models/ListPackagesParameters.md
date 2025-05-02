# ListPackagesParameters

**Properties**

| Name             | Type    | Required | Description                                                                                                                                                                                                         |
| :--------------- | :------ | :------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| destination      | String  | ❌       | ISO representation of the package's destination.                                                                                                                                                                    |
| startDate        | String  | ❌       | Start date of the package's validity in the format 'yyyy-MM-dd'. This date can be set to the current day or any day within the next 12 months.                                                                      |
| endDate          | String  | ❌       | End date of the package's validity in the format 'yyyy-MM-dd'. End date can be maximum 90 days after Start date.                                                                                                    |
| dataLimitInGb    | Double  | ❌       | Size of the package in GB. - **Limited Packages (1, 2, 3, 5, 8, 20GB)** - **Unlimited Packages (available for Region-3):** Use **-1** for unlimited.                                                                |
| includeUnlimited | Boolean | ❌       | A boolean flag to include the unlimited packages in the response. The flag is false by default.                                                                                                                     |
| afterCursor      | String  | ❌       | To get the next batch of results, use this parameter. It tells the API where to start fetching data after the last item you received. It helps you avoid repeats and efficiently browse through large sets of data. |
| limit            | Double  | ❌       | Maximum number of packages to be returned in the response. The value must be greater than 0 and less than or equal to 160. If not provided, the default value is 20                                                 |
| startTime        | Long    | ❌       | Epoch value representing the start time of the package's validity. This timestamp can be set to the current time or any time within the next 12 months                                                              |
| endTime          | Long    | ❌       | Epoch value representing the end time of the package's validity. End time can be maximum 90 days after Start time                                                                                                   |
| duration         | Double  | ❌       | Duration in seconds for the package's validity. If this parameter is present, it will override the startTime and endTime parameters. The maximum duration for a package's validity period is 90 days                |
