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
				if (driver == null) {
					log.info("driver null");
					Thread.sleep(5000);
				} else if (driver == null) {
					log.info("----------------------判断无弹窗！---------------------------");
				} else {
					log.info("----------------------判断有弹窗！---------------------------");
					driver.switchTo().alert().accept();
					TimeUnit.SECONDS.sleep(3);
					log.info("Thread InterrputedException");
					Thread.interrupted();
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
