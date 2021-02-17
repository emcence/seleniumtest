package com.it.pop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestData extends FillForm{
    @Test
    public void TestPage(){
        //Type in first name
        TypeFirstName("Ana");

        //Type in last name
        TypeLastName("Manjana");

        //Type in job title
        TypeJobTitle("Volshebnik");

        //Highest level of Education
        ChooseEducation(gradsschool);

        //Gender
        ChooseGender(preferNotSay);

        //Years of Experience
        ChooseYearsOfExperience(3);

        //Choose date
        ChooseDate("10/23/2020");

        //Press Submit button
        PresSubmit();

        //Test that url is correct
        String url = driver.getCurrentUrl();
        String currentUrl = "https://formy-project.herokuapp.com/thanks";
        assertEquals(url, currentUrl);
        System.out.println("Correct URL is get");

        //Test that title is correct
        String title = driver.getTitle();
        String currentTitle = "Formy";
        assertEquals(title, currentTitle);
        System.out.println("Correct title is get");
    }
}
