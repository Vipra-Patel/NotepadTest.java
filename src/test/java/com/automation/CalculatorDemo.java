package com.automation;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculatorDemo {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        WindowsDriver driver = null;

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.findElement(By.name("One")).click();
        driver.findElement(By.name("Plus")).click();
        driver.findElement(By.name("Nine")).click();
        driver.findElement(By.name("Equals")).click();

        String result = driver.findElementByAccessibilityId("CalculatorResults").getText();
        System.out.println(result);

        driver.findElementByName("Eight").click();
        driver.findElementByName("Multiply by").click();
        driver.findElementByName("Eight").click();
        driver.findElementByName("Equals").click();

        String result1 = driver.findElementByAccessibilityId("CalculatorResults").getText();
        System.out.println(result1);

        driver.findElementByName("Nine").click();
        driver.findElementByName("Minus").click();
        driver.findElementByName("Five").click();
        driver.findElementByName("Equals").click();

        String result2 = driver.findElementByAccessibilityId("CalculatorResults").getText();
        System.out.println(result2);

        Actions action = new Actions(driver);
        driver.findElementByName("Open Navigation").click();
        action.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();

        Thread.sleep(2000);

        driver.findElementByName("Open Navigation").click();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();


        driver.close();




    }

}