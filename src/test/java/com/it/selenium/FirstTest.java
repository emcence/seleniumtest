package com.it.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;


public class FirstTest {

    @Test
    public void testWebSite(){
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://google.com");

        assertEquals("Google",driver.getTitle(),"Tittle check failed!");

        driver.close();
        driver.quit();
    }

}
