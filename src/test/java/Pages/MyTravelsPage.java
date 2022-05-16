package Pages;

import Pages.Base.BasePage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import static Utils.FindElement.clickElementByiOSNsPredicateString;
import static Utils.Time._wait;
import static Utils.Scroll.scrollByRange;

public class MyTravelsPage extends BasePage {

    public MyTravelsPage (IOSDriver<IOSElement> driver) {
        super(driver);
    }

    //ByIosPredicableString
    String iosPredicableBtnMyTravel = "name CONTAINS 'Mis Viajes' AND accessible == true";
    String iosPredicableBtnActualTravels = "name CONTAINS 'Actuales' AND accessible == true";
    String iosPredicableBtnCompletedTravels = "name CONTAINS 'Finalizados' AND accessible == true";
    String iosPredicableBtnCanceledTravels = "name CONTAINS 'Cancelados' AND accessible == true";
    String iosPredicableBtnReserve = "name CONTAINS 'Reserva ya' AND accessible == true";

    public void baseNavigator(String section) throws Exception {
        clickElementByiOSNsPredicateString(driver, iosPredicableBtnMyTravel);
        _wait(1);
        clickElementByiOSNsPredicateString(driver, section);
        _wait(1);
        scrollByRange(driver, 0.5, 0.6, 0.5, 0.4);
        clickElementByiOSNsPredicateString(driver, iosPredicableBtnReserve);
        _wait(1);
    }

    public void actualTravels() throws Exception{
        baseNavigator(iosPredicableBtnActualTravels);
    }

    public void completedTravels() throws Exception {
        baseNavigator(iosPredicableBtnCompletedTravels);
    }

    public void canceledTravels() throws Exception{
        baseNavigator(iosPredicableBtnCanceledTravels);
    }

}
