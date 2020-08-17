package learning.hybrid.pom;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import learning.hybrid.waits.WaitTypes;

public class LogoutPOM {

	private AndroidDriver<AndroidElement> driver = null;
	private WebElement ele = null;
	private WaitTypes wait = null;
	
	public LogoutPOM(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.wait=new WaitTypes(driver);
	}
	
	public void goToSettings() throws InterruptedException {
		Thread.sleep(4000);
		ele=driver.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]"));
		wait.waitUntilLocated(ele, 10);
		ele.click();
		//driver.findElement(MobileBy.className("android.widget.ImageView")).click();
	}
	
	public void clickSignout() throws InterruptedException {
		ele=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"Sign out\"]"));
		wait.waitUntilLocated(ele, 10);
		ele.click();
	}
	
}
