package utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import pageObjects.HomePage;

public class Common {

	public Log log;

	public Common() {
		log = LogFactory.getLog(this.getClass());
	}

	public void doWait(int waitTime) throws InterruptedException {
		log.info("dowait :" + waitTime + " seconds");
		TimeUnit.SECONDS.sleep(waitTime);
	}

	public String getMethodName() {
		return Thread.currentThread().getStackTrace()[1].getMethodName().toString();
	}


	public void tapByXY(AppiumDriver driver, int width ,int height,int xtimes,int ytimes,int finger) {
//		log.info("Tap by relative location!");
		int sX=width/xtimes;
		int sY=height/ytimes;
		log.info("------------------Tap X"+sX+";Tap Y"+sY+"------------------------");
		driver.tap(finger, sX,sY, 300);
	}
	
	public void tapByTimes(AppiumDriver driver, int width ,int height,double xtimes,double ytimes,int finger) {
//		log.info("Tap by relative location!");
		int sX=(int) (width*xtimes);
		int sY=(int) (height*ytimes);
		log.info("------------------Tap X"+sX+";Tap Y"+sY+"------------------------");
		driver.tap(finger, sX,sY, 200);
	}
	
	//复制测试中产生的截图
	public static void snapshot(TakesScreenshot drivername, String filename){
	      // this method will take screen shot ,require two parameters ,one is driver name, another is file name
	    String currentPath = System.getProperty("user.dir"); //get current work folder
	    System.out.println(currentPath);
	    File scrFile = drivername.getScreenshotAs(OutputType.FILE);
	        // Now you can do whatever you need to do with it, for example copy somewhere
	        try {
	            System.out.println("save snapshot path is:"+currentPath+filename);
	            FileUtils.copyFile(scrFile, new File(currentPath+"\\"+filename));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            System.out.println("Can't save screenshot");
	            e.printStackTrace();
	        } 
	        finally
	        {
	           
	            System.out.println("screen shot finished");
	        }
	  }
	
	 //判断签到弹窗
	public void ifExistSign( IOSDriver driver,HomePage homePage) {
		List we = driver.findElementsById("Check in");
		if (we.size()>0) {
			log.info("有签到弹窗！");
			// int signDays=driver.findElementsById("ic_checkin_check").size();
			homePage.signClick.click();
			String day = homePage.signDay.getAttribute("name");
			if (day.equals("Day 3") || day.equals("Day 5") || day.equals("Day 7")) {
				homePage.signClick.click();
				homePage.signClick.click();
				log.info("特殊签到完成！");
			} else {
				homePage.signClick.click();
				log.info("普通签到完成！");
			}
		}else {
			log.info("无签到弹窗！");
		}
	}
	
	//判断弹框
	public void isAlert(IOSDriver driver) {
		if (driver.findElementsByClassName("UIAAlert").size() == 0) {
			log.info("无弹窗");
			return;
		} else {
			driver.switchTo().alert().accept();
		}	
	}
	
}