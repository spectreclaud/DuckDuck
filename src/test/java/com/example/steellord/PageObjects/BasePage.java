package com.example.steellord.PageObjects;

import com.example.steellord.config.Configuration;
import com.example.steellord.driver.DriversFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.example.steellord.config.ConfigurationManager.configuration;

public class BasePage {

    protected WebDriver driver;

    protected Configuration configuration;
    public By form = By.cssSelector(".form-content");

    @BeforeEach
    public void preCondition() {
        configuration = configuration();
        driver = new DriversFactory().createInstance(configuration().browser());
        driver.get(configuration().url());
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @AfterEach
    public void postCondition() {
        driver.quit();
    }
}
