package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import location.SaleLocation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalePage {

    public AndroidDriver<MobileElement> driver;

    public SalePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id= SaleLocation.SHOP_CAR)
    public WebElement shopCar;
    @FindBy(id=SaleLocation.P_NAME)
    public WebElement productName;
    @FindBy(id=SaleLocation.P_NUM)
    public WebElement productNum;
    @FindBy(id=SaleLocation.P_BRAND)
    public WebElement productBrand;
    @FindBy(id=SaleLocation.P_LOCATOR)
    public WebElement productLocator;
    @FindBy(id=SaleLocation.P_STAND)
    public WebElement productStand;
    @FindBy(id=SaleLocation.P_UNIT)
    public WebElement productUnit;
    @FindBy(id=SaleLocation.P_WHOLE_SALE_PRICE)
    public WebElement productWholeSalePrice;
    @FindBy(id=SaleLocation.P_RETAIL_PRICE)
    public WebElement productRetailPrice;
    @FindBy(id=SaleLocation.P_ADD_UNIT)
    public WebElement productAddUnit;
    @FindBy(id=SaleLocation.P_COST)
    public WebElement productCost;
    @FindBy(id=SaleLocation.P_TAG)
    public WebElement productTag;
    @FindBy(id=SaleLocation.P_DETAIL_TAG)
    public WebElement productDetailTag;
    @FindBy(name=SaleLocation.P_SAVE_TEXT)
    public WebElement productSave;
    @FindBy(id=SaleLocation.P_EDIT_BACK)
    public WebElement endEditProduct;











}
