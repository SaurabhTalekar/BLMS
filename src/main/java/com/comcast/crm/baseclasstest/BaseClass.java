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
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class BaseClass {

	public DatabaseUtility dblib = new DatabaseUtility();
	public FileUtility flib = new FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public ExcelUtility elib = new ExcelUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite (groups = {"smoke","regression"})
	public void configBS() {
		System.out.println("==Connection to db, Report config==");
		dblib.getDBConnection();
	}

	//@Parameters("BROWSER")
	@BeforeClass (groups = {"smoke","regression"})
	public void configBC() throws Throwable {
		System.out.println("Launch the browser");
		String browser = flib.getDataFromPropertiesFile("browser");
		//String browser = brow;

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
		driver.manage().window().maximize();
	}

	@BeforeMethod (groups = {"smoke","regression"})
	public void configBM() throws Throwable {
		System.out.println("Login to the App");
		String url = flib.getDataFromPropertiesFile("url");
		String username = flib.getDataFromPropertiesFile("username");
		String password = flib.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password, url);
	}

	@AfterMethod (groups = {"smoke","regression"})
	public void configAM() {
		System.out.println("Logout to App");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass (groups = {"smoke","regression"})
	public void configAC() {
		System.out.println("Close the browser");
		driver.close();
	}

	@AfterSuite (groups = {"smoke","regression"})
	public void configAS() {
		System.out.println("==close db, Report backup==");
		dblib.closeDBConnection();
	}

}
