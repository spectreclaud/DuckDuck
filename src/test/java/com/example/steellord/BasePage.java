package com.example.steellord;

import com.example.steellord.config.Configuration;
import com.example.steellord.driver.DriversFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static com.example.steellord.config.ConfigurationManager.configuration;

public class BasePage {

    protected WebDriver driver;

    protected Configuration configuration;

    @BeforeEach
    public void preCondition() {
        configuration = configuration();

        driver = new DriversFactory().createInstance(configuration().browser());
        driver.get(configuration().url());
    }

    @AfterEach
    public void postCondition() {
        driver.quit();
    }
}
