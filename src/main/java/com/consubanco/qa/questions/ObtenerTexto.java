package com.consubanco.qa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ObtenerTexto implements Question<String> {

    private Target target;

    public ObtenerTexto(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).getText();
    }

    public static Question<String> enPantalla(Target target) {
        return new ObtenerTexto(target);
    }
}