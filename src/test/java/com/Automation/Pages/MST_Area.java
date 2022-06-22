package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class MST_Area extends ActionEngine {
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

	@FindBy(id = "AREM_01")
	WebElement AreaRegistrationMenu;

	@FindBy(id = "AREM_02")
	WebElement AreaModificatinMenu;

	@FindBy(id = "AREM_03")
	WebElement AreaStatusChangeMenu;

	// MST_AREA_CTF_001
	@FindBy(id = "MST_AREA_CTF_001")
	WebElement AreaUcode;

	@FindBy(id = "MST_AREA_CTF_002")
	WebElement AreaName;

	@FindBy(id = "MST_AREA_CTF_001_error")
	WebElement AreaUcodeError;

	@FindBy(id = "MST_AREA_CTF_002_error")
	WebElement AreaNameError;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(xpath = "//div[@id='StdRemarks_container']//div[2]//span")
	WebElement RemarksError;

	@FindBy(id = "txtRemarks")
	WebElement RemarksText;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement AreaCodeValue;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearchButton;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(name = "MST_AREA_CTF_001")
	WebElement areaCodeSearchFilter;
	
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
	
	
	public void areaRegistrationInitiation(String areaCode, String areaName) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
		}

		setUniquecode(Uniquecode = areaCode + s);

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(AreaRegistrationMenu);
		click(AreaRegistrationMenu, "Area Registration Menu");
		click(SubmitButton, "Submit button");

		verifyCaptionContains(AreaUcodeError, "Enter Value");
		sendText(AreaUcode, Uniquecode, "Area Code");

		click(SubmitButton, "Submit button");

		verifyCaptionContains(AreaNameError, "Enter Value");
		sendText(AreaName, areaName, "Area Name");
		
		click(SubmitButton, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		

	}
	
	public void areaModificationInitiation(String areaName, String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(AreaModificatinMenu, "Area Modification menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, areaCodeSearchFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		clearField(AreaName, "Area Name");
		sendText(AreaName, areaName, "Area Name");
		click(SubmitButton, "Submit");
		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks or reasons");
		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, AreaCodeValue);
		switchToDefaultContent(driver);
	}

	public void areaStatusChangeInactive(String remarks) {

		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(AreaStatusChangeMenu, "Status Change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, areaCodeSearchFilter);
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
		saveUniqueCode(driver, AreaCodeValue);
		switchToDefaultContent(driver);
		
		

	}
	
	public void areaStatusChangeActive(String remarks) {

		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(AreaStatusChangeMenu, "Status Change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, areaCodeSearchFilter);
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
		saveUniqueCode(driver, AreaCodeValue);
		switchToDefaultContent(driver);
		
		

	}
	
	public void areaStatusChangePermanentInactive(String remarks) {

		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(AreaStatusChangeMenu, "Status Change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, areaCodeSearchFilter);
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
		saveUniqueCode(driver, AreaCodeValue);
		switchToDefaultContent(driver);
		
		

	}
}
