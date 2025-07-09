package com.comcast.crm.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateSubBankerPage {
	
	//Declaration
	@FindBy (id = "sadminusername")
	private WebElement username;

	@FindBy (id = "fullname")
	private WebElement fullname;

	@FindBy (id = "emailid")
	private WebElement email;

	@FindBy (id = "mobilenumber")
	private WebElement mobilenumber;

	@FindBy (id = "inputpwd")
	private WebElement password;

	@FindBy (id = "submit")
	private WebElement submit;

	//intialization
	WebDriver driver;
	public CreateSubBankerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void getUsername(String uname) {
		username.sendKeys(uname);
	}
	public void getFullname(String fname) {
		fullname.sendKeys(fname);
	}
	public void getEmail(String mail) {
		 email.sendKeys(mail);
	}
	public void getMobilenumber(String phone) {
		mobilenumber.sendKeys(phone);
	}
	public void getPassword(String pass) {
		password.sendKeys(pass);
	}
	public void getSubmit() {
		submit.click();
	}
	
}
