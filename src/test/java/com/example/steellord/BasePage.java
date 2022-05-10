package com.example.steellord;

import com.example.steellord.config.Configuration;
import com.example.steellord.driver.DriverFactory;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    protected Configuration configuration;

    @BeforeEach
    public void preCondition() {
        configuration = configuration();

        driver = new DriverFactory().createInstance(configuration().browser());
    }
}
