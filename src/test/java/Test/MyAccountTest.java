package Test;

import Pages.MyAccountPage;
import org.testng.annotations.Test;

public class MyAccountTest extends Base{

    @Test
    public void accountTest() throws InterruptedException, Exception{
        MyAccountPage account = new MyAccountPage(driver);
        account.account();
        account.editProfile("Edwin Neira", "edwinchivata@out.com");
        account.out();
    }

}
