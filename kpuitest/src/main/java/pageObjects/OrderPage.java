package pageObjects;

import com.sun.istack.internal.NotNull;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import location.OrderLocation;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class OrderPage {

    Log log = LogFactory.getLog(OrderPage.class);
    public AndroidDriver<MobileElement> driver;

    @Autowired
    public OrderPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = OrderLocation.ANY_PRODUCT_NUM)
    public WebElement anyProNum;
    @FindBy(id = OrderLocation.ANY_PRODUCT_PRICE)
    public WebElement anyProPrice;
    @FindBy(id = OrderLocation.ANY_PRODUCT_NOTE)
    public WebElement anyProNote;
    @FindBy(id = OrderLocation.ANY_TOTAL_PRICE)
    public WebElement anyOrderTotalPrice;
    @FindBy(id = OrderLocation.ANY_PRODUCT_STAOCK)
    public WebElement anyProStock;
    @FindBy(id = OrderLocation.ANY_PRODUCT_SAVE)
    public WebElement anyProSave;
    @FindBy(id = OrderLocation.ANY_PRODUCT_NAME)
    public WebElement anyProName;
    @FindBy(id = OrderLocation.ANY_MUTLI_STAND)
    public WebElement anyMutliStand;
    @FindBy(id=OrderLocation.ORDER_TOTAL_MONEY)
    public WebElement orderTotalMoney;
    @FindBy(id=OrderLocation.ORDER_TOTAL_RECEIVABLE)
    public WebElement orderTotalReceivable;
    @FindBy(id=OrderLocation.ORDER_TOTAL_RECEIVED)
    public WebElement orderTotalReceived;
    @FindBy(id=OrderLocation.ANY_SAVE)
    public WebElement anySave;

    public String createAnOrder(OrderPage op, String changePrice, @NotNull String proNum, String proNote) {

        StringBuilder sb = new StringBuilder();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException i) {
            log.info("timeout fail ");
        }
        if (StringUtils.isEmpty(changePrice) || StringUtils.isBlank(changePrice)) {  //avoid null pointer
            log.info("not change pro price!");
        } else {
            op.anyProPrice.clear();
            driver.pressKeyCode(4);
            op.anyProPrice.sendKeys(changePrice);
        }
        try {
            if (StringUtils.isNotEmpty(op.anyMutliStand.getAttribute("name"))) {
                addSingleStand(op, proNum, true);
            } else {
                addSingleStand(op, proNum, false);
            }
        } catch (NoSuchElementException ne) {
            log.info("single stand product!");
            addSingleStand(op, proNum, false);
        }

        op.anyProNote.sendKeys(proNote);
        sb.append(op.anyProNum.getAttribute("name") + " , " + op.anyProStock.getAttribute("name") + " , "
                + op.anyProNote.getAttribute("name") + ".");
        op.anyProSave.click();//save pro
        String result = String.valueOf(sb);
        sb.setLength(0);// reset stringBuilder
        return result;
    }


    public void addSingleStand(OrderPage op, String proNum, boolean mutliStand) {
        if (mutliStand) {
            op.anyMutliStand.clear();
            op.anyMutliStand.sendKeys(proNum);
        } else {
            op.anyProNum.clear();
            op.anyProNum.sendKeys(proNum);
        }
    }
}
