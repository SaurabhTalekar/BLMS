package com.comcast.crm.baseclasstest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.PomPages.HomePage;
import com.comcast.crm.PomPages.LoginPage;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileuility.ExcelUtility;
import com.comcast.crm.generic.fileuility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class samplebaseclass {

	public DatabaseUtility dlib = new DatabaseUtility();
	public FileUtility flib = new FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public ExcelUtility elib = new ExcelUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite (groups = {"Smoke","Regression"})
	public void configBS() {
		System.out.println("==Connection to db, Report config====>BaseClass<====");
		dlib.getDBConnection();
	}

	//@Parameters("Browser")
	@BeforeClass (groups = {"Smoke","Regression"})
	public void configBC() throws Throwable {
		System.out.println("==Launch the browser====>BaseClass<====");
		
		//String browser = flib.getDataFromPropertiesFile("browser");
		String browser = System.getProperty("browser",flib.getDataFromPropertiesFile("browser") );  //====Getting data from Cmd-line parameter during runtime or from property

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("safari")) {
			driver = new SafariDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
		driver.manage().window().maximize();
		
	}

	@BeforeMethod (groups = {"Smoke","Regression"})
	public void configBM() throws Throwable {
		System.out.println("==Login to te application====>BaseClass<====");
		String username = flib.getDataFromPropertiesFile("username");
		String password = flib.getDataFromPropertiesFile("password");
		String url = flib.getDataFromPropertiesFile("url");
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password, url);
		//wlib.waitPageToLoad(driver);
	}

	@AfterMethod (groups = {"Smoke","Regression"})
	public void configAF() {
		System.out.println("==Logout to the application====>BaseClass<====");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass (groups = {"Smoke","Regression"})
	public void configAC() {
		System.out.println("==close the browser====>BaseClass<====");
		driver.close();
	}

	@AfterSuite (groups = {"Smoke","Regression"})
	public void configAS() {
		System.out.println("==Connection close to db, Report config====>BaseClass<====");
		dlib.closeDBConnection();
	}

}
