package com.comcast.crm.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddLockerFormPage {
	
	@FindBy (id ="ahname")
	private WebElement fullname;
	
	@FindBy (id ="emailid")
	private WebElement email;
	
	@FindBy (id ="mobilenumber")
	private WebElement mbnumber;
	
	@FindBy (name ="comadd")
	private WebElement address;
	
	@FindBy (id ="occupation")
	private WebElement occupation;
	
	@FindBy (id ="lockernum")
	private WebElement lockernum;
	
	@FindBy (name ="keynum")
	private WebElement keynum;
	
	@FindBy (name ="instruction")
	private WebElement instruction;
	
	@FindBy (id ="nomineename")
	private WebElement nomiee;
	
	@FindBy (id ="nomineerelation")
	private WebElement relation;
	
	@FindBy (name ="valuabledetails")
	private WebElement details;
	
	@FindBy (id ="lockersize")
	private WebElement lockersize;
	
	@FindBy (name ="idcard")
	private WebElement idcard;
	
	@FindBy (id ="addressproof")
	private WebElement addproof;
	
	@FindBy (id ="photo")
	private WebElement photo;
	
	@FindBy (id ="status")
	private WebElement status;
	
	@FindBy (id ="submit")
	private WebElement submitbtn;
	
	WebDriver driver;
	public AddLockerFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void getFullname(String fname) {
		fullname.sendKeys(fname);
	}
	
	public void getEmail(String emails) {
		email.sendKeys(emails);
	}
	
	public void getMbnumber(String mobilenum) {
		mbnumber.sendKeys(mobilenum);
	}
	public void getAddress(String add) {
		address.sendKeys(add);
	}
	public void getOccupation(String occu) {
		occupation.sendKeys(occu);
	}
	public void getLockernum(String lnum) {
		lockernum.sendKeys(lnum);
	}
	public void getKeynum(String knum) {
		keynum.sendKeys(knum);
	}
	public void getInstruction(String inst) {
		instruction.sendKeys(inst);
	}
	public void getNomiee(String nomie) {
		nomiee.sendKeys(nomie);
	}
	public void getRelation(String rel) {
		 relation.sendKeys(rel);
	}
	public void getDetails(String detail) {
		details.sendKeys(detail);
	}
	public void getLockersize(String size) {
		Select s = new Select(lockersize);
		s.selectByVisibleText(size);
	}
	public void getIdcard(String proof) {
		Select s = new Select(idcard);
		s.selectByVisibleText(proof);
	}
	public void getAddproof(String path) {
		addproof.sendKeys(path);
	}
	public void getPhoto(String path) {
		photo.sendKeys(path);
	}
	public void getStatus() {
		status.click();
	}
	public void getSubmitbtn() {
		submitbtn.click();
	}

	
}
