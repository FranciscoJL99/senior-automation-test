package com.consubanco.qa.interaction;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostRest implements Interaction {

    private String requestBody;
    private String endpoint;

    public PostRest(String endpoint, String requestBody) {
        this.endpoint = endpoint;
        this.requestBody = requestBody;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(endpoint)
                        .with(req -> req
                                .header("Content-Type", "application/json")
                                .header("Accept", "application/json")
                                .body(requestBody))
        );
        System.out.println("POST Response: " + SerenityRest.lastResponse().asString());
    }

    public static PostRest on(String endpoint, String body) {
        return new PostRest(endpoint, body);
    }
}
