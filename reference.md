# Reference

## Destinations

<details><summary><code>client.destinations.listDestinations() -> ListDestinationsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List Destinations

</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.destinations().listDestinations();
```

</dd>
</dl>
</dd>
</dl>

</dd>
</dl>
</details>

## Packages

<details><summary><code>client.packages.listPackages(requestParameters) -> ListPackagesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List Packages

</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.packages().listPackages(requestParameters);
```

</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**requestParameters:** `ListPackagesRequest` — _optional_ Request Parameters Object

</dd>
</dl>
</dd>
</dl>

</dd>
</dl>
</details>

## Purchases

<details><summary><code>client.purchases.createPurchaseV2(requestParameters) -> List&lt;CreatePurchaseV2ResponseItem&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint is used to purchase a new eSIM by providing the package details.

</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.purchases().createPurchaseV2(requestParameters);
```

</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**requestParameters:** `CreatePurchaseV2Request` — Request Parameters Object

</dd>
</dl>
</dd>
</dl>

</dd>
</dl>
</details>

<details><summary><code>client.purchases.listPurchases(requestParameters) -> ListPurchasesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint can be used to list all the successful purchases made between a given interval.

</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.purchases().listPurchases(requestParameters);
```

</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**requestParameters:** `ListPurchasesRequest` — _optional_ Request Parameters Object

</dd>
</dl>
</dd>
</dl>

</dd>
</dl>
</details>

<details><summary><code>client.purchases.createPurchase(requestParameters) -> CreatePurchaseResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

**Deprecated.** This endpoint is used to purchase a new eSIM by providing the package details.

</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.purchases().createPurchase(requestParameters);
```

</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**requestParameters:** `CreatePurchaseRequest` — Request Parameters Object

</dd>
</dl>
</dd>
</dl>

</dd>
</dl>
</details>

<details><summary><code>client.purchases.topUpEsim(requestParameters) -> TopUpEsimResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint is used to top-up an existing eSIM with the previously associated destination by providing its ICCID and package details. To determine if an eSIM can be topped up, use the Get eSIM endpoint, which returns the `isTopUpAllowed` flag.

</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.purchases().topUpEsim(requestParameters);
```

</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**requestParameters:** `TopUpEsimRequest` — Request Parameters Object

</dd>
</dl>
</dd>
</dl>

</dd>
</dl>
</details>

<details><summary><code>client.purchases.editPurchase(requestParameters) -> EditPurchaseResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint allows you to modify the validity dates of an existing purchase. **Behavior:** - If the purchase has **not yet been activated**, both the start and end dates can be updated. - If the purchase is **already active**, only the **end date** can be updated, while the **start date must remain unchanged** (and should be passed as originally set). - Updates must comply with the same pricing structure; the modification cannot alter the package size or change its duration category. The end date can be extended or shortened as long as it adheres to the same pricing category and does not exceed the allowed duration limits.

</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.purchases().editPurchase(requestParameters);
```

</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**requestParameters:** `EditPurchaseRequest` — Request Parameters Object

</dd>
</dl>
</dd>
</dl>

</dd>
</dl>
</details>

<details><summary><code>client.purchases.getPurchaseConsumption(purchaseId, requestParameters) -> GetPurchaseConsumptionResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint can be called for consumption notifications (e.g. every 1 hour or when the user clicks a button). It returns the data balance (consumption) of purchased packages.

</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.purchases().getPurchaseConsumption(
    purchaseId,
    requestParameters
);
```

</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**purchaseId:** `String` — ID of the purchase

</dd>
</dl>

<dl>
<dd>

**requestParameters:** `GetPurchaseConsumptionRequest` — _optional_ Request Parameters Object

</dd>
</dl>
</dd>
</dl>

</dd>
</dl>
</details>

## ESim

<details><summary><code>client.eSim.getEsim(requestParameters) -> GetEsimResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get eSIM

</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.eSim().getEsim(requestParameters);
```

</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**requestParameters:** `GetEsimRequest` — Request Parameters Object

</dd>
</dl>
</dd>
</dl>

</dd>
</dl>
</details>

<details><summary><code>client.eSim.getEsimDevice(iccid, requestParameters) -> GetEsimDeviceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get eSIM Device

</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.eSim().getEsimDevice(
    iccid,
    requestParameters
);
```

</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**iccid:** `String` — ID of the eSIM

</dd>
</dl>

<dl>
<dd>

**requestParameters:** `GetEsimDeviceRequest` — _optional_ Request Parameters Object

</dd>
</dl>
</dd>
</dl>

</dd>
</dl>
</details>

<details><summary><code>client.eSim.getEsimHistory(iccid, requestParameters) -> GetEsimHistoryResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get eSIM History

</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.eSim().getEsimHistory(
    iccid,
    requestParameters
);
```

</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**iccid:** `String` — ID of the eSIM

</dd>
</dl>

<dl>
<dd>

**requestParameters:** `GetEsimHistoryRequest` — _optional_ Request Parameters Object

</dd>
</dl>
</dd>
</dl>

</dd>
</dl>
</details>

<details><summary><code>client.eSim.suspendEsim(iccid, requestParameters) -> SuspendEsimResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Suspends an eSIM to prevent abuse. All of the eSIM's packages are terminated and its connectivity is switched off. The eSIM is not refunded: the charge stays.

</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.eSim().suspendEsim(
    iccid,
    requestParameters
);
```

</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**iccid:** `String` — ID of the eSIM

</dd>
</dl>

<dl>
<dd>

**requestParameters:** `SuspendEsimRequest` — _optional_ Request Parameters Object

</dd>
</dl>
</dd>
</dl>

</dd>
</dl>
</details>

## IFrame

<details><summary><code>client.iFrame.token() -> TokenResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Generate a new token to be used in the iFrame

</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.iFrame().token();
```

</dd>
</dl>
</dd>
</dl>

</dd>
</dl>
</details>

## OAuth

<details><summary><code>client.oAuth.getAccessToken(oAuthTokenRequest) -> OAuthTokenResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.oAuth().getAccessToken(oAuthTokenRequest);
```

</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**oAuthTokenRequest:** `OAuthTokenRequest` — Request Body

</dd>
</dl>
</dd>
</dl>

</dd>
</dl>
</details>
