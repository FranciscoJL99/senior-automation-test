package com.consubanco.qa.interaction;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PutRest implements Interaction {

    private String endpoint;
    private String requestBody;

    public PutRest(String endpoint, String requestBody) {
        this.endpoint = endpoint;
        this.requestBody = requestBody;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(endpoint)
                        .with(req -> req
                                .header("Content-Type", "application/json")
                                .header("Accept", "*/*")
                                .body(requestBody))
        );
        System.out.println("PUT Response: " + SerenityRest.lastResponse().asString());
    }

    public static PutRest to(String endpoint, String body) {
        return new PutRest(endpoint, body);
    }
}
