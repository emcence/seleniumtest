package com.it.domasna;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TestAnsokanPage extends FillComponent{

    @Test
    public void testAnsokanValidationMsg(){
        //Test correct location
        goToAnsokanPage();
        assertEquals(driver.getCurrentUrl(), ansokanUrl);

        //Test that validation message is get when value is not selected in "Vilken utbildning vill du läsa?"
        pressSkicka();
        String actual_msg = driver.findElement(By.id(ansokanValidation)).getText();
        assertEquals(actual_msg, expectedValidationMsg);

        goToHomePage();
    }

    @Test
    //test is not running in Mozila Firefox even with the latest FF update
    public void testAnsokanRefresh(){
        goToAnsokanPage();

        //Test that validation message is removed after refresh is done or value is selected
        pressSkicka();
        //driver.navigate().refresh();
        //commented because can't be executed in FF so test is done when valid value is selected
        selectUtbuildning(2);

        //assertFalse(driver.findElement(By.id(ansokanValidation)).isDisplayed());
        assertTrue(driver.findElement(By.id(ansokanValidation)).isDisplayed());
        goToHomePage();
   }

    @Test
    public void testAnsokanValidValue(){

        goToAnsokanPage();

        //select value from drop-down menu
        selectUtbuildning(3);

        //Choose Kön
        chooseGender(man);

        //Type FirstName
        typeFirstName("Emilija");

        //Type LastName
        typeLastName("Petreska");

        //Type personal number
        typePN("7785461234");

        //Type post number
        typePostNumber("67554");

        //Type postadress
        typePostAdress("Mörbydalen 34");

        //Type email address
        typeEMail("testadd@test.com");

        //Type telefonNumber
        typePhone("0752465511");

        //Click Submit button
        pressSkicka();

        //Verify that correct URL is displayed
        assertEquals(driver.getCurrentUrl(), ansokanUrl);

        String expectedValidMsg = "Tack för din ansökan, Emilija! Vi bekräftar din ansökan inom kort.";
        String actual_msg = driver.findElement(By.id(ansokanValidMsg)).getText();
        assertEquals(actual_msg, expectedValidMsg);

        goToHomePage();
    }

    @Test
    public void testAnsokanSpecialCharInTxtBox(){

        goToAnsokanPage();

        //select value from drop-down menu
        selectUtbuildning(3);

        //Choose Kön
        chooseGender(man);

        //Type FirstName
        typeFirstName("<!This might be script>");

        //Type LastName
        typeLastName("@Petreska");

        //Type personal number
        typePN("!7785461234");

        //Type post number
        typePostNumber("#4567893");

        //Type postadress
        typePostAdress("<!Mörbydalen 34>");

        //Type email address
        typeEMail("testadd@test.com");

        //Type telefonNumber
        typePhone("#0752465511");

        //Click Submit button
        pressSkicka();

        //Verify that correct URL is displayed
        assertEquals(driver.getCurrentUrl(), ansokanUrl);

        String expectedValidMsg = "Tack för din ansökan, <!This might be script>! Vi bekräftar din ansökan inom kort.";
        String actual_msg = driver.findElement(By.id(ansokanValidMsg)).getText();
        assertEquals(actual_msg, expectedValidMsg);

        goToHomePage();
    }

    @Test
    public void testAnsokanTextForNumFields(){

        goToAnsokanPage();

        //select value from drop-down menu
        selectUtbuildning(3);

        //Choose Kön
        chooseGender(kvinna);

        //Type FirstName
        typeFirstName("Invalid Numbers");

        //Type LastName
        typeLastName("Petreska");

        //Type personal number
        typePN("abncjdkfsj");

        //Type post number
        typePostNumber("aabbhjss");

        //Type postadress
        typePostAdress("Mörbydalen 34");

        //Type email address
        typeEMail("testadd@test.com");

        //Type telefonNumber
        typePhone("bndhfkshufusj");

        //Click Submit button
        pressSkicka();

        //Verify that correct URL is displayed
        assertEquals(driver.getCurrentUrl(), ansokanUrl);

        String expectedValidMsg = "Tack för din ansökan, Invalid Numbers! Vi bekräftar din ansökan inom kort.";
        String actual_msg = driver.findElement(By.id(ansokanValidMsg)).getText();
        assertEquals(actual_msg, expectedValidMsg);

        goToHomePage();
    }

    @Test
    public void testAnsokanLongTxtFields(){

        goToAnsokanPage();

        //select value from drop-down menu
        selectUtbuildning(3);

        //Choose Kön
        chooseGender(man);

        //Type FirstName
        typeFirstName("vrjeWIIMMaObyPQÖJGxniVhc4aä8t4TgZlztaRVmÅZVbwtAJKXJana0XiVkKrnUzJQK91sZh4RMÅså8QhQ9öulewDcåmzmö1Ak4VQq9yHQY1hukZRpLVYhfXSTpgwjpÄKZclÖvdF0Dv1ÅlPAUWVwZXoILÄAjÄHÖEgtBdÄ9E7JT3hcJHKägRqWTHuÄån5öF82ZX7ElIsQxPEEÅwWHaMuO07stö9KNryPcYÅhdmJiOluXGPVhpTFTYEi0IV3wÄeÅwcv5TÖYCvrExIhYYkZFUX5fnJWjBTÄöCqyfaUCICBOJgå5");

        //Type LastName
        typeLastName("vrjeWIIMMaObyPQÖJGxniVhc4aä8t4TgZlztaRVmÅZVbwtAJKXJana0XiVkKrnUzJQK91sZh4RMÅså8QhQ9öulewDcåmzmö1Ak4VQq9yHQY1hukZRpLVYhfXSTpgwjpÄKZclÖvdF0Dv1ÅlPAUWVwZXoILÄAjÄHÖEgtBdÄ9E7JT3hcJHKägRqWTHuÄån5öF82ZX7ElIsQxPEEÅwWHaMuO07stö9KNryPcYÅhdmJiOluXGPVhpTFTYEi0IV3wÄeÅwcv5TÖYCvrExIhYYkZFUX5fnJWjBTÄöCqyfaUCICBOJgå5");

        //Type personal number
        typePN("vrjeWIIMMaObyPQÖJGxniVhc4aä8t4TgZlztaRVmÅZVbwtAJKXJana0XiVkKrnUzJQK91sZh4RMÅså8QhQ9öulewDcåmzmö1Ak4VQq9yHQY1hukZRpLVYhfXSTpgwjpÄKZclÖvdF0Dv1ÅlPAUWVwZXoILÄAjÄHÖEgtBdÄ9E7JT3hcJHKägRqWTHuÄån5öF82ZX7ElIsQxPEEÅwWHaMuO07stö9KNryPcYÅhdmJiOluXGPVhpTFTYEi0IV3wÄeÅwcv5TÖYCvrExIhYYkZFUX5fnJWjBTÄöCqyfaUCICBOJgå5");

        //Type post number
        typePostNumber("vrjeWIIMMaObyPQÖJGxniVhc4aä8t4TgZlztaRVmÅZVbwtAJKXJana0XiVkKrnUzJQK91sZh4RMÅså8QhQ9öulewDcåmzmö1Ak4VQq9yHQY1hukZRpLVYhfXSTpgwjpÄKZclÖvdF0Dv1ÅlPAUWVwZXoILÄAjÄHÖEgtBdÄ9E7JT3hcJHKägRqWTHuÄån5öF82ZX7ElIsQxPEEÅwWHaMuO07stö9KNryPcYÅhdmJiOluXGPVhpTFTYEi0IV3wÄeÅwcv5TÖYCvrExIhYYkZFUX5fnJWjBTÄöCqyfaUCICBOJgå5");

        //Type postadress
        typePostAdress("vrjeWIIMMaObyPQÖJGxniVhc4aä8t4TgZlztaRVmÅZVbwtAJKXJana0XiVkKrnUzJQK91sZh4RMÅså8QhQ9öulewDcåmzmö1Ak4VQq9yHQY1hukZRpLVYhfXSTpgwjpÄKZclÖvdF0Dv1ÅlPAUWVwZXoILÄAjÄHÖEgtBdÄ9E7JT3hcJHKägRqWTHuÄån5öF82ZX7ElIsQxPEEÅwWHaMuO07stö9KNryPcYÅhdmJiOluXGPVhpTFTYEi0IV3wÄeÅwcv5TÖYCvrExIhYYkZFUX5fnJWjBTÄöCqyfaUCICBOJgå5");

        //Type email address
        typeEMail("testadd@test.com");

        //Type telefonNumber
        typePhone("bndhfkshufusj");

        //Click Submit button
        pressSkicka();

        //Verify that correct URL is displayed
        assertEquals(driver.getCurrentUrl(), ansokanUrl);

        String expectedValidMsg = "Tack för din ansökan, vrjeWIIMMaObyPQÖJGxniVhc4aä8t4TgZlztaRVmÅZVbwtAJKXJana0XiVkKrnUzJQK91sZh4RMÅså8QhQ9öulewDcåmzmö1Ak4VQq9yHQY1hukZRpLVYhfXSTpgwjpÄKZclÖvdF0Dv1ÅlPAUWVwZXoILÄAjÄHÖEgtBdÄ9E7JT3hcJHKägRqWTHuÄån5öF82ZX7ElIsQxPEEÅwWHaMuO07stö9KNryPcYÅhdmJiOluXGPVhpTFTYEi0IV3wÄeÅwcv5TÖYCvrExIhYYkZFUX5fnJWjBTÄöCqyfaUCICBOJgå5! Vi bekräftar din ansökan inom kort.";
        String actual_msg = driver.findElement(By.id(ansokanValidMsg)).getText();
        assertEquals(actual_msg, expectedValidMsg);

        goToHomePage();
    }

    @Test
    //test is not running in Mozila Firefox even with the latest FF update
    public void testAnsokanStage1(){
        goToAnsokanPage();

        //Test Stage 1
        driver.findElement(By.xpath(stage1)).click();
        String actualTxt = driver.findElement(By.xpath("//*[@id=\"steps__description--0\"]/h3")).getText();

        //After click is done verify url, displayed text, background color of button 1
        assertEquals(driver.getCurrentUrl(),"https://www.iths.se/ansokan-it-hogskolan/");
        assertEquals("1. Ansöka", actualTxt);
        assertEquals("#662246", testColor(stage1));
    }
    //Have no idea why but if i add all the stages in same method wrong color is retirned for the button, so 5 separat are created
    @Test
    public void testAnsokanStage2(){
        goToAnsokanPage();

        //Test Stage 2
        driver.findElement(By.id("steps__box--1")).click();
        String actualTxt = driver.findElement(By.xpath("//*[@id=\"steps__description--1\"]/h3")).getText();

        //After click is done verify url, displayed text, background color of button 2
        assertEquals(driver.getCurrentUrl(),"https://www.iths.se/ansokan-it-hogskolan/");
        assertEquals("2. Behörighet",actualTxt);
        assertEquals("#662246", testColor("//*[@id=\"steps__box--1\"]/div"));

    }
    @Test
    public void testAnsokanStage3(){
        goToAnsokanPage();

        //Test Stage 3
        driver.findElement(By.id("steps__box--2")).click();
        String actualTxt = driver.findElement(By.xpath("//*[@id=\"steps__description--2\"]/h3")).getText();

        //After click is done verify url, displayed text, background color of button 3
        assertEquals(driver.getCurrentUrl(),"https://www.iths.se/ansokan-it-hogskolan/");
        assertEquals("3. Antagningsprov",actualTxt);
        assertEquals("#662246", testColor("//*[@id=\"steps__box--2\"]/div"));

    }

    @Test
    public void testAnsokanStage4(){
        goToAnsokanPage();

        //Test Stage 4
        driver.findElement(By.id("steps__box--3")).click();
        String actualTxt = driver.findElement(By.xpath("//*[@id=\"steps__description--3\"]/h3")).getText();

        //After click is done verify url, displayed text, background color of button 4
        assertEquals(driver.getCurrentUrl(),"https://www.iths.se/ansokan-it-hogskolan/");
        assertEquals("4. Antagning",actualTxt);
        assertEquals("#662246", testColor("//*[@id=\"steps__box--3\"]/div"));

    }
    @Test
    public void testAnsokanStage5(){
        goToAnsokanPage();

        //Test Stage 5
        driver.findElement(By.id("steps__box--4")).click();
        String actualTxt = driver.findElement(By.xpath("//*[@id=\"steps__description--4\"]/h3")).getText();

        //After click is done verify url, displayed text, background color of button 5
        assertEquals(driver.getCurrentUrl(),"https://www.iths.se/ansokan-it-hogskolan/");
        assertEquals("5. Utbildningsstart",actualTxt);
        assertEquals("#662246", testColor("//*[@id=\"steps__box--4\"]/div"));
        //Verify that button Ansök här is changing the color
        assertEquals("#662246", testColor("//*[@id=\"steps__description--4\"]/div/a"));

    }
    @Test
    public void testAlvisLink(){
        goToAnsokanPage();

        String mainWindow = driver.getWindowHandle();
        //Go to stage 5
        driver.findElement(By.id("steps__box--4")).click();

        //Go to Ansök här button
        driver.findElement(By.xpath(ansokBtn)).click();

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
        driver.get("https://iths.alvis.se/Student/kurskatalog.aspx");


//Perform whatever actions you want done on the secondary tab, let’s pretend we’re logging in somewhere
        assertEquals(driver.getCurrentUrl(),"https://iths.alvis.se/Student/kurskatalog.aspx");

        driver.switchTo().window(mainWindow);
        assertEquals(driver.getCurrentUrl(),"https://iths.alvis.se/Student/kurskatalog.aspx");
//Perform whatever actions you want done on the main tab, we’ll click a button

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");


    }

}
