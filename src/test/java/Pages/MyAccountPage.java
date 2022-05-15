package Pages;

import Pages.Base.BasePage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.FindBy;

import static Utils.FindElement.clickElementByiOSNsPredicateString;
import static Utils.Scroll.scrollByRange;
import static Utils.Time._wait;
import static Utils.Scroll.scroll;

public class MyAccountPage extends BasePage {

    public MyAccountPage (IOSDriver<IOSElement> driver) {
        super(driver);
    }
    String iosPredicableBtnMyAccount = "name CONTAINS 'Mi Cuenta' AND accessible == true";
    String iosPredicableBtnOut = "name CONTAINS 'Cerrar Sesión' AND accessible == true AND enabled == true";
    String iosPredicableBtnCanceled = "name CONTAINS 'Cancelar' AND accessible == true AND enabled == true";
    String iosPredicableBtnAccept = "name CONTAINS 'Aceptar' AND accessible == true AND enabled == true";

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"\uF044 Editar perfil\"]")
    private IOSElement btnEditProfile;

    @FindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF007\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    private IOSElement txtUser;

    @FindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF119\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    private IOSElement txtEmail;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"Guardar\"]")
    private IOSElement btnSave;

    public void account() throws InterruptedException, Exception {
        _wait(3);
        clickElementByiOSNsPredicateString(driver, iosPredicableBtnMyAccount);
        _wait(2);
    }

    public void editProfile(String name, String email) throws InterruptedException, Exception {
        btnEditProfile.click();
        _wait(2);
        txtUser.click();
        _wait(1);
        txtUser.clear();
        _wait(3);
        txtUser.sendKeys(name);
        _wait(2);
        txtEmail.click();
        _wait(1);
        txtEmail.clear();
        _wait(3);
        txtEmail.sendKeys(email);
        _wait(3);
        btnSave.click();
        btnSave.click();
        _wait(7);
    }

    public void out() throws InterruptedException, Exception {
        scrollByRange(driver, 0.5, 0.6, 0.5, 0.5);
        clickElementByiOSNsPredicateString(driver, iosPredicableBtnOut);
        _wait(2);
        clickElementByiOSNsPredicateString(driver, iosPredicableBtnCanceled);
        _wait(2);
        clickElementByiOSNsPredicateString(driver, iosPredicableBtnOut);
        _wait(2);
        //clickElementByiOSNsPredicateString(driver, iosPredicableBtnAccept);
        //_wait(5);
    }

}
