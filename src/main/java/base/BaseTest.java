package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class BaseTest {
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public ExtentTest logger;
	@BeforeTest
	public static void BeforeTestMethod() {
		// Set up ExtentReports
		report=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("./Result/result.html");
		report.attachReporter(spark);
		report.setSystemInfo("", "");
		report.setSystemInfo("", "");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle(" Automation Report");
		spark.config().setReportName("Report by Hafisa");



	}
	@BeforeMethod
	@Parameters("browser")
	public void beforemethodmethod(String browser,Method testmethod) {
		logger=report.createTest(testmethod.getName());
		driversetup(browser);
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

	}
	@AfterMethod
	public void aftermethodmethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" -TestCase Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+" -TestCase Failed", ExtentColor.RED));
		}else if(result.getStatus()==ITestResult.SKIP){
			logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+" -TestCase Skipped",ExtentColor.ORANGE));
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" -TestCase Passed", ExtentColor.GREEN));
			driver.quit();
		}

	}
	@AfterTest
	public void aftertestmethod() {
		report.flush();
	}

	public void driversetup(String browser) {


		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} 
		else {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}

	}


}


