package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class Dev_FocreClosure extends ActionEngine {

	@FindBy(id = "btnCreate")
	WebElement initiate;

	@FindBy(id = "btnProcessClosure")
	WebElement ForceClosure;

	@FindBy(xpath = "//label[@for='item_DEV']")
	WebElement DeviationTile;

	@FindBy(id = "btnSubmit")
	WebElement proceedButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssueCodeFilter;
	
	@FindBy(name= "PRC_FCL_CTF_001")
	WebElement UcodeFilter;

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
	
	@FindBy(xpath = "//table[@id='ReportTab']//tbody/tr/td/span")
	WebElement IssueCodeValue;

	@FindBy(id = "DEFC_04")
	WebElement DevForceClosureAuditTrailMenu;
	@FindBy(className = "popup-close-button")
	WebElement AuditTrailClose;

	@FindBy(className = "dateVCBtn")
	WebElement DateFilter;

	@FindBy(xpath = "//li[text()='Last 30 Days']")
	WebElement LastThirtyBtn;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;

	@FindBy(xpath = "//td[text()='No data available in table']")
	WebElement NodataElement;

	@FindBy(className = "confirmation_text")
	WebElement DroppedIssueCode;

	public void devForceClosureAuditTrail() {
		switchToDefaultContent(driver);
		click(ProcessmanagerMenu, "Process manager");
		scrollToViewElement(DevForceClosureAuditTrailMenu);
		click(DevForceClosureAuditTrailMenu, "Deviation force closure Audit Trail");
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced sreach button");
		enterUniqueCode(driver, UcodeFilter);
		click(DateFilter, "Date calendar");
		click(LastThirtyBtn, "Last 30 days");
		click(ApplyButton, "Apply button");
		verifyUniqueCode(IssueCodeValue);
		click(Record, "Record");
		
		switchToPopupModelFrame(driver);
		click(AuditTrailClose, "Close Button");
		switchToDefaultContent(driver);
	}

	public void devForceClosureInitiation() {
		click(initiate, "Intiate button");
		click(ForceClosure, "Force Closure");
		//click(initiate, "Iitiate button");

		switchToPopupModelFrame(driver);

		click(DeviationTile, "Deviation Tile");
		click(proceedButton, "Proceed button");

		switchToDefaultContent(driver);

		// `````````````````````````````````````````````````` ```````
		// Wait for 1sec
//	waitForPageToLoad(1000);

		// Switch to frame of the page
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced search");
		click(DateFilter, "Date Filter");
		TimeUtil.shortWait();
		// click(LastThirtyBtn, "Last Thirty Btn");
		jsClick(LastThirtyBtn, "Last 30 days");

		sendText(IssuecodeFilter, "", "");
	// 	enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply button");
		click(Record, "Record");
		click(SubmitBtn, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, DroppedIssueCode);
		switchToDefaultContent(driver);

	}

	public void devForceClosureAfterApproval() {
		switchToDefaultContent(driver);
		click(ProcessmanagerMenu, "Process manager");
		scrollToViewElement(DevForceClosureAuditTrailMenu);
		click(DevForceClosureAuditTrailMenu, "Deviation force closure Audit Trail");
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced sreach button");
		enterUniqueCode(driver, IssuecodeFilter);
		//sendText(IssuecodeFilter, "DEV-CTPL-QC-22-0005", "");
		click(DateFilter, "Date calendar");
		click(LastThirtyBtn, "Last 30 days");
		click(ApplyButton, "Apply button");
		verifyCaptionContains(NodataElement, "No data available in table");
		switchToDefaultContent(driver);

	}

}
