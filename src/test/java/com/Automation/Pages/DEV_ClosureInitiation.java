package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class DEV_ClosureInitiation extends ActionEngine {
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

	@FindBy(id = "ISU_CLS_CTR_023")
	WebElement ReviewCommentsText;

	@FindBy(id = "ISU_CLS_CTR_023_error")
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

	public void devClosureInitiation(String reviewComments) {
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
		click(SubmitButton, "Submit");

		verifyCaptionContains(ReviewCommentsTextError, "Enter Value");
		sendText(ReviewCommentsText, reviewComments, "review comments");
		click(SubmitButton, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);

	}

	public void devClosureInitiationAuditTrails() {
		switchToDefaultContent(driver);
		click(ProcessmanagerMenu, "Process manager");
		click(DevClosureAuditTrailMenu, "Deviation closure Audit Trail");
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced sreach button");
		enterUniqueCode(driver, IssuecodeFilter);
		click(ApplyButton, "Apply button");
		click(Record, "Record");
		switchToPopupModelFrame(driver);
		click(AuditTrailClose, "Close Button");
		switchToDefaultContent(driver);

	}

	public void devClosureReinitiate(String ReviewComments, String RemarksReason) {
		switchToDefaultContent(driver);
		click(DevMyTaskMenu, "Deviation my task menu");
		click(DevClosureMyTaskMenu, "Deviation Closure My task menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		click(ApplyButton, "Apply button");
		click(Record, "Record");
		clearField(ReviewCommentsText, "Review comments");
		sendText(ReviewCommentsText, ReviewComments, "Review comments");
		click(SubmitButton, "Submit button");
		verifyCaptionContains(RemarkError, "Enter Value");
		sendText(Remarks, RemarksReason, "Remarks Reason");
		click(SubmitButton, "submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);

	}

	public void devClosureReInitiationAuditTrails() {
		switchToDefaultContent(driver);
		click(ProcessmanagerMenu, "Process manager");
		click(DevClosureAuditTrailMenu, "Deviation closure Audit Trail");
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced sreach button");
		enterUniqueCode(driver, IssuecodeFilter);
		click(ApplyButton, "Apply button");
		click(Record, "Record");
		switchToPopupModelFrame(driver);
		click(RegRevision, "Registration Revision No 0");
		click(proceedBtn, "Proceed Button");

		click(AuditTrailClose, "Close Button");
		switchToDefaultContent(driver);

	}

	

}
