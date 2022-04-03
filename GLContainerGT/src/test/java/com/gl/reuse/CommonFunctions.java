package com.gl.reuse;

import org.openqa.selenium.WebDriver;

import com.gl.config.StartBrowser;
import com.gl.objectrepository.HomePage;
import com.gl.objectrepository.LumenDataPage;
import com.gl.wdcmds.ActionDriver;

public class CommonFunctions 
{

	public WebDriver driver;
	public ActionDriver aDriver;
	
	public CommonFunctions()
	{
		driver = StartBrowser.driver;
		aDriver = new ActionDriver();
	}
	
	public void Login() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to GL Container");
		aDriver.navigateToApplication("http://gl.container.com");
		aDriver.click(HomePage.btnSignIn,"Signing in Gl Container");
	}
	
	public void submitForm(String submitterName, String submitterEmail, String clientCode, String GLCode, 
			String assignment, String glVersion) throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to GL Container");
		aDriver.navigateToApplication("http://gl.container.com");
		aDriver.type(LumenDataPage.txtSubmitter, submitterName, "Submitter Name field");
		aDriver.type(LumenDataPage.txtSubmitterEmail, submitterEmail , "Submitter Email field");
		aDriver.type(LumenDataPage.txtClientCode, clientCode, "Client code field");
		aDriver.type(LumenDataPage.txtGlCode, GLCode, "Gl Code field");
		aDriver.type(LumenDataPage.txtAssignment, assignment, "Assignement field");
		aDriver.type(LumenDataPage.txtGlVersion, glVersion, "GL Version field");
		aDriver.click(LumenDataPage.btnSignIn,"Submit link");
		
	}
}
