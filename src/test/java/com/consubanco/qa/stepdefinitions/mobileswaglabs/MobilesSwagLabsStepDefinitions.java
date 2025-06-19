package com.consubanco.qa.stepdefinitions.mobileswaglabs;

import com.consubanco.qa.appiumdriver.AppiumDriverAndroid;
import com.consubanco.qa.tasks.LoginMobile;
import com.consubanco.qa.tasks.Logout;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import io.cucumber.java.Before;

import java.io.IOException;

import static com.consubanco.qa.userinterfaces.SwagLabs.*;

public class MobilesSwagLabsStepDefinitions {
    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que abrimos la APK de swag labs")
    public void queAbrimosLaAPKDeSwagLabs() {
        OnStage.theActorCalled("QA").can(BrowseTheWeb.with(AppiumDriverAndroid.conCapabilities().onDriver()));
    }

    @Entonces("debe verse el titulo {string} y el boton Login")
    public void debeVerseElTituloYElBotonLogin(String string) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(TXT_SWAG_LABS), WebElementStateMatchers.isVisible()));
    }

    @Cuando("ingresamos usuario {string} y clave {string}")
    public void ingresamosUsuarioYClave(String usuario, String clave) {
        OnStage.theActorInTheSpotlight().attemptsTo(LoginMobile.usuario(usuario, clave));

    }
    @Cuando("pulsamos el boton Login")
    public void pulsamosElBotonLogin() {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(BTN_LOGIN));
    }
    @Entonces("debe mostrarse la lista de productos")
    public void debeMostrarseLaListaDeProductos() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(PRODUCT), WebElementStateMatchers.isVisible()));
    }

    @Cuando("seleccionamos el producto {string}")
    public void seleccionamosElProducto(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(BTN_ADD_TO_CART));
    }

    @Entonces("el carrito debe tener el producto {string} agregado")
    public void elCarritoDebeTenerElProductoAgregado(String producto) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(PRODUCT_CART), WebElementStateMatchers.isVisible()));

    }

    @Cuando("el carrito tiene el producto {string} agregado")
    public void elCarritoTieneElProductoAgregado(String producto) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(PRODUCT_CART), WebElementStateMatchers.isVisible()));

    }
    @Cuando("pulsamos remove junto al producto {string}")
    public void pulsamosRemoveJuntoAlProducto(String string) {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(BTN_REMOVER));

    }
    @Entonces("el carrito debe quedar vacio")
    public void elCarritoDebeQuedarVacio() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(BTN_SEGUIR_COMPRANDO), WebElementStateMatchers.isVisible()));

    }

    @Cuando("pulsamos el boton logout")
    public void pulsamosElBotonLogout() {
        OnStage.theActorInTheSpotlight().attemptsTo(Logout.usuario());

    }
    @Entonces("debe regresar a la pantalla de login")
    public void debeRegresarALaPantallaDeLogin() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(TXT_SWAG_LABS), WebElementStateMatchers.isVisible()));
    }

    @Y("pulsamos el boton agregar al carrito")
    public void pulsamosElBotonAgregarAlCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(BTN_CART));
    }

    @Y("abrimos el menu lateral")
    public void abrimosElMenuLateral() {
    }
}
