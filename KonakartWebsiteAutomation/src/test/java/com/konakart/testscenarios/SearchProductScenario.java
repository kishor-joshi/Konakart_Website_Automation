package com.konakart.testscenarios;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.konakart.script.QuickSearchPage;
import com.konakart.utility.DataProviderClass;



public class SearchProductScenario {

	
	QuickSearchPage page=new QuickSearchPage();
	
	/**
	 * 		
	 * @param browserType
	 * @throws IOException
	 */
			
	@Parameters({"browserType"})
	@BeforeClass
	public void setBrowser(String browserType) throws IOException {
		page.openBrowser(browserType);
	}
	
		
	/**
	 * 	
	 * @param dropDownText
	 * @param productName
	 * @param message
	 * @throws Exception
	 */
	@Test(dataProvider = "userData",dataProviderClass =DataProviderClass.class )
	public void OutComeOfSearch(String dropDownText,String productName,String message) throws Exception {
   page.searchProduct(dropDownText, productName,message);
			
	}
/**
 * 	
 * @throws Exception
 */
	@AfterMethod
	public void message() throws Exception {
		page.getItemMessage();
			
		}
}
