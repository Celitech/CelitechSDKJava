# ESimService

A list of all methods in the `ESimService` service. Click on the method name to view detailed information about that method.

| Methods                           | Description                                                                                                                                                    |
| :-------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [getEsim](#getesim)               | Get eSIM                                                                                                                                                       |
| [getEsimDevice](#getesimdevice)   | Get eSIM Device                                                                                                                                                |
| [getEsimHistory](#getesimhistory) | Get eSIM History                                                                                                                                               |
| [suspendEsim](#suspendesim)       | Suspends an eSIM to prevent abuse. All of the eSIM's packages are terminated and its connectivity is switched off. The eSIM is not refunded: the charge stays. |

## getEsim

Get eSIM

- HTTP Method: `GET`
- Endpoint: `/esim`

**Parameters**

| Name              | Type                                                | Required | Description               |
| :---------------- | :-------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [GetEsimParameters](../models/GetEsimParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`GetEsimOkResponse`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GetEsimOkResponse;
import io.github.celitech.celitechsdk.models.GetEsimParameters;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    GetEsimParameters requestParameters = GetEsimParameters.builder()
      .iccid("1111222233334444555000")
      .build();

    GetEsimOkResponse response = celitech.eSim.getEsim(requestParameters);

    System.out.println(response);
  }
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

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GetEsimDeviceOkResponse;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    GetEsimDeviceOkResponse response = celitech.eSim.getEsimDevice("1111222233334444555000");

    System.out.println(response);
  }
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

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.GetEsimHistoryOkResponse;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    GetEsimHistoryOkResponse response = celitech.eSim.getEsimHistory("1111222233334444555000");

    System.out.println(response);
  }
}

```

## suspendEsim

Suspends an eSIM to prevent abuse. All of the eSIM's packages are terminated and its connectivity is switched off. The eSIM is not refunded: the charge stays.

- HTTP Method: `POST`
- Endpoint: `/esim/{iccid}/suspend`

**Parameters**

| Name              | Type                                                        | Required | Description               |
| :---------------- | :---------------------------------------------------------- | :------- | :------------------------ |
| iccid             | String                                                      | ✅       | ID of the eSIM            |
| requestParameters | [SuspendEsimParameters](../models/SuspendEsimParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`SuspendEsimOkResponse`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.SuspendEsimOkResponse;
import io.github.celitech.celitechsdk.models.SuspendEsimParameters;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    SuspendEsimOkResponse response = celitech.eSim.suspendEsim("1111222233334444555000");

    System.out.println(response);
  }
}

```
