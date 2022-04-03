package com.gl.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gl.config.StartBrowser;
import com.gl.objectrepository.LumenDataPage;
import com.gl.reuse.CommonFunctions;
import com.gl.wdcmds.ActionDriver;

public class HomePage  extends StartBrowser{
  @Test
  public void testHomePage() throws Exception 
  {
	  CommonFunctions cfs = new CommonFunctions();
	  ActionDriver aDriver = new ActionDriver();
	  cfs.Login();
	  String txtLumen = aDriver.getText(LumenDataPage.txtTitle);
	  Assert.assertEquals(txtLumen, "Lumen Data Page");
	  StartBrowser.childTest.pass("Verification Done Sucessfully");
  }
}
