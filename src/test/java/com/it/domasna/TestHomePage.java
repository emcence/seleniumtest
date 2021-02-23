package com.it.domasna;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class TestHomePage extends FillComponent{
    @Test
    public void testHomePageUrlTitle() {
        //Test that url is correct
        assertEquals(driver.getCurrentUrl(), homeUrl);

        //Test that title is correct
        assertEquals(driver.getTitle(), homeTitle);
    }

    @Test
    public void testHomePageUpperLinks(){
        //Verify UTBILDNINGAR link
        driver.findElement(By.xpath(utbildningar)).click();
        String actualTxt = driver.findElement(By.xpath("//*[@id=\"main\"]/div/h1")).getText();

        assertEquals(driver.getCurrentUrl(),"https://www.iths.se/courses/");
        assertEquals("Utbildningar",actualTxt);


        //Verify OM-OSS link
        driver.findElement(By.xpath(omOss)).click();
        actualTxt = driver.findElement(By.xpath("//*[@id=\"page\"]/div/div/div[2]/div[2]/div[1]/div[1]/div[1]/h4")).getText();

        assertEquals(driver.getCurrentUrl(),"https://www.iths.se/om-oss/");
        assertEquals("Om oss",actualTxt);

        //Verify NYHETER link
        driver.findElement(By.xpath(nyheter)).click();
        actualTxt = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/h1")).getText();

        assertEquals(driver.getCurrentUrl(),"https://www.iths.se/nyheter/");
        assertEquals("Nyheter",actualTxt);

        //need to be verified for rest of the links but it is the same approach

    }

    @Test
    public void testHomePageUttbildBtn() {
        //Verify YH-utbildningar button
        goToHomePage();
        driver.findElement(By.xpath(yhUttbild)).click();
        String actualTxt = driver.findElement(By.xpath("//*[@id=\"main\"]/div/h1")).getText();

        assertEquals(driver.getCurrentUrl(), "https://www.iths.se/kurstyp/yh-utbildning/");
        assertEquals("Våra YH-utbildningar", actualTxt);
    }

    @Test
    public void testHomePageDistansBtn(){
        goToHomePage();

        //Verify Distansutbildningar button
        driver.findElement(By.xpath(distansUttbild)).click();
        String actualTxt = driver.findElement(By.xpath("//*[@id=\"main\"]/div/h1")).getText();

        assertEquals(driver.getCurrentUrl(),"https://www.iths.se/kurstyp/distansutbildning/");
        assertEquals("Våra distansutbildningar",actualTxt);
    }
        //To see find the next button need to start from home page

    @Test
    public void testHomePageAllUtbBtn(){
        //To see find the next button need to start from home page
        goToHomePage();

        //Verify Alla utbildningar button
        driver.findElement(By.xpath(allUttbild)).click();
        String actualTxt = driver.findElement(By.xpath("//*[@id=\"main\"]/div/h1")).getText();

        assertEquals(driver.getCurrentUrl(),"https://www.iths.se/courses/");
        assertEquals("Utbildningar",actualTxt);

    }


    @Test
    public void testSwitchToFB(){

        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.cssSelector("#footer-container > div > div.row.footer-contact > div.col-2.social-media > div > a:nth-child(1) > i")).click();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
        driver.get("https://www.facebook.com/ITHogskolan?ref=hl");


//Perform whatever actions you want done on the secondary tab, let’s pretend we’re logging in somewhere
        assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/ITHogskolan?ref=hl");

        driver.switchTo().window(mainWindow);
        assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/ITHogskolan?ref=hl");
//Perform whatever actions you want done on the main tab, we’ll click a button

       driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
    }
}
