package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class MST_WeekendHoliday extends ActionEngine {

	@FindBy(xpath = "//div[@class='left-menupanel']/div[2]")
	WebElement MasterMenu;

	@FindBy(id = "CAL1_02")
	WebElement weekendModificationMenu;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(xpath = "//input[@class='date-range-control form-control date-range-control-from']")
	WebElement DateFilterCode;

	@FindBy(xpath = "//button[text()='Apply']")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;
	
	@FindBy(id="MST_CAL_CTF_003_error")
	WebElement WeekendsError;

	@FindBy(xpath = "//div[@class='d-inline-block custom-checkbox mr-1'][1]")
	WebElement Sunday;

	@FindBy(xpath = "//div[@class='d-inline-block custom-checkbox mr-1'][2]")
	WebElement Monday;

	@FindBy(xpath = "//div[@class='d-inline-block custom-checkbox mr-1'][3]")
	WebElement Tuesday;

	@FindBy(xpath = "//div[@class='d-inline-block custom-checkbox mr-1'][4]")
	WebElement Wednesday;

	@FindBy(xpath = "//div[@class='d-inline-block custom-checkbox mr-1'][5]")
	WebElement Thursday;

	@FindBy(xpath = "//div[@class='d-inline-block custom-checkbox mr-1'][6]")
	WebElement Friday;

	@FindBy(xpath = "//div[@class='d-inline-block custom-checkbox mr-1'][7]")
	WebElement Saturday;

	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement Remarks_Error;

	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement UniqueCodePopUp;

	@FindBy(id = "cfnMsg_Next")
	WebElement Done;

	// AuditTrails

	@FindBy(id = "CAL1_04")
	WebElement AuditTrails;
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement AuditTrailsclose;

	public void WeekendModificationScreen(String date, String remarksReason) {

		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(weekendModificationMenu);
		click(weekendModificationMenu, "weekend ModificationMenu");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		/// click(DateFilterCode, "DateFilterCode");
		// clearField(DateFilterCode, "Date FilterCode");
		sendText(DateFilterCode, date, "DateFilterCode");
		click(ApplyButton, "Apply Button");
		click(Record, "Record");

		UnSelectRadioBtnAndCheckbox(driver, Sunday);
		UnSelectRadioBtnAndCheckbox(driver, Monday);
		UnSelectRadioBtnAndCheckbox(driver, Tuesday);
		UnSelectRadioBtnAndCheckbox(driver, Wednesday);
		UnSelectRadioBtnAndCheckbox(driver, Thursday);
		UnSelectRadioBtnAndCheckbox(driver, Friday);
		UnSelectRadioBtnAndCheckbox(driver, Saturday);
		click(SubmitBtn, "Submit Button");
		verifyCaptionContains(WeekendsError, "Select Value");
		sunday();
		monday();
		click(SubmitBtn, "Submit Button");
		verifyCaptionContains(Remarks_Error, "Enter Value");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "Submit Button");
		
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCodePopUp);
		click(Done, "Done poup");
		switchToDefaultContent(driver);
		

	}
	public void sunday() {
		click(Sunday, "Sunday");	
	}
	
	public void monday() {
		click(Monday, "Monday");
	}
	
	public void tuesday() {
		click(Tuesday, "Tuesday");
	}
	public void thursday() {
		click(Thursday, "Thursday");
	}
	public void friday() {
		click(Friday, "Friday");
		
	}
	public void saturday() {
		click(Saturday, "Saturday");
	}
	
	

	public void WeekendAuditTrails() {

		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(AuditTrails);
		click(AuditTrails, "weekend ModificationMenu");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(Record, "Record");
		switchToPopupModelFrame(driver);
		click(AuditTrailsclose, "close pop");
		switchToDefaultContent(driver);
		
	}
}
