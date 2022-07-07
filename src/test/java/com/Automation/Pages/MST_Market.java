package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class MST_Market extends ActionEngine {
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

	@FindBy(id = "MKT_01")
	WebElement MarketRegistrationMenu;
	
	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;
	
	@FindBy(id = "MST_MKT_CTF_001")
	WebElement MarketCode;
	
	@FindBy(id = "MST_MKT_CTF_001_error")
	WebElement MarketCodeError;
	
	@FindBy(id = "MST_MKT_CTF_003")
	WebElement MarketName;
	
	@FindBy(id = "MST_MKT_CTF_003_error")
	WebElement MarketNameError;
	
	@FindBy(id = "MST_MKT_CTF_002")
	WebElement MarketDescription;
	
	@FindBy(id = "MST_MKT_CTF_002_error")
	WebElement MarketDescriptionError;
	
	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement MarketCodeValue;
	
	@FindBy(id = "MKT_02")
	WebElement MarketModificationMenu;
	
	@FindBy(id = "MKT_03")
	WebElement MarketStatusChangeMenu;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearchButton;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;
	
	@FindBy(name = "MST_MKT_CTF_001")
	WebElement MarketSearchCodeFilter;
	
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
	WebElement PermanaentInactiveYesButton;	//"C:\Users\sandeepbd\OneDrive - caliberuniversal\Pictures\tet.PNG"
	public void StageRegistrationInitiation(String marketCode, String marketName, String description) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
		}
		
		setUniquecode(Uniquecode = marketCode + s);
		
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(MarketRegistrationMenu);

		click(MarketRegistrationMenu, "Market Registration menu");
		switchToBodyFrame(driver);
		
		click(SubmitButton, "Submit button");
		verifyCaptionContains(MarketCodeError, "Enter Value");
		sendText(MarketCode, marketCode, "Market Code");
		
		click(SubmitButton, "Submit button");
		verifyCaptionContains(MarketNameError, "Enter Value");
		sendText(MarketName, marketName, "Stage Name");
		
		click(SubmitButton, "Submit button");
		verifyCaptionContains(MarketDescriptionError, "Enter Value");
		sendText(MarketDescription, description, "Description");
		
		click(SubmitButton, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, MarketCodeValue);
		switchToDefaultContent(driver);

		
	}
	
	public void marketModificationInitiation(String description, String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(MarketModificationMenu, "Market Modification menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, MarketSearchCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		clearField(MarketDescription, "Description");
		sendText(MarketDescription, description, "Description");
		click(SubmitButton, "Submit");
		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks or reasons");
		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, MarketCodeValue);
		switchToDefaultContent(driver);
	}
	
	public void MarketStatuschangeInactiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(MarketStatusChangeMenu, "Market Staus change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, MarketSearchCodeFilter);
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
		saveUniqueCode(driver, MarketCodeValue);
		switchToDefaultContent(driver);
		
	}
	
	public void MarketStatuschangeActiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(MarketStatusChangeMenu, "Market Staus change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, MarketSearchCodeFilter);
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
		saveUniqueCode(driver, MarketCodeValue);
		switchToDefaultContent(driver);
		
	}
	
	public void MarketStatuschangePermanentInactiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(MarketStatusChangeMenu, "Market Staus change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, MarketSearchCodeFilter);
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
		saveUniqueCode(driver, MarketCodeValue);
		switchToDefaultContent(driver);
	}
	
}
