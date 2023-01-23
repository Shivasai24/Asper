package Tests;

import ProjectPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase1 extends BaseTest {
    @Test
    public void logintest(){
        LoginPage lp = new LoginPage(driver);
        logger.info("Entered the URL");
        lp.setUsername(username);
        logger.info("Entered the Username");
        lp.setPassword(password);
        logger.info("Entered the password");
        lp.setLogin();
        logger.info("Clicked n login button");
        String title=driver.getTitle();
        Assert.assertTrue(title.equals("GTPL Bank Manager HomePage"),"title not matched");
    }
}
