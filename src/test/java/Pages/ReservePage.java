package Pages;

import Pages.Base.BasePage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.FindBy;

import static Utils.CicleClick.click;
import static Utils.Constans.*;
import static Utils.Constans.PRICE_MORE_LESS;
import static Utils.FindElement.clickElementByiOSNsPredicateString;
import static Utils.Tap.tapByCoordinates;
import static Utils.Time._wait;

public class ReservePage extends BasePage {

    public ReservePage(IOSDriver<IOSElement> driver) {
        super(driver);
    }

    //ByIosPredicableString
    String iosPredicableBtnReserve = "name CONTAINS 'Reserva' AND accessible == true";
    String iosPredicableBtnOrders = "name CONTAINS '%s' AND accessible == true";

    //By Xpath
    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"Continúa y selecciona las fechas\"]")
    private IOSElement btnContinueDates;

    @FindBy(xpath = "(//XCUIElementTypeOther[@name=\"Ordenar \uE978\"])[2]")
    private IOSElement btnOrder;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name=\"\uF055\"])[1]")
    private IOSElement btnMoreAdult;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name=\"\uF055\"])[2]")
    private IOSElement btnMoreChildren;

    @FindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF142\"])[2]")
    private IOSElement btnBack;

    public void reserve() throws InterruptedException, Exception {
        _wait(3);
        clickElementByiOSNsPredicateString(driver, iosPredicableBtnReserve);
        _wait(1);
        btnBack.click();
        _wait(2);
    }

    public void howPerson(int adult, int children) throws InterruptedException{
        click(btnMoreAdult, adult);
        _wait(1);
        click(btnMoreChildren, children);
        _wait(1);
        btnContinueDates.click();
        _wait(2);
        tapByCoordinates(181, 632, driver);
    }

    public void orderBy(String order) throws InterruptedException, Exception {
        _wait(2);
        btnOrder.click();
        _wait(1);
        switch (order){
            case QUALIFICATION:
                clickElementByiOSNsPredicateString(driver, String.format(iosPredicableBtnOrders, QUALIFICATION));
                break;
            case MORE_SEARCH:
                clickElementByiOSNsPredicateString(driver, String.format(iosPredicableBtnOrders, MORE_SEARCH));
                break;
            case PRICE_LESS_MORE:
                clickElementByiOSNsPredicateString(driver, String.format(iosPredicableBtnOrders, PRICE_LESS_MORE));
                break;
            case PRICE_MORE_LESS:
                clickElementByiOSNsPredicateString(driver, String.format(iosPredicableBtnOrders, PRICE_MORE_LESS));
                break;
            default:
                System.out.println("Don't exist the order");
        }
        _wait(3);
    }
}
