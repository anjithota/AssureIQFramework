package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class MST_Stage extends ActionEngine{
	
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

	@FindBy(id = "STG_01")
	WebElement StageRegistrationMenu;
	
	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;
	
	@FindBy(id = "MST_STG_CTF_002_error")
	WebElement StageCodeError;
	
	@FindBy(id = "MST_STG_CTF_002")
	WebElement StageCode;
	
	@FindBy(id = "MST_STG_CTF_001_error")
	WebElement StageNameError;
	
	@FindBy(id = "MST_STG_CTF_001")
	WebElement StageName;
	
	@FindBy(id = "MST_STG_CTF_003_error")
	WebElement DescriptionError;
	
	@FindBy(id = "MST_STG_CTF_003")
	WebElement Description;
	
	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement StageCodeValue;
	
	@FindBy(id = "STG_02")
	WebElement StageModificationMenu;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearchButton;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;
	
	@FindBy(id = "MST_STG_CTF_002")
	WebElement StageCodeSearchFilter;
	
	@FindBy(xpath = "//div[@id='StdRemarks_container']//div[2]//span")
	WebElement RemarksError;

	@FindBy(id = "txtRemarks")
	WebElement RemarksText;
	
	@FindBy(id = "STG_03")
	WebElement StageStusChangeMenu;
	
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
	
	

	
	public void StageRegistrationInitiation(String stageCode, String stageName, String description) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
		}
		
		setUniquecode(Uniquecode = stageCode + s);
		
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(StageRegistrationMenu);

		click(StageRegistrationMenu, "Stage Registration menu");
		switchToBodyFrame(driver);
		
		click(SubmitButton, "Submit button");
		verifyCaptionContains(StageCodeError, "Enter Value");
		sendText(StageCode, stageCode, "Stage Code");
		
		click(SubmitButton, "Submit button");
		verifyCaptionContains(StageNameError, "Enter Value");
		sendText(StageName, stageName, "Stage Name");
		
		click(SubmitButton, "Submit button");
		verifyCaptionContains(DescriptionError, "Enter Value");
		sendText(Description, description, "Description");
		
		click(SubmitButton, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, StageCodeValue);
		switchToDefaultContent(driver);

		
	}


	public void stageModifiicationInitiation(String description, String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(StageModificationMenu, "Stage Modification menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, StageCodeSearchFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		clearField(Description, "Description");
		sendText(Description, description, "Description");
		click(SubmitButton, "Submit");
		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks or reasons");
		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, StageCodeValue);
		switchToDefaultContent(driver);
	}

	public void stageStatuschangeInactiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(StageStusChangeMenu, "Stage Status Change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, StageCode);
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
		saveUniqueCode(driver, StageCodeValue);
		switchToDefaultContent(driver);
		
		
	}

	public void stageStatuschangeActiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(StageStusChangeMenu, "Stage Status Change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, StageCode);
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
		saveUniqueCode(driver, StageCodeValue);
		switchToDefaultContent(driver);
		
		
	}
	
	public void stageStatuschangePermanentInactiveInitiation(String remarks) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(StageStusChangeMenu, "Stage Status Change menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, StageCode);
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
		saveUniqueCode(driver, StageCodeValue);
		switchToDefaultContent(driver);
		
	}

	
}
