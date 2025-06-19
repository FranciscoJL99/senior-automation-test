package com.consubanco.qa.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickEn implements Task {
    private Target elemento;

    public ClickEn(Target elemento) {
        this.elemento = elemento;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(elemento, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds(),
                Click.on(elemento)
        );
    }

    public static ClickEn elemento(Target elemento) {
        return instrumented(ClickEn.class, elemento);
    }
}