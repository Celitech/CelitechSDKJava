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
import net.celitech.celitechsdk.Celitech;
import net.celitech.celitechsdk.config.CelitechConfig;
import net.celitech.celitechsdk.models.ListPackagesOkResponse;
import net.celitech.celitechsdk.models.ListPackagesParameters;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    ListPackagesParameters requestParameters = ListPackagesParameters.builder()
      .destination("FRA")
      .startDate("2023-11-01")
      .endDate("2023-11-20")
      .afterCursor(
        "Y3JlYXRlZEF0OjE1OTk0OTMwOTgsZGVzdGluYXRpb246QVVTLG1pbkRheXM6MCxkYXRhTGltaXRJbkJ5dGVzOjUzNjg3MDkxMjA"
      )
      .limit(20D)
      .build();

    ListPackagesOkResponse response = celitech.packages.listPackages(requestParameters);

    System.out.println(response);
  }
}

```
