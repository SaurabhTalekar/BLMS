package LockerType_Module;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.PomPages.CreateLockerTypePage;
import com.comcast.crm.PomPages.HomePage;
import com.comcast.crm.baseclasstest.samplebaseclass;

public class DeleteLockerTypeTest extends samplebaseclass {

	@Test
	public void deleteLockerType() throws Throwable {

		// read data from excel file
		String size = elib.getDataFromExcel("BLMS", 1, 2);
		String price = elib.getDataFromExcel("BLMS", 1, 3);
		String msg = elib.getDataFromExcel("BLMS", 1, 4);

		// create Locker Type
		wlib.waitPageToLoad(driver);
		HomePage hp = new HomePage(driver);
		hp.getLockertype();
		hp.getLockertypeadd();

		CreateLockerTypePage clp = new CreateLockerTypePage(driver);
		clp.getLockers(size);
		clp.getLockerp(price);
		clp.getSubmitbtn();

		// go to manage Locker and check the created locker
		String actmsg = wlib.switchToAlertText(driver);
		boolean status =actmsg.contains(msg);
		Assert.assertEquals(status, true);
		driver.switchTo().alert().accept();
	

		// Go ack to home page
		hp.getBLMSBanker();

		// Manage Locker Type
		hp.getLockertype();
		hp.getLockertypemanage();

		// Delete the created Locker
		driver.findElement(By.xpath("//td[text()='" + size + "']/../th/a[@title='Delete this record']")).click();

		String actmsg1 = wlib.switchToAlertText(driver);
		boolean status1 =actmsg1.contains("delete");
		Assert.assertEquals(status1, true);
		driver.switchTo().alert().accept();
		wlib.switchToAlertAccept(driver);

		// logout
		hp.logout();
	}

}
