package com.konakart.testscenarios;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.konakart.script.SortingByRating;

public class SpecificProductValidationScenario {
	
SortingByRating contentObj=new SortingByRating();
/**
 * 
 * @param browserType
 * @throws IOException
 */
@Parameters({"browserType"})
@BeforeClass
public void setBrowser(String browserType) throws IOException {
	contentObj.openBrowser(browserType);
}

/**
 * 	
 * @throws Exception
 */
	
@Test
public void navigateToProductDetails() throws Exception {
	contentObj.naviateToSpecificProductDetailPage();
	contentObj.navigateToProductDescription();
	contentObj.navigateToProductSpecification();
	contentObj.validateSortingByMostRecent();
	contentObj.validateSortingByOldest();
	contentObj.validateRatingHighToLow();
	contentObj.validateRatingLowToHigh();
	
}

}
