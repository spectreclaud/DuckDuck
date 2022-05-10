package com.example.steellord.e2e;

import com.example.steellord.BasePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleExTest extends BasePage {

    @Test
    void testGoogleSearch() {
        WebElement element = driver.findElement(By.name("q"));
        element.clear();

        element.sendKeys("Selenium testing tools cookbook");
        element.submit();

        assertEquals("Selenium testing tools cookbook - Google Search",
                driver.getTitle());
    }
}
