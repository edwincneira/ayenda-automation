package Test;

import Utils.Capabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base{

    public static IOSDriver<IOSElement> driver;

    public static String DEVICE_NAME = "iPhone X";
    public static String SERIAL_NAME = "5a40a9ebbdc4e527bdbfe2bd686b6184615e759e";
    public static String VERSION_IPHONE = "12.0";

    @BeforeSuite(alwaysRun = true)
    public static void setup() throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4725/wd/hub");
        DesiredCapabilities capabilitiesIos = Capabilities.get_capabilities_ios(DEVICE_NAME, SERIAL_NAME, VERSION_IPHONE);
        System.out.println("Inicializando Driver");
        driver = new IOSDriver<IOSElement>(url, capabilitiesIos);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Id Sessión, Ayenda App: " + driver.getSessionId());
    }

    @AfterMethod(alwaysRun = true)
    public static void launchApp() {
        driver.launchApp();
    }
    @BeforeMethod()
    public static void closeApp() {
        driver.closeApp();
    }

    @AfterSuite
    public static void close() {
        driver.closeApp();
    }

}
