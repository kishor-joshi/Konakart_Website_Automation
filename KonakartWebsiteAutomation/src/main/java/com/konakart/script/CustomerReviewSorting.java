package com.konakart.script;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.konakart.helper.PageManager;
import com.konakart.utility.Constants;

import validationHelper.SortingValidationHelper;

/**
 * 
 * @author kishor.joshi
 *
 */

public class CustomerReviewSorting extends ValidationOfContent {
	SortingValidationHelper validation=new SortingValidationHelper();
	String sortingDropDownXpath,dropDownText;
	List<WebElement>dateList;
	public static String[] actualDateSorting,expectedDateSorting;
	
	
/**
 * 	
 * @throws Exception
 */
	
public void validateSortingByMostRecent() throws Exception {
	
	property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);
	
	dropDownText=property.getProperty("mostrecent");
	
	dateList=helper.getElements(driver, property, "date");
	actualDateSorting=validation.sortDate(dateList);
	expectedDateSorting=actualDateSorting;
	Arrays.sort(actualDateSorting);
	Assert.assertEquals(actualDateSorting, expectedDateSorting, "date sorting not matched");
	log.info("Most recent sorting order passed ");
	
}



public void validateSortingByOldest() throws Exception {
	
	property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);
	dropDownText=property.getProperty("oldest");
	PageManager.selectDropDownText(dropDownText, helper.getElement(driver, property, "sortingDropDown"));
	dateList=helper.getElements(driver, property, "date");
	actualDateSorting=validation.sortDate(dateList);
	expectedDateSorting=actualDateSorting;
	 Arrays.sort(actualDateSorting, Collections.reverseOrder()); 
	Assert.assertEquals(actualDateSorting, expectedDateSorting, "date sorting not matched");
	log.info("Oldest is first sorting order passed ");
}

}
