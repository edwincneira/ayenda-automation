package Test;

import Pages.MyAccountPage;
import Pages.MyTravelsPage;
import Pages.ReservePage;
import Pages.SelectCityPage;
import org.testng.annotations.*;

import static Utils.Constans.PRICE_MORE_LESS;
import static Utils.Time._wait;

public class MainTest extends Base{

    @AfterMethod(alwaysRun = true)
    public static void closeapp() {
        driver.closeApp();
        driver.launchApp();
    }

    @Test(priority = 1)
    public void account() throws InterruptedException, Exception{
        MyAccountPage account = new MyAccountPage(driver);
        account.account();
        account.editProfile("Edwin Neira", "edwinchivata@out.com");
        account.out();
    }

    @Test(priority = 2)
    public void travels() throws Exception {
        MyTravelsPage travel = new MyTravelsPage(driver);
        travel.actualTravels();
        travel.completedTravels();
        travel.canceledTravels();
    }

    @Test(priority = 3)
    public void reserve() throws Exception {
        SelectCityPage select = new SelectCityPage(driver);
        ReservePage reserve = new ReservePage(driver);
        select.searchCity("Pereira");
        reserve.howPerson(2, 2);
        reserve.orderBy(PRICE_MORE_LESS);
    }

    @Test(priority = 4)
    public static void search() throws InterruptedException, Exception{
        SelectCityPage select = new SelectCityPage(driver);
        select.searchCity("Medellín");
        _wait(3);
    }

}
