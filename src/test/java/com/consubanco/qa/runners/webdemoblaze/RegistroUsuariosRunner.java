package com.consubanco.qa.runners.webdemoblaze;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/webdemoblaze/RegistroUsuarios.feature",
        glue = "com.consubanco.qa.stepdefinitions",
        tags = "@Web",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RegistroUsuariosRunner {
}
