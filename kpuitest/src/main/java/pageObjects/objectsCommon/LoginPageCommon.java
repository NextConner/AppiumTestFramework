package pageObjects.objectsCommon;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import location.LoginLocation;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import pageObjects.LoginPage;
import pageObjects.SalePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginPageCommon {

    Log log = LogFactory.getLog(LoginPageCommon.class);

    public void login(SalePage sg, LoginPage login, AndroidDriver<MobileElement> driver) throws InterruptedException {

        try {
            isLogin(sg);
        } catch (NoSuchElementException n) {
            log.info("login util method !");
            String password = "";
            Map<String, String> accountMap = new HashMap<String, String>();
            accountMap.put("13570351393", "zjt3461829");
            accountMap.put("1115785160@qq.com", "zjt3461829ZJT");
            TimeUnit.SECONDS.sleep(3);
            login.accountList.click();
            log.info("wait for loading element!");
            TimeUnit.SECONDS.sleep(2);
            List<MobileElement> list = driver.findElements(By.id(LoginLocation.ACCOUNT));
            for (MobileElement mob : list) {
                // TODO id find account element
                String account = mob.getText().trim();
                if (account.equals("13570351393")) {
                    mob.click();
                    login.password.sendKeys(accountMap.get(account));
                    login.login.click();
                    TimeUnit.SECONDS.sleep(3);
                    Assert.assertNotNull(sg.shopCar);
                    break;
                }
            }
        }
    }

    // is login or not
    public boolean isLogin(SalePage sg) {
        boolean result = false;
        try {
            if (StringUtils.isNotEmpty(sg.shopCar.getAttribute("name"))) {
                log.info("had login");
                result = true;
            } else {
                log.info("not login!");
            }
        } catch (NoSuchElementException ne) {
            log.info("not login!");
        }
        return result;
    }
}