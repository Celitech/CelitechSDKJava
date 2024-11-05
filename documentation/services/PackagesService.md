# PackagesService

A list of all methods in the `PackagesService` service. Click on the method name to view detailed information about that method.

| Methods                       | Description   |
| :---------------------------- | :------------ |
| [listPackages](#listpackages) | List Packages |

## listPackages

List Packages

- HTTP Method: `GET`
- Endpoint: `/packages`

**Parameters**

| Name              | Type                                                          | Required | Description               |
| :---------------- | :------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListPackagesParameters](../models/ListPackagesParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ListPackagesOkResponse`

**Example Usage Code Snippet**

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.models.ListPackagesOkResponse;
import io.github.celitech.celitechsdk.models.ListPackagesParameters;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = new Celitech();

    ListPackagesOkResponse response = celitech.packagesService.listPackages();

    System.out.println(response);
  }
}

```
