package com.example;

import net.celitech.celitechsdk.Celitech;
import net.celitech.celitechsdk.config.CelitechConfig;
import net.celitech.celitechsdk.exceptions.ApiError;
import net.celitech.celitechsdk.models.ListDestinationsOkResponse;

public class Main {

  public static void main(String[] args) {
    CelitechConfig config = CelitechConfig.builder()
      .clientId("CLIENT_ID")
      .clientSecret("CLIENT_SECRET")
      .build();

    Celitech celitech = new Celitech(config);

    try {
      ListDestinationsOkResponse response = celitech.destinations.listDestinations();

      System.out.println(response);
    } catch (ApiError e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}
