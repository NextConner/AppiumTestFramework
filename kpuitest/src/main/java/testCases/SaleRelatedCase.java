package testCases;

import initAppium.AndroidDeviceDriverInit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import location.SaleLocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import pageObjects.OrderPage;
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
    public OrderPage op;
    boolean flag = false;
    Commons common;
    Log log = LogFactory.getLog(SettingRelatedCase.class);

    @BeforeClass
    public void setUp() {
        try {
            this.addi = new AndroidDeviceDriverInit();
            this.driver = addi.setUpAppium();
            this.lg = new LoginPage(driver);
            this.ta = new TagPage(driver);
            this.common = new Commons(driver);
            this.sg = new SalePage(driver);
            this.op = new OrderPage(driver);
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
        //driver.findElementsByClassName(SaleLocation.ADD_SALE_CLASS).get(common.getMenuElement("R")).click();
        try {
            driver.findElementsByClassName(SaleLocation.ADD_SALE_CLASS).get(2).click();
        } catch (StaleElementReferenceException s) {
            log.info("catch that  element has exp");
            driver.findElementsByClassName(SaleLocation.ADD_SALE_CLASS).get(1).click();
        }
        //get(common.getMenuElement("R")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.pressKeyCode(4);//hide keyboard
        sg.productUnit.sendKeys("位");
        driver.pressKeyCode(4);
        sg.productWholeSalePrice.sendKeys("100");
        sg.productRetailPrice.sendKeys("200");
        sg.productCost.sendKeys("50");
        //sg.productSave.click();
        if (driver.findElementsByClassName("android.widget.RelativeLayout").size() >= 2) {
            driver.findElementsByClassName("android.widget.RelativeLayout").get(1).click();
        } else {
            log.info("find again !");
            driver.findElementsByClassName("android.widget.RelativeLayout").get(1).click();
        }
        try {
            sg.endEditProduct.click();
        } catch (NoSuchElementException ns) {
            log.info("recovery form exception first!");
            TimeUnit.SECONDS.sleep(1);
            sg.endEditProduct.click();
        }
        TimeUnit.SECONDS.sleep(2);
        Assert.assertNotNull(sg.shopCar);
        MobileElement me = driver.findElementById("xyz.kptech:id/tv_product_title");
        Assert.assertTrue(me.getAttribute("name").contains("测试商品"));
        log.info("add product success and del new prod after add it");
        TimeUnit.SECONDS.sleep(2);
        String getFirstName = sg.listProductName.getAttribute("name").split("\\s")[0];
        //getFirstName = getFirstName.split("\\s")[0];
        common.deletePro(sg, getFirstName);
        log.info("delete pro");
        log.info("end test");
    }

    @Test(enabled = true)
    public void createOrder() throws InterruptedException {
        log.info("test create order");
        int j = 0;
        common.login();
        int gettedProNum = driver.findElementsById(SaleLocation.LIST_PRODUCT_NAME).size();// get pro num by title
        log.info("getted pro num  :" + gettedProNum);
        for (int i = 0; i < gettedProNum; i++) {
            try {
                driver.findElementsById(SaleLocation.LIST_PRODUCT_NAME).get(i).click();
                op.createAnOrder(op, "", "10", "test create order");
                TimeUnit.SECONDS.sleep(2);
            } catch (StaleElementReferenceException se) {
                TimeUnit.SECONDS.sleep(2);
                driver.findElementsById(SaleLocation.LIST_PRODUCT_NAME).get(i).click();
                op.createAnOrder(op, "", "10", "test create order");
                log.info("added pro " + i + "times！");
            }
            j = i;
        }
        //compare the num of pro
        Integer carNum = Integer.valueOf(sg.shopCarTotal.getAttribute("name"));
        Assert.assertEquals(Integer.valueOf(j), carNum);
        sg.shopCar.click();
        // TODO compare the total price and num in shopCar

        sg.orderCheckout.click();
        TimeUnit.SECONDS.sleep(2);
        String totalMoney=op.orderTotalMoney.getAttribute("name").trim();
        String totalReceiveable=op.orderTotalReceivable.getAttribute("name").trim();
        //String totaReceived=op.orderTotalReceived.getAttribute("name").trim();
        Assert.assertEquals(totalMoney,totalReceiveable);
        op.orderTotalReceived.click();
        //TODO Compare two price
        op.anySave.click();
        TimeUnit.SECONDS.sleep(3);
        sg.order.click();
        //TODO Compare customer name
        String customerName=sg.customerName.getAttribute("name").trim();


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
