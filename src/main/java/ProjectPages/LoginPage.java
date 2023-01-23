package ProjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){PageFactory.initElements(driver,this);}
    @FindBy(name="uid")
    WebElement Name;
    @FindBy(name="password")
    WebElement Password;
    @FindBy(name="btnLogin")
    WebElement login;
    public void setUsername(String username) {
         Name.sendKeys(username);}
    public void setPassword(String password) {
        Password.sendKeys(password);
    }
    public void setLogin() {
         login.click();
    }
}
