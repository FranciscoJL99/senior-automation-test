package com.consubanco.qa.interaction;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetRest implements Interaction {

    private String endpoint;

    public GetRest(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(endpoint)
                        .with(req -> req
                                .header("Accept", "application/json"))
        );
        System.out.println("GET Response: " + SerenityRest.lastResponse().asString());
    }

    public static GetRest from(String endpoint) {
        return new GetRest(endpoint);
    }
}
