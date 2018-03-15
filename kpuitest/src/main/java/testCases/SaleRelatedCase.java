package testCases;

import initAppium.AndroidDeviceDriverInit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import location.SaleLocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import pageObjects.SalePage;
import pageObjects.TagPage;
import utils.Commons;

import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;


@Test
public class SaleRelatedCase {
    public AndroidDriver<MobileElement> driver;
    public AndroidDeviceDriverInit addi;
    public TagPage ta;
    public SalePage sg;
    public LoginPage lg;
    boolean flag = false;
    Commons common;
    Log log = LogFactory.getLog(DemoCase.class);

    @BeforeClass
    public void setUp() {
        try {
            this.addi = new AndroidDeviceDriverInit();
            this.driver = addi.setUpAppium();
            this.lg = new LoginPage(driver);
            this.ta = new TagPage(driver);
            this.common = new Commons(driver);
            this.sg = new SalePage(driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeTest
    public void beforeTe() {
        log.info("start");
    }


    @Test(enabled = false)
    public void testAddNewProduct() throws InterruptedException {

        common.login();
        Assert.assertNotNull(sg.shopCar);
        driver.findElementsByClassName(SaleLocation.ADD_SALE_CLASS).get(common.getMenuElement("R")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.pressKeyCode(4);//hide keyboard
        sg.productName.sendKeys("测试商品");
        sg.productNum.sendKeys("100");
        sg.productBrand.sendKeys("测试");
        sg.productLocator.sendKeys("零三");
        sg.productUnit.clear();
        sg.productUnit.sendKeys("位");
        driver.pressKeyCode(4);
        sg.productWholeSalePrice.sendKeys("100");
        sg.productRetailPrice.sendKeys("200");
        sg.productCost.sendKeys("50");
        //sg.productSave.click();
        driver.findElementsByClassName("android.widget.TextView").get(1).click();
        sg.endEditProduct.click();
        TimeUnit.SECONDS.sleep(3);
        Assert.assertNotNull(sg.shopCar);
        MobileElement me = driver.findElementById("xyz.kptech:id/tv_product_title");
        Assert.assertTrue(me.getAttribute("name").contains("测试商品"));
        log.info("add product success");
        log.info("end test");
    }

    @Test
    public void createOrder()throws InterruptedException {
        log.info("test create order");
        common.login();
        String getFirstName = sg.listProductName.getAttribute("name").split("\\s")[0];
        //getFirstName = getFirstName.split("\\s")[0];
        common.deletePro(sg,getFirstName);
        log.info("delete pro");

    }

    @AfterTest
    public void afterTes() {
        log.info(" : has end!");
    }

    @AfterClass
    public void tearDown() {
        //quit driver
        if (driver != null) {
            driver.quit();
        }
        //stop server
        if (addi.getService().isRunning()) {
            addi.getService().stop();
        }
    }
}
