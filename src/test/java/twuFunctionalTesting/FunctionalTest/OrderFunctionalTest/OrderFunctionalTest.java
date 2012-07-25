package twuFunctionalTesting.FunctionalTest.OrderFunctionalTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class OrderFunctionalTest {

    WebDriver driver = new FirefoxDriver();

    //on  new form submit check the show form is displayed
    @Test
    public void SubmitForm(){

        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/twuFunctionalTesting/order/new");
        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("Meaghan");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("mlewis@thoughtworks.com");
        WebElement item = driver.findElement(By.id("items"));
        item.sendKeys("To Kill A Mockingbird");
        WebElement submit = driver.findElement(By.name("submitButton"));
        submit.submit();
        driver.close();

        assertNotSame(name,email);
    }


}
