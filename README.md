# Celitech Java Library

[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-Built%20with%20Fern-brightgreen)](https://buildwithfern.com?utm_source=github&utm_medium=github&utm_campaign=readme&utm_source=Celitech%2FJava)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.celitech/celitech-sdk)](https://central.sonatype.com/artifact/io.github.celitech/celitech-sdk)

The Celitech Java library provides convenient access to the Celitech APIs from Java.

## Table of Contents

- [Documentation](#documentation)
- [Installation](#installation)
- [Reference](#reference)
- [Usage](#usage)
- [Environments](#environments)
- [Base Url](#base-url)
- [Exception Handling](#exception-handling)
- [Advanced](#advanced)
  - [Custom Client](#custom-client)
  - [Retries](#retries)
  - [Timeouts](#timeouts)
  - [Custom Headers](#custom-headers)
  - [Access Raw Response Data](#access-raw-response-data)
- [Contributing](#contributing)

## Documentation

API reference documentation is available [here](https://docs.celitech.com/).

## Installation

### Gradle

Add the dependency in your `build.gradle` file:

```groovy
dependencies {
  implementation 'io.github.celitech:celitech-sdk:3.0.0'
}
```

### Maven

Add the dependency in your `pom.xml` file:

```xml
<dependency>
  <groupId>io.github.celitech</groupId>
  <artifactId>celitech-sdk</artifactId>
  <version>3.0.0</version>
</dependency>
```

## Reference

A full reference for this library is available [here](./reference.md).

## Usage

Instantiate and use the client with the following:

```java
import io.github.celitech.celitechsdk.Celitech;

Celitech client = Celitech
    .builder()
    .build();

client.destinations().listDestinations();
```

## Environments

This SDK allows you to configure different environments for API requests.

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.core.Environment;

Celitech client = Celitech.builder().environment(Environment.DEFAULT).build();

```

## Base Url

You can set a custom base URL when constructing the client.

```java
import io.github.celitech.celitechsdk.Celitech;

Celitech client = Celitech.builder().url("https://example.com").build();

```

## Exception Handling

When the API returns a non-success status code (4xx or 5xx response), an API exception will be thrown.

```java
import io.github.celitech.celitechsdk.core.CelitechApiException;

try {
    client.destinations().listDestinations();
} catch (CelitechApiException e) {
    // Do something with the API exception...
}
```

## Advanced

### Custom Client

This SDK is built to work with any instance of `OkHttpClient`. By default, if no client is provided, the SDK will construct one.
However, you can pass your own client like so:

```java
import io.github.celitech.celitechsdk.Celitech;
import okhttp3.OkHttpClient;

OkHttpClient customClient = ...;

Celitech client = Celitech
    .builder()
    .httpClient(customClient)
    .build();
```

### Retries

The SDK is instrumented with automatic retries with exponential backoff. A request will be retried as long
as the request is deemed retryable and the number of retry attempts has not grown larger than the configured
retry limit (default: 2). Before defaulting to exponential backoff, the SDK will first attempt to respect
the `Retry-After` header (as either in seconds or as an HTTP date), and then the `X-RateLimit-Reset` header
(as a Unix timestamp in epoch seconds); failing both of those, it will fall back to exponential backoff.

Which status codes are retried depends on the `retry-status-codes` generator configuration:

**`legacy`** (current default): retries on

- [408](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408) (Timeout)
- [429](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429) (Too Many Requests)
- [5XX](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#server_error_responses) (All server errors, including 500)

**`recommended`**: retries on

- [408](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408) (Timeout)
- [429](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429) (Too Many Requests)
- [502](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/502) (Bad Gateway)
- [503](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/503) (Service Unavailable)
- [504](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/504) (Gateway Timeout)

Use the `maxRetries` client option to configure this behavior.

```java
import io.github.celitech.celitechsdk.Celitech;

Celitech client = Celitech.builder().maxRetries(1).build();

```

### Timeouts

The SDK defaults to a 60 second timeout. You can configure this with a timeout option at the client or request level.

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.core.RequestOptions;

// Client level
Celitech client = Celitech
    .builder()
    .timeout(60)
    .build();

// Request level
client.destinations().listDestinations(
    RequestOptions
        .builder()
        .timeout(60)
        .build()
);
```

### Custom Headers

The SDK allows you to add custom headers to requests. You can configure headers at the client level or at the request level.

```java
import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.core.RequestOptions;

// Client level
Celitech client = Celitech
    .builder()
    .addHeader("X-Custom-Header", "custom-value")
    .addHeader("X-Request-Id", "abc-123")
    .build();

// Request level
client.destinations().listDestinations(
    RequestOptions
        .builder()
        .addHeader("X-Request-Header", "request-value")
        .build()
);
```

### Access Raw Response Data

The SDK provides access to raw response data, including headers, through the `withRawResponse()` method.
The `withRawResponse()` method returns a raw client that wraps all responses with `getData()` and `getMetadata()` methods.
(A normal client's `response` is identical to a raw client's `response.getData()`.)

```java
CelitechHttpResponse<ListDestinationsResponse> response =
    client.destinations().withRawResponse().listDestinations();

response.getData();
response.getMetadata().getStatusCode();
response.getMetadata().getHeaders();
response.getRaw();
```

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically.
Additions made directly to this library would have to be moved over to our generation code,
otherwise they would be overwritten upon the next generated release. Feel free to open a PR as
a proof of concept, but know that we will not be able to merge it as-is. We suggest opening
an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!
