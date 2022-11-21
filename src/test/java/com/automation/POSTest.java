package com.automation;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class POSTest {
    private static WindowsDriver PosSession = null;

    @BeforeClass
    public static void setUp() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app","C:\\Program Files (x86)\\Intercard Inc\\iCashier\\AppStart.exe");
            capabilities.setCapability("PlatformName","Windows");
            capabilities.setCapability("deviceName","WindowsPC");
            PosSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            PosSession.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginTest() {
        
        PosSession.findElementByAccessibilityId("label1").sendKeys("Vipra");
        PosSession.findElementByAccessibilityId("label2").sendKeys("Vipra1080");
        PosSession.findElementByAccessibilityId("button5").click();
    }

    @Test
    public void placeOrderTest() {

        PosSession.findElementByAccessibilityId("buttonB2_0").click();   //Kids Cheese Pizza
        PosSession.findElementByAccessibilityId("buttonB0_0").click();   //Extra cheese
        PosSession.findElementByAccessibilityId("buttonA3").click();     //Back
        PosSession.findElementByAccessibilityId("buttonB3_0").click();   //Supreme Pizza
        PosSession.findElementByAccessibilityId("ctl3dPushButton3").click(); //Tender
        PosSession.findElementByAccessibilityId("btnCash").click();
        PosSession.findElementByAccessibilityId("btnCash10").click();
        PosSession.findElementByAccessibilityId("btnSaleAmount").click();

    }

    @Test
    public void clearCard() {

        PosSession.findElementByAccessibilityId("button6").click();
        PosSession.findElementByAccessibilityId("ButtonClearCards").click();
        PosSession.findElementByAccessibilityId("pictureBox1").click();
        PosSession.findElementByAccessibilityId("btn7").click();
        PosSession.findElementByAccessibilityId("btn0").click();
        PosSession.findElementByAccessibilityId("button1").click();
        PosSession.findElementByAccessibilityId("ButtonClearCard").click();

    }

    @Test
    public void accountTest() {

        PosSession.findElementByName("Account").click();




    }



}
