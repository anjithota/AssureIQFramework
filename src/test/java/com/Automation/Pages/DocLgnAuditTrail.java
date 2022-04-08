package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class DocLgnAuditTrail extends ActionEngine {
	@FindBy(xpath = "//div[@class='textdiv qsTitle']//span[text()='Revision No. 0 - Draft']")
	WebElement RegRevisionDraft;
	
	@FindBy(xpath = "//div[@class='textdiv qsTitle']//span[text()='Revision No. 0']")
	WebElement RegRevision;

	@FindBy(id = "AuditEventModal_View")
	WebElement proceedBtn;

	@FindBy(xpath = "//*[@class='caliber-product-qams product-icon1']")
	WebElement assureiq;

	@FindBy(xpath = "//ul[@id='QAMS_PRSMGR']/preceding-sibling::a")
	WebElement ProcessManager;

	@FindBy(xpath = "//a[text()='Documentation Action Plan Login']")
	WebElement DocLogin;

	@FindBy(id = "QAMS_PRSMGR_DN_LGN_FRM_ID_01_AUDMEN")
	WebElement DocLoginAuditTrail;

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

	public void docLgnReturnAuditTrail() {
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		click(DocLogin, "Doc Login menu");
		click(DocLoginAuditTrail, "Doc Audit Trail");
		switchToBodyFrame(driver);

		click(AdvanceSearchButton, "Advanced Search button");


		 enterUniqueCode(driver, IssueCodeFilter);

		click(ApplyButton, "Apply button");

		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		click(RegRevisionDraft, "Registration Revision No Draft");
		click(proceedBtn, "Proceed Button");
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);

	}
	
	public void docLgnReviewedAuditTrail() {
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		click(DocLogin, "Doc Login menu");
		click(DocLoginAuditTrail, "Doc Audit Trail");
		switchToBodyFrame(driver);

		click(AdvanceSearchButton, "Advanced Search button");

		//sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040", "Issue code");

		enterUniqueCode(driver, IssueCodeFilter);

		click(ApplyButton, "Apply button");

		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		
			click(RegRevision, "Registration Revision No 0");
			click(proceedBtn, "Proceed Button");
			
		 
		
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);

	}
	public void docLgnInitAuditTrail() {
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		click(DocLogin, "Doc Login menu");
		click(DocLoginAuditTrail, "Doc Audit Trail");
		switchToBodyFrame(driver);

		click(AdvanceSearchButton, "Advanced Search button");

		//sendText(IssueCodeFilter, "CC-PL01-Admin-22-0014", "Issue code");

		enterUniqueCode(driver, IssueCodeFilter);

		click(ApplyButton, "Apply button");

		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);
		
	}
	
	
	


}
