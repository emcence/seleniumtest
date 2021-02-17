package com.it.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

public class TestElement {
    static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().maximize();
    }

    @Test
    public void TestDiffrentElements(){
        //Type in first name
        driver.findElement(By.id("first-name")).sendKeys("Emilija");

        //Type in last name
        driver.findElement(By.id("last-name")).sendKeys("Petreska");

        //Type in job title
        driver.findElement(By.id("job-title")).sendKeys("Software Engineer");

        //Choose highest level of education
        driver.findElement(By.cssSelector("#radio-button-2")).click();

        //Choose gender
        driver.findElement(By.cssSelector("#checkbox-2")).click();

        //Choose years of experience
        Select selectMenu = new Select(driver.findElement(By.id("select-menu")));
        //selectMenu.selectByVisibleText("0-1");
        selectMenu.selectByIndex(3);

        //Choose date
        driver.findElement(By.id("datepicker")).sendKeys("10/15/2020");

        //Press submit button
        driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a")).click();

        //Test that url is correct
        String url = driver.getCurrentUrl();
        String currentUrl = "https://formy-project.herokuapp.com/thanks";
        assertEquals(url, currentUrl);

        //Test that title is correct
        String title = driver.getTitle();
        String currentTitle = "Formy";
        assertEquals(title, currentTitle);
    }

    @AfterAll
    public static void teardown(){
        driver.close();
        driver.quit();
    }

}
