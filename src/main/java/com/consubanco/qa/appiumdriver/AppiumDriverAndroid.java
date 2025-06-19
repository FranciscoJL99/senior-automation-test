package com.consubanco.qa.appiumdriver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumDriverAndroid {
    private static AndroidDriver driver;

    public static AppiumDriverAndroid conCapabilities() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium:deviceName", "moto g31");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appium:appPackage", "com.swaglabsmobileapp");
            capabilities.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
            capabilities.setCapability("appium:noReset", true);
            capabilities.setCapability("appium:udid", "ZY22F3WV8J");
            capabilities.setCapability("appium:platformVersion", "12");
            capabilities.setCapability("appium:automationName", "UiAutomator2");
            capabilities.setCapability("appium:newCommandTimeout", 180);
            capabilities.setCapability("appium:timeout", 20000);

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } catch (MalformedURLException e) {
            throw new RuntimeException("Error en la URL de Appium Server", e);
        }
        return new AppiumDriverAndroid();
    }

    public AndroidDriver onDriver() {
        return driver;
    }
}

