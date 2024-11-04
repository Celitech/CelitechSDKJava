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
import io.github.Celitech.celitechsdk.Celitech;
import io.github.Celitech.celitechsdk.config.CelitechConfig;
import io.github.Celitech.celitechsdk.models.ListDestinationsOkResponse;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("client-id").clientSecret("client-secret").build();

    Celitech celitech = new Celitech(config);

    ListDestinationsOkResponse response = celitech.destinationsService.listDestinations();

    System.out.println(response);
  }
}

```
