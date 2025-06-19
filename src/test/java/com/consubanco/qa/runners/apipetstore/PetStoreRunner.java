package com.consubanco.qa.runners.apipetstore;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/apipetstoreswagger/PetStore.feature",
        glue = "com.consubanco.qa.stepdefinitions.apipetstoresagger",
        tags = "@Api",
        plugin = {"pretty"}
)
public class PetStoreRunner {

}