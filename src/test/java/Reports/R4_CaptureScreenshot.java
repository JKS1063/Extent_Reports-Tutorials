package Reports;

import java.awt.Desktop;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class R4_CaptureScreenshot {

	private static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		ExtentReports extentReports = new ExtentReports();
		String filePath = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\ExtentReports\\Reports\\reports4.html";
		File file = new File(filePath);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		String path = getScreenShot("SwagLabs");
		
		extentReports
		.createTest("Test 1", "This is log level Screenshot")
		.info("This is info message")
		.addScreenCaptureFromPath(path);
		
		extentReports
		.createTest("Test 2", "This is test level ScreenShot")
		.pass("This is Login Page", MediaEntityBuilder.createScreenCaptureFromPath(path, "SwagLabs login").build()); //This is good practice
		
		Throwable t = new Throwable("This is throwable exception");
		extentReports
		.createTest("Test 3", "This is test level Screenshot")
		.fail(t, MediaEntityBuilder.createScreenCaptureFromPath(path, "SwagLabs login failed").build());
		
		extentReports.flush();
		
		driver.quit();
		Desktop.getDesktop().browse(new File(filePath).toURI());
	}
	
	public static String getScreenShot(String fileName) {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		
		File sourceFile =  takeScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File ("./ScreenShots/" + fileName);
		
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (Exception e) {
			System.out.println("Error Saving ScreenShot" + e.getMessage());
		}
		
		System.out.println("ScreenShot saved Successfully");
		return destFile.getAbsolutePath();
	}
}
