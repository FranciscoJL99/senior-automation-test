package com.consubanco.qa.runners.webdemoblaze;

import com.consubanco.qa.runners.RunnerPersonalizado;
import com.consubanco.qa.utils.BeforeSuite;
import com.consubanco.qa.utils.DataToFeatures;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        features = "src/test/resources/features/webdemoblaze/LoginUsuarios.feature",
        glue = "com.consubanco.qa.stepdefinitions",
        tags = "@Web",
        plugin = {"pretty"}
)
public class LoginRunner {

    @BeforeSuite
    public static void test() throws IOException {
        DataToFeatures.overrideFeatureFiles("src/test/resources/features/webdemoblaze");
    }
}