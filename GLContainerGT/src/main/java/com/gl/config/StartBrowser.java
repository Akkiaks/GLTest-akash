package com.gl.config;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;


public class StartBrowser {
  public static WebDriver driver;
  
  //Extent report variable
  public static ExtentReports extent;
  public static ExtentTest parentTest;
  public static ExtentTest childTest;
  ExtentSparkReporter sparkreporter;
  String method;
  
  @BeforeTest
  public void generateReport() {
	  sparkreporter = new ExtentSparkReporter("Reports/AutomationReports.html");
	  extent = new ExtentReports();
	  extent.attachReporter(sparkreporter);
  }
  
  @BeforeMethod
  public void methodName(Method method) {
	  parentTest = extent.createTest(method.name());
  }
  
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  extent.flush();
  }

}
