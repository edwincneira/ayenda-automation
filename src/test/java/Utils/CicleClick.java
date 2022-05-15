package Utils;

import io.appium.java_client.ios.IOSElement;
import static Utils.Time._wait;
public class CicleClick {

    public static void click(IOSElement element, int cicle) throws InterruptedException {
        for (int i=0; i<cicle; i++){
            element.click();
            _wait(1);
        }
    }

}
