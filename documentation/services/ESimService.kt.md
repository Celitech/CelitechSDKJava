# ESimService

A list of all methods in the `ESimService` service. Click on the method name to view detailed information about that method.

| Methods                           | Description      |
| :-------------------------------- | :--------------- |
| [getEsim](#getesim)               | Get eSIM Status  |
| [getEsimDevice](#getesimdevice)   | Get eSIM Device  |
| [getEsimHistory](#getesimhistory) | Get eSIM History |
| [getEsimMac](#getesimmac)         | Get eSIM MAC     |

## getEsim

Get eSIM Status

- HTTP Method: `GET`
- Endpoint: `/esim`

**Parameters**

| Name              | Type                                                | Required | Description               |
| :---------------- | :-------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [GetEsimParameters](../models/GetEsimParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`GetEsimOkResponse`

**Example Usage Code Snippet**

```kotlin
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GetEsimOkResponse;
import io.github.celitech.celitechsdk.models.GetEsimParameters;

fun main() {
	val config: CelitechConfig = CelitechConfig.builder()
			.clientId("CLIENT_ID")
			.clientSecret("CLIENT_SECRET")
			.build();

    val celitech: Celitech = Celitech(config);

    val requestParameters: GetEsimParameters = GetEsimParameters.builder()
			.iccid("1111222233334444555000")
			.build();

    val response: GetEsimOkResponse = celitech.eSim.getEsim(requestParameters);

    println(response);
}
```

## getEsimDevice

Get eSIM Device

- HTTP Method: `GET`
- Endpoint: `/esim/{iccid}/device`

**Parameters**

| Name  | Type   | Required | Description    |
| :---- | :----- | :------- | :------------- |
| iccid | String | ✅       | ID of the eSIM |

**Return Type**

`GetEsimDeviceOkResponse`

**Example Usage Code Snippet**

```kotlin
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GetEsimDeviceOkResponse;

fun main() {
	val config: CelitechConfig = CelitechConfig.builder()
			.clientId("CLIENT_ID")
			.clientSecret("CLIENT_SECRET")
			.build();

    val celitech: Celitech = Celitech(config);

    val response: GetEsimDeviceOkResponse = celitech.eSim.getEsimDevice("1111222233334444555000");

    println(response);
}
```

## getEsimHistory

Get eSIM History

- HTTP Method: `GET`
- Endpoint: `/esim/{iccid}/history`

**Parameters**

| Name  | Type   | Required | Description    |
| :---- | :----- | :------- | :------------- |
| iccid | String | ✅       | ID of the eSIM |

**Return Type**

`GetEsimHistoryOkResponse`

**Example Usage Code Snippet**

```kotlin
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GetEsimHistoryOkResponse;

fun main() {
	val config: CelitechConfig = CelitechConfig.builder()
			.clientId("CLIENT_ID")
			.clientSecret("CLIENT_SECRET")
			.build();

    val celitech: Celitech = Celitech(config);

    val response: GetEsimHistoryOkResponse = celitech.eSim.getEsimHistory("1111222233334444555000");

    println(response);
}
```

## getEsimMac

Get eSIM MAC

- HTTP Method: `GET`
- Endpoint: `/esim/{iccid}/mac`

**Parameters**

| Name  | Type   | Required | Description    |
| :---- | :----- | :------- | :------------- |
| iccid | String | ✅       | ID of the eSIM |

**Return Type**

`GetEsimMacOkResponse`

**Example Usage Code Snippet**

```kotlin
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GetEsimMacOkResponse;

fun main() {
	val config: CelitechConfig = CelitechConfig.builder()
			.clientId("CLIENT_ID")
			.clientSecret("CLIENT_SECRET")
			.build();

    val celitech: Celitech = Celitech(config);

    val response: GetEsimMacOkResponse = celitech.eSim.getEsimMac("1111222233334444555000");

    println(response);
}
```
