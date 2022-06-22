package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class MST_CustomHoliday extends ActionEngine {

	

	@FindBy(xpath = "//div[@class='left-menupanel']/div[2]")
	WebElement MasterMenu;
	
	@FindBy(id = "CAL3_01")
	WebElement CustomHolidayRegistrationMenu;
	
	@FindBy(id = "CAL3_02")
	WebElement CustomHolidayModificationMenu;

	@FindBy(id = "CAL3_03")
	WebElement CustomHolidayStatusChangeMenu;

	
	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(id = "MST_CAL_CTF_005_error")
	WebElement YearError;

	@FindBy(id = "MST_CAL_CTF_005")
	WebElement YearDropDown;

	@FindBy(xpath = "//span[@class= 'error reoccuring-date-error']")
	WebElement DateError;

	@FindBy(xpath = "//span[@id= 'select2-81no-container']")
	WebElement DateDropdown;

	@FindBy(xpath = "//span[@class='error reoccuring-month-error']")
	WebElement MonthError;

	@FindBy(xpath = "//span[@class= 'caliber-selectdropdown form-control reoccuring-month select2-hidden-accessible']")
	WebElement MonthDropDown;

	@FindBy(xpath = "//span[@class='caliber-textbox form-control reoccuring-desc']")
	WebElement Descripiton;

	@FindBy(xpath = "//span[@class='error reoccuring-desc-error']")
	WebElement DescriptionError;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement CustomHolidayCodeValue;
	
	@FindBy(name = "MST_CAL_CTF_001")
	WebElement CustomUcodeFilter;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearchButton;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

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

	public void CustomHolidayRegistrationInitiation(String year, String date, String month, String dscription) {

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(CustomHolidayRegistrationMenu);

		click(CustomHolidayRegistrationMenu, "Custom Holiday Registration menu");
		switchToBodyFrame(driver);

		click(SubmitButton, "Submit button");
		verifyCaptionContains(YearError, "Select Value");
		selectDropdownUsingVisisbleText(YearDropDown, year, "Year");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(DateError, "Select Value");
		selectDropdownUsingVisisbleText(DateDropdown, date, "Date");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(MonthError, "Select Value");
		selectDropdownUsingVisisbleText(MonthDropDown, month, "Month");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(DescriptionError, "Enter Value");
		sendText(Descripiton, dscription, "Description");

		click(SubmitButton, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, CustomHolidayCodeValue);
		switchToDefaultContent(driver);

	}
	
	public void CustomHolidayModificationInitiation(String month, String remarks) {
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(CustomHolidayModificationMenu);

		click(CustomHolidayRegistrationMenu, "Custom Holiday Registration menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, CustomUcodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		selectDropdownUsingVisisbleText(MonthDropDown, month, "Month");
		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks or reasons");
		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, CustomUcodeFilter);
		switchToDefaultContent(driver);
	
		

	}
	
	public void MarketStatuschangeInactiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(CustomHolidayStatusChangeMenu, "Custom Holiday Staus change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, CustomUcodeFilter);
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
		saveUniqueCode(driver, CustomUcodeFilter);
		switchToDefaultContent(driver);
		
	}
	
	public void MarketStatuschangeActiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(CustomHolidayStatusChangeMenu, "Custom Holiday Staus change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, CustomUcodeFilter);
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
		saveUniqueCode(driver, CustomUcodeFilter);
		switchToDefaultContent(driver);
		
	}
	
	public void MarketStatuschangePermanentInactiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(CustomHolidayStatusChangeMenu, "Custom Holiday Staus change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, CustomUcodeFilter);
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
		saveUniqueCode(driver, CustomUcodeFilter);
		switchToDefaultContent(driver);
		
	}
	
	
	
}
