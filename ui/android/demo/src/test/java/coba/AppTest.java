package coba;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("deviceName", "P0AA003810060900077");
        options.setCapability("automationName", "uiautomator2");
        options.setCapability("platformName", "android");
        options.setCapability("appPackage", "com.swaglabsmobileapp");
        options.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

        // appium2 no longer using /wd/hub
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // login
            WebElement textUsername = driver.findElement(AppiumBy
                    .xpath("//android.view.ViewGroup[@content-desc='test-standard_user']/android.widget.TextView"));
            textUsername.click();

            WebElement buttonLogin = driver
                    .findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']"));
            buttonLogin.click();
        } finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }
}
