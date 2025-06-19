package com.consubanco.qa.runners;

import com.consubanco.qa.utils.BeforeSuite;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class RunnerPersonalizado extends Runner {

    private final Class<?> classValue;
    private final CucumberWithSerenity cucumberWithSerenity;

    public RunnerPersonalizado(Class<?> classValue) throws Exception {
        this.classValue = classValue;
        this.cucumberWithSerenity = new CucumberWithSerenity(classValue);
    }

    @Override
    public Description getDescription() {
        return cucumberWithSerenity.getDescription();
    }

    private void runAnnotatedMethods(Class<? extends Annotation> annotation) throws Exception {
        for (Method method : classValue.getMethods()) {
            if (method.isAnnotationPresent(annotation)) {
                method.invoke(null);
            }
        }
    }

    @Override
    public void run(RunNotifier notifier) {
        try {
            runAnnotatedMethods(BeforeSuite.class);
        } catch (Exception e) {
            throw new RuntimeException("Error ejecutando métodos anotados", e);
        }
        cucumberWithSerenity.run(notifier);
    }
}