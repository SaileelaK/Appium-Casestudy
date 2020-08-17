package learning.hybrid.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import learning.hybrid.waits.WaitTypes;

public class ExamsPOM {
	
	private AndroidDriver<AndroidElement> driver = null;
	private WaitTypes wait = null;
	private WebElement ele = null;
	
	public ExamsPOM(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.wait=new WaitTypes(driver);
	}
	
	public void selectCourse() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"My courses\").instance(0))"));
		int count = driver.findElements(MobileBy.className("android.widget.TextView")).size();
		for(int i=0;i<count;i++) {
			String txt = driver.findElements(By.className("android.widget.TextView")).get(i).getText();
			System.out.println(txt);
			if(txt.equalsIgnoreCase("My courses")) {
				driver.findElements(By.className("android.widget.TextView")).get(i+2).click();
				break;
			}
		}
	}
	
	public void walkThrough() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"Take Course Challenge\").instance(0))"));
	}
	
	public void goToHome() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("org.khanacademy.android:id/tab_bar_button_home")).click();
	}
	
}
