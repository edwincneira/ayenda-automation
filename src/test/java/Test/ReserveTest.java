package Test;

import Pages.SelectCityPage;
import org.testng.annotations.Test;
import Pages.ReservePage;
import static Utils.Constans.*;
public class ReserveTest extends Base{

    @Test
    public void reserve() throws Exception {
        SelectCityPage select = new SelectCityPage(driver);
        ReservePage reserve = new ReservePage(driver);
        select.searchCity("Pereira");
        reserve.howPerson(2, 2);
        reserve.orderBy(PRICE_MORE_LESS);
    }

}
