package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.TimeUtil;

public class CCOTD_AuditTrail extends ActionEngine {
	@FindBy(xpath = "//a[@class='caliber-product-qams product-icon1']")
	WebElement assureIQ;

	@FindBy(xpath = "//a[contains(text(), 'Process Manager')]")
	WebElement processManager;

	@FindBy(xpath = "//ul[@id='QAMS_PRSMGR']/li[10]/a[1]")
	WebElement CCOTD_Menu;

	@FindBy(id = "QAMS_PRSMGR_ISU_OTD_FRM_01_AUDMEN")
	WebElement CCOTDAuditTrail;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssueCodeFilter;

	@FindBy(xpath = "(//div[@class='textdiv qsTitle']//span[text()='Revision No. 0'])")
	WebElement RegRevision;

	@FindBy(id = "AuditEventModal_View")
	WebElement proceedBtn;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(className = "popup-close-button")
	WebElement AuditTrailClose;

	public void ccOTD_AuditTrail() {
		click(assureIQ, "AssureIQ menu");

		click(processManager, "Process Manager");

		// click(CCOTD_Menu, "OTD menu");

		jsClick(CCOTD_Menu, "OTD");

		click(CCOTDAuditTrail, "OTD Audit Trail menu");

		switchToBodyFrame(driver);

		click(AdvanceSearchButton, "Advanced Search button");

		// sendText(IssueCodeFilter, "CC-PL01-Admin-21-0013", "Issue code");

		enterUniqueCode(driver, IssueCodeFilter);

		click(ApplyButton, "Apply button");

		click(Record, "Click on record");

		/*
		 * switchToDefaultContent(driver);
		 * 
		 * switchToBodyFrame(driver);
		 */

		TimeUtil.shortWait();

		/* click(AuditTrailClose, "Close button"); */

		switchToDefaultContent(driver);

	}

	public void ccOTD_AuditTrailAgain() {
		click(assureIQ, "AssureIQ menu");

		click(processManager, "Process Manager");

		// click(CCOTD_Menu, "OTD menu");

		jsClick(CCOTD_Menu, "OTD");

		click(CCOTDAuditTrail, "OTD Audit Trail menu");

		switchToBodyFrame(driver);

		click(AdvanceSearchButton, "Advanced Search button");

		enterUniqueCode(driver, IssueCodeFilter);

		click(ApplyButton, "Apply button");

		click(Record, "Click on record");

		// Switch to frame inside a frame
		switchToPopupModelFrame(driver);

		// Click Registration Revision No Draft
		click(RegRevision, "Registration Revision No Draft");

		// Click Proceed Button
		click(proceedBtn, "Proceed Button");

		TimeUtil.shortWait();

		click(AuditTrailClose, "Close button");

		switchToDefaultContent(driver);

	}

}
