# ListPurchasesParameters

**Properties**

| Name        | Type   | Required | Description                                                                                                                                                                                                         |
| :---------- | :----- | :------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| iccid       | String | ❌       | ID of the eSIM                                                                                                                                                                                                      |
| afterDate   | String | ❌       | Start date of the interval for filtering purchases in the format 'yyyy-MM-dd'                                                                                                                                       |
| beforeDate  | String | ❌       | End date of the interval for filtering purchases in the format 'yyyy-MM-dd'                                                                                                                                         |
| referenceId | String | ❌       | The referenceId that was provided by the partner during the purchase or topup flow.                                                                                                                                 |
| afterCursor | String | ❌       | To get the next batch of results, use this parameter. It tells the API where to start fetching data after the last item you received. It helps you avoid repeats and efficiently browse through large sets of data. |
| limit       | Double | ❌       | Maximum number of purchases to be returned in the response. The value must be greater than 0 and less than or equal to 100. If not provided, the default value is 20                                                |
| after       | Double | ❌       | Epoch value representing the start of the time interval for filtering purchases                                                                                                                                     |
| before      | Double | ❌       | Epoch value representing the end of the time interval for filtering purchases                                                                                                                                       |
