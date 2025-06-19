package com.consubanco.qa.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.consubanco.qa.userinterfaces.SwagLabs.*;

public class IrAbout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_MENU),
                Click.on(BTN_ABOUT)
        );

    }

    public static IrAbout usuario() {
        return Instrumented.instanceOf(IrAbout.class).withProperties();
    }
}