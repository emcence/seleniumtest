package com.it.pop;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

    static WebDriver driver;
    public static String highschool = "#radio-button-1";
    public static String college = "#radio-button-2";
    public static String gradsschool = "#radio-button-3";
    public static String male = "#checkbox-1";
    public static String female = "#checkbox-2";
    public static String preferNotSay = "#checkbox-3";

    @BeforeAll
    public static void setUp(){
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

}
