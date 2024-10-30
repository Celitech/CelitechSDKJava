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
import net.celitech.celitech.Celitech;
import net.celitech.celitech.config.CelitechConfig;
import net.celitech.celitech.models.GetAccessTokenOkResponse;
import net.celitech.celitech.models.GetAccessTokenRequest;

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
