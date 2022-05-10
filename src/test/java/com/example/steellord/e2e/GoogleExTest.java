package com.example.steellord.e2e;

import com.example.steellord.BasePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleExTest extends BasePage {

    @Test
    void testGoogleSearch() {

        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text()) = 'Zgadzam się']")));
        driver.findElement(By.xpath("//div[normalize-space(text()) = 'Zgadzam się']")).click();


        WebElement element = driver.findElement(By.name("q"));
        element.clear();

        element.sendKeys("Selenium testing tools cookbook");
        element.submit();

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase()
                        .startsWith("selenium testing tools cookbook");
            }
        });


        assertEquals("Selenium testing tools cookbook - Szukaj w Google",
                driver.getTitle());
    }
}
