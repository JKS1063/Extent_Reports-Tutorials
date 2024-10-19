package Reports;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class R5_ExtentAttributes {

	public static void main(String[] args) throws Exception {
		
		ExtentReports extentReports = new ExtentReports();
		String filePath = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\ExtentReports\\Reports\\reports5.html";
		File file = new File(filePath);
		ExtentSparkReporter extentSparkReport = new ExtentSparkReporter(file);
		extentReports.attachReporter(extentSparkReport);
		
		// Single Attributes
		extentReports
		.createTest("Test 1", "Single Attribute test")
		.assignAuthor("Jaya Krishna")
		.assignCategory("Smoke")
		.assignDevice("Google Chrome")
		.fail("This test is failed");
		
		//Multiple Attributes
		extentReports
		.createTest("Test 2", "Muitple Attributes test") 
		.assignAuthor("HariHara", "Krishna", "Sekhar") // String Arrays can be passed here
		.assignDevice("Google Chrome", "FireFox")
		.assignCategory("Smoke", "Regression", "Sanity")
		.pass("This test is passed");
		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File(filePath).toURI());
	}
}
