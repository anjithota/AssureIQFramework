package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class MST_StandardRule extends ActionEngine{
	
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
	
	@FindBy(id="GXRL_01")
	WebElement StandardRuleRegistration;
	
	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;
	
	@FindBy(id="MST_RUL_CTF_001_error")
	WebElement RuleType_Error;
	
	@FindBy(id="MST_RUL_CTF_001")
	WebElement RuleType;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;
		
	@FindBy(name="MST_RTY_CTF_002")
	WebElement RuleTypeIssueCodeFilter;
	
	@FindBy(xpath = "//span[@class='text-ellipsis']")
	WebElement RuleTypeRadioBtn;
	
	@FindBy(id="btnOk")
	WebElement RuleTypeOkBtn;
		
	@FindBy(id="btnSubmitListFilter")
	WebElement ApplyBtn;
	
	@FindBy(id="MST_RUL_CTF_002_error")
	WebElement RuleCodeError;
	
	@FindBy(id="MST_RUL_CTF_002")
	WebElement RuleCode;
	
	@FindBy(id="MST_RUL_CTF_003_error")
	WebElement Description_Error;
	
	@FindBy(id="MST_RUL_CTF_003")
	WebElement Description;
//	
//	@FindBy(id="txtESignPassword")
//	WebElement E_sign;
	
	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement UniqueCode;
	
	@FindBy(id="cfnMsg_Next")
	WebElement Done;
	
	//Modification
	
	@FindBy(id="GXRL_02")
	WebElement StandardRuleModification;
	
	@FindBy(name="MST_RUL_CTF_002")
	WebElement IssueCode;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement record;
	
	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement Remarks_Error;
	
	@FindBy(id = "txtRemarks")
	WebElement Remarks;
	
	//Status Change
	
	@FindBy(id="GXRL_03")
	WebElement StandardRuleStatusChange;
	
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
	
	@FindBy(id="GXRL_04")
	WebElement StandardRuleAuditTrails;
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement AuditTrailsclose;
	
	
	
	
	public void StandreadRuleRegistration(String ruleType , String Desc)
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
		scrollToViewElement(StandardRuleRegistration);
		click(StandardRuleRegistration, "StandreadRuleRegistration");
		switchToBodyFrame(driver);
		click(SubmitBtn, "Submit Button");
		
		verifyCaptionContains(RuleType_Error, "Select Value");
		click(RuleType, "Rule Type");
		switchToPopupModelFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		//enterUniqueCode(driver, unicCode);
		sendText(RuleTypeIssueCodeFilter, ruleType, Desc);
	    
	    click(ApplyBtn, "Apply Button");
	    click(RuleTypeRadioBtn, "Rule Type Radio Button");
		click(RuleTypeOkBtn, "Rule Type ok Button");
		switchToParentFrame(driver);
		click(SubmitBtn, "Submit Button");
		
		verifyCaptionContains(RuleCodeError, "Enter Value");
		sendText(RuleCode, Uniquecode, "Role Code");
		click(SubmitBtn, "Submit Button");
		
		verifyCaptionContains(Description_Error, "Enter Value");
		sendText(Description, Desc, "Description");
		click(SubmitBtn, "Submit Button");
		
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);	
	}
	
	public void StandardRuleModification(String Desc , String remarksReason)
	{
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(StandardRuleModification);
		click(StandardRuleModification, "StandardRuleModification");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, "Apply Button");
		click(record, "Record");
		click(SubmitBtn, "Submit Button");
		
		clearField(Description, "Description");
		sendText(Description, Desc, "Description");
		
		verifyCaptionContains(Remarks_Error, "Enter Value");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);					
	}
	
	public void StandardRuleStatusChangeInactive(String remarksReason)
	{
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(StandardRuleStatusChange);
		click(StandardRuleStatusChange, "StandardRuleStatusChange");
		switchToBodyFrame(driver);
		//click(SubmitBtn, "Submit Button");
		
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, "Apply Button");
		click(record, "Record");
		click(SubmitBtn, "Submit Button");
		
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(Inactive, "In Active");
		sendText(Remarks, remarksReason, "enetr name");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);			
		
	}
	public void StandardRuleStatusChangeActive(String remarksReason)
	{
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(StandardRuleStatusChange);
		click(StandardRuleStatusChange, "StandardRuleStatusChange");
		switchToBodyFrame(driver);
		//click(SubmitBtn, "Submit Button");
		
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, "Apply Button");
		click(record, "Record");
		click(SubmitBtn, "Submit Button");
		
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(Active, "Active");
		sendText(Remarks, remarksReason, "enetr name");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);			
		
	}
	
	public void StandardRuleStatusChangePermanentInActive(String remarksReason)
	{
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(StandardRuleStatusChange);
		click(StandardRuleStatusChange, "StandardRuleStatusChange");
		switchToBodyFrame(driver);
		//click(SubmitBtn, "Submit Button");
		
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, "Apply Button");
		click(record, "Record");
		click(SubmitBtn, "Submit Button");
		
		
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(PermanetInActive, "PermanetInActive");
		click(PermanetInActiveYes, "PermanetInActiveYes");
		sendText(Remarks, remarksReason, "enetr name");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);			
		
	}
	
	public void StandardRuleAuditTrails()
	{
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(StandardRuleAuditTrails);
		click(StandardRuleAuditTrails, "StandardRuleAuditTrails");
		switchToBodyFrame(driver);
		
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, "Apply Button");
		click(record, "Record");
		switchToPopupModelFrame(driver);
		
		click(AuditTrailsclose, "close pop");
		switchToDefaultContent(driver);
	}
	
}
