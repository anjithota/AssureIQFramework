package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Base.ActionEngine;
import com.Automation.Base.TestEngine;
import com.Automation.Utils.TimeUtil;

public class MST_Facility extends ActionEngine {
	Properties prop;
	public static String Uniquecode = "";
	public static String Description = "";
	public static String getUniqueCode() {
		return Uniquecode;
	}

	public static void setUniquecode(String uniquecode) {
		Uniquecode = uniquecode;
	}
	@FindBy(xpath= "//*[@class='caliber-product-qams product-icon1']")
	WebElement assureiq;
	@FindBy(xpath= "//*[contains(text(),'Master')]")
	WebElement Master;
	@FindBy(xpath= "//ul[@id='QAMS_MASTMOD']/preceding-sibling::a")
	WebElement Facility;
	@FindBy(xpath= "//*[contains(text(),'Facility')]//li")
	WebElement FacilityRegistration;
	@FindBy(id = "MST_FCT_CTF_001")
	WebElement UniqueCode;
	@FindBy(id = "MST_FCT_CTF_002")
	WebElement FDescription;
	@FindBy(id = "btnSubmit_1")
	WebElement Submit;
	public MST_Facility() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void facilityRegistration(String Uniquecode, String Description) {
		waitForPageToLoad(3000);
		click(assureiq, "assureiq icon");
		TimeUtil.shortWait();
		jsClick(Master, "MasterMenu");
		System.out.println("master menu");
		TimeUtil.shortWait();
		jsClick(Facility, "Facility menu");
		System.out.println("Facility menu");
		TimeUtil.shortWait();
		jsClick(FacilityRegistration, "Facility Registration menu");
		System.out.println("Facility reg menu");
		/*click(Facility, "Facility menu");
		click(FacilityRegistration, "Facility Registration menu");*/
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		sendText(UniqueCode, Uniquecode, "Uniuecode");
		//sendKeys(FDescription, Description, "Facility description");
		sendText(FDescription, Description, "Descritpion");
		click(Submit, "SubmitButton");
		
		
		
	}
	
	
	
	
	
	
	//@FindBy(xpath= "//ul[1]/li[2]/a[contains(text(),'Course Manager')]")
	//WebElement CourseManagerMenu;
}
 