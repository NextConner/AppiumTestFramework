package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import location.LoginLocation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public AndroidDriver<MobileElement> driver;

    public LoginPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //element
    @FindBy(id= LoginLocation.ACCOUNT_LIST)
    public WebElement accountList;
    @FindBy(id=LoginLocation.PASSWORD)
    public WebElement password;
    @FindBy(id=LoginLocation.REMEMBER_PASSWORD)
    public WebElement  rememberPass;
    @FindBy(id=LoginLocation.LOGIN)
    public WebElement login;

}
