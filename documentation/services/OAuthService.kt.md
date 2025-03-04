# OAuthService

A list of all methods in the `OAuthService` service. Click on the method name to view detailed information about that method.

| Methods                           | Description                       |
| :-------------------------------- | :-------------------------------- |
| [getAccessToken](#getaccesstoken) | This endpoint was added by liblab |

## getAccessToken

This endpoint was added by liblab

- HTTP Method: `POST`
- Endpoint: `/oauth2/token`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| getAccessTokenRequest | [GetAccessTokenRequest](../models/GetAccessTokenRequest.md) | ✅       | Request Body |

**Return Type**

`GetAccessTokenOkResponse`

**Example Usage Code Snippet**

```kotlin
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GetAccessTokenOkResponse;
import io.github.celitech.celitechsdk.models.GetAccessTokenRequest;

fun main() {
	val config: CelitechConfig = CelitechConfig.builder()
			.clientId("CLIENT_ID")
			.clientSecret("CLIENT_SECRET")
			.build();

    val celitech: Celitech = Celitech(config);

    val getAccessTokenRequest: GetAccessTokenRequest = GetAccessTokenRequest.builder()
			.build();

    val response: GetAccessTokenOkResponse = celitech.oAuth.getAccessToken(getAccessTokenRequest);

    println(response);
}
```
