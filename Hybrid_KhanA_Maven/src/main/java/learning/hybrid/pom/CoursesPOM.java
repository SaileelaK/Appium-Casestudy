package learning.hybrid.pom;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import learning.hybrid.actions.Capabilities;
import learning.hybrid.waits.WaitTypes;

public class CoursesPOM extends Capabilities {

	private AndroidDriver<AndroidElement> driver = null;
	private WebElement ele = null;
	private WaitTypes wait = null;

	public CoursesPOM(AndroidDriver<AndroidElement> driver) throws MalformedURLException {
		this.driver=driver;
		this.wait=new WaitTypes(driver);
	}
	
	public void editMyCourses() {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"Edit\").instance(0))"));
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"Edit\"]")).click();
	}
	
	public WebElement seeAllMathCourses() {
		return driver.findElements(MobileBy.xpath("//android.widget.TextView")).get(0);
	}
	
	public void selectCourse(String course) {
		//either of below lines will work
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+course+"\").instance(0))");
//        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\""+course+"\").instance(0))"));

		int count = driver.findElements(By.className("android.widget.TextView")).size();
        System.out.println("Count is : "+count);
        for(int i=0;i<count;i++)
        {
        	String course_name = driver.findElements(By.className("android.widget.TextView")).get(i).getText();
        	System.out.println(course_name);
        	if(course_name.equalsIgnoreCase(course))
        	{
        		driver.findElements(By.className("android.widget.TextView")).get(i).click();
        		break;
        	}
        }
		
		
	}
	
	public void confirmCourses() {
		ele=driver.findElement(MobileBy.className("android.widget.Button"));
		wait.waitUntilLocated(ele, 10);
		ele.click();
	}
	
	public void selectGrade(String grade) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+grade+"\"))");
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\""+grade+"\"]")).click();
	}
	
	public void closeGrade() {
		ele=driver.findElement(MobileBy.className("android.widget.ImageView"));
		wait.waitUntilLocated(ele, 10);
		ele.click();
	}
}
