package com.consubanco.qa.stepdefinitions.webdemoblaze;

import com.consubanco.qa.exceptions.Exceptions;
import com.consubanco.qa.questions.ObtenerTexto;
import com.consubanco.qa.questions.ValidarTexto;
import com.consubanco.qa.tasks.ClickEn;
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

public class ProductosStepDefinitions {

    String producto;

    @Y("selecciono una categoría de productos aleatoria desde el menú")
    public void selecciono_una_categoría_de_productos_aleatoria_desde_el_menú() {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickEn.elemento(BTN_CATEGORY()));
    }
    @Cuando("selecciono un producto aleatorio de la lista de productos")
    public void selecciono_un_producto_aleatorio_de_la_lista_de_productos() {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickEn.elemento(PRODUCT()));
        producto = OnStage.theActorInTheSpotlight()
                .asksFor(ObtenerTexto.enPantalla(TXT_PRODUCT));
        OnStage.theActorInTheSpotlight().attemptsTo(ClickEn.elemento(BTN_ADD_CART));
    }

    @Entonces("el carrito muestra un mensaje de {string} al agregar el producto")
    public void el_carrito_muestra_un_mensaje_de_al_agregar_el_producto(String mensajeConfirmacion) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarTexto.alerta(mensajeConfirmacion))
                .orComplainWith(Exceptions.class, MSJ_SIGN_UP));
    }

    @Y("al acceder a la sección Cart desde el menú")
    public void al_acceder_a_la_sección_cart_desde_el_menú() {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickEn.elemento(BTN_CART));
    }

    @Entonces("el carrito de compras se actualiza con el producto seleccionado")
    public void el_carrito_de_compras_se_actualiza_con_el_producto_seleccionado() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ObtenerTexto.enPantalla(TXT_PRODUCT_CART.of(producto)),
                        Matchers.containsString(producto)
                ).orComplainWith(Exceptions.class, MSJ_PRODUCTO_NO_EXIST));
    }

    @Cuando("elimino el producto del carrito")
    public void elimino_el_producto_del_carrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickEn.elemento(BTN_DELETE_PRODUCT.of(producto)));
    }
    @Entonces("el carrito de compras se actualiza y no muestra el producto eliminado")
    public void el_carrito_de_compras_se_actualiza_y_no_muestra_el_producto_eliminado() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(TXT_PRODUCT_CART.of(producto)), WebElementStateMatchers.isNotVisible()));

    }

}
