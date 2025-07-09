package AssignLocker;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.PomPages.AddLockerFormPage;
import com.comcast.crm.PomPages.HomePage;
import com.comcast.crm.baseclasstest.samplebaseclass;

public class DeleteAssigedLockerTest extends samplebaseclass {

	@Test
	public void deleteAssignedLocker() throws Throwable {

		// read data from excel file
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
		driver.findElement(By.xpath("//td[text()='" + lockerno + "']/../th/a[@title='Delete this record']")).click();

		String actmsg1 = wlib.switchToAlertText(driver);
		boolean status = actmsg1.contains(msg1);
		Assert.assertEquals(status, true);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);

		wlib.switchToAlertAccept(driver);

		// Logout
		hp.logout();

	}

}
