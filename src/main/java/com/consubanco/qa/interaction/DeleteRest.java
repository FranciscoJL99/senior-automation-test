package com.consubanco.qa.interaction;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class DeleteRest implements Interaction {

    private String endpoint;

    public DeleteRest(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(endpoint)
                        .with(req -> req
                                .header("Accept", "application/json"))
        );
        System.out.println("DELETE Response: " + SerenityRest.lastResponse().asString());
    }

    public static DeleteRest from(String endpoint) {
        return new DeleteRest(endpoint);
    }
}
