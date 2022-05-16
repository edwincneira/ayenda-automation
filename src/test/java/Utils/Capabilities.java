package Utils;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Capabilities {

    public static DesiredCapabilities get_capabilities_ios(String deviceName, String serialName, String version) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", version);
        capabilities.setCapability("udid", serialName);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("bundleId", "com.ayendaapp");  //com.merqueo.user.ios.Merqueo com.ayendaapp
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("newCommandTimeout", "95000");
        return capabilities;
    }

}
