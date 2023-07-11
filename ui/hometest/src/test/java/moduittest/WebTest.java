package moduittest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest {
    @Test
    public void testMethod() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        // login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(5000);

        // verify
        final String actualUrl = driver.getCurrentUrl();
        final String actualTitle = driver.getTitle();
        final WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        Assert.assertEquals(actualUrl, "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(actualTitle, "Swag Labs");
        Assert.assertEquals(shoppingCart.isDisplayed(), true);

        // end the test
        driver.quit();
    }
}
