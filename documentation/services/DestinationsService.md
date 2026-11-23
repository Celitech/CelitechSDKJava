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

[`ListDestinationsResponse`](../models/ListDestinationsResponse.md)

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.resources.destinations.types.ListDestinationsResponse;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = Celitech.builder().token("ACCESS_TOKEN").build();

    ListDestinationsResponse response = celitech.destinations().listDestinations();

    System.out.println(response);
  }
}
```
