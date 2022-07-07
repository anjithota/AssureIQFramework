package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class MST_Division extends ActionEngine{
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

	@FindBy(id = "DIV_01")
	WebElement DivisionRegistrationMenu;
	
	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;
	
	@FindBy(id = "MST_DIV_CTF_001")
	WebElement DivUcode;
	
	@FindBy(id = "MST_DIV_CTF_001_error")
	WebElement DivUcodeError;
	
	@FindBy(id = "MST_DIV_CTF_002")
	WebElement DivDescription;
	
	@FindBy(id = "MST_DIV_CTF_002_error")
	WebElement DivDescriptionError;
	
	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement DivCodeValue;
	
	@FindBy(id = "DIV_02")
	WebElement DivisionModificationMenu;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearchButton;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;
	
	@FindBy(name = "MST_DIV_CTF_001")
	WebElement DivisionSearchCodeFilter;
	
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
	
	@FindBy(id = "DIV_03")
	WebElement DivisionStatusChangeMenu;
	
	
	
	
	public void divisionRegistrationInitiation(String uCode, String description) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
		}
		
		setUniquecode(Uniquecode = uCode + s);
		
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(DivisionRegistrationMenu);
		click(DivisionRegistrationMenu, "Division Registration Menu");
		
		click(SubmitButton, "Submit button");
		verifyCaptionContains(DivUcodeError, "Enter Value");
		sendText(DivUcode, Uniquecode, "division Code");
		
		
		click(SubmitButton, "Submit button");
		verifyCaptionContains(DivDescriptionError, "Enter Value");
		sendText(DivDescription, description, "division description");
		
		
		click(SubmitButton, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, DivCodeValue);
		switchToDefaultContent(driver);
		
	}
	
	public void divisionModificationInitiation(String description, String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(DivisionModificationMenu, "Market Modification menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, DivisionSearchCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		clearField(DivDescription, "Description");
		sendText(DivDescription, description, "Description");
		click(SubmitButton, "Submit");
		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks or reasons");
		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, DivCodeValue);
		switchToDefaultContent(driver);
	}
	
	public void divisionStatuschangeInactiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(DivisionStatusChangeMenu, "Division status change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, DivisionSearchCodeFilter);
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
		saveUniqueCode(driver, DivCodeValue);
		switchToDefaultContent(driver);
		
	}
	
	public void divisionStatuschangeActiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(DivisionStatusChangeMenu, "Division status change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, DivisionSearchCodeFilter);
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
		saveUniqueCode(driver, DivCodeValue);
		switchToDefaultContent(driver);
		
	}


	public void divisionStatuschangePermanentInactiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(DivisionStatusChangeMenu, "Division status change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, DivisionSearchCodeFilter);
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
		saveUniqueCode(driver, DivCodeValue);
		switchToDefaultContent(driver);
		
	}

	
}
