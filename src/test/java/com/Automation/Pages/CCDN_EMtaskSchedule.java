package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class CCDN_EMtaskSchedule extends ActionEngine {
	
	@FindBy(xpath= "//ul[@id='QAMS_PRSMGR']/li[15]/a")
	WebElement EMSchedulemenu;
	
	@FindBy(id="QAMS_PRSMGR_DN_EMSH_FRM_ID_01_AUDMEN")
	WebElement EMScheduleAuditTrailMenu;
	
	@FindBy(xpath = "//*[@class='caliber-product-qams product-icon1']")
	WebElement assureiq;

	@FindBy(xpath = "//ul[@id='QAMS_PRSMGR']/preceding-sibling::a")
	WebElement ProcessManager;
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeBtn;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssueCodeFilter;
	
	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;
	
	@FindBy(className = "text-ellipsis")
	WebElement Record;
	
	//Em Task Initiation elements
	
	@FindBy(xpath= "//a[@href='http://10.10.3.33//QAMS510BL_OQ/BasePages/ListReport?TT=21&Fid=81196']//span")
	WebElement DocEMTask;
	
	@FindBy(id = "PRC_EM_CTF_02_error")
	WebElement ReviewCommentsError;
	
	@FindBy(id = "PRC_EM_CTF_02")
	WebElement ReviewComments;
	
	@FindBy(id = "btnSubmit_1")
	WebElement submit;
	
	
	//EM Task Audit Trail
	
	@FindBy(xpath= "//ul[@id='QAMS_PRSMGR']/li[22]/a")
	WebElement DocEMTaskmenu;
	
	@FindBy(id="QAMS_PRSMGR_DN_EM_FRM_ID_01_AUDMEN")
	WebElement DocEMTaskAuditTrailMenu;
	
	//SP build
	@FindBy(xpath = "//div[@class='left-module ft-grid menu-icons'][2]")
	WebElement ProcessManagersp;
	
	@FindBy()
	WebElement EMScheduleAuditTrailSP;
	
	public void emSchelduleAuditTrail() {
		switchToDefaultContent(driver);
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		
		scrollToViewElement(EMSchedulemenu);
		
		click(EMSchedulemenu, "EM Schedule");
		scrollToViewElement(EMScheduleAuditTrailMenu);
		click(EMScheduleAuditTrailMenu, "EM Schedule Audit Trail Menu");
		switchToBodyFrame(driver);
		
		click(AdvanceSearchButton, "Advanced Search button");
		enterUniqueCode(driver, IssueCodeFilter);

		//sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040%", "Issue code");
		click(ApplyButton, "Apply button");

		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);

	}
	
	public void docEMTask(String reviewcomments) {
		
		switchToBodyFrame(driver);
		scrollToViewElement(DocEMTask);
		click(DocEMTask, "Doc EM Task Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(submit, "Submit");
		verifyCaptionContains(ReviewCommentsError, "Enter Value");
		sendText(ReviewComments, reviewcomments, "Comments");
		
		E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnQAPwd"));
		switchToDefaultContent(driver);
		
		
	}
	
	public void docEMTaskAuditTrail() {
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		
		scrollToViewElement(DocEMTaskmenu);
		
		click(DocEMTaskmenu, "Doc EM Task menu");
		scrollToViewElement(DocEMTaskAuditTrailMenu);
		click(DocEMTaskAuditTrailMenu, "Doc EM Task Audit Trail Menu");
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced Search button");
		enterUniqueCode(driver, IssueCodeFilter);

		//sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040%", "Issue code");
		click(ApplyButton, "Apply button");

		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);
		
		
	}
	
	public void emSchelduleAuditTrailSP()  {
		switchToDefaultContent(driver);
		
		click(ProcessManagersp, "Process Manager");
		
		/*scrollToViewElement(EMSchedulemenu);
		
		click(EMSchedulemenu, "EM Schedule");*/
		scrollToViewElement(EMScheduleAuditTrailSP);
		click(EMScheduleAuditTrailSP, "EM Schedule Audit Trail Menu");
		switchToBodyFrame(driver);
		
		click(AdvanceSearchButton, "Advanced Search button");
		enterUniqueCode(driver, IssueCodeFilter);

		//sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040%", "Issue code");
		click(ApplyButton, "Apply button");

		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);

	}
	

}
