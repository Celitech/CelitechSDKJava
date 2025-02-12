package com.example

import io.github.celitech.celitechsdk.Celitech;
import io.github.celitech.celitechsdk.config.CelitechConfig;
import io.github.celitech.celitechsdk.models.ListDestinationsOkResponse;

fun main() {
	val config: CelitechConfig = CelitechConfig.builder()
			.clientId("CLIENT_ID")
			.clientSecret("CLIENT_SECRET")
			.build();

    val celitech: Celitech = Celitech(config);

    val response: ListDestinationsOkResponse = celitech.destinations.listDestinations();
    
    println(response);
}

