package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class MCDN_ForceClosure_Page extends ActionEngine {

	@FindBy(id = "btnCreate")
	WebElement initiate;

	@FindBy(id = "btnProcessClosure")
	WebElement ForceClosureButton;

	@FindBy(id = "btnSubmit")
	WebElement proceedButton;

	@FindBy(xpath = "//label[@for='item_DN']")
	WebElement DocumentationActionPlanIcon;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "DN_LGN_CTR_006")
	WebElement ActionPlanUcodeSearchFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(xpath = "//span[@title='Process Manager']")
	WebElement ProcessManagerMyTaskMenu;

	@FindBy(id = "MyTaskMod_PRSMGR_PRC_FCL_DN_FRM_ID")
	WebElement ForceClosureDNMyTaskMenu;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssueCodeFilter;

	@FindBy(xpath = "//label[@for='EsignerDecision_2']")
	WebElement ApproveButton;

	@FindBy(xpath = "//label[@for='EsignerDecision_4']")
	WebElement DropButton;

	public void DnForceClosureInitiator() {
		switchToDefaultContent(driver);
		// switchToBodyFrame(driver);
		click(initiate, "InitiateButtton");

		click(ForceClosureButton, "Force Closure Button");

		// Switch to Frame
		switchToPopupModelFrame(driver);

		click(DocumentationActionPlanIcon, "Market Complaints Icon");

		click(proceedButton, "Proceed button");

		switchToDefaultContent(driver);

		switchToBodyFrame(driver);

		click(AdvanceSearchButton, "Advanced Search button");
		enterUniqueCodeConcat(driver, ActionPlanUcodeSearchFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		switchToDefaultContent(driver);

	}

	public void dnForceClosureApprovalApprove() {
		
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		scrollToViewElement(ProcessManagerMyTaskMenu);
		click(ProcessManagerMyTaskMenu, "Process Manager My Task Menu");
		click(ForceClosureDNMyTaskMenu, "Force Closure DN My Task Menu");
		switchToTaskListFrame(driver);
		click(AdvanceSearchButton, "Advance Search Button");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(ApproveButton, "Approve Button");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		switchToDefaultContent(driver);

	}

	public void dnForceClosureApprovalDrop() {

		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		scrollToViewElement(ProcessManagerMyTaskMenu);
		click(ProcessManagerMyTaskMenu, "Process Manager My Task Menu");
		click(ForceClosureDNMyTaskMenu, "Force Closure DN My Task Menu");
		switchToTaskListFrame(driver);
		click(AdvanceSearchButton, "Advance Search Button");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(DropButton, "Drop Button");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		switchToDefaultContent(driver);

	}

}
