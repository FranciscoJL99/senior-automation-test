package com.consubanco.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.consubanco.qa.userinterfaces.DemoBlaze.TXT_LOGIN_PASSWORD;
import static com.consubanco.qa.userinterfaces.DemoBlaze.TXT_LOGIN_USERNAME;
import static com.consubanco.qa.userinterfaces.SwagLabs.TXT_PASSWORD;
import static com.consubanco.qa.userinterfaces.SwagLabs.TXT_USERNAME;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginMobile implements Task {

    private String usuario;
    private String clave;


    public LoginMobile(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(TXT_USERNAME),
                Enter.theValue(clave).into(TXT_PASSWORD)
        );

    }

    public static LoginMobile usuario(String usuario, String clave) {
        return instrumented(LoginMobile.class, usuario, clave);
    }
}