package com.consubanco.qa.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Status implements Question<Boolean>{

    private String codigoExpectativa;

    public Status(String codigoExpectativa) {
        this.codigoExpectativa = codigoExpectativa;
    }

    public static Status delServicio(String codigoExpectativa) {

        return new Status(codigoExpectativa);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return String.valueOf(SerenityRest.lastResponse().statusCode()).equals(codigoExpectativa);
    }
}