package learning.hybrid.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WaitTypes {
	
	private AndroidDriver<AndroidElement> driver = null;

	public WaitTypes(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	
	public void clickWhenReady(By locator, int maxTimeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, maxTimeOut);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public WebElement waitUntilLocated(WebElement element, int maxTimeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, maxTimeOut);
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null; 
	}
	
}
