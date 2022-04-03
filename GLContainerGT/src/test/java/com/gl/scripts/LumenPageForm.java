package com.gl.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.gl.config.StartBrowser;
import com.gl.objectrepository.LumenDataPage;
import com.gl.reuse.CommonFunctions;
import com.gl.wdcmds.ActionDriver;

public class LumenPageForm extends StartBrowser{
  @Test
  public void testLumenPageForm()  throws Exception 
  {
	  CommonFunctions cfs = new CommonFunctions();
	  ActionDriver aDriver = new ActionDriver();
	  cfs.Login();
	  String txtLumen = aDriver.getText(LumenDataPage.txtTitle);
	  Assert.assertEquals(txtLumen, "Lumen Data Page");
	  StartBrowser.childTest.pass("Verification Done Sucessfully");
	  Fillo f = new Fillo();
	  Connection con = f.getConnection("TestData/Data.xlsx");
	  String strQuery = "Select * from TC1";
	  Recordset recordset = con.executeQuery(strQuery);
	  while(recordset.next())
	  {
	  cfs.submitForm(recordset.getField("SubmitterName"), recordset.getField("SubmitterEmail"), 
			  recordset.getField("ClientCode"), recordset.getField("GlCode"), recordset.getField("Assignment"),
			  recordset.getField("GlVersion"));
	  
	  }
  }
}
