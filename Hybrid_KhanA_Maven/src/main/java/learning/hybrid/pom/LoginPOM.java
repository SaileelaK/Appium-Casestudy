package learning.hybrid.pom;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import learning.hybrid.waits.WaitTypes;

public class LoginPOM {
	
	private AndroidDriver <AndroidElement> driver=null;
	private WebElement ele = null;
	private WaitTypes wait = null;
	
	public LoginPOM(AndroidDriver <AndroidElement> driver) throws MalformedURLException {
		this.driver=driver;
		this.wait=new WaitTypes(driver);
	}
	
	public void clickDismiss() {
		ele=driver.findElement(MobileBy.className("android.widget.Button"));
		wait.waitUntilLocated(ele, 10);
		ele.click();
	}
	
	public void clickCovidDismiss() {
		ele=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"Dismiss\"]"));
		wait.waitUntilLocated(ele, 10);
		ele.click();
	}
	
	public void clickSigninButton() throws InterruptedException {
		Thread.sleep(4000);
		ele=driver.findElement(MobileBy.className("android.widget.Button"));
		wait.waitUntilLocated(ele, 10);
		ele.click();
	}
	
	public void clickSignin() {
		ele= driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"Sign in\"]"));
		wait.waitUntilLocated(ele, 10);
		ele.click();
	}
	
	public void continueWithGoogle() {
		ele=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"Continue with Google\"]"));
		wait.waitUntilLocated(ele, 10);
		ele.click();
	}
	
	public void chooseAccount() {
		ele=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"sai leela\"]"));
		wait.waitUntilLocated(ele, 10);
		ele.click();
	}
}
