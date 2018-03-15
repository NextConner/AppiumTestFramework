package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import location.Set;
import location.UILocation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TagPage {


    public AndroidDriver<MobileElement> driver;

    public TagPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = UILocation.SETTING)
    public WebElement setting;
    @FindBy(id = UILocation.TAG_SETTING)
    public WebElement tagSetting;
    @FindBy(className = UILocation.ADD_TAG_CALSS)
    public WebElement addTag;//find by element attribute
    @FindBy(id = UILocation.ADD_TAG)
    public WebElement tagName;
    @FindBy(id = UILocation.SURE_ADD)
    public WebElement sureAddTag;
    @FindBy(id = UILocation.HOME)
    public WebElement home;
}
