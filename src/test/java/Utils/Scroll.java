package Utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class Scroll {

    public static void scroll(
            IOSDriver<IOSElement> driver,
            int init_x,
            int init_y,
            int final_x,
            int final_y)
    {
        new TouchAction(driver).press(PointOption.point(init_x, init_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(final_x, final_y))
                .release().perform();
    }

    public static void scrollByRange(
            IOSDriver<IOSElement> driver,
            double init_x,
            double init_y,
            double final_x,
            double final_y)
    {
        Dimension dimension = driver.manage().window().getSize();
        int start_x = (int) (dimension.width * init_x);
        int start_y = (int) (dimension.height * init_y);
        int end_x = (int) (dimension.width * final_x);
        int end_y = (int) (dimension.height * final_y);
        new TouchAction(driver).press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y))
                .release().perform();
    }
}
