package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class Dev_OTDAutitTrail extends ActionEngine {
	@FindBy(id = "DVOT_04")
	WebElement DeviationOtdAuditTrailmenu;

	@FindBy(xpath = "//div[@class='left-module ft-grid menu-icons'][2]")
	WebElement ProcessmanagerMenu;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssuecodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(xpath = "//div[@class='textdiv qsTitle']//span[text()='Revision No. 0 - Draft']")
	WebElement RegRevisionDraft;

	@FindBy(xpath = "//div[@class='textdiv qsTitle']//span[text()='Revision No. 0']")
	WebElement RegRevision;

	@FindBy(className = "popup-close-button")
	WebElement AuditTrailClose;
	
	@FindBy(id = "AuditEventModal_View")
	WebElement proceedBtn;


	public void dev_Otd_auditTrail() {
		switchToDefaultContent(driver);
		click(ProcessmanagerMenu, "Process manager");
		click(DeviationOtdAuditTrailmenu, "Deviation closure Audit Trail");
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced sreach button");
		enterUniqueCode(driver, IssuecodeFilter);
		click(ApplyButton, "Apply button");
		click(Record, "Record");
		switchToPopupModelFrame(driver);
		click(AuditTrailClose, "Close Button");
		switchToDefaultContent(driver);
	}
	
	public void dev_Otd_auditTrail_Revision() {
		switchToDefaultContent(driver);
		click(ProcessmanagerMenu, "Process manager");
		click(DeviationOtdAuditTrailmenu, "Deviation closure Audit Trail");
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
 