package Test;

import Utils.Capabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base{

    public static IOSDriver<IOSElement> driver;

    @BeforeSuite
    public static void setup() throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4725/wd/hub");
        DesiredCapabilities capabilitiesIos = Capabilities.get_capabilities_ios("iPhone X", "5a40a9ebbdc4e527bdbfe2bd686b6184615e759e", "12.0");
        driver = new IOSDriver<IOSElement>(url, capabilitiesIos);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public static void close() {
        driver.closeApp();
    }

}
