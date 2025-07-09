package SubBanker_Module;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.PomPages.CreateSubBankerPage;
import com.comcast.crm.PomPages.HomePage;
import com.comcast.crm.baseclasstest.samplebaseclass;

public class DeleteSubBankerTest extends samplebaseclass {

	@Test
	public void deleteSubBanker() throws Throwable {

		// read data from excel file
		String uname = elib.getDataFromExcel("BLMS", 4, 2) + jlib.getRandonNumber();
		String fullname = elib.getDataFromExcel("BLMS", 4, 3);
		String email = elib.getDataFromExcel("BLMS", 4, 4);
		String mobile = elib.getDataFromExcel("BLMS", 4, 5);
		String pass = elib.getDataFromExcel("BLMS", 4, 6);
		String msg = elib.getDataFromExcel("BLMS", 4, 7);
		String msg1 = elib.getDataFromExcel("BLMS", 4, 8);

		// create Sub-Banker Type
		HomePage hp = new HomePage(driver);
		hp.getSubanker();
		hp.getSubbankeradd();

		CreateSubBankerPage csp = new CreateSubBankerPage(driver);
		csp.getUsername(uname);
		System.out.println(uname);
		csp.getFullname(fullname);
		csp.getEmail(email);
		csp.getMobilenumber(mobile);
		csp.getPassword(pass);
		csp.getSubmit();
		wlib.waitPageToLoad(driver);
		
		// go to manage Locker and check the created locker
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
		driver.findElement(By.xpath("//td[text()='" + fullname + "']/../th/a[2]")).click();
		wlib.switchToAlertAccept(driver);
		
		String actmsg1 = wlib.switchToAlertText(driver);		
		boolean status1 = actmsg1.contains(msg);
		System.out.println(actmsg1);
		System.out.println(msg);
		Assert.assertEquals(status1, true);
		
		wlib.switchToAlertAccept(driver);	
		
		//Logout
		//hp.logout();
	}
}
