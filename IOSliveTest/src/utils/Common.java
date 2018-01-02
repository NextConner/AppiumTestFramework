package utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SettingPage;
import pageObjects.UserPage;

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

	public void resetStatue(LoginPage login, UserPage user, SettingPage set, HomePage home)
			throws InterruptedException {
		doWait(2);
		log.info("进行登录状态重置操作！");
		home.userInfo.click();
		user.setting.click();
		set.logOut.click();
		set.sure.click();
		login.otherLogin.click();
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
}