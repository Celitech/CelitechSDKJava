# CreatePurchaseV2ResponseItem

**Properties**

| Name     | Type                                                                          | Required | Description |
| :------- | :---------------------------------------------------------------------------- | :------- | :---------- |
| purchase | [CreatePurchaseV2ResponseItemPurchase](#createpurchasev2responseitempurchase) | ✅        |             |
| profile  | [CreatePurchaseV2ResponseItemProfile](#createpurchasev2responseitemprofile)   | ✅        |             |

# CreatePurchaseV2ResponseItemPurchase

**Properties**

| Name        | Type           | Required | Description                                                         |
| :---------- | :------------- | :------- | :------------------------------------------------------------------ |
| id          | String         | ✅        | ID of the purchase                                                  |
| packageId   | String         | ✅        | ID of the package                                                   |
| createdDate | OffsetDateTime | ✅        | Creation date of the purchase in the format 'yyyy-MM-ddThh:mm:ssZZ' |

# CreatePurchaseV2ResponseItemProfile

**Properties**

| Name                  | Type   | Required | Description                         |
| :-------------------- | :----- | :------- | :---------------------------------- |
| iccid                 | String | ✅        | ID of the eSIM                      |
| activationCode        | String | ✅        | QR Code of the eSIM as base64       |
| manualActivationCode  | String | ✅        | Manual Activation Code of the eSIM  |
| iosActivationLink     | String | ✅        | iOS Activation Link of the eSIM     |
| androidActivationLink | String | ✅        | Android Activation Link of the eSIM |
