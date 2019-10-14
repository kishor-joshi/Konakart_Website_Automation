package com.konakart.script;

import java.util.List;
import org.openqa.selenium.WebElement;

import com.konakart.helper.PageManager;

import com.konakart.utility.BaseClass;
import com.konakart.utility.Constants;

import validationHelper.ItemMessageValidation;

public class QuickSearchPage extends BaseClass{
public static	String dropDownLocator, actualMessage,expectedMessage;
public static   List<WebElement>itemList;
	/**
	 * 
	 * @param dropDownText
	 * @param productName
	 * @param message
	 * @throws Exception
	 */
public void searchProduct(String dropDownText,String productName,String message) throws Exception {
	property=PageManager.loadpropertyFile(Constants.SearchPagePropertiesFilePath);
	PageManager.selectDropDownText(dropDownText,helper.getElement(driver, property, "dropdown"));
	helper.getElement(driver, property, "input").sendKeys(productName);
	this.expectedMessage=message;
	log.info("product Name is: "+productName+" dropDownText is: "+dropDownText);
	helper.getElement(driver, property, "searchbutton").click();
	
}

/**
 * 
 * @throws Exception
 */
public void getItemMessage() throws Exception {
	property=PageManager.loadpropertyFile(Constants.SearchPagePropertiesFilePath);
	
	itemList=helper.getElements(driver, property, "itemMessage");
	
	if(itemList.size()>0) {
		actualMessage=itemList.get(0).getText();
		ItemMessageValidation.validateItemMessage(actualMessage, expectedMessage);
		
	}
	else
	{
		List<WebElement>productList=helper.getElements(driver, property, "productList");
		ItemMessageValidation.getItems(productList);
	}
	
}
}
