package moduittest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.HomePagePO;
import page_objects.LoginPO;

public class WebTest {
    @Test
    public void testLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        // login
        driver.findElement(LoginPO.inputUserName).sendKeys("standard_user");
        driver.findElement(LoginPO.inputPassword).sendKeys("secret_sauce");
        driver.findElement(LoginPO.buttonLogin).click();

        // debugging purpose
        Thread.sleep(2000);

        // verify home page
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        Assert.assertEquals(driver.findElement(HomePagePO.buttonShoppingCart).isDisplayed(), true);
        Assert.assertEquals(driver.findElement(HomePagePO.buttonMenu).isDisplayed(), true);
        Assert.assertEquals(driver.findElement(HomePagePO.dropdownProductSort).isDisplayed(), true);
        Assert.assertEquals(driver.findElement(HomePagePO.textLogo).getText(), "Swag Labs");

        // end the test
        driver.quit();
    }
}
