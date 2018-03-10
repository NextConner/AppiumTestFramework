package testCases;

import initAppium.AndroidDeviceDriverInit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import location.SaleLocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.SalePage;
import pageObjects.TagPage;
import utils.Commons;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Test
public class SaleRelatedCase {
    public AndroidDriver<MobileElement> driver;
    public AndroidDeviceDriverInit addi;
    public TagPage ta;
    public SalePage sg;
    boolean flag = false;
    Commons common;
    Log log = LogFactory.getLog(DemoCase.class);

    @BeforeClass
    public void setUp() {
        try {
            this.addi = new AndroidDeviceDriverInit();
            this.driver = addi.setUpAppium();
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

    @Test(enabled =true)
    public void testAddNewProduct() throws InterruptedException {
        if (null == sg.shopCar) {
            log.info("not login！");
            flag = common.login(flag);
        } else {
            flag = true;
            log.info("had login");
        }
        Assert.assertNotNull(sg.shopCar);
        MobileElement mob=common.getMenuElement("R");
        mob.click();
//        String text = "";
//        List<MobileElement> list = driver.findElementsByClassName(SaleLocation.ADD_SALE_CLASS);
//        for (int i = 0; i < list.size(); i++) {
//            //log.info(mob.getAttribute("contentDescription"));
//            try {
//                text = list.get(i).getAttribute("contentDescription");//find element content-desc in android
//                log.info(text);
//                if (text != null && text.trim().equals("right_menu")) {
//                    log.info("find it!");
//                    list.get(i).click();
//                    break;
//                } else {
//                    continue;
//                }
//            } catch (StaleElementReferenceException sere) {
//                list.get(i).click();
//                break;
//            }
//        }
        TimeUnit.SECONDS.sleep(2);
        driver.pressKeyCode(4);
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
        MobileElement me=driver.findElementById("xyz.kptech:id/tv_product_title");
        Assert.assertTrue(me.getAttribute("name").contains("测试商品"));
        log.info("add product success");
        log.info("end test");
    }

    @Test
    public void createOrder(){
        log.info("test create order");
    }

    @AfterTest
    public void afterTes() {
        log.info(" : has end!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
