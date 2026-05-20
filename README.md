# Celitech Java SDK 1.3.63

Welcome to the Celitech SDK documentation. This guide will help you get started with integrating and using the Celitech SDK in your project.

## Versions

- API version: `1.3.63`
- SDK version: `1.3.63`
- Homepage: [https://docs.celitech.com/](https://docs.celitech.com/)

## About the API

Welcome to the CELITECH API documentation!

Useful links: [Homepage](https://www.celitech.com) | [Support email](mailto:support@celitech.com) | [Blog](https://www.celitech.com/blog/)

Contact Support:
Name: CELITECH
Email: support@celitech.com

## Table of Contents

- [Setup & Configuration](#setup--configuration)
  - [Supported Language Versions](#supported-language-versions)
  - [Installation](#installation)
- [Authentication](#authentication)
  - [OAuth Authentication](#oauth-authentication)
  - [Environment Variables](#environment-variables)
- [Setting a Custom Timeout](#setting-a-custom-timeout)
- [Sample Usage](#sample-usage)
- [Services](#services)
- [Models](#models)
- [License](#license)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `Java >= 1.8`

## Installation

If you use Maven, place the following within the _dependency_ tag in your `pom.xml` file:

```XML
<dependency>
    <groupId>io.github.celitech</groupId>
    <artifactId>celitech-sdk</artifactId>
    <version>1.3.63</version>
</dependency>
```

If you use Gradle, paste the next line inside the _dependencies_ block of your `build.gradle` file:

```Gradle
implementation("io.github.celitech:celitech-sdk:1.3.63")
```

If you use JAR files, package the SDK by running the following command:

```shell
mvn compile assembly:single
```

Then, add the JAR file to your project's classpath.

## Authentication

### OAuth Authentication

The Celitech API uses OAuth 2.0 for authentication.

You need to provide your OAuth credentials when initializing the SDK. Tokens are automatically fetched, cached, and refreshed — you do not need to manage them yourself.

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);
  }
}

```

If you need to set or update the OAuth credentials after the SDK initialization, you can use:

```java
celitech.setClientId("CLIENT_ID");
celitech.setClientSecret("CLIENT_SECRET");
```

## Environment Variables

These are the environment variables for the SDK:

| Name          | Description             |
| :------------ | :---------------------- |
| CLIENT_ID     | Client ID parameter     |
| CLIENT_SECRET | Client Secret parameter |

Environment variables are a way to configure your application outside the code. You can set these environment variables on the command line or use your project's existing tooling for managing environment variables.

If you are using a `.env` file, a template with the variable names is provided in the `.env.example` file located in the same directory as this README.

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().timeout(10000).build();
    Celitech celitech = new Celitech(config);
  }
}

```

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.exceptions.ApiError;
import io.github.celitech.celitechsdk.models.ListDestinationsParameters;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    ListDestinationsParameters requestParameters = ListDestinationsParameters.builder()
      .accept("application/json")
      .build();

    try {
      Object response = celitech.destinations.listDestinations(requestParameters);

      System.out.println(response);
    } catch (ApiError e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}

```

## Services

The SDK provides various services to interact with the API.

<details>
<summary>Below is a list of all available services with links to their detailed documentation:</summary>

| Name                                                                 |
| :------------------------------------------------------------------- |
| [DestinationsService](documentation/services/DestinationsService.md) |
| [PackagesService](documentation/services/PackagesService.md)         |
| [V2Service](documentation/services/V2Service.md)                     |
| [TopupService](documentation/services/TopupService.md)               |
| [EditService](documentation/services/EditService.md)                 |
| [ConsumptionService](documentation/services/ConsumptionService.md)   |
| [PurchasesService](documentation/services/PurchasesService.md)       |
| [DeviceService](documentation/services/DeviceService.md)             |
| [HistoryService](documentation/services/HistoryService.md)           |
| [EsimService](documentation/services/EsimService.md)                 |
| [TokenService](documentation/services/TokenService.md)               |

</details>

## Models

The SDK includes several models that represent the data structures used in API requests and responses. These models help in organizing and managing the data efficiently.

<details>
<summary>Below is a list of all available models with links to their detailed documentation:</summary>

| Name                                                                                         | Description |
| :------------------------------------------------------------------------------------------- | :---------- |
| [ListDestinationsParameters](documentation/models/ListDestinationsParameters.md)             |             |
| [ListPackagesParameters](documentation/models/ListPackagesParameters.md)                     |             |
| [CreatePurchaseV2Request](documentation/models/CreatePurchaseV2Request.md)                   |             |
| [CreatePurchaseV2Parameters](documentation/models/CreatePurchaseV2Parameters.md)             |             |
| [TopUpESimRequest](documentation/models/TopUpESimRequest.md)                                 |             |
| [TopUpESimParameters](documentation/models/TopUpESimParameters.md)                           |             |
| [EditPurchaseRequest](documentation/models/EditPurchaseRequest.md)                           |             |
| [EditPurchaseParameters](documentation/models/EditPurchaseParameters.md)                     |             |
| [GetPurchaseConsumptionParameters](documentation/models/GetPurchaseConsumptionParameters.md) |             |
| [CreatePurchaseRequest](documentation/models/CreatePurchaseRequest.md)                       |             |
| [CreatePurchaseParameters](documentation/models/CreatePurchaseParameters.md)                 |             |
| [ListPurchasesParameters](documentation/models/ListPurchasesParameters.md)                   |             |
| [GetESimDeviceParameters](documentation/models/GetESimDeviceParameters.md)                   |             |
| [GetESimHistoryParameters](documentation/models/GetESimHistoryParameters.md)                 |             |
| [GetESimParameters](documentation/models/GetESimParameters.md)                               |             |
| [GenerateTokenParameters](documentation/models/GenerateTokenParameters.md)                   |             |
| [GrantType](documentation/models/GrantType.md)                                               |             |

</details>

## License

This SDK is licensed under the MIT License.

See the [LICENSE](LICENSE) file for more details.
