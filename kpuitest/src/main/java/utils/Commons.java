package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import location.LoginLocation;
import location.SaleLocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
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

    //login
    public boolean login(boolean result) {
        if (result == true) {
            log.info("has login");
            return result;
        }
        log.info("login util method !");
        String password = "";
        Map<String, String> accountMap = new HashMap<String, String>();
        accountMap.put("13570351393", "zjt3461829");
        accountMap.put("1115785160@qq.com", "zjt3461829ZJT");
        try {
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
                    result = true;
                    break;
                }
            }
            if (sg.shopCar.getAttribute("name") != null) {
                result = true;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    //get side menu element
    public MobileElement getMenuElement(String LorR) {
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
            //log.info(mob.getAttribute("contentDescription"));
            try {
                text = list.get(i).getAttribute("contentDescription");//find element content-desc in android
                log.info(text);
                if (text != null && text.trim().equals(menuName)) {
                    j = i;
                    moEl = list.get(i);
                    break;
                } else {
                    continue;
                }
            } catch (StaleElementReferenceException sere) {
                moEl = list.get(i);
            }
        }
        return moEl;
    }

}
