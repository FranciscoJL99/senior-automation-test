package com.consubanco.qa.tasks;

import com.consubanco.qa.utils.FakeDataGenerator;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.consubanco.qa.userinterfaces.DemoBlaze.TXT_PASSWORD;
import static com.consubanco.qa.userinterfaces.DemoBlaze.TXT_USERNAME;

public class IngresarDatos implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_USERNAME, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(FakeDataGenerator.randomUsername()).into(TXT_USERNAME),
                Enter.theValue(FakeDataGenerator.randomPassword()).into(TXT_PASSWORD)
        );

    }

    public static IngresarDatos deRegistro() {
        return Instrumented.instanceOf(IngresarDatos.class).withProperties();
    }
}