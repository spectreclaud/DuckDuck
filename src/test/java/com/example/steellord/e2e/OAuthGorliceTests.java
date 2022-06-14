package com.example.steellord.e2e;

import com.example.steellord.PageObjects.BasePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class OAuthGorliceTests extends BasePage {

    By signInButton = By.cssSelector(".pointer");

    By loginEmailOption = By.cssSelector("div:nth-child(3) > a .login-type-title");
    By userEmail = By.id("username");
    By sendCodeButton = By.xpath("//button[@name='action']");
    By entrCodeField = By.xpath("//input[@id='code']");
    By errorMessage = By.xpath("//div[3]");
    By passwdField = By.id("password");
    By header = By.xpath("//div[@id='headerDiv']/nav/div[2]/div[2]/b");

    private String email = "druki.rafst@gmail.com";
    private String password = "KYubffayamX7?$";
    private String emailCode = "123456";

    @Test
    @DisplayName("User registration via email")
    public void registrationTest() {

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(signInButton));

        driver.findElement(signInButton).click();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(form));

        driver.findElement(loginEmailOption).click();

        driver.findElement(userEmail).clear();
        driver.findElement(userEmail).sendKeys(email);

        driver.findElement(sendCodeButton).click();

        driver.findElement(entrCodeField).clear();
        driver.findElement(entrCodeField).sendKeys(emailCode);

        driver.findElement(entrCodeField).submit();

        String txt = driver.findElement(errorMessage).getAttribute("class");
        assertEquals("info-error", txt, "There is no error something wrong with the authorization");
    }


    @Test
    @DisplayName("User login with email")
    public void logInTest() {

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(signInButton));

        driver.findElement(signInButton).click();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(form));

        driver.findElement(loginEmailOption).click();

        driver.findElement(userEmail).clear();
        driver.findElement(userEmail).sendKeys(email);

        driver.findElement(passwdField).clear();
        driver.findElement(passwdField).sendKeys(password);

        driver.findElement(passwdField).submit();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(header));

        assertEquals("druki.rafst", driver.findElement(header), "Login failed");
    }
}
