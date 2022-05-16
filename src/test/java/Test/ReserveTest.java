package Test;

import Pages.SelectCityPage;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Pages.ReservePage;
import static Utils.Constans.*;
public class ReserveTest extends Base{

    @Parameters("reserve_city")
    @Test(priority = 1)
    public void reserve(@Optional("Bogota") String city) throws Exception {
        SelectCityPage select = new SelectCityPage(driver);
        ReservePage reserve = new ReservePage(driver);
        select.searchCity(city);
        reserve.howPerson(2, 2);
        reserve.orderBy(PRICE_MORE_LESS);
    }

}
