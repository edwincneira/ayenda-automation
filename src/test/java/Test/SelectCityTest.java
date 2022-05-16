package Test;

import Test.Base;
import Pages.SelectCityPage;
import org.testng.annotations.*;

import static Utils.Time._wait;

public class SelectCityTest extends  Base{

    private String city;

    @Factory(dataProvider = "dataMethod")
    public SelectCityTest(String city) {
        this.city = city;
    }

    @DataProvider
    public static Object[][] dataMethod() {
        return new Object[][] {
                { "Santa Marta" },
                { "Armenia" },
                { "Cali" },
                { "Barranquilla" },
                { "Villavicencio" }
        };
    }

    @Test(priority = 1, groups = {"city", "search"})
    public void searchTheCity() throws InterruptedException, Exception{
        SelectCityPage select = new SelectCityPage(driver);
        select.searchCity(city);
        _wait(1);
    }
    @Test(priority = 2, groups = {"city", "select"})
    public void selectTheCity() throws InterruptedException, Exception{
        SelectCityPage select = new SelectCityPage(driver);
        select.selectCity(city);
        _wait(1);
    }

}






