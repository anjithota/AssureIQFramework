package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class DocTaskAllocationAuditTrail extends ActionEngine {
	@FindBy(xpath = "//*[@class='caliber-product-qams product-icon1']")
	WebElement assureiq;

	@FindBy(xpath = "//ul[@id='QAMS_PRSMGR']/preceding-sibling::a")
	WebElement ProcessManager;

	@FindBy(xpath = "//a[text()='Documentation Action Task Allocation']")
	WebElement DocTaskMenu;
	
	@FindBy(id="QAMS_PRSMGR_DN_TSK_FRM_ID_01_AUDMEN")
	WebElement DocTaskAuditTrailMenu;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeBtn;
	public void docTaskAlcnAuditTrail() {
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		click(DocTaskMenu, "Doc Task menu");
		click(DocTaskAuditTrailMenu, "Doc Task Allocation Audit Trail");
		switchToBodyFrame(driver);
		

		click(AdvanceSearchButton, "Advanced Search button");
		
		enterUniqueCode(driver, IssueCodeFilter);

		//sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040", "Issue code");
		click(ApplyButton, "Apply button");

		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);

	}


}
