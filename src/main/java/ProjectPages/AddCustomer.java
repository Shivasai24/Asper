package ProjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
    WebDriver driver;

    public AddCustomer(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="dismiss-button")
    WebElement close;

    @FindBy(xpath="//a[@href='addcustomerpage.php']")
    WebElement AddCustomer;
    @FindBy(id="dismiss-button")
    WebElement dismiss;
    @FindBy(name="name")
    WebElement Name;
    @FindBy(name = "rad1")
    WebElement Gender;
    @FindBy(id = "dob")
    WebElement DOB;
    @FindBy(name = "addr")
    WebElement Address;
    @FindBy(name="city")
    WebElement City;
    @FindBy(name = "state")
    WebElement State;
    @FindBy(name = "pinno")
    WebElement Pin;
    @FindBy(name = "telephoneno")
    WebElement Tele;
    @FindBy(name = "emailid")
    WebElement Email;
    @FindBy(name="res")
    WebElement Reset;

    public void setClose(){
        try {
            close.click();
        }
        catch (Exception e)
        {}

    }
    public void setAddCustomer() {
        AddCustomer.click();
    }

    public void setDismiss() {
        try{
            dismiss.click();
        }
        catch (Exception e){}

    }

    public void setName(String name) {
        Name.sendKeys(name);
    }
    public void setGender() {
            Gender.click();
        }
    public void setDOB (String mm, String dd, String yy){
            DOB.sendKeys(mm);
            DOB.sendKeys(dd);
            DOB.sendKeys(yy);
    }
    public void setAddress(String address) {
        Address.sendKeys(address);
    }
    public void setCity(String city){
        City.sendKeys(city);
    }
    public void setState(String state) {
        State.sendKeys(state);
    }
    public void setPin(String pin) {
        Pin.sendKeys(pin);
    }
    public void setTele(String tele) {
        Tele.sendKeys(tele);
    }
    public void setEmail(String email) {
        Email.sendKeys(email);
    }
    public void setReset() {
        Reset.click();
    }
}


