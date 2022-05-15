package Test;

import Pages.MyTravelsPage;
import org.testng.annotations.Test;

public class MyTravelsTest extends Base{

    @Test(priority = 1, groups = {"navigation"})
    public void test() throws Exception {
        MyTravelsPage travel = new MyTravelsPage(driver);
        travel.actualTravels();
        travel.completedTravels();
        travel.canceledTravels();
    }

}
