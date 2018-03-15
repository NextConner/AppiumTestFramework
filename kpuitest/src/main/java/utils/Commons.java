package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import location.LoginLocation;
import location.SaleLocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import pageObjects.LoginPage;
import pageObjects.SalePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Commons {

    LoginLocation loc;
    LoginPage lgin;
    AndroidDriver<MobileElement> driver;
    SalePage sg;
    Log log = LogFactory.getLog(Commons.class);

    public Commons(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.loc = new LoginLocation();
        this.lgin = new LoginPage(driver);
        this.sg = new SalePage(driver);
    }

    //delete product
    public void deletePro(SalePage sg, String firstProName)throws InterruptedException {
        log.info("try delete product'");
        String getFirstName = sg.listProductName.getAttribute("name").split("\\s")[0];//get first product name only by regex
        log.info("try to print name : " + getFirstName);
        try {
            driver.findElementsByClassName(SaleLocation.PRODUCT_LIST_CLASS).get(0).click();
            sg.anyProductEdit.click();
            TimeUnit.SECONDS.sleep(2);
        } catch(NoSuchElementException e){
            sg.anyProductEdit.click();
        }catch (StaleElementReferenceException s){
            driver.findElementsByClassName(SaleLocation.PRODUCT_LIST_CLASS).get(0).click();
            sg.anyProductEdit.click();
        }
        driver.pressKeyCode(4);
        int x = driver.manage().window().getSize().getWidth() / 2;
        int endY = driver.manage().window().getSize().getHeight();
        log.info("x : " + x + " y :" + endY);
        driver.swipe(x, endY / 2, x, 100, 500);
        sg.productDel.click();
        sg.proDelOk.click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertFalse(sg.listProductName.getAttribute("name").contains(getFirstName));//assert deleted product name
        log.info("complete del");
    }

    //login
    public void login()throws InterruptedException {

        try {
            log.info(sg.shopCar.getAttribute("name"));
            log.info("had login!");
        } catch (NoSuchElementException n) {
            log.info("login util method !");
            String password = "";
            Map<String, String> accountMap = new HashMap<String, String>();
            accountMap.put("13570351393", "zjt3461829");
            accountMap.put("1115785160@qq.com", "zjt3461829ZJT");

                TimeUnit.SECONDS.sleep(3);
                lgin.accountList.click();
                log.info("wait for loading element!");
                TimeUnit.SECONDS.sleep(2);
                List<MobileElement> list = driver.findElements(By.id(LoginLocation.ACCOUNT));
                for (MobileElement mob : list) {
                    // TODO id find account element
                    String account = mob.getText().trim();
                    if (account.equals("13570351393")) {
                        mob.click();
                        lgin.password.sendKeys(accountMap.get(account));
                        lgin.login.click();
                        TimeUnit.SECONDS.sleep(3);
                        Assert.assertNotNull(sg.shopCar);
                        break;
                    }
                }
        }
    }

    //get side menu element
    public int getMenuElement(String LorR) {
        String menuName = "";
        if (LorR == "L") {
            menuName = "left_menu";
        } else {
            menuName = "right_menu";
        }
        MobileElement moEl = null;
        int j = 0;
        String text = "";
        List<MobileElement> list = driver.findElementsByClassName(SaleLocation.ADD_SALE_CLASS);
        for (int i = 0; i < list.size(); i++) {
            try {
                text = list.get(i).getAttribute("contentDescription");//find element content-desc in android
                log.info(text);
                if (text != null && text.trim().equals(menuName)) {
                    j = i;
                } else {
                    continue;
                }
            } catch (StaleElementReferenceException sere) {
                log.info("continue from exception");
                return j;
            }
        }
        return j;
    }

}
