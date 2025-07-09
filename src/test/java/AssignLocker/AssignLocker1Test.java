package AssignLocker;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.PomPages.AddLockerFormPage;
import com.comcast.crm.PomPages.HomePage;
import com.comcast.crm.baseclasstest.samplebaseclass;

public class AssignLocker1Test extends samplebaseclass {

	@Test
	public void assignLocker() throws Throwable {

		// read data from excel file
		String fullname = elib.getDataFromExcel("BLMS", 7, 2) + jlib.getRandonNumber();
		String email = elib.getDataFromExcel("BLMS", 7, 3);
		String mobile = elib.getDataFromExcel("BLMS", 7, 4);
		String address = elib.getDataFromExcel("BLMS", 7, 5);
		String occupation = elib.getDataFromExcel("BLMS", 7, 6);
		String size = elib.getDataFromExcel("BLMS", 7, 7);
		String lockerno = elib.getDataFromExcel("BLMS", 7, 8)+jlib.getRandonNumber();
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
		
		//Validation
		SoftAssert soft = new SoftAssert();
		boolean status = actmsg.contains(msg);
		soft.assertEquals(status, true);
		soft.assertAll();
		
		//Handel the Alert
		driver.switchTo().alert().accept();
				
		//logout
		//hp.logout();

	}

}
