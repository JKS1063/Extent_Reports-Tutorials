package Reports;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class R6_ReportsConfig {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		
		ExtentReports extentReports = new ExtentReports();
		String filePath = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\ExtentReports\\Reports\\reports6.html";
		File file = new File(filePath);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		ExtentSparkReporterConfig config = sparkReporter.config();
		
		// Configuration
//		config.setTheme(Theme.DARK); //Sets Dark theme
//		config.setReportName("Test Reports"); //Sets Reports name
//		config.setDocumentTitle("Extent Title"); // Sets Document Title
//		config.setTimeStampFormat("dd/MM/yyyy hh:mm:ss"); // Sets TimeStamp format
//		config.setCss(".badge-default{background-color:yellow}"); //Sets CSS Styles
//		config.setJs("document.getElementsByClassName('logo')[0].style.display = 'none';"); // Sets JavaScript
		
		// Or
		
		//String jsonFile = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\ExtentReports\\Resources\\extent_reports_config.json";
		//sparkReporter.loadJSONConfig(new File(jsonFile));
		
		// Or
		
		File jsonFile = new File("D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\ExtentReports\\Resources\\extent_reports_config.json");
		sparkReporter.loadJSONConfig(jsonFile);
		
		extentReports.attachReporter(sparkReporter);
		
		String[] authors = {"Jaya Krishna", "HariHara", "Shiva"};
		String[] devices = {"Google Chrome", "Firefox", "Edge"};
		String[] tests = {"Smoke", "Regression"};
		
		// Test - 1
		extentReports
		.createTest("Test - 1", "This is test 1")
		.assignAuthor(authors[0])
		.assignCategory(tests[1])
		.assignDevice(devices[2])
		.fail("This test failed");
		
		// Test - 2
		extentReports
		.createTest("Test 2", "This is test 2")
		.assignAuthor(authors)
		.assignCategory(tests)
		.assignDevice(devices)
		.pass("This test passed");
		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File(filePath).toURI());
		
	}
}
