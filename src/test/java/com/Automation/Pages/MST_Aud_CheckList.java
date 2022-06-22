package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class MST_Aud_CheckList extends ActionEngine{
	
	Properties prop;
	public static String Uniquecode = "";

	public static String getUniqueCode() {
		return Uniquecode;
	}

	public static void setUniquecode(String uniquecode) {
		Uniquecode = uniquecode;
	}
	
	@FindBy(xpath = "//div[@class='left-menupanel']/div[5]")
	WebElement AuditManagement;
	
	@FindBy(id="CKLT_01")
	WebElement CheckListRegistration;
	
	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;
	
	@FindBy(id="AUD_CKT_CTR_002_error")
	WebElement NameError;
	
	@FindBy(id="AUD_CKT_CTR_002")
	WebElement Name;
	
	@FindBy(id="AUD_CKT_CTR_003_error")
	WebElement DescriptionError;
	
	@FindBy(id="AUD_CKT_CTR_003")
	WebElement Description;
	
	@FindBy(id="AUD_CKT_CTR_006_error")
	WebElement FileAttachmentError;
	
	@FindBy(id="AUD_CKT_CTR_006")
	WebElement FileAttachmentAddItems;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;
	
	@FindBy(name="MST_DOC_CTF_001")
	WebElement DocumentIssueCodeFilter;
	
//	@FindBy(id="btnSubmitListFilter")
//	WebElement ApplyBtn;
	
	@FindBy(xpath = "//button[text()='Apply']")
	WebElement ApplyBtn;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement DocumentSelect;
	
	@FindBy(id="btnOk")
	WebElement AttachButton;
	
	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement UniqueCode;
	
	@FindBy(id="cfnMsg_Next")
	WebElement Done;
	
	//Modification
	
	@FindBy(id="CKLT_02")
	WebElement CheckListModification;
	
	@FindBy(name="AUD_CKT_CTR_001")
	WebElement IssueCodeFilter;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement Record;
	
	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement Remarks_Error;
	
	@FindBy(id = "txtRemarks")
	WebElement Remarks;
	
	//Status Change
	
	@FindBy(id="CKLT_03")
	WebElement CheckListStatusChange;
	
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
	
	@FindBy(id="CKLT_04")
	WebElement CheckListAuditTrails;
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement AuditTrailsclose;
	
	

	
	public void checkListRigistaration(String name ,String desc , String uniqueCodeFilter)
	{
		
		String s = "";

		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
			System.out.println("Generated S Value is: " + s);
		}
		setUniquecode(Uniquecode = name + s);
		
		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(CheckListRegistration);
		click(CheckListRegistration, "CheckList Registration");
		switchToBodyFrame(driver);
		click(SubmitBtn, "Submit Button");

		verifyCaptionContains(NameError, "Enter Value");
		sendText(Name, Uniquecode, "Name");
		click(SubmitBtn, "SubmitBtn");
		
		verifyCaptionContains(DescriptionError, "Enter Value");
		sendText(Description, desc, "Description");
		click(SubmitBtn, "SubmitBtn");
		
		verifyCaptionContains(FileAttachmentError, "Select Value");
		click(FileAttachmentAddItems, "FileAttachment Add Items");
		switchToPopupModelFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		//click(DocumentIssueCodeFilter, "Document Issue Code Filter");
		sendText(DocumentIssueCodeFilter, uniqueCodeFilter, "Document Issue Code Filter");
		enterUniqueCode(driver, DocumentIssueCodeFilter);
		click(ApplyBtn, "Apply Button");
		click(DocumentSelect, "Document Select");
		click(AttachButton, "Attach Button");
		switchToParentFrame(driver);
		
		click(SubmitBtn, "SubmitBtn");

		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);
		  	 
     }
	
	public void checkListModification(String name ,String remarksReason)
	{
		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(CheckListModification);
		click(CheckListModification, "CheckList Modification");
		switchToBodyFrame(driver);
		
		click(AdvancedSearch, "Advanced Search");
		//click(IssueFilterCode, "Document Issue Code Filter");
		//sendText(DocumentIssueCodeFilter, data, "DocumentIssueCodeFilter");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyBtn, "Apply Button");
		
		click(Record, "Record");
		click(SubmitBtn, "Submit Button");
		clearField(Name, "Name");
		sendText(Name, name, "Name");
		
		verifyCaptionContains(Remarks_Error, "Enter Value");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "SubitBtn");
		
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);
			
	}
	
	public void checkListStatusChangeInactive(String remarksReason)
	{
		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(CheckListStatusChange);
		click(CheckListStatusChange, "CheckList Status Change");
		switchToBodyFrame(driver);
		
		click(AdvancedSearch, "Advanced Search");
		//click(IssueCodeFilter, "Document Issue Code Filter");
		//sendText(DocumentIssueCodeFilter, data, "DocumentIssueCodeFilter");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyBtn, "Apply Button");
		
		click(Record, "Record");
		click(SubmitBtn, "SubmitBtn");
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(Inactive, "In Active");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);		

	}
	
	public void checkListStatusChangeactive(String remarksReason)
	{
		TimeUtil.shortWait();
		click(AuditManagement, "AuditManagement");
		scrollToViewElement(CheckListStatusChange);
		click(CheckListStatusChange, "CheckListStatusChange");
		switchToBodyFrame(driver);
		
		click(AdvancedSearch, "Advanced Search");
		//click(IssueCodeFilter, "Document Issue Code Filter");
		//sendText(DocumentIssueCodeFilter, data, "DocumentIssueCodeFilter");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyBtn, "Apply Button");
		
		click(Record, "Record");
		click(SubmitBtn, "SubmitBtn");
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(Active, "Active");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);		

	}
	public void checkListStatusChangePermanetInActive(String remarksReason)
	{
		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(CheckListStatusChange);
		click(CheckListStatusChange, "CheckList Status Change");
		switchToBodyFrame(driver);
		
		click(AdvancedSearch, "Advanced Search");
		//click(IssueCodeFilter, "Document Issue Code Filter");
		//sendText(DocumentIssueCodeFilter, data, "DocumentIssueCodeFilter");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyBtn, "Apply Button");
		
		click(Record, "Record");
		click(SubmitBtn, "SubmitBtn");
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(PermanetInActive, "Permanet InActive");
		click(PermanetInActiveYes, "Permanet In Active Yes");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);		

	}
	
	public void checkListAuditTrails()
	{
		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(CheckListAuditTrails);
		click(CheckListAuditTrails, "CheckList Audit Trails");
		switchToBodyFrame(driver);
		
		click(AdvancedSearch, "Advanced Search");
		//click(IssueCodeFilter, "Document Issue Code Filter");
		//sendText(DocumentIssueCodeFilter, data, "DocumentIssueCodeFilter");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyBtn, "Apply Button");
		
		click(Record, "Record");
		switchToPopupModelFrame(driver);
		
		click(AuditTrailsclose, "close pop");
		switchToDefaultContent(driver);
	}
	
	
	
	



}

