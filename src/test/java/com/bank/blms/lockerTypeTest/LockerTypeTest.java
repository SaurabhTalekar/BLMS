package com.bank.blms.lockerTypeTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.PomPages.CreateLockerTypePage;
import com.comcast.crm.PomPages.HomePage;
import com.comcast.crm.baseclasstest.samplebaseclass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

@Listeners(com.comcast.crm.Listenerutility.ListenerImplimentationClass.class)
public class LockerTypeTest extends samplebaseclass{

	@Test (groups = "Smoke")
	public void createLockerType() throws Throwable {

		// read data from excel file
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");  //===>to print Low Level log in Extent Report
		String size = elib.getDataFromExcel("BLMS", 1, 2);
		String price = elib.getDataFromExcel("BLMS", 1, 3);	
		String msg = elib.getDataFromExcel("BLMS", 1, 4); 

		// create Locker Type
		UtilityClassObject.getTest().log(Status.INFO, "Create Locker Type");
		HomePage hp = new HomePage(driver);
		hp.getLockertype();
		hp.getLockertypeadd();
		
		CreateLockerTypePage clp = new CreateLockerTypePage(driver);
		clp.getLockers(size);
		clp.getLockerp(price);
		clp.getSubmitbtn();

		// go to manage Locker and check the created locker
		UtilityClassObject.getTest().log(Status.INFO, "Validating success msg for locker creation");
		Thread.sleep(1000);
		String actmsg = wlib.switchToAlertText(driver);
		boolean status = actmsg.contains(msg);
		Assert.assertEquals(status, true);
		driver.switchTo().alert().accept();
		
		//hp.logout();
	}
	
	
	@Test (groups = "Regression")
	public void deleteLockerType() throws Throwable {

		// read data from excel file
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");
		String size = elib.getDataFromExcel("BLMS", 1, 2);
		String price = elib.getDataFromExcel("BLMS", 1, 3);
		String msg = elib.getDataFromExcel("BLMS", 1, 4);

		// create Locker Type
		UtilityClassObject.getTest().log(Status.INFO, "Create Locker Type");
		wlib.waitPageToLoad(driver);
		HomePage hp = new HomePage(driver);
		hp.getLockertype();
		hp.getLockertypeadd();

		CreateLockerTypePage clp = new CreateLockerTypePage(driver);
		clp.getLockers(size);
		clp.getLockerp(price);
		clp.getSubmitbtn();

		// go to manage Locker and check the created locker
		UtilityClassObject.getTest().log(Status.INFO, "Validating success msg for locker creation");
		String actmsg = wlib.switchToAlertText(driver);
		boolean status =actmsg.contains(msg);
		Assert.assertEquals(status, true);
		driver.switchTo().alert().accept();
	

		// Go ack to home page
		hp.getBLMSBanker();

		// Manage Locker Type
		UtilityClassObject.getTest().log(Status.INFO, "Deleting the Created locker");
		hp.getLockertype();
		hp.getLockertypemanage();

		// Delete the created Locker
		driver.findElement(By.xpath("//td[text()='" + size + "']/../th/a[@title='Delete this record']")).click();

		//Validating 
		UtilityClassObject.getTest().log(Status.INFO, "Validating success msg for locker deletion");
		String actmsg1 = wlib.switchToAlertText(driver);
		boolean status1 =actmsg1.contains("delete");
		Assert.assertEquals(status1, true);
		driver.switchTo().alert().accept();
		wlib.switchToAlertAccept(driver);

	}

}
