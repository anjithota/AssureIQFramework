package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class MST_Facility extends ActionEngine {
	Properties prop;
	public static String Uniquecode = "";

	public static String getUniqueCode() {
		return Uniquecode;
	}

	public static void setUniquecode(String uniquecode) {
		Uniquecode = uniquecode;
	}

	@FindBy(xpath = "//div[@class='left-menupanel']/div[2]")
	WebElement MasterMenu;

	@FindBy(id = "FCT_01")
	WebElement FacilityRegistrationMenu;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement FacilityCodeValue;

	@FindBy(id = "MST_FCT_CTF_001")
	WebElement FacilityUcode;

	@FindBy(id = "MST_FCT_CTF_001_error")
	WebElement FacilityUcodeError;

	@FindBy(id = "MST_FCT_CTF_002")
	WebElement FacilityDescription;

	@FindBy(id = "MST_FCT_CTF_002_error")
	WebElement FacilityDescriptionError;

	@FindBy(id = "FCT_02")
	WebElement FacilityModificationMenu;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearchButton;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(name = "MST_FCT_CTF_001")
	WebElement FacilitySearchCodeFilter;

	@FindBy(xpath = "//div[@id='StdRemarks_container']//div[2]//span")
	WebElement RemarksError;

	@FindBy(id = "txtRemarks")
	WebElement RemarksText;
	
	@FindBy(id = "FCT_03")
	WebElement FacilityStatusChangeMenu;
	
	@FindBy(xpath = "//div[@class='col caliber-control-group haserror']/div/span")
	WebElement ProposedStatusError;
	
	@FindBy(xpath = "//label[@for='NewStatus_1']")
	WebElement ActiveButton;
	
	@FindBy(xpath = "//label[@for='NewStatus_5']")
	WebElement InactiveButton;
	
	@FindBy(xpath = "//label[@for='NewStatus_10']")
	WebElement PermanentInactiveButton;
	
	@FindBy(xpath = "//button[@id = 'confirmationRevertNo']")
	WebElement PermanaentInactiveNoButton;

	@FindBy(xpath = "//button[@id = 'confirmationRevertYes']")
	WebElement PermanaentInactiveYesButton;

	public void facilityRegistrationInitiation(String uCode, String description) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
		}

		setUniquecode(Uniquecode = uCode + s);

		switchToDefaultContent(driver);
		TimeUtil.shortWait();

		click(MasterMenu, "Master Menu");
		scrollToViewElement(FacilityRegistrationMenu);

		click(FacilityRegistrationMenu, "Facility Registration Menu");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(FacilityUcodeError, "Enter Value");
		sendText(FacilityUcode, Uniquecode, "Facility Code");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(FacilityDescriptionError, "Enter Value");
		sendText(FacilityDescription, description, "Description");
		click(SubmitButton, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, FacilityCodeValue);
		switchToDefaultContent(driver);

	}

	public void facilityModificationInitiation(String description, String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		scrollToViewElement(FacilityModificationMenu);
		click(FacilityModificationMenu, "Market Modification menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, FacilitySearchCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		clearField(FacilityDescription, "Description");
		sendText(FacilityDescription, description, "Description");
		click(SubmitButton, "Submit");
		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks or reasons");
		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, FacilityCodeValue);
		switchToDefaultContent(driver);
	}
	
	public void facilityStatuschangeInactiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(FacilityStatusChangeMenu, "Facility Staus change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, FacilitySearchCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		click(SubmitButton, "Submit");
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(PermanentInactiveButton, "Permanent Inactive Button");
		TimeUtil.shortWait();
		click(PermanaentInactiveNoButton, "Permanent Inactive No Button");
		click(InactiveButton, "Inactive Button");
		click(SubmitButton, "Submit");
		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks");
		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, FacilityCodeValue);
		switchToDefaultContent(driver);
		
	}

	public void facilityStatuschangeActiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(FacilityStatusChangeMenu, "Facility Status change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, FacilitySearchCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		click(SubmitButton, "Submit");
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(PermanentInactiveButton, "Permanent Inactive Button");
		TimeUtil.shortWait();
		click(PermanaentInactiveNoButton, "Permanent Inactive No Button");
		click(ActiveButton, "Active Button");
		click(SubmitButton, "Submit");
		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks");
		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, FacilityCodeValue);
		switchToDefaultContent(driver);
		
	}
	
	public void facilityStatuschangePermanentInactiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(FacilityStatusChangeMenu, "Division status change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, FacilitySearchCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		click(SubmitButton, "Submit");
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(PermanentInactiveButton, "Permanent Inactive Button");
		TimeUtil.shortWait();
		click(PermanaentInactiveYesButton, "Permanent Inactive Yes Button");
		
		click(SubmitButton, "Submit");
		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks");
		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, FacilityCodeValue);
		switchToDefaultContent(driver);
		
	}

}
