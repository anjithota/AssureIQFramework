package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class Audit_Responce_2Approval extends ActionEngine{
	
	@FindBy(xpath = "//small[text()='IA']")
	WebElement InternalAudit;

	@FindBy(id = "MyTaskPrc_IA_IA_AUD_AR_FRM_ID_01")
	WebElement AuditResponceMyTask;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(name = "AUD_LGN_CTF_003")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;
	
	@FindBy(xpath = "//label[@for='EsignerDecision_2']")
	WebElement Approve;
	
	@FindBy(id="AUD_AR_CTF_025_error")
	WebElement HeadAuditeeCommentsError;
	
	@FindBy(id="AUD_AR_CTF_025")
	WebElement HeadAuditeeComments;
	
	@FindBy(id="btnSubmit_1")
	WebElement SubmitButton;
	
	//-------------Return--------//
	
	@FindBy(xpath = "//label[@for='EsignerDecision_3']")
	WebElement Return;
	
	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement RemarksError;

	@FindBy(id = "txtRemarks")
	WebElement RemarksReason;

	
	
	public void audit_Finding_Responce_AgainReturn(String reasons) {
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "Internal Audit");
		click(AuditResponceMyTask, "AuditResponce MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(Return, "Return");
		click(SubmitButton, "Submit Button");

		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksReason, reasons, "RemarksReason");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		switchToDefaultContent(driver);
	}

	
	public void auditResponce2Approve(String reasons) {
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "Internal Audit");
		click(AuditResponceMyTask, "AuditResponce MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(Approve, "Approve");
		//click(SubmitButton, "Submit Button");
		
		verifyCaptionContains(HeadAuditeeCommentsError, "Enter Value");
		sendText(HeadAuditeeComments, reasons, "HeadAuditeeComments");
		click(Approve, "Approve");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		switchToDefaultContent(driver);
	}

	public void auditResponceAgain2Approve(String reasons) {
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "Internal Audit");
		click(AuditResponceMyTask, "AuditResponce MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(Approve, "Approve");
		//click(SubmitButton, "Submit Button");
		
//		verifyCaptionContains(HeadAuditeeCommentsError, "Enter Value");
//		sendText(HeadAuditeeComments, reasons, "HeadAuditeeComments");
//		click(Approve, "Approve");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		switchToDefaultContent(driver);
	}
	
	public void auditResponce2Approve100(String reasons) {
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "Internal Audit");
		click(AuditResponceMyTask, "AuditResponce MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(Approve, "Approve");
		//click(SubmitButton, "Submit Button");
		
		verifyCaptionContains(HeadAuditeeCommentsError, "Enter Value");
		sendText(HeadAuditeeComments, reasons, "HeadAuditeeComments");
		click(Approve, "Approve");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		switchToDefaultContent(driver);
	}


}
