package Tests;

import ProjectPages.AddCustomer;
import ProjectPages.LoginPage;
import org.testng.annotations.Test;

public class Testcase2 extends BaseTest
{
    @Test
    public void AddCustomer()  {
        LoginPage lp=new LoginPage(driver);
        logger.info("Entered thr URL");
        lp.setUsername(username);
        logger.info("Entered the Username");
        lp.setPassword(password);
        logger.info("Entered the password");
        lp.setLogin();
        logger.info("Clicked on login button");


        AddCustomer ac=new AddCustomer(driver);
        ac.setClose();
        ac.setAddCustomer();
        ac.setName(name);
        ac.setGender();
        ac.setDOB("05","24","2000");
        ac.setAddress(Address);
        ac.setCity(city);
        ac.setState(state);
        ac.setPin(pincode);
        ac.setTele(telephone);
        ac.setEmail(email);
        ac.setReset();
    }

}
