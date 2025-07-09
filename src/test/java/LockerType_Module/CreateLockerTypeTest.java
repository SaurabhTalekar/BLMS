package LockerType_Module;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.PomPages.CreateLockerTypePage;
import com.comcast.crm.PomPages.HomePage;
import com.comcast.crm.baseclasstest.samplebaseclass;

public class CreateLockerTypeTest extends samplebaseclass {

	@Test
	public void createLockerType() throws Throwable {

		// read data from excel file
		String size = elib.getDataFromExcel("BLMS", 1, 2);
		String price = elib.getDataFromExcel("BLMS", 1, 3);	
		String msg = elib.getDataFromExcel("BLMS", 1, 4); 

		// create Locker Type
		HomePage hp = new HomePage(driver);
		hp.getLockertype();
		hp.getLockertypeadd();
		
		CreateLockerTypePage clp = new CreateLockerTypePage(driver);
		clp.getLockers(size);
		clp.getLockerp(price);
		clp.getSubmitbtn();

		// go to manage Locker and check the created locker
		String actmsg = wlib.switchToAlertText(driver);
		boolean status = actmsg.contains(msg);
		Assert.assertEquals(status, true);
		driver.switchTo().alert().accept();
		
		hp.logout();
	}

}
