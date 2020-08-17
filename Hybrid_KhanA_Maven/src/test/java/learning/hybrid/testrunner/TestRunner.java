package learning.hybrid.testrunner;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import learning.hybrid.pom.CoursesPOM;
import learning.hybrid.pom.ExamsPOM;
import learning.hybrid.pom.LanguagePOM;
import learning.hybrid.pom.LoginPOM;
import learning.hybrid.pom.LogoutPOM;
import learning.hybrid.waits.WaitTypes;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import learning.hybrid.actions.Capabilities;

public class TestRunner extends Capabilities{
	
	private AndroidDriver <AndroidElement> driver=null;
	private LoginPOM loginPom=null;
	private CoursesPOM coursesPom = null;
	private LanguagePOM languagePom = null;
	private ExamsPOM examsPom = null;
	private LogoutPOM logoutPom = null;
	private WaitTypes wait = null;
	
	
	@BeforeTest
	//before test gets executed before all tests and classes
	public void beforeTest() throws MalformedURLException {
		System.out.println("*****************  In BeforeTest *************");
		driver=capability();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		loginPom=new LoginPOM(driver);
		coursesPom=new CoursesPOM(driver);
		languagePom=new LanguagePOM(driver);
		examsPom=new ExamsPOM(driver);
		logoutPom=new LogoutPOM(driver);
		wait=new WaitTypes(driver);
	}
	
	@Test(priority = 0)
	public void TC01() throws InterruptedException {
		System.out.println("*************In Signin method*************");
		loginPom.clickDismiss();
		loginPom.clickCovidDismiss();		
		loginPom.clickSigninButton();
		loginPom.clickSignin();
		loginPom.continueWithGoogle();
		loginPom.chooseAccount();
	}
	
	@Test(priority = 1)
	public void selectCourse() throws InterruptedException {
		Thread.sleep(4000);
//		TestRunner tr = new TestRunner();
//		tr.TC01();
		coursesPom.editMyCourses();
		//coursesPom.seeAllMathCourses().click();
//		coursesPom.selectCourse("Class 2 math (India)").click();
//		coursesPom.selectCourse("Class 3 math (India)").click();
//		coursesPom.confirmCourses().click();
//		coursesPom.selectGrade("Class 2").click();
//		coursesPom.confirmCourses().click();
//		coursesPom.selectGrade("Class 2").click();
//		coursesPom.confirmCourses().click();
		Thread.sleep(5000);
		coursesPom.selectCourse("Computer programming");
		coursesPom.confirmCourses();
		coursesPom.selectGrade("Class 2");
		coursesPom.confirmCourses();
		coursesPom.closeGrade();
		
	}
	
	@Test(priority = 2)
	public void selectLanguage() throws InterruptedException{
		System.out.println("In select language Test");
		Thread.sleep(5000);
		languagePom.selectLangButton();
		languagePom.clickEng();
		languagePom.selectLang("English");
		languagePom.goBackToHomePage();
		
	}
	
	@Test(priority = 3)
	public void courseWalkThrough() throws InterruptedException {
		System.out.println("In course challenge Test");
		examsPom.selectCourse();
		examsPom.walkThrough();
		examsPom.goToHome();		
	}
	
	@Test(priority = 4)
	public void signOut() throws InterruptedException {
		System.out.println("In Signout Test");
		logoutPom.goToSettings();
		logoutPom.clickSignout();
	}
	
	@AfterTest
	//after test gets executed after all tests and classes
	public void afterTest() {
		System.out.println("*****************  In AfterTest *************");
	}

}
