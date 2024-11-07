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

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GetAccessTokenOkResponse;
import io.github.celitech.celitechsdk.models.GetAccessTokenRequest;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("client-id").clientSecret("client-secret").build();

    Celitech celitech = new Celitech(config);

    GetAccessTokenRequest getAccessTokenRequest = GetAccessTokenRequest.builder().build();

    GetAccessTokenOkResponse response = celitech.oAuthService.getAccessToken(getAccessTokenRequest);

    System.out.println(response);
  }
}

```