package com.gl.wdcmds;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.gl.config.StartBrowser;

public class ActionDriver 
{
    public WebDriver driver;
    
    public ActionDriver() 
    {
    	driver = StartBrowser.driver;
    }
    /**
     * Use to Naviagte to given URL
     * @param url -- http://xxxxx.test.com
     */
    public void navigateToApplication(String url) 
    {
    	try {
    		driver.get(url);
    		StartBrowser.childTest.pass("Successfully Navigate to : "+ url);
    	} catch (Exception e) {
    		StartBrowser.childTest.fail("Unable to Navigate to : "+ url);
    	}
    }
    /**
     * Use to perform click action on buttons, check box, links, radio buttons
     * @param locator-- Get it from object repository
     * @param eleName -- Name of the element on which you are performing action ex: Gl container
     * @throws Exception
     */
    public void click(By locator, String eleName) throws Exception 
    {
    	try {
    		driver.findElement(locator).click();
    		StartBrowser.childTest.pass("Successfully Performed click action on : "+ eleName);
    	} catch (Exception e) {
    		StartBrowser.childTest.fail("Unable to Perform click action on : "+ eleName,
    				MediaEntityBuilder.createScreenCaptureFromBase64String(screeShot()).build());
    		StartBrowser.childTest.info(e);
    		throw e;
    	}
    }
    public String getText(By locator)
    {
    	return driver.findElement(locator).getText();
    }
    public String screeShot() {
    	return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    }
    /**
     * Use to type in text boxes or Text areas
     * @param locator -- Get it from Object repository
     * @param testData -- what you want to type in text
     * @param eleName -- Name of the element on which you are performing action ex: submitter text field
     * @throws Exception
     */
    public void type(By locator, String testData, String eleName) throws Exception
    {
    	try {
			driver.findElement(locator).sendKeys(testData);
			StartBrowser.childTest.pass("Successfully Performed type action in : "+ eleName + " With Data" + testData);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to perform type action in: "+ eleName + "With Data"+ testData,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screeShot()).build());
			StartBrowser.childTest.info(e);
    		throw e;
		}
    }
    /**
     * Use to perform mousehover on any given element
     * @param locator -- Get it from Object repository
     * @param eleName -- Name of the element on which you are performing action 
     * @throws Exception
     */
    public void mouseHover(By locator, String eleName) throws Exception
    {
    	try {
			Actions a = new Actions(driver);
			WebElement mo = driver.findElement(locator);
			a.moveToElement(mo).build().perform();
			StartBrowser.childTest.pass("Successfully performed mousehover on: "+eleName);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to perform mousehover action: "+ eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screeShot()).build());
			StartBrowser.childTest.info(e);
    		throw e;
			
		}
    }
}
