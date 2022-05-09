package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class Dev_Closure_Approve extends ActionEngine {
	@FindBy(xpath = "//span[@title='Deviation']")
	WebElement DevMyTaskMenu;

	@FindBy(xpath = "//span[@title='Deviation Closure']")
	WebElement DevClosureMyTaskMenu;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssuecodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;
	
	@FindBy(id = "ISU_CLS_CTR_024")
	WebElement ReviewCommentsText;

	@FindBy(id = "ISU_CLS_CTR_024_error")
	WebElement ReviewCommentsTextError;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(xpath = "//div[@class='left-module ft-grid menu-icons'][2]")
	WebElement ProcessmanagerMenu;

	@FindBy(id = "DVCL_04")
	WebElement DevClosureAuditTrailMenu;
	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkError;
	
	@FindBy(xpath = "//div[@class='textdiv qsTitle']//span[text()='Revision No. 0 - Draft']")
	WebElement RegRevisionDraft;
	
	@FindBy(xpath = "//div[@class='textdiv qsTitle']//span[text()='Revision No. 0']")
	WebElement RegRevision;
	
	@FindBy(id = "AuditEventModal_View")
	WebElement proceedBtn;

	@FindBy(className = "popup-close-button")
	WebElement AuditTrailClose;
	
	@FindBy(xpath = "//label[@for='EsignerDecision_2']")
	WebElement AprroveDecision;
	
	@FindBy(xpath = "//label[@for='EsignerDecision_3']")
	WebElement ReturnDecision;
	
	@FindBy(id = "ISU_CLS_CTR_018_1")
	WebElement DecisionApproved;
	

	@FindBy(id = "ISU_CLS_CTR_018_error")
	WebElement DecisionApprovedError;
	
	public void devClosureReturn(String Remark) {
		switchToBodyFrame(driver);
		click(DevMyTaskMenu, "Deviation my task menu");
		click(DevClosureMyTaskMenu, "Deviation Closure My task menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		// sendText(IssuecodeFilter, "CC-PL01-Admin-21-0013", "Isssue Code Filter");

		enterUniqueCode(driver, IssuecodeFilter);


		
		 
		
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		
		click(ReturnDecision, "Return");
		
		click(SubmitButton, "Submit");
		verifyCaptionContains(RemarkError, "Enter Value");
		sendText(Remarks, Remark, "Remark or reason");
		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevID"));
		switchToDefaultContent(driver);
	}
	
	public void devClosureApprove(String ReviewComments) {
		switchToBodyFrame(driver);
		click(DevMyTaskMenu, "Deviation my task menu");
		click(DevClosureMyTaskMenu, "Deviation Closure My task menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		// sendText(IssuecodeFilter, "CC-PL01-Admin-21-0013", "Isssue Code Filter");

		enterUniqueCode(driver, IssuecodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		
		click(AprroveDecision, "Approve button");
		verifyCaptionContains(ReviewCommentsTextError, "Enter Value");
		sendText(ReviewCommentsText, ReviewComments, "Review Comments");
		click(AprroveDecision, "Approve button");
		verifyCaptionContains(DecisionApprovedError, "Select Value");
		click(DecisionApproved, "Approved button");
		click(AprroveDecision, "Approval Decision");
		click(SubmitButton, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevID"));
		switchToDefaultContent(driver);
		
	}
	
	

}




