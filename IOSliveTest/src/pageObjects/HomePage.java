package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;

public class HomePage {

	public IOSDriver driver;

	public HomePage(IOSDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = Loc.USER_INFO)
	public WebElement userInfo;

	@FindBy(id = Loc.START_LIVEID)
	public WebElement startLive;

}
