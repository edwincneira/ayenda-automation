package Utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

public class FindElement {

    public static void clickElementByiOSNsPredicateString (IOSDriver<IOSElement> driver, String search) throws Exception {
        try {
            driver.findElement(MobileBy.iOSNsPredicateString(search)).click();
        }catch (NoSuchElementException e) {
            System.out.printf(e.getMessage());
            throw new Exception("Ups! we couldn't find this element " + search);
        }
    }

    public static void clickElementByXpath (IOSDriver<IOSElement> driver, String search) throws Exception {
        try {
            driver.findElement(By.xpath(search)).click();
        }catch (NoSuchElementException e) {
            System.out.printf(e.getMessage());
            throw new Exception("Ups! we couldn't find this element " + search);
        }
    }

    public static IOSElement elementsByiOSNsPredicateString (IOSDriver<IOSElement> driver, String search) throws Exception {
        try {
            return driver.findElements(MobileBy.iOSNsPredicateString(search)).get(5);
        }catch (NoSuchElementException | IndexOutOfBoundsException  e) {

        }
        return driver.findElement(By.className("Nothing"));
    }


    public static boolean isVisibleElementByiOSNsPredicateString (IOSDriver<IOSElement> driver, String search) throws Exception {
        try {
            if(driver.findElement(MobileBy.iOSNsPredicateString(search)).isDisplayed()) return true;
        }catch (NoSuchElementException e) {
            System.out.printf(e.getMessage());
            return false;
        }
        return false;
    }

    public static boolean isVisibleElementsByiOSNsPredicateString (IOSDriver<IOSElement> driver, String search) throws Exception {
        try {
            List<IOSElement> list = driver.findElements(MobileBy.iOSNsPredicateString(search));
            if(list.get(5).isDisplayed()) return true;
        }catch (NoSuchElementException | IndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

}
