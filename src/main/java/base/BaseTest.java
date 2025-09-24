//package base;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.*;
//import utils.DriverManager;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class BaseTest {
//
//    @BeforeMethod
//    public void setUp() throws MalformedURLException {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("deviceName", "emulator-5554");
//        caps.setCapability("automationName", "UiAutomator2");
//        caps.setCapability("appPackage", "com.credobusiness");
//        caps.setCapability("appActivity", "com.credobusiness.MainActivity");
//
//        AppiumDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
//        DriverManager.setDriver(driver);
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        DriverManager.getDriver().quit();
//    }
//
//}
