package Pages;

import Pages.Base.BasePage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.FindBy;

import static Utils.FindElement.*;
import static Utils.Scroll.scroll;
import static Utils.Time._wait;
import static Utils.Tap.tapByCoordinates;
import static Utils.Constans.*;

public class SelectCityPage extends BasePage {

    public SelectCityPage(IOSDriver<IOSElement> driver){
        super(driver);
    }

    ReservePage reserve = new ReservePage(driver);

    //ByIosPredicableString
    String iosPredicableScreenCity = "label CONTAINS '%s' AND accessible == false AND enabled == true AND visible == true AND index == 1";
    String xpathBtnCity = "(//XCUIElementTypeOther[@name=\"%s\"])[3]";

    //By Xpath
    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"\uF505 Busca hoteles, barrios o puntos de referencia \uF223\"]")
    private IOSElement btnSearchPointsReference;

    public void selectCity(String city) throws InterruptedException, Exception {
        String element = String.format(iosPredicableScreenCity, city);
        _wait(3);
        int i=0;
        while(!isVisibleElementsByiOSNsPredicateString(driver, element)){
            scroll(driver, 348, 264, 160, 264);
            if(i==40) break;
            i++;
        }
        IOSElement btnCity = elementsByiOSNsPredicateString(driver, element);
        Point coordinates = btnCity.getLocation();
        int _x = coordinates.getX() + 8;
        int _y = coordinates.getY() - 8;
        tapByCoordinates(_x, _y, driver);
        _wait(1);
        reserve.howPerson(1, 1);
        reserve.orderBy(QUALIFICATION);
    }

    public void searchCity(String city) throws Exception, InterruptedException {
        _wait(3);
        btnSearchPointsReference.click();
        _wait(1);
        btnSearchPointsReference.click();
        btnSearchPointsReference.sendKeys(city);
        _wait(2);
        clickElementByXpath(driver, String.format(xpathBtnCity, city));
        _wait(2);
        reserve.howPerson(1, 2);
        reserve.orderBy(MORE_SEARCH);
    }
}
