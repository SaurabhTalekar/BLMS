package SubBanker_Module;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.PomPages.CreateSubBankerPage;
import com.comcast.crm.PomPages.HomePage;
import com.comcast.crm.baseclasstest.samplebaseclass;

public class CreateSubBanckerTest extends samplebaseclass {

	@Test
	public void createSubBanker() throws Throwable {

		// read data from excel
		String uname = elib.getDataFromExcel("BLMS", 4, 2) + jlib.getRandonNumber();
		String fullname = elib.getDataFromExcel("BLMS", 4, 3);
		String email = elib.getDataFromExcel("BLMS", 4, 4);
		String mobile = elib.getDataFromExcel("BLMS", 4, 5);
		String pass = elib.getDataFromExcel("BLMS", 4, 6);
		String msg = elib.getDataFromExcel("BLMS", 4, 7);

		// create Sub-Banker Type
		HomePage hp = new HomePage(driver);
		hp.getSubanker();
		hp.getSubbankeradd();

		CreateSubBankerPage csp = new CreateSubBankerPage(driver);
		csp.getUsername(uname);
		csp.getFullname(fullname);
		csp.getEmail(email);
		csp.getMobilenumber(mobile);
		csp.getPassword(pass); 
		csp.getSubmit();
		wlib.waitPageToLoad(driver);

		// go to manage Locker and check the created locker
		String actmsg = wlib.switchToAlertText(driver);
		boolean status = actmsg.contains(msg);
		Assert.assertEquals(status, true);
		driver.switchTo().alert().accept();
		
		//hp.logout();

	}

}
