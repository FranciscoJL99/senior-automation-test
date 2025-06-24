package com.consubanco.qa.stepdefinitions.apipetstoresagger;

import com.consubanco.qa.interaction.DeleteRest;
import com.consubanco.qa.interaction.GetRest;
import com.consubanco.qa.interaction.PostRest;
import com.consubanco.qa.interaction.PutRest;
import com.consubanco.qa.utils.ConstructorJson;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.io.IOException;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class PetStoreStepDefinitions {

    int petId = ConstructorJson.generarIdNumerico();
    @Before
    public void before() throws IOException {
        OnStage.setTheStage(OnlineCast.whereEveryoneCan(CallAnApi.at("https://petstore.swagger.io/v2")));
        SerenityRest.useRelaxedHTTPSValidation();
        OnStage.theActorCalled("Usuario");
    }

    @Cuando("agrego una nueva mascota con nombre {string}")
    public void agregoUnaNuevaMascota(String nombre) {
        String petBody = """
    {
      "id": %d,
      "name": "%s",
      "photoUrls": [],
      "status": "available"
    }
    """.formatted(petId, nombre);

        theActorInTheSpotlight().attemptsTo(
                PostRest.on("/pet", petBody)
        );
    }

    @Entonces("la mascota debe ser registrada correctamente en la API")
    public void laMascotaDebeSerRegistradaCorrectamente(io.cucumber.datatable.DataTable dataTable) {
        int statusEsperado = Integer.parseInt(dataTable.cell(1, 0));
        theActorInTheSpotlight().should(
                seeThatResponse("Validar status code de creación",
                        response -> response.statusCode(statusEsperado))
        );
    }

    @Cuando("consulto la información de la mascota")
    public void consultoLaInformacionDeLaMascota() {
        theActorInTheSpotlight().attemptsTo(
                GetRest.from("/pet/" + petId)
        );
    }

    @Entonces("se devuelve la mascota correctamente")
    public void seDevuelveLaMascotaCorrectamente(io.cucumber.datatable.DataTable dataTable) {
        int statusEsperado = Integer.parseInt(dataTable.cell(1, 0));
        theActorInTheSpotlight().should(
                seeThatResponse("Validar status del GET",
                        response -> response.statusCode(Integer.parseInt("200")))
        );
    }


    @Cuando("actualizo el nombre de la mascota a {string}")
    public void actualizoElNombreDeLaMascotaA(String updatedName) {
        String petBody = """
    {
      "id": %d,
      "name": "%s",
      "photoUrls": [],
      "status": "available"
    }
    """.formatted(petId, updatedName);

        theActorInTheSpotlight().attemptsTo(
                PutRest.to("/pet", petBody)
        );
    }

    @Entonces("la mascota debe ser consultada correctamente en la API")
    public void laMascotaDebeSerConsultadaCorrectamente(io.cucumber.datatable.DataTable dataTable) {
        int statusEsperado = Integer.parseInt(dataTable.cell(1, 0));
        theActorInTheSpotlight().should(
                seeThatResponse("Validar status",
                        response -> response.statusCode(statusEsperado))
        );
    }

    @Y("elimino la mascota")
    public void eliminoLaMascota() {
        theActorInTheSpotlight().attemptsTo(
                DeleteRest.from("/pet/" + petId)
        );
    }




}
