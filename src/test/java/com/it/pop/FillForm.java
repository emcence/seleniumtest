package com.it.pop;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class FillForm extends BaseClass{

    //Type in first name
    public void TypeFirstName(String firstName){
        driver.findElement(By.id("first-name")).sendKeys(firstName);

    }

    //Type in last name
    public void TypeLastName(String lastName) {
        driver.findElement(By.id("last-name")).sendKeys(lastName);
    }

    //Type in job title
    public void TypeJobTitle(String jobTitle) {
        driver.findElement(By.id("job-title")).sendKeys(jobTitle);
    }

    //Choose highest level of education
    public void ChooseEducation(String eduLevel) {
        driver.findElement(By.cssSelector(eduLevel)).click();
    }

    //Choose gender
    public void ChooseGender(String gender) {
        driver.findElement(By.cssSelector(gender)).click();
    }

    //Choose years of experience
    public void ChooseYearsOfExperience(Integer index){
        Select selectMenu = new Select(driver.findElement(By.id("select-menu")));
        //selectMenu.selectByVisibleText("0-1");
        selectMenu.selectByIndex(index);
    }

    //Choose date
    public void ChooseDate(String date){
        driver.findElement(By.id("datepicker")).sendKeys(date);
    }

    //Press submit button
    public void PresSubmit(){
        driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a")).click();
    }

}
