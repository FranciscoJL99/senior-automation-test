package com.consubanco.qa.tasks;

import com.consubanco.qa.utils.FakeDataGenerator;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.consubanco.qa.userinterfaces.SwagLabs.*;

public class Logout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_MENU),
                Click.on(BTN_LOGOUT)
        );

    }

    public static Logout usuario() {
        return Instrumented.instanceOf(Logout.class).withProperties();
    }
}