# DeviceService

A list of all methods in the `DeviceService` service. Click on the method name to view detailed information about that method.

| Methods                         | Description     |
| :------------------------------ | :-------------- |
| [getESimDevice](#getesimdevice) | Get eSIM Device |

## getESimDevice

Get eSIM Device

- HTTP Method: `GET`
- Endpoint: `/esim/{iccid}/device`

**Parameters**

| Name              | Type                                                            | Required | Description               |
| :---------------- | :-------------------------------------------------------------- | :------- | :------------------------ |
| iccid             | String                                                          | ✅       |                           |
| requestParameters | [GetESimDeviceParameters](../models/GetESimDeviceParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GetESimDeviceParameters;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    GetESimDeviceParameters requestParameters = GetESimDeviceParameters.builder()
      .accept("application/json")
      .build();

    Object response = celitech.device.getESimDevice("iccid", requestParameters);

    System.out.println(response);
  }
}

```
