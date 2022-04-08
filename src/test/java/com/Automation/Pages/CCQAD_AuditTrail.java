package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.TimeUtil;

public class CCQAD_AuditTrail extends ActionEngine {
	@FindBy(xpath = "//a[@class='caliber-product-qams product-icon1']")
	WebElement assureIQ;

	@FindBy(xpath = "//a[contains(text(), 'Process Manager')]")
	WebElement processManager;
	@FindBy(xpath = "//ul[@id='QAMS_PRSMGR']/li[9]/a[1]")
	WebElement CCQAD_Menu;

	@FindBy(id = "QAMS_PRSMGR_ISU_CC_QAD_FRM_01_AUDMEN")
	WebElement CCQADAuditTrail;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(className = "popup-close-button")
	WebElement AuditTrailClose;

	public void ccQAD_AuditTrail() {
		click(assureIQ, "AssureIQ menu");

		click(processManager, "Process Manager");

		click(CCQAD_Menu, "OTD menu");

		click(CCQADAuditTrail, "OTD Audit Trail menu");

		switchToBodyFrame(driver);

		click(AdvanceSearchButton, "Advanced Search button");

		// sendText(IssueCodeFilter, "CC-PL01-Admin-21-0014", "Issue code");

		enterUniqueCode(driver, IssueCodeFilter);

		click(ApplyButton, "Apply button");

		click(Record, "Click on record");

		switchToDefaultContent(driver);

		switchToBodyFrame(driver);

		TimeUtil.shortWait();

		// click(AuditTrailClose, "Close button");

		switchToDefaultContent(driver);

	}
}