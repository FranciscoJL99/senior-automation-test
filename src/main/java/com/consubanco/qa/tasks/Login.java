package com.consubanco.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.consubanco.qa.userinterfaces.DemoBlaze.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private String usuario;
    private String clave;


    public Login(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_LOGIN_USERNAME, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(usuario).into(TXT_LOGIN_USERNAME),
                Enter.theValue(clave).into(TXT_LOGIN_PASSWORD)
        );

    }

    public static Login usuario(String usuario, String clave) {
        return instrumented(Login.class, usuario, clave);
    }
}