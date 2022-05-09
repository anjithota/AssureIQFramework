package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class CC_ForceClosureApproval extends ActionEngine {
	
	@FindBy(xpath="//a[@href='http://10.10.3.33//QAMS510BL_OQ/BasePages/ListReport?TT=21&Fid=81411']//span")
	WebElement ForceClosureMyTask;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssuecodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;
	
	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;
	
	
	@FindBy(id="txtRemarks")
	WebElement Remark;
	
	@FindBy(xpath = "//label[text()='Approve']")
	WebElement decisionApprove;
	
	@FindBy(xpath = "//label[text()='Drop']")
	WebElement decisionDrop;
	
	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkError;
	
	@FindBy(className="confirmation_text")
	WebElement DroppedIssueCode;
	
	@FindBy(id="PRC_FCL_CTF_001_VAL")
	WebElement UcodeAuditTrail;
	

	@FindBy(xpath="//a[text()='Force Closure - CC']")
	WebElement ForceClosureCCMenu;
	
	@FindBy(xpath = "//*[@class='caliber-product-qams product-icon1']")
	WebElement assureiq;

	@FindBy(xpath = "//ul[@id='QAMS_PRSMGR']/preceding-sibling::a")
	WebElement ProcessManager;
	
	@FindBy(id="QAMS_PRSMGR_PRC_FCL_CC_FRM_ID_AUDMEN")
	WebElement ForceClosureAuditTrial;
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeBtn;
	
	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssueCodeFilter;
	
	@FindBy(xpath = "//td[text()='Approved']")
	WebElement ApprovedActivity;
	
	@FindBy(xpath = "//td[text()='Dropped']")
	WebElement DroppedActivity;
	
	public void ccForceClosureApprove() {
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		scrollToViewElement(ForceClosureMyTask);
		click(ForceClosureMyTask, "CC Force closure my task");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		enterUniqueCode(driver, IssuecodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		TimeUtil.shortWait();
		click(decisionApprove, "Approve Button");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnIHODPwd"));
		switchToDefaultContent(driver);
		
	}
	
	public void ccForceClosureDrop(String RemarkReason) {
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		scrollToViewElement(ForceClosureMyTask);
		click(ForceClosureMyTask, "CC Force closure my task");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		enterUniqueCode(driver, IssuecodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		TimeUtil.shortWait();
		click(decisionDrop, "Drop Button");
		click(SubmitBtn, "Submit");
		verifyCaptionContains(RemarkError, "Enter Value");
		sendText(Remarks, RemarkReason, "remarks");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnIHODPwd"));
		//saveAlterUniqueCode(driver, DroppedIssueCode);
		switchToDefaultContent(driver);
		
	}
	
	public void forceClosureDroppedAuditTrail() {
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		scrollToViewElement(ForceClosureCCMenu);
		click(ForceClosureCCMenu, "Force closure menu");
		click(ForceClosureAuditTrial, "Force closure Audit Trial menu");
		switchToBodyFrame(driver);

		click(AdvanceSearchButton, "Advanced Search button");


		 enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply button");

		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		TimeUtil.shortWait();
		verifyCaptionContains(DroppedActivity, "Dropped");
		click(closeBtn, "Close Button");
		
		switchToDefaultContent(driver);
		
	}
	
	public void forceClosureApproveAuditTrail() {
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		scrollToViewElement(ForceClosureCCMenu);
		click(ForceClosureCCMenu, "Force closure menu");
		click(ForceClosureAuditTrial, "Force closure Audit Trial menu");
		switchToBodyFrame(driver);

		click(AdvanceSearchButton, "Advanced Search button");


		 enterUniqueCode(driver, IssueCodeFilter);

		click(ApplyButton, "Apply button");

		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		TimeUtil.shortWait();
		scrollToViewElement(ApprovedActivity);
		verifyCaptionContains(ApprovedActivity, "Approved");
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);
		
	}
	

 
}
