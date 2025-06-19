package com.consubanco.qa.stepdefinitions.webdemoblaze;

import com.consubanco.qa.exceptions.Exceptions;
import com.consubanco.qa.questions.ValidarTexto;
import com.consubanco.qa.tasks.ClickEn;
import com.consubanco.qa.tasks.IngresarDatos;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.consubanco.qa.exceptions.Exceptions.MSJ_SIGN_UP;
import static com.consubanco.qa.userinterfaces.DemoBlaze.BTN_REGISTRO;
import static com.consubanco.qa.userinterfaces.DemoBlaze.BTN_SIGN_UP;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class RegistroUsuarioStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario ingresar a la pagina de DemoBlaze")
    public void queElUsuarioIngresarALaPaginaDeDemoBlaze() {
        OnStage.theActorCalled("Usuario").can(BrowseTheWeb.with(getDriver()));
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.demoblaze.com/"));
    }
    @Cuando("hace click en la opcion de Sign Up")
    public void haceClickEnLaOpcionDeSignUp() {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickEn.elemento(BTN_SIGN_UP));
    }
    @Y("ingresa un usuario y clave")
    public void ingresaUnUsuarioYClave() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarDatos.deRegistro());

    }
    @Y("da click en sign up")
    public void daClickEnSignUp() {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickEn.elemento(BTN_REGISTRO));
    }
    @Entonces("se presenta el mensaje de {string}")
    public void sePresentaElMensajeDe(String mensajeConfirmacion) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarTexto.alerta(mensajeConfirmacion))
                .orComplainWith(Exceptions.class, MSJ_SIGN_UP));
    }

}
