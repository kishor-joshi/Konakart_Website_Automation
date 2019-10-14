package com.konakart.script;


import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.konakart.helper.PageManager;
import com.konakart.utility.Constants;



public class SortingByRating extends CustomerReviewSorting{
	
	List<WebElement>allRatings;
	int[] actualRatingList,expectedRatingList;
	
/**
 * 	
 * @throws Exception
 */
public void validateRatingHighToLow() throws Exception {
	PageManager.manageTimeOuts(driver);
	property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);
	dropDownText=property.getProperty("highToLow");
	PageManager.selectDropDownText(dropDownText,helper.getElement(driver, property, "sortingDropDown"));
	allRatings=helper.getElements(driver, property, "date");
	actualRatingList=validation.getRating(driver, property,allRatings.size());
	expectedRatingList=actualRatingList;
	
	Assert.assertEquals(actualRatingList, expectedRatingList,"rating not matched");
    log.info("rating High to low order: "+Arrays.toString(expectedRatingList));
	
	log.info(" High to Low Rating, sorting order passed ");
 
	
}
/**
 * 
 * @throws Exception
 */

public void validateRatingLowToHigh() throws Exception {
	PageManager.manageTimeOuts(driver);
	property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);
	dropDownText=property.getProperty("lowToHigh");
	PageManager.selectDropDownText(dropDownText,helper.getElement(driver, property, "sortingDropDown"));
	allRatings=helper.getElements(driver, property, "date");
	actualRatingList=validation.getRating(driver, property,allRatings.size());
	expectedRatingList=actualRatingList;
	Arrays.sort(expectedRatingList);
	Assert.assertEquals(actualRatingList, expectedRatingList,"rating not matched");
	log.info("rating low to High order: "+Arrays.toString(expectedRatingList));
	log.info(" Low to High Rating, sorting order passed ");
	
	
}
}
