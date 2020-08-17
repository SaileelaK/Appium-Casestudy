package learning.hybrid.pom;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import learning.hybrid.actions.Capabilities;
import learning.hybrid.waits.WaitTypes;

public class LanguagePOM extends Capabilities{

	private AndroidDriver<AndroidElement> driver = null;
	private WaitTypes wait = null;
	private WebElement ele = null;
	
	public LanguagePOM(AndroidDriver<AndroidElement> driver ) throws MalformedURLException {
		this.driver = driver;
		this.wait=new WaitTypes(driver);
	}
	
	public void selectLangButton() {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"Select language\").instance(0))"));
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"Select language\"]")).click();
	}
	public void clickEng() throws InterruptedException {
		Thread.sleep(4000);
		ele=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"English\"]"));
		wait.waitUntilLocated(ele, 10);
		ele.click();
	}
	public void selectLang(String lang) throws InterruptedException {
		Thread.sleep(4000);
		ele=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\""+lang+"\"]"));
		wait.waitUntilLocated(ele, 10);
		ele.click();
	}
	public void goBackToHomePage() throws InterruptedException {
		Thread.sleep(6000);
		ele=driver.findElement(MobileBy.className("android.widget.ImageButton"));
		wait.waitUntilLocated(ele, 10);
		ele.click();
	}
	
	
}
