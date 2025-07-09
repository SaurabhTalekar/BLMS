package com.comcast.crm.Listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseclasstest.samplebaseclass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplimentationClass implements ITestListener, ISuiteListener {

	ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		
		System.out.println("Report Configuration");
		String time2 = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./Extent_AdvanceReport/Report"+"+"+time2);
		     spark.config().setDocumentTitle("Bank Locker management suite test Result");
		     spark.config().setReportName("BLMS Report");
		     spark.config().setTheme(Theme.DARK);
		     
		     report = new ExtentReports();
		     report.attachReporter(spark);
		     report.setSystemInfo("OS","Windows-10");
		     report.setSystemInfo("Browser","Chrome");     
		
	}

	@Override
	public void onFinish(ISuite suite) {
		
		System.out.println("Report Backup<=======ListenerImpClass===");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("=====" + result.getMethod().getMethodName() + "===ListenerImpClass===");
		
		//Createing test into ExtentReport
		 test = report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"===>Started<====ListenerImpClass===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=====" + result.getMethod().getMethodName() + "====Ended=====ListenerImpClass=====");
		
		test.log(Status.PASS, result.getMethod().getMethodName()+"===>Complited<====ListenerImpClass===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
//		EventFiringWebDriver edriver = new EventFiringWebDriver();
//		File srcfile =edriver.getscreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(srcfile, new File("./screenshot/+"testname"+.png"));

		//Taking screenshot for normat testNG and getting strore in Screenshot folder
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot) samplebaseclass.sdriver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File("./screenshot/"+testname+" + "+time+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Taking ss and attachiong with the extent report
		String time1 = new Date().toString().replace(" ","_").replace(":", "_");
		TakesScreenshot ts1 = (TakesScreenshot) samplebaseclass.sdriver;
		String filepath = ts1.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath,testname+"_"+time1);
		
		System.out.println("=====" + result.getMethod().getMethodName()+"===Failed====ListenerImpClass===");
		      
		test.log(Status.FAIL, result.getMethod().getMethodName()+"===>Failed<====ListenerImpClass===");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
