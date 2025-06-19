package com.consubanco.qa.runners.mobileswaglabs;


import com.consubanco.qa.runners.RunnerPersonalizado;
import com.consubanco.qa.utils.BeforeSuite;
import com.consubanco.qa.utils.DataToFeatures;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        features = "src/test/resources/features/mobileswaglabs/MobileSwageLabs.feature",
        glue = "com.consubanco.qa.stepdefinitions.mobileswaglabs",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        tags = "@Mobile",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class SwagsLabsRunner {
    @BeforeSuite
    public static void test() throws IOException {
        DataToFeatures.overrideFeatureFiles("src/test/resources/features/webdemoblaze");
    }
}
