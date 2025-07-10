package com.bank.blms.assinLockerTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.PomPages.AddLockerFormPage;
import com.comcast.crm.PomPages.HomePage;
import com.comcast.crm.baseclasstest.samplebaseclass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

@Listeners(com.comcast.crm.Listenerutility.ListenerImplimentationClass.class)
public class AssignLockerTest extends samplebaseclass {

	@Test (groups = "Smoke")
	public void assignLocker() throws Throwable {

		// read data from excel file
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");  //===>to print Low Level log in Extent Report
		String fullname = elib.getDataFromExcel("BLMS", 7, 2) + jlib.getRandonNumber();
		String email = elib.getDataFromExcel("BLMS", 7, 3);
		String mobile = elib.getDataFromExcel("BLMS", 7, 4);
		String address = elib.getDataFromExcel("BLMS", 7, 5);
		String occupation = elib.getDataFromExcel("BLMS", 7, 6);
		String size = elib.getDataFromExcel("BLMS", 7, 7);
		String lockerno = elib.getDataFromExcel("BLMS", 7, 8) + jlib.getRandonNumber();
		String keyno = elib.getDataFromExcel("BLMS", 7, 9) + jlib.getRandonNumber();
		String instruction = elib.getDataFromExcel("BLMS", 7, 10);
		String nominee = elib.getDataFromExcel("BLMS", 7, 11);
		String relation = elib.getDataFromExcel("BLMS", 7, 12);
		String details = elib.getDataFromExcel("BLMS", 7, 13);
		String idproof = elib.getDataFromExcel("BLMS", 7, 14);
		String addproof_path = elib.getDataFromExcel("BLMS", 7, 15);
		String photo_path = elib.getDataFromExcel("BLMS", 7, 16);
		String msg = elib.getDataFromExcel("BLMS", 7, 17);

		wlib.waitPageToLoad(driver);
		// Assign Locker
		HomePage hp = new HomePage(driver);
		hp.getAssignLocker();
		hp.getAssignlockeradd();

		UtilityClassObject.getTest().log(Status.INFO, "Adding Locker form entering details");  //===>to print Low Level log in Extent Report
		AddLockerFormPage acfp = new AddLockerFormPage(driver);
		acfp.getFullname(fullname);
		acfp.getEmail(email);
		acfp.getMbnumber(mobile);
		acfp.getAddress(address);
		acfp.getOccupation(occupation);
		acfp.getLockernum(lockerno);
		acfp.getKeynum(keyno);
		acfp.getInstruction(instruction);
		acfp.getNomiee(nominee);
		acfp.getRelation(relation);
		acfp.getDetails(details);
		acfp.getLockersize(size);
		acfp.getIdcard(idproof);
		acfp.getAddproof(addproof_path);
		acfp.getPhoto(photo_path);
		acfp.getStatus();
		acfp.getSubmitbtn();

		// go to manage Locker and check the created locker
		String actmsg = wlib.switchToAlertText(driver);
		
		// Handel the Alert
		driver.switchTo().alert().accept();
		
		// Validation
		UtilityClassObject.getTest().log(Status.INFO, "Validatin the success msg");  //===>to print Low Level log in Extent Report
		SoftAssert soft = new SoftAssert();
		boolean status = actmsg.contains(msg);
		soft.assertEquals(status, true);
		soft.assertAll();

	}
	

	@Test (groups = "Regression")
	public void deleteAssignedLocker() throws Throwable {

		// read data from excel file
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");  //===>to print Low Level log in Extent Report
		String fullname = elib.getDataFromExcel("BLMS", 7, 2) + jlib.getRandonNumber();
		String email = elib.getDataFromExcel("BLMS", 7, 3);
		String mobile = elib.getDataFromExcel("BLMS", 7, 4);
		String address = elib.getDataFromExcel("BLMS", 7, 5);
		String occupation = elib.getDataFromExcel("BLMS", 7, 6);
		String size = elib.getDataFromExcel("BLMS", 7, 7);
		String lockerno = elib.getDataFromExcel("BLMS", 7, 8) + jlib.getRandonNumber();
		String keyno = elib.getDataFromExcel("BLMS", 7, 9) + jlib.getRandonNumber();
		String instruction = elib.getDataFromExcel("BLMS", 7, 10);
		String nominee = elib.getDataFromExcel("BLMS", 7, 11);
		String relation = elib.getDataFromExcel("BLMS", 7, 12);
		String details = elib.getDataFromExcel("BLMS", 7, 13);
		String idproof = elib.getDataFromExcel("BLMS", 7, 14);
		String addproof_path = elib.getDataFromExcel("BLMS", 7, 15);
		String photo_path = elib.getDataFromExcel("BLMS", 7, 16);
		String msg = elib.getDataFromExcel("BLMS", 7, 17);
		String msg1 = elib.getDataFromExcel("BLMS", 7, 18);

		wlib.waitPageToLoad(driver);
		// Assign Locker
		HomePage hp = new HomePage(driver);
		hp.getAssignLocker();
		hp.getAssignlockeradd();

		UtilityClassObject.getTest().log(Status.INFO, "Adding Locker form entering details");
		AddLockerFormPage acfp = new AddLockerFormPage(driver);
		acfp.getFullname(fullname);
		acfp.getEmail(email);
		acfp.getMbnumber(mobile);
		acfp.getAddress(address);
		acfp.getOccupation(occupation);
		acfp.getLockernum(lockerno);
		acfp.getKeynum(keyno);
		acfp.getInstruction(instruction);
		acfp.getNomiee(nominee);
		acfp.getRelation(relation);
		acfp.getDetails(details);
		acfp.getLockersize(size);
		acfp.getIdcard(idproof);
		acfp.getAddproof(addproof_path);
		acfp.getPhoto(photo_path);
		acfp.getStatus();
		acfp.getSubmitbtn();

		// go to manage Locker and check the created locker
		UtilityClassObject.getTest().log(Status.INFO, "Validating success msg");
		String actmsg = wlib.switchToAlertText(driver);
		Thread.sleep(1000);
		if (actmsg.contains(msg)) {
			driver.switchTo().alert().accept();
			System.out.println("Test case pass");
		} else {
			driver.switchTo().alert().accept();
			System.out.println("Test case fail");
		}

		// Go ack to home page
		hp.getBLMSBanker();

		// click on Sub-Banker Type Dropdown and click on manage
		hp.getAssignLocker();
		hp.getAssignlockermanage();

		// delete the assign Locker
		UtilityClassObject.getTest().log(Status.INFO, "Deleting assign Locker");
		driver.findElement(By.xpath("//td[text()='" + lockerno + "']/../th/a[@title='Delete this record']")).click();

		UtilityClassObject.getTest().log(Status.INFO, "Validating the detele msg");
		String actmsg1 = wlib.switchToAlertText(driver);
		boolean status = actmsg1.contains(msg1);
		Assert.assertEquals(status, true);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);

		wlib.switchToAlertAccept(driver);

		// Logout
		//hp.logout();

	}

}
