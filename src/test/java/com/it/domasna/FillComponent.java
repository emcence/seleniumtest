package com.it.domasna;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class FillComponent extends BaseComponent{
    //Press submit button
    public void pressSkicka(){
        driver.findElement(By.id("gform_submit_button_3")).click();
    }
    //Go to page https://www.iths.se/ansokan-it-hogskolan/
    public void goToAnsokanPage(){
        driver.navigate().to(ansokanUrl);
    }

    //Go to home page https://www.iths.se/
    public void goToHomePage(){
        driver.navigate().to(homeUrl);
    }

    //Select value from drop down menu in "Vilken utbildning vill du läsa?"
    public void selectUtbuildning(Integer index){
        Select selectMenu = new Select(driver.findElement(By.id("input_3_1")));
        //selectMenu.selectByVisibleText("0-1");
        selectMenu.selectByIndex(index);

    }

    //Choose gender
    public void chooseGender(String gender) {
        driver.findElement(By.id(gender)).click();
    }

    //Type firstName
    public void typeFirstName(String firstName){
        driver.findElement(By.id("input_3_3")).sendKeys(firstName);
    }

    //Type lastName
    public void typeLastName(String lastName){
        driver.findElement(By.id("input_3_4")).sendKeys(lastName);
    }

    //Type personal number
    public void typePN(String pn){
        driver.findElement(By.id("input_3_10")).sendKeys(pn);
    }

    //Type post number
    public void typePostNumber(String postNumber){
        driver.findElement(By.id("input_3_11")).sendKeys(postNumber);
    }

    //Type post address
    public void typePostAdress(String postAdress){
        driver.findElement(By.id("input_3_13")).sendKeys(postAdress);
    }

    //Type email address
    public void typeEMail(String email){
        driver.findElement(By.id("input_3_8")).sendKeys(email);
    }

    //Type phone
    public void typePhone(String phone){
        driver.findElement(By.id("input_3_6")).sendKeys(phone);
    }

    public String testColor(String xpathValue) {
        String actualColor = "";
        //if it is not initialized to "" than wrong color is returned if it is called more than once
        String color = driver.findElement(By.xpath(xpathValue)).getCssValue("background-color");
        String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

        int hexValue1=Integer.parseInt(hexValue[0]);
        hexValue[1] = hexValue[1].trim();
        int hexValue2=Integer.parseInt(hexValue[1]);
        hexValue[2] = hexValue[2].trim();
        int hexValue3=Integer.parseInt(hexValue[2]);

        actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
        System.out.println(actualColor);
        return actualColor;
    }
}
