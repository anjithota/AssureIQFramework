package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class MST_OtherImpactedSites extends ActionEngine {
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

	@FindBy(id = "OTSM_01")
	WebElement OISRegistrationMenu;

	@FindBy(id = "OTSM_02")
	WebElement OISModificatinMenu;

	@FindBy(id = "OTSM_03")
	WebElement OIStatusChangeMenu;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement OISCodeValue;
	
	@FindBy(id = "MST_OTS_CTF_001")
	WebElement OISUcode;
	
	@FindBy(id = "MST_OTS_CTF_001_error")
	WebElement OISUcodeError;
	
	@FindBy(id = "MST_OTS_CTF_002_error")
	WebElement OISDescriptionError;
	
	@FindBy(id = "MST_OTS_CTF_002")
	WebElement OISDescription;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearchButton;

	
	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;
	
	@FindBy(name = "MST_OTS_CTF_001")
	WebElement OISSearchFilter;
	
	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(xpath = "//div[@id='StdRemarks_container']//div[2]//span")
	WebElement RemarksError;

	@FindBy(id = "txtRemarks")
	WebElement RemarksText;
	
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


	public void oisRegistrationInitiation(String uCode, String description) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
		}

		setUniquecode(Uniquecode = uCode + s);

		switchToDefaultContent(driver);
		TimeUtil.shortWait();

		click(MasterMenu, "Master Menu");
		scrollToViewElement(OISRegistrationMenu);

		click(OISRegistrationMenu, "OIS Registration Menu");
		
		switchToBodyFrame(driver);
		
		click(SubmitButton, "Submit button");
		verifyCaptionContains(OISUcodeError, "Enter Value");
		sendText(OISUcode, Uniquecode, "Unique code");
		
		click(SubmitButton, "Submit button");
		verifyCaptionContains(OISDescriptionError, "Enter Value");
		sendText(OISDescription, description, "Description");
		saveUniqueCode(driver, OISCodeValue);
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		switchToDefaultContent(driver);
		}
	
	public void oisModificationInitiation(String description, String remarks) {

		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		scrollToViewElement(OISModificatinMenu);
		click(OISModificatinMenu, "Modification menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, OISSearchFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		clearField(OISDescription, "Description");
		sendText(OISDescription, description, "Quality inspDescriptionection");
		click(SubmitButton, "Submit");
		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks or reasons");
		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, OISCodeValue);
		switchToDefaultContent(driver);

	}
	
	public void oisStatusChangeInactive(String remarks) {

		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(OIStatusChangeMenu, "Status Change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, OISSearchFilter);
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
		saveUniqueCode(driver, OISCodeValue);
		switchToDefaultContent(driver);
		
		

	}
	
	public void oisStatusChangeActive(String remarks) {

		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(OIStatusChangeMenu, "Status Change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, OISSearchFilter);
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
		saveUniqueCode(driver, OISCodeValue);
		switchToDefaultContent(driver);
		
		

	}
	
	public void oisStatusChangePermanentInctive(String remarks) {

		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(OIStatusChangeMenu, "Status Change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, OISSearchFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		click(SubmitButton, "Submit");
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(PermanentInactiveButton, "Permanent Inactive Button");
		TimeUtil.shortWait();
		click(PermanaentInactiveYesButton, "Permanent Inactive Yes Button");
		//click(ActiveButton, "Active Button");
		click(SubmitButton, "Submit");
		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks");
		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, OISCodeValue);
		switchToDefaultContent(driver);
		
		

	}
	

	
	
}
