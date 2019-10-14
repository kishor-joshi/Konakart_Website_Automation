package com.konakart.script;


import org.openqa.selenium.WebElement;
import com.konakart.helper.ExcelReader;
import com.konakart.helper.PageManager;
import com.konakart.utility.BaseClass;
import com.konakart.utility.Constants;

import validationHelper.ValidationOfEachContentPage;

public class ValidationOfContent extends BaseClass {
	
	
  ValidationOfEachContentPage eachContentObj=new ValidationOfEachContentPage();
  WebElement galleryElement;
  public static String pageTitle,description,specification;
  public static int titleIndex;
  public  String[][] getProductDetail;
/**
 * 
 * @throws Exception
 */
  public void naviateToSpecificProductDetailPage() throws Exception {
		property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);
		
		helper.getElement(driver, property, "imageLink").click();
	}

	/**
	 * 
	 * @throws Exception
	 */
  public void navigateToProductDescription() throws Exception {
		property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);
		pageTitle=helper.getElement(driver, property, "pagetitle").getText();
		log.info("selected product is "+pageTitle);
		PageManager.scrollAndViewAtTop(driver, helper.getElement(driver, property, "gallery"));
		getProductDetail=ExcelReader.getUserData(Constants.productDetailDataPath);
		
		if(pageTitle.equalsIgnoreCase(getProductDetail[0][0]))
			titleIndex=0;
		else
			titleIndex=1;
		
		PageManager.scrollAndViewAtTop(driver, helper.getElement(driver, property, "gallery"));
		helper.getElement(driver, property, "productdescription").click();
		description=helper.getElement(driver, property, "descriptioncontent").getText();
		
		ValidationOfEachContentPage.validateProductDetails(description, getProductDetail[titleIndex][1]);
		
		
		log.info("Validation of Description part is passed ");
	}
	
	
/**
 * 	
 * @throws Exception
 */
  public void navigateToProductSpecification() throws Exception {
		property=PageManager.loadpropertyFile(Constants.productPropertiesFilePath);
		helper.getElement(driver, property, "productspecification").click();
		description=helper.getElement(driver, property, "specificationcontent").getText();
		
		ValidationOfEachContentPage.validateProductDetails(description, getProductDetail[titleIndex][2]);
		log.info("Validation of specification is passed ");
		helper.getElement(driver, property, "reviewtab").click();
	}
}
