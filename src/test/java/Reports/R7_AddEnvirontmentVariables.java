package Reports;

import java.awt.Desktop;
import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class R7_AddEnvirontmentVariables {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
//		System.out.println(capabilities.getBrowserName()); // Prints Browser name
//		System.out.println(capabilities.getBrowserVersion()); // Prints Browser version
//		System.getProperties().list(System.out); // Prints list of system properties
		
		ExtentReports extentReports = new ExtentReports();
		String filePath = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\ExtentReports\\Reports\\reports7.html";
		File file = new File(filePath);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		
		//System/Environment Variables
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java", System.getProperty("java.version"));
		extentReports.setSystemInfo("Browser", capabilities.getBrowserName() + " " + capabilities.getBrowserVersion());
		extentReports.setSystemInfo("APP URL", "https://www.saucedemo.com/");
		extentReports.setSystemInfo("username", "extentuser@usermail.com");
		extentReports.setSystemInfo("Password", "12345");
		
		// Test 1
		extentReports
		.createTest("Test 1 ", "This is test 1")
		.assignAuthor("Krishna", "Sekhar")
		.assignCategory("Smoke", "Regression")
		.pass("Test passed");
		
		//Test 2
		extentReports
		.createTest("Test 2", "This is test 2")
		.assignAuthor("Jaya Krishna")
		.assignCategory("Regression")
		.fail("Test failed");
		
		extentReports.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File(filePath).toURI());
	
	}

}
