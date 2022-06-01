package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class Dev_ForceClosureApproval extends ActionEngine {
	@FindBy(xpath = "//span[@title='Process Manager']")
	WebElement ProcessManagerMyTaskMenu;

	@FindBy(id = "MyTaskMod_PRSMGR_PRC_FCL_DEV_FRM_ID")
	WebElement ForceClosuremenu;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssuecodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;

	@FindBy(id = "txtRemarks")
	WebElement Remark;

	@FindBy(xpath = "//label[text()='Approve']")
	WebElement decisionApprove;

	@FindBy(xpath = "//label[text()='Drop']")
	WebElement decisionDrop;

	@FindBy(className = "confirmation_text")
	WebElement DroppedIssueCode;

	@FindBy(id = "PRC_FCL_CTF_001_VAL")
	WebElement UcodeAuditTrail;

	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeBtn;
	
	@FindBy(id = "MyTaskPrc_DEV_ISU_DEV_OTD_FRM_01")
	WebElement DeviationOTDMytask;

	@FindBy(xpath = "//span[@title='Deviation']")
	WebElement DevMyTaskMenu;
	
	@FindBy(xpath = "//td[text()='No data available in table']")
	WebElement NodataElement;

	public void devForceClosureApprovalApprove() {
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		scrollToViewElement(ProcessManagerMyTaskMenu);
		click(ProcessManagerMyTaskMenu, "Process manager");
		scrollToViewElement(ForceClosuremenu);
		click(ForceClosuremenu, "force closure menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		enterUniqueCode(driver, IssuecodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		TimeUtil.shortWait();
		click(decisionApprove, "Approve Button");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		switchToDefaultContent(driver);

	}

	public void devForceClosureApprovalDrop(String remarks) {

		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		scrollToViewElement(ProcessManagerMyTaskMenu);
		click(ProcessManagerMyTaskMenu, "Process manager");
		scrollToViewElement(ForceClosuremenu);
		click(ForceClosuremenu, "force closure menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		enterUniqueCode(driver, IssuecodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		TimeUtil.shortWait();
		//
		click(decisionDrop, "Drop Button");
		sendText(Remark, remarks, "Remarks");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		//saveAlterUniqueCode(driver, DroppedIssueCode);
		switchToDefaultContent(driver);

	}
	
	public void devForceClosureImpacts() {
		
		switchToBodyFrame(driver);

		click(DevMyTaskMenu, "Deviation menu");
		click(DeviationOTDMytask, "Deviation OTD Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		enterUniqueCode(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		verifyCaptionContains(NodataElement, "No data available in table");
		switchToDefaultContent(driver);
		
		
	}

}
