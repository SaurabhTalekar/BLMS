package com.comcast.crm.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateLockerTypePage {

	@FindBy (id = "lockersize")
	private WebElement lockers;
	
	@FindBy (id = "lockerprice")
	private WebElement lockerp;
	
	@FindBy (id = "submit")
	private WebElement submitbtn;

	WebDriver driver;
	public CreateLockerTypePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void getLockers(String size) {
		Select s = new Select(lockers);
		s.selectByValue(size);
	}
		
	public void getLockerp(String price) {
		 lockerp.sendKeys(price);
	}
	public void getSubmitbtn() {
		submitbtn.click();;
	}
	
	
}
