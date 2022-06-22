package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class MST_Stansard_Rule_Type extends ActionEngine{
	
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
	
	//Registration Role
	@FindBy(id="GXRT_01")
	WebElement StandreadRuleTypeRegistration;
	
	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;
	
	@FindBy(id="MST_RTY_CTF_002_error")
	WebElement RuleTypeError;
	
	@FindBy(id="MST_RTY_CTF_002")
	WebElement RuleType;
	
	@FindBy(id="MST_RTY_CTF_001_error")
	WebElement Decription_Error;
	
	@FindBy(id="MST_RTY_CTF_001")
	WebElement Description;
	
	@FindBy(id="txtESignPassword")
	WebElement E_sing;
	
	@FindBy(id="Submit_Esign")
	WebElement proceed;
	
	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement UnicCode;
	
	@FindBy(id="cfnMsg_Next")
	WebElement Done;
	
	//modification
	
	@FindBy(id="GXRT_02")
	WebElement StandreadRuleTypeModification;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;
	
	@FindBy(name="MST_RTY_CTF_002")
	WebElement IssueCode;
	
	@FindBy(id="btnSubmitListFilter")
	WebElement ApplyBtn;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement record;
	
	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement Remarks_Error;
	
	@FindBy(id = "txtRemarks")
	WebElement Remarks;
	
	//Status Change Menu
	
	@FindBy(id="GXRT_03")
	WebElement StandreadRuleTypeStatusChange;
	
	@FindBy(xpath = "//span[text()='Select Value']")
	WebElement ProposedStatusError;
	
	@FindBy(xpath = "//label[@for='NewStatus_5']")
	WebElement Inactive;
	
	@FindBy(xpath = "//label[@for='NewStatus_1']")
	WebElement Active;
	
	@FindBy(xpath = "//label[@for='NewStatus_10']")
	WebElement PermanetInActive;
	
	@FindBy(id = "confirmationRevertYes")
	WebElement PermanetInActiveYes;
	
	//AuditTrails
	
	@FindBy(id="GXRT_04")
	 WebElement StandreadRuleTypeAuditTrails;
	
//	@FindBy(xpath = "//span[@class='popup-close-button']")
//	WebElement AuditTrailsclose;
	
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement AuditTrailsclose;
	
	
	
	
	public void StandreadRuleTypeRegistration(String ruleType ,String Desc)
	{
		String s = "";

		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
			System.out.println("Generated S Value is: " + s);
		}
		setUniquecode(Uniquecode = ruleType + s);
				
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(StandreadRuleTypeRegistration);
		click(StandreadRuleTypeRegistration, "StandreadRuleTypeRegistration");
		switchToBodyFrame(driver);
		click(SubmitBtn, "submit button");
		
		verifyCaptionContains(RuleTypeError, "Enter Value");
		sendText(RuleType, Uniquecode, "rule Type");
		click(SubmitBtn, "submit button");
		
		verifyCaptionContains(Decription_Error, "Enter Value");
		sendText(Description, Desc, "Description");
		click(SubmitBtn, "submit button");
//		click(E_sing, "E_sign");
//		click(proceed, "submit e_sign");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UnicCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);		
	}
	
	public void StandreadRuleTypeModification(String description, String remarksReason)
	{
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(StandreadRuleTypeModification);
		click(StandreadRuleTypeModification, "StandreadRuleTypeModification");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Searh");
		enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, "Apply Button");
		click(record, "Record");
		click(SubmitBtn, "submit button");
		clearField(Description, "Description Field");
		sendText(Description, description, "Description");
		
		verifyCaptionContains(Remarks_Error, "Enter Value");
		sendText(Remarks, remarksReason, "enetr name");
		click(SubmitBtn, "submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UnicCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);		
	}
	
	public void StandreadRuleTypeStatusChangeInActive(String remarksReason)
	{
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(StandreadRuleTypeStatusChange);
		click(StandreadRuleTypeStatusChange, "StandreadRuleTypeStatusChange");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Searh");
		enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, "Apply Button");
		click(record, "Record");
		click(SubmitBtn, "submit button");
		
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(Inactive, "In Active");
		sendText(Remarks, remarksReason, "enetr name");
		click(SubmitBtn, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UnicCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);	
	}
	
	public void StandreadRuleTypeStatusChangeActive(String remarksReason)
	{
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(StandreadRuleTypeStatusChange);
		click(StandreadRuleTypeStatusChange, "StandreadRuleTypeStatusChange");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Searh");
		enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, "Apply Button");
		click(record, "Record");
		click(SubmitBtn, "submit button");
		
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(Active, "Active");
		sendText(Remarks, remarksReason, "enetr name");
		click(SubmitBtn, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UnicCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);	
	}
	
	public void StandreadRuleTypeStatusChangePermanentInActive(String remarksReason)
	{
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(StandreadRuleTypeStatusChange);
		click(StandreadRuleTypeStatusChange, "StandreadRuleTypeStatusChange");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Searh");
		enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, "Apply Button");
		click(record, "Record");
		click(SubmitBtn, "submit button");
		
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(PermanetInActive, "PermanetInActive");
		click(PermanetInActiveYes, "PermanetInActiveYes");
		sendText(Remarks, remarksReason, "enetr name");
		click(SubmitBtn, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UnicCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);	
	}
	
	public void StandreadRuleTypeAuditTrails()
	{
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(StandreadRuleTypeAuditTrails);
		click(StandreadRuleTypeAuditTrails, "StandreadRuleTypeAuditTrails");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Searh");
		enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, "Apply Button");
		click(record, "Record");
		switchToPopupModelFrame(driver);
		click(AuditTrailsclose, "close pop");
		switchToDefaultContent(driver);
	}

}
