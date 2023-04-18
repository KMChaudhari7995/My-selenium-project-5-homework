package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";


    @Before
    public void setUp()
    {
        openBrowser(baseUrl);//opening the browser
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.linkText("Sign In")).click();// finding the sign in element and clicking the same link
        String expectedMessage = "Welcome Back!";//verifying welcome back is displayed or not
        WebElement actualMessage = driver.findElement(By.xpath("//h2[@class='page__heading']"));//finding the Actual message element
        String actualMessage1 = actualMessage.getText();//Storing the value in Actual message String
        //System.out.println(actualMessage1);
        Assert.assertEquals("Error Message is not Displayed", expectedMessage, actualMessage1);//comparing the both element
    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();// finding the sign in element and clicking the same link
        driver.findElement(By.id("user[email]")).sendKeys("Prime1234@gmail.com");  //finding and entering invalid username and password
        driver.findElement(By.id("user[password]")).sendKeys("Prime1234");  //finding and entering invalid username and password
        driver.findElement(By.xpath("//button[contains(@class,'button button-primary g-recaptcha')]")).click();   //finding sign in button element and clicking the button
        String expectedMessage = "Invalid email or password."; //verifying Invalid email or password is displayed or not
        WebElement actualMessage = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        //System.out.println(actualMessage);
        String actualMessageText = actualMessage.getText();
        Assert.assertEquals("Error message is not displayed", expectedMessage, actualMessageText);//comparing the both element value


    }

}
