package com.consubanco.qa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidarTexto implements Question<Boolean> {
    private String texto;

    public ValidarTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        try {
            new org.openqa.selenium.support.ui.WebDriverWait(BrowseTheWeb.as(actor).getDriver(), java.time.Duration.ofSeconds(5))
                    .until(driver -> {
                        try {
                            driver.switchTo().alert();
                            return true;
                        } catch (org.openqa.selenium.NoAlertPresentException e) {
                            return false;
                        }
                    });
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }

        String mensajeAlerta = BrowseTheWeb.as(actor).getDriver().switchTo().alert().getText();
        boolean esIgual = mensajeAlerta.contains(texto);
        if (esIgual) {
            BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
        }
        return esIgual;
    }

    public static Question<Boolean> alerta(String texto) {
        return new ValidarTexto(texto);
    }
}
