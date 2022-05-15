package Pages;

import Pages.Base.BasePage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.FindBy;

import java.util.MissingFormatArgumentException;

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

    String iosPredicableBtnReserve = "name CONTAINS 'Reserva' AND accessible == true";
    String iosPredicableBtnOrders = "name CONTAINS '%s' AND accessible == true";

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
        _wait(3);
        try {
            btnOrder.click();
        } catch (MissingFormatArgumentException e) {
            _wait(1);
            btnOrder.click();
        }
        _wait(2);
        switch (order){
            case QUALIFICATION:
                clickElementByiOSNsPredicateString(driver, "name CONTAINS 'Calificación' AND accessible == true");
                break;
            case MORE_SEARCH:
                clickElementByiOSNsPredicateString(driver, "name CONTAINS 'Los más buscados' AND accessible == true");
                break;
            case PRICE_LESS_MORE:
                clickElementByiOSNsPredicateString(driver, "name CONTAINS 'Precio de mayor a menor' AND accessible == true");
                break;
            case PRICE_MORE_LESS:
                clickElementByiOSNsPredicateString(driver, "name CONTAINS 'Precio de menor a mayor' AND accessible == true");
                break;
            default:
                System.out.println("Don't exist the order");
        }
        _wait(3);
    }
}
