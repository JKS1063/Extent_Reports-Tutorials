package Reports;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class R1_BasicReport {

	public static void main(String[] args) throws Exception {
		
		ExtentReports extentReports =  new ExtentReports();
		String reportsPath = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\ExtentReports\\Reports\\reports.html";
		File file = new File(reportsPath);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		
		//Method - 1
		ExtentTest test1 = extentReports.createTest("Test 1");
		test1.pass("Test passed");
		
		//Method - 2
		ExtentTest test2 = extentReports.createTest("Test 2");
		test2.log(Status.FAIL, "Test Failed");
		
		//Method - 3
		extentReports.createTest("Test 3").skip("Test Skipped");
		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File(reportsPath).toURI());
	}
}
