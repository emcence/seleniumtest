package com.it.domasna;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseComponent {
    static WebDriver driver;
 /*
    public static String highschool = "#radio-button-1";
    public static String college = "#radio-button-2";
    public static String gradsschool = "#radio-button-3";
    public static String male = "#checkbox-1";
    public static String female = "#checkbox-2";
    public static String preferNotSay = "#checkbox-3";
*/
    public static String homeUrl = "https://www.iths.se/";
    public static String homeTitle = "IT-Högskolan – Här startar din IT-karriär!";
    public static String ansokanUrl = "https://www.iths.se/ansokan-it-hogskolan/";
    public static String ansokanValidation = "validation_message_3_1";
    public static String expectedValidationMsg = "Fältet är obligatoriskt.";
    public static String man = "choice_3_17_0";
    public static String kvinna = "choice_3_17_1";
    public static String ansokanValidMsg = "gform_confirmation_message_3";
    public static String utbildningar = "//*[@id=\"nav-utbildningar\"]/a";
    public static String omOss = "//*[@id=\"nav-omoss\"]/a";
    public static String nyheter = "//*[@id=\"nav-nyheter\"]/a";
    public static String yhUttbild = "//*[@id=\"frontpage\"]/div/div[1]/div/div/div[2]/div/a[1]";
    public static String distansUttbild = "//*[@id=\"frontpage\"]/div/div[1]/div/div/div[2]/div/a[2]";
    public static String allUttbild = "//*[@id=\"frontpage\"]/div/div[1]/div/div/div[2]/div/a[3]";
    public static String stage1 = "//*[@id=\"steps__box--0\"]/div";
    public static String ansokBtn = "//*[@id=\"steps__description--4\"]/div/a";


    @BeforeEach
//  @BeforeAll
//    public static void setUp(){
    public void setUp(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://www.iths.se/");
        driver.manage().window().maximize();
    }

    @AfterEach
//  @AfterAll
//    public static void teardown(){
    public void teardown(){
        driver.quit();
    }

}
