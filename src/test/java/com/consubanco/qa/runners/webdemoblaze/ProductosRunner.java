package com.consubanco.qa.runners.webdemoblaze;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/webdemoblaze/Productos.feature",
        glue = "com.consubanco.qa.stepdefinitions.webdemoblaze",
        tags = "@Web",
        plugin = {"pretty"}
)
public class ProductosRunner {

}