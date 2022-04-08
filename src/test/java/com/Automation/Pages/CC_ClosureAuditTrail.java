package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class CC_ClosureAuditTrail extends ActionEngine {
	@FindBy(xpath = "//*[@class='caliber-product-qams product-icon1']")
	WebElement assureiq;

	@FindBy(xpath = "//ul[@id='QAMS_PRSMGR']/preceding-sibling::a")
	WebElement ProcessManager;

	@FindBy(xpath = "//a[text()='Change Control Closure']")
	WebElement ChangeControlClosureMenu;

	@FindBy(id = "QAMS_PRSMGR_ISU_CC_CLS_FRM_ID_02_AUDMEN")
	WebElement CCClsAuditTrailMenu;

	@FindBy(id = "AuditEventModal_View")
	WebElement proceedBtn;

	@FindBy(xpath = "//div[@class='textdiv qsTitle']//span[text()='Revision No. 0 - Draft']")
	WebElement RegRevisionDraft;

	@FindBy(xpath = "//div[@class='textdiv qsTitle']//span[text()='Revision No. 0']")
	WebElement RegRevision;
	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_CLS_CTR_001")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeBtn;

	public void ccClsReturnAuditTrail() {
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		click(ChangeControlClosureMenu, "Change Control Closure Menu");
		click(CCClsAuditTrailMenu, "Change Control Closure Audit Trail Menu");
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced Search button");


		enterUniqueCodeConcat(driver, IssueCodeFilter);

		click(ApplyButton, "Apply button");

		click(Record, "Click on record");

		switchToPopupModelFrame(driver);
		click(RegRevisionDraft, "Registration Revision No Draft");
		click(proceedBtn, "Proceed Button");
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);

	}

	public void ccClsInitiateAuditTrail() {

		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		click(ChangeControlClosureMenu, "Change Control Closure Menu");
		click(CCClsAuditTrailMenu, "Change Control Closure Audit Trail Menu");
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced Search button");

		
		enterUniqueCodeConcat(driver, IssueCodeFilter);

		

		click(ApplyButton, "Apply button");

		click(Record, "Click on record");

		switchToPopupModelFrame(driver);

		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);

	}

	public void ccClsApproveAuditTrail() {
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		click(ChangeControlClosureMenu, "Change Control Closure Menu");
		click(CCClsAuditTrailMenu, "Change Control Closure Audit Trail Menu");
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced Search button");

		enterUniqueCodeConcat(driver, IssueCodeFilter);


		click(ApplyButton, "Apply button");

		click(Record, "Click on record");

		switchToPopupModelFrame(driver);
		click(RegRevision, "Registration Revision No Draft");
		click(proceedBtn, "Proceed Button");
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);

	}

}
