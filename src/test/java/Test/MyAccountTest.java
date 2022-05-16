package Test;

import Pages.MyAccountPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyAccountTest extends Base{

    @Parameters({
            "name_1",
            "email_1"
    })
    @Test(priority = 1, groups = { "change_user" })
    public void accountTest1(
            String name,
            String email
    ) throws InterruptedException, Exception{
        MyAccountPage account = new MyAccountPage(driver);
        account.account();
        account.editProfile(name, email);
        account.out();
    }

    @Parameters({
            "name_2",
            "email_2"
    })
    @Test(priority = 2, groups = { "change_user" })
    public void accountTest2(
            String name,
            String email
    ) throws InterruptedException, Exception{
        MyAccountPage account = new MyAccountPage(driver);
        account.account();
        account.editProfile(name, email);
        account.out();
    }

    @Parameters({
            "name_3",
            "email_3"
    })
    @Test(priority = 3, groups = { "change_user" })
    public void accountTest3(
            String name,
            String email
    ) throws InterruptedException, Exception{
        MyAccountPage account = new MyAccountPage(driver);
        account.account();
        account.editProfile(name, email);
        account.out();
    }
}
