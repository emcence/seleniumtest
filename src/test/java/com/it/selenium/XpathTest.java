package com.it.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTest {

    static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        driver = new ChromeDriver();

    }
/*
    @Test
    public void hideColumn(){
        driver.manage().window().maximize();
        driver.get("https://jwatsondev.github.io/ng-prime-testing/ng-prime-testing");
        driver.findElement(By.xpath("/html/body/app-root/app-prime/div/p-table/div/div[1]/div/p-multiselect/div/div[2]/label")).click();
        driver.findElement(By.xpath("/html/body/app-root/app-prime/div/p-table/div/div[1]/div/p-multiselect/div/div[4]/div[2]/ul/li[2]/div/div[2]/span")).click();



    }
*/
    @Test
    public void showColumn(){

        //Variable for chcking the result
        boolean result = false;

        driver.manage().window().maximize();
        driver.get("https://jwatsondev.github.io/ng-prime-testing/ng-prime-testing");

        driver.findElement(By.xpath("/html/body/app-root/app-prime/div/p-table/div/div[1]/div/p-multiselect/div/div[3]")).click();
        driver.findElement(By.xpath("/html/body/app-root/app-prime/div/p-table/div/div[1]/div/p-multiselect/div/div[4]/div[2]/ul/li[2]/label")).click();
        driver.findElement(By.xpath("/html/body/app-root/app-prime/div/p-table/div/div[1]/div/p-multiselect/div/div[4]/div[2]/ul/li[2]/label")).click();
        driver.findElement(By.xpath("/html/body/app-root/app-prime/div/p-table/div/div[1]/div/p-multiselect/div/div[4]/div[2]/ul/li[2]/label")).click();


        try
        {
            result = driver.findElement(By.id("id")).isDisplayed();
        }
        catch (Exception e){
            System.out.println("Exception thrown because column id is not visible");
        }

        if (result){
            System.out.println("Column is visible in the GUI");
        }


    }
/*
    @AfterAll
    public static void closeBrowser(){
        driver.close();
        driver.quit();
    }
*/
}
