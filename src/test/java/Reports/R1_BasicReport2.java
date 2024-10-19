package Reports;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class R1_BasicReport2 {

	public static void main(String[] args) throws Exception {
		
		ExtentReports extentReport = new ExtentReports();
		String filePath = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\ExtentReports\\Reports\\reports2.html";
		File file = new File(filePath);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReport.attachReporter(sparkReporter);
		
		//Method - 1
		ExtentTest test1 = extentReport.createTest("Test 1");
		test1.pass("Test Passed");
		
		//Method - 2
		ExtentTest test2 = extentReport.createTest("Test 2");
		test2.log(Status.FAIL, "Test Failed");
		
		//Method - 3
		extentReport.createTest("Test 3").skip("Test Skipped");
		
		extentReport.flush();
		
		Desktop.getDesktop().browse(new File(filePath).toURI());
	}
}
