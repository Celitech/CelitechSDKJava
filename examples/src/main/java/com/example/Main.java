package com.example;

import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.exceptions.ApiException;
import io.github.celitech.celitechsdk.models.ListDestinationsOkResponse;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder().clientId("CLIENT_ID").clientSecret("CLIENT_SECRET").build();

    Celitech celitech = new Celitech(config);

    try {
      ListDestinationsOkResponse response = celitech.destinations.listDestinations();

      System.out.println(response);
    } catch (ApiException e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}
