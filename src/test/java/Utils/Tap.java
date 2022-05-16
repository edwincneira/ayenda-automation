package Utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;

public class Tap {

    public static void tapByCoordinates(
            int x,
            int y,
            IOSDriver<IOSElement> driver)
    {
        new TouchAction(driver).tap(PointOption.point(x,y)).release().perform();
    }

}
