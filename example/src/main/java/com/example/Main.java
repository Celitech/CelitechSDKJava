package com.example;

import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.models.ListDestinationsOkResponse;

public class Main {

  public static void main(String[] args) {
    Celitech celitech = new Celitech();

    ListDestinationsOkResponse response = celitech.destinationsService.listDestinations();

    System.out.println(response);
  }
}
