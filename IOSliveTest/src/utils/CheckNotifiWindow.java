package utils;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import testCases.LoginTestCase;

public class CheckNotifiWindow implements Runnable {

	public AppiumDriver driver;
	Log log = LogFactory.getLog(CheckNotifiWindow.class);

	@Override
	public void run() {
		try {
			while (true) {
				if (driver != null && driver.findElementsByClassName("UIAAlert").size()>0) {
					driver.switchTo().alert().accept();
					log.info("接受弹窗。");
				} else {
					log.info("----------------------判断无弹窗！---------------------------");
					TimeUnit.SECONDS.sleep(5);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public CheckNotifiWindow(AppiumDriver driver) {
		this.driver = driver;
	}

}
