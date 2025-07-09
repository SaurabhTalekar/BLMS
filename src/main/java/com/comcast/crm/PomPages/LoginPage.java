package com.comcast.crm.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{

	// Declaration
	@FindBy(partialLinkText = "Bankers")
	private WebElement bankerlink;
	
	@FindBy(name = "username")
	private WebElement usernameTF;
	
	@FindBy(name = "inputpwd")
	private WebElement passwordTF;
	
	@FindBy (name = "login")
	private WebElement loginbtn;
	
	// Initialization
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public void getbankerlink() {
		bankerlink.click();
	}
	
	public void getUsernameTF(String username) {
		 usernameTF.sendKeys(username);
	}

	public void getPasswordTF(String password) {
		 passwordTF.sendKeys(password);
	}

	public void getloginbtn() {
		 loginbtn.click();
	}

	public void login(String username, String password, String url) {
		waitPageToLoad(driver);
		driver.get(url);
		bankerlink.click();
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginbtn.click();
	}

	
}