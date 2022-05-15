package Test;

import Pages.SelectCityPage;
import org.testng.annotations.Test;
import static Utils.Time._wait;

public class SelectCityTest extends Base{

    @Test(priority = 1)
    public static void search() throws InterruptedException, Exception{
        SelectCityPage select = new SelectCityPage(driver);
        select.searchCity("Medellín");
        _wait(3);
    }
}
