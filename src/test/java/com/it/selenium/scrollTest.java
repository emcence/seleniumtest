package com.it.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrollTest {

    static WebDriver driver;
    static JavascriptExecutor js;

    @BeforeAll
    public static void setUp(){
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }
/*
    @Test
    public void scrollByPixel(){
        driver.get("https://www.fysiken.nu/sv/");
        driver.manage().window().maximize();

        js.executeScript("window.scrollBy(0,500)");
    }
*/
    @Test
    public void srollByVisibleElements(){
        driver.get("https://www.fysiken.nu/sv/");
        driver.manage().window().maximize();

        //WebElement Element = driver.findElement(By.linkText("BOKA"));
        WebElement Element = driver.findElement(By.linkText("VISA HELA SCHEMAT"));
        //This will scroll the page to the element BOKA
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    @AfterAll
    public static void closeBrowser(){
        driver.close();
        driver.quit();
    }

}
