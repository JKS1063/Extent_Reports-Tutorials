package Reports;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class R8_ExtentReportFailedPassed {

	public static void main(String[] args) throws Exception {
		
		ExtentReports extentReport  = new ExtentReports();
//		String allTests = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\ExtentReports\\Reports\\reports8.html";
//		String failTests = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\ExtentReports\\Reports\\reports8_1.html";
//		String passTests = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\ExtentReports\\Reports\\reports8_2.html";
		
		// Or
		
		String allTests = "/Reports/reports8.html";
		String failTests = "/Reports/reports8_1.html";
		String passTests = "/Reports/reports8_2.html";
		
		
		
		ExtentSparkReporter sparkReporterAllTests = new ExtentSparkReporter(allTests);
		
		ExtentSparkReporter sparkReporterFailTests = new ExtentSparkReporter(failTests);
		sparkReporterFailTests.filter().statusFilter().as(new Status[] {Status.FAIL});
		
		ExtentSparkReporter sparkReporterPassTests = new ExtentSparkReporter(passTests);
		sparkReporterPassTests.filter().statusFilter().as(new Status[] {Status.PASS});
		
		extentReport.attachReporter(sparkReporterAllTests, sparkReporterFailTests, sparkReporterPassTests);
		
		// Test - 1 Fail
		extentReport.createTest("Test 1", "Test Failed")
		.assignAuthor("Jaya Krishna")
		.assignDevice("Google Chrome")
		.assignCategory("Regression")
		.fail("Regression test failed");
		
		// Test - 2 Pass
		extentReport.createTest("Test 2", "Test Passed")
		.assignAuthor("Jaya Krishna", "HariHara")
		.assignDevice("Google Chrome", "Firefox")
		.assignCategory("Smoke", "Regression")
		.pass("Both smoke and regression tests passed");
		
		// Test - 3 Fail
		extentReport.createTest("Test 3", "Test Failed")
		.assignAuthor("Krishna", "Sekhar")
		.assignDevice("Firefox")
		.assignCategory("Smoke")
		.fail("Smoke Test Failed");
		
		//Test - 4 Pass
		extentReport.createTest("Test 4", "Test Passed")
		.assignAuthor("Jaya Krishna")
		.assignDevice("Google Chrome", "Firefox", "Edge")
		.assignCategory("Smoke", "Regression", "Sanity")
		.pass("Smoke, Regression and Sanity tests passed");
		
		extentReport.flush();
		
		Desktop.getDesktop().browse(new File(allTests).toURI());
		Desktop.getDesktop().browse(new File(failTests).toURI());
		Desktop.getDesktop().browse(new File(passTests).toURI());
	}
}
