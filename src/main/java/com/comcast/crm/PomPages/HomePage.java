package com.comcast.crm.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// Declaration
	@FindBy(xpath = "//span[text()='BLMS | Banker ']")
	private WebElement BLMSBanker;

	@FindBy(partialLinkText = "Sub-Banker")
	private WebElement subanker;

	@FindBy(xpath = "(//p[text()='Add'])[1]")
	private WebElement subbankeradd;

	@FindBy(xpath = "//p[text()=' Manage'][1]")
	private WebElement subbankermanage;
	
	@FindBy(partialLinkText = "Locker Type")
	private WebElement lockertype;

	@FindBy(xpath = "(//p[text()='Add'])[2]")
	private WebElement lockertypeadd;

	@FindBy(xpath = "(//p[text()=' Manage'])[2]")
	private WebElement lockertypemanage;

	@FindBy(partialLinkText = "Assign Locker")
	private WebElement assignLocker;
	
	@FindBy(xpath = "(//p[text()='Add'])[3]")
	private WebElement assignlockeradd;

	@FindBy(xpath = "(//p[text()=' Manage'])[3]")
	private WebElement assignlockermanage;

	@FindBy(partialLinkText = "Account Setting")
	private WebElement accountsettinglink;

	@FindBy(xpath = "//p[text()='Logout']")
	private WebElement logoutlink;

	// Initialization
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public void getBLMSBanker() {
		BLMSBanker.click();
	}

	public void getSubanker() {
		subanker.click();
	}

	public void getSubbankeradd() {
		subbankeradd.click();
	}

	public void getSubbankermanage() {
		subbankermanage.click();
	}

	public void getLockertype() {
		lockertype.click();
	}
	
	public void getLockertypeadd() {
		lockertypeadd.click();
	}

	public void getLockertypemanage() {
		lockertypemanage.click();
	}

	
	
	public void getAssignLocker() {
		assignLocker.click();
	}
	
	public void getAssignlockeradd() {
		assignlockeradd.click();
	}

	public void getAssignlockermanage() {
		assignlockermanage.click();
	}

	public void getAccountsettinglink() {
		accountsettinglink.click();

	}

	public void getLogoutlink() {
		logoutlink.click();
	}

	public void logout() {
		accountsettinglink.click();
		logoutlink.click();
	}

}
