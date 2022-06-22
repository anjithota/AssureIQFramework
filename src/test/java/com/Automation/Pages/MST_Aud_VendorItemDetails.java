package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class MST_Aud_VendorItemDetails extends ActionEngine{
	
	Properties prop;
	public static String Uniquecode = "";

	public static String getUniqueCode() {
		return Uniquecode;
	}

	public static void setUniquecode(String uniquecode) {
		Uniquecode = uniquecode;
	}
	
	@FindBy(id = "BVID_01")
	WebElement VIDRegistrationMenu;
	
	@FindBy(id = "BVID_02")
	WebElement VIDModificationMenu;
	
	@FindBy(id = "BVID_03")
	WebElement VIDStatusChangeMenu;
	
	
	@FindBy(name = "MST_BSA_CTF_002")
	WebElement BAUcodeSearchFilter;
	
	@FindBy(className = "text-ellipsis")
	WebElement Record;
	
	@FindBy(xpath = "//div[@id='StdRemarks_container']//div[2]//span")
	WebElement RemarksError;

	@FindBy(id = "txtRemarks")
	WebElement RemarksText;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearchButton;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

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
	
	
	@FindBy(xpath = "//div[@class='left-menupanel']/div[5]")
	WebElement AuditManagementMenu;
	
	@FindBy(xpath = "//div[contains(text(),'System Generated')]")
	WebElement VIDCodeDafaultValue;
	
	@FindBy(id = "MST_VID_CTR_003_error")
	WebElement ItemsError;
	
	@FindBy(id = "MST_VID_CTR_003_button")
	WebElement ItemsButton;
	
	@FindBy(name = "MST_PRD_CTF_002")
	WebElement ItemCodeFilter;
	
	@FindBy(xpath = "//button[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement ItemAddButton;
	
	@FindBy(id = "btnOk")
	WebElement ItemPopupAdd;
	
	@FindBy(name = "MST_VID_CTR_002")
	WebElement VIDUcodeFilter;
	
	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement VIDCodeValue;
	

	
	public void vedorItemRegistrationInitiation(String BACode, String itemCode) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
		}

		//setUniquecode(Uniquecode = areaCode + s);

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(AuditManagementMenu, "Master Menu");
		scrollToViewElement(VIDRegistrationMenu);
		click(VIDRegistrationMenu, "Vendor and Item Details Registration menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		sendText(BAUcodeSearchFilter, BACode, "Business Associate ucode search filter");
		click(ApplyButton, "Apply button");
		click(Record, "Business associate record");
		
		verifyCaptionContains(VIDCodeDafaultValue, "<< System Generated >>");
		
		click(SubmitButton, "Submit button");
		verifyCaptionContains(ItemsError, "Select Value");
		click(ItemsButton, "Items Button");
		switchToPopupModelFrame(driver);//PopupModalFrame
		click(AdvancedSearchButton, "Advanced search button");
		sendText(ItemCodeFilter, itemCode, "Item Code");
		click(ApplyButton, "Apply Button");
		click(ItemAddButton, "Item Add button");
		click(ItemPopupAdd, "Item popup add button");
		switchToParentFrame(driver);
		click(SubmitButton, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, VIDCodeValue);
		switchToDefaultContent(driver);
		
			
	}
	
	public void vendorItemDetailsModificationInitiation(String itemCode, String remarks) {
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(AuditManagementMenu, "Master Menu");
		scrollToViewElement(VIDModificationMenu);
		click(VIDModificationMenu, "VID Modification Menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search button");
		enterUniqueCode(driver, VIDUcodeFilter);
		click(ApplyButton, "Apply button");
		click(ItemsButton, "Items Button");
	    switchToPopupModelFrame(driver);//PopupModalFrame	
		click(AdvancedSearchButton, "Advanced search button");
		sendText(ItemCodeFilter, itemCode, "Item Code");
		click(ApplyButton, "Apply Button");
		click(ItemAddButton, "Item Add button");
		click(ItemPopupAdd, "Item popup add button");
		switchToParentFrame(driver);
		click(SubmitButton, "Submit button");
		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks reasons");
		click(SubmitButton, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, VIDCodeValue);
		switchToDefaultContent(driver);
		
	}
	
	public void vidStatuschangeInactiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(AuditManagementMenu, "Audit Management Menu");
		click(VIDStatusChangeMenu, "VID Status Change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, VIDUcodeFilter);
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
		saveUniqueCode(driver, VIDCodeValue);
		switchToDefaultContent(driver);
		
	}
	
	public void vidStatuschangeActiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(AuditManagementMenu, "Audit Management Menu");
		click(VIDStatusChangeMenu, "VID Status Change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, VIDUcodeFilter);
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
		saveUniqueCode(driver, VIDCodeValue);
		switchToDefaultContent(driver);
		
	}
	
	public void vidStatuschangePermanentInactiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(AuditManagementMenu, "Master Menu");
		click(VIDStatusChangeMenu, "VID Status Change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, VIDUcodeFilter);
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
		saveUniqueCode(driver, VIDCodeValue);
		switchToDefaultContent(driver);
	}
	
	
	
	
	
	

}
