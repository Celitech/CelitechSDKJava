# HistoryService

A list of all methods in the `HistoryService` service. Click on the method name to view detailed information about that method.

| Methods                           | Description      |
| :-------------------------------- | :--------------- |
| [getESimHistory](#getesimhistory) | Get eSIM History |

## getESimHistory

Get eSIM History

- HTTP Method: `GET`
- Endpoint: `/esim/{iccid}/history`

**Parameters**

| Name              | Type                                                              | Required | Description               |
| :---------------- | :---------------------------------------------------------------- | :------- | :------------------------ |
| iccid             | String                                                            | ✅       |                           |
| requestParameters | [GetESimHistoryParameters](../models/GetESimHistoryParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GetESimHistoryParameters;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    GetESimHistoryParameters requestParameters = GetESimHistoryParameters.builder()
      .accept("application/json")
      .build();

    Object response = celitech.history.getESimHistory("iccid", requestParameters);

    System.out.println(response);
  }
}

```
