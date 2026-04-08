# DestinationsService

A list of all methods in the `DestinationsService` service. Click on the method name to view detailed information about that method.

| Methods                               | Description       |
| :------------------------------------ | :---------------- |
| [listDestinations](#listdestinations) | List Destinations |

## listDestinations

List Destinations

- HTTP Method: `GET`
- Endpoint: `/destinations`

**Return Type**

`ListDestinationsOkResponse`

**Example Usage Code Snippet**

```java
import net.celitech.celitechsdk.Celitech;
import net.celitech.celitechsdk.config.CelitechConfig;
import net.celitech.celitechsdk.models.ListDestinationsOkResponse;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    ListDestinationsOkResponse response = celitech.destinations.listDestinations();

    System.out.println(response);
  }
}

```
