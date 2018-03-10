package testCases;


import initAppium.AndroidDeviceDriverInit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import location.UILocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import pageObjects.TagPage;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Test
public class DemoCase {

    public AndroidDriver<MobileElement> driver;
    public AndroidDeviceDriverInit addi;
    public TagPage ta;
    Log log = LogFactory.getLog(DemoCase.class);

    @BeforeClass
    public void setUp() {
        try {
            this.addi = new AndroidDeviceDriverInit();
            this.driver = addi.setUpAppium();
            this.ta = new TagPage(driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeTest
    public void beforeTe() {
        log.info("start");
    }

    @Test
    public void testAddMultipleTag() {

        try {
            int x = driver.manage().window().getSize().getWidth();
            int y = driver.manage().window().getSize().getHeight();
            TimeUnit.SECONDS.sleep(7);
            driver.swipe(1, y / 2, x / 2, y / 2, 500);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String[] name = {"1", "2", "3", "4"};
        ta.setting.click();
        ta.tagSetting.click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < name.length; i++) {
            List<MobileElement> li = driver.findElements(By.className(UILocation.ADD_TAG_CALSS));
            li.get(1).click();
            ta.tagName.sendKeys(name[i]);
            ta.sureAddTag.click();
        }
        driver.pressKeyCode(4);
        log.info("test end");
    }

    @AfterTest
    public void afterTes(Method method) {
        log.info(method.getName() + " : has end!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
