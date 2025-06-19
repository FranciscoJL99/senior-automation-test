package com.consubanco.qa.stepdefinitions.webdemoblaze;

import com.consubanco.qa.exceptions.Exceptions;
import com.consubanco.qa.questions.ObtenerTexto;
import com.consubanco.qa.tasks.ClickEn;
import com.consubanco.qa.tasks.Login;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.hamcrest.Matchers;

import static com.consubanco.qa.exceptions.Exceptions.*;
import static com.consubanco.qa.userinterfaces.DemoBlaze.*;

public class LoginStepDefinitions {

    @Cuando("hace click en la opcion de Log In")
    public void haceClickEnLaOpcionDeLogIn() {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickEn.elemento(BTN_LOGIN));
    }
    @Y("ingresa el usuario {string} y la clave {string}")
    public void ingresaElUsuarioYLaClave(String usuario, String clave) {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.usuario(usuario, clave));
    }
    @Cuando("da click en Log In")
    public void daClickEnLogIn() {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickEn.elemento(BTN_LOGIN_USERNAME));
    }
    @Entonces("se presenta el nombre del {string} en la esquina superior derecha")
    public void se_presenta_el_nombre_del_en_la_esquina_superior_derecha(String usuario) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ObtenerTexto.enPantalla(TXT_NAME_USERNAME),
                        Matchers.containsString(usuario)
                ).orComplainWith(Exceptions.class, MSJ_LOGIN));
    }

    @Y("hace click en la opcion de Logout")
    public void hace_click_en_la_opcion_de_logout() {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickEn.elemento(BTN_LOGOUT));
    }
    @Entonces("regresa a la pagina de inicio")
    public void regresa_a_la_pagina_de_inicio() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(BTN_LOGIN), WebElementStateMatchers.isVisible())
                .orComplainWith(Exceptions.class, SCR_HOME));
    }


}
