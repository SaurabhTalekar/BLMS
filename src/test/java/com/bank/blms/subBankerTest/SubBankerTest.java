package com.bank.blms.subBankerTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.PomPages.CreateSubBankerPage;
import com.comcast.crm.PomPages.HomePage;
import com.comcast.crm.baseclasstest.samplebaseclass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

@Listeners(com.comcast.crm.Listenerutility.ListenerImplimentationClass.class)
public class SubBankerTest extends samplebaseclass{
	
	@Test (groups = "Smoke")
	public void createSubBanker() throws Throwable {

		// read data from excel
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");  //===>to print Low Level log in Extent Report
		String uname = elib.getDataFromExcel("BLMS", 4, 2) + jlib.getRandonNumber();
		String fullname = elib.getDataFromExcel("BLMS", 4, 3);
		String email = elib.getDataFromExcel("BLMS", 4, 4);
		String mobile = elib.getDataFromExcel("BLMS", 4, 5);
		String pass = elib.getDataFromExcel("BLMS", 4, 6);
		String msg = elib.getDataFromExcel("BLMS", 4, 7);

		wlib.waitPageToLoad(driver);
		// create Sub-Banker Type
		HomePage hp = new HomePage(driver);
		hp.getSubanker();
		hp.getSubbankeradd();

		UtilityClassObject.getTest().log(Status.INFO, "Creating Sub Banker");  
		CreateSubBankerPage csp = new CreateSubBankerPage(driver);
		csp.getUsername(uname);
		csp.getFullname(fullname);
		csp.getEmail(email);
		csp.getMobilenumber(mobile);
		csp.getPassword(pass); 
		csp.getSubmit();
		wlib.waitPageToLoad(driver);

		// go to manage Locker and check the created Subbanker
		UtilityClassObject.getTest().log(Status.INFO, "Validating success msg for creation"); 
		String actmsg = wlib.switchToAlertText(driver);
		boolean status = actmsg.contains(msg);
		Assert.assertEquals(status, true);
		driver.switchTo().alert().accept();
		
		//hp.logout();

	}

	
	@Test (groups = "Regression")
	public void deleteSubBanker() throws Throwable {

		// read data from excel file
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");  //===>to print Low Level log in Extent Report
		String uname = elib.getDataFromExcel("BLMS", 4, 2) + jlib.getRandonNumber();
		String fullname = elib.getDataFromExcel("BLMS", 4, 3);
		String email = elib.getDataFromExcel("BLMS", 4, 4);
		String mobile = elib.getDataFromExcel("BLMS", 4, 5);
		String pass = elib.getDataFromExcel("BLMS", 4, 6);
		String msg = elib.getDataFromExcel("BLMS", 4, 7);
		//String msg1 = elib.getDataFromExcel("BLMS", 4, 8);

		wlib.waitPageToLoad(driver);
		// create Sub-Banker Type
		HomePage hp = new HomePage(driver);
		hp.getSubanker();
		hp.getSubbankeradd();

		UtilityClassObject.getTest().log(Status.INFO, "Creating Sub Banker"); 
		CreateSubBankerPage csp = new CreateSubBankerPage(driver);
		csp.getUsername(uname);
		System.out.println(uname);
		csp.getFullname(fullname);
		csp.getEmail(email);
		csp.getMobilenumber(mobile);
		csp.getPassword(pass);
		csp.getSubmit();
		wlib.waitPageToLoad(driver);
		
		// go to manage Locker and check the created subbanker
		UtilityClassObject.getTest().log(Status.INFO, "Validating success msg for subbanker creation");
		String actmsg = wlib.switchToAlertText(driver);
		if (actmsg.contains(msg)) {
			driver.switchTo().alert().accept();
			System.out.println("Test case pass");
		} else {
			System.out.println("Test case fail");
		}

		// Go ack to home page
		hp.getBLMSBanker();

		//click on Sub-Banker Type Dropdown and click on manage
		hp.getSubanker();
		hp.getSubbankermanage();

		// delete the created SubBBanker
		UtilityClassObject.getTest().log(Status.INFO, "Deleting the subbanker");
		driver.findElement(By.xpath("//td[text()='" + fullname + "']/../th/a[2]")).click();
		wlib.switchToAlertAccept(driver);
		
		UtilityClassObject.getTest().log(Status.INFO, "Validating deletion msg for successful deletion of subbanker");
		String actmsg1 = wlib.switchToAlertText(driver);		
		boolean status1 = actmsg1.contains(msg);
		Assert.assertEquals(status1, true);
		
		wlib.switchToAlertAccept(driver);	
		
		//Logout
		//hp.logout();
	}

}
