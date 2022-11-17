package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class MC_QADecision_Page extends ActionEngine {

	@FindBy(xpath = "//small[text()='MC']")
	WebElement MarketComplaintsMyTaskMenu;

	@FindBy(id = "MyTaskPrc_MC_ISU_MC_QAD_FRM_01")
	WebElement QADecisionMyTaskMenu;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(id = "ISU_QAD_CTF_023_error")
	WebElement SummaryConclusionError;

	@FindBy(id = "ISU_QAD_CTF_023")
	WebElement SummaryConclusion;

	@FindBy(id = "ISU_QAD_CTF_022_error")
	WebElement PropbableReasonCategoryError;

	@FindBy(id = "ISU_QAD_CTF_022")
	WebElement PropbableReasonCategoryDropdown;

	@FindBy(id = "ISU_QAD_CTF_025_error")
	WebElement PropbableReasonError;

	@FindBy(id = "ISU_QAD_CTF_025")
	WebElement PropbableReasonTextbox;

	@FindBy(id = "ISU_QAD_CTF_034_error")
	WebElement RecategoryRequiredError;

	@FindBy(xpath = "//label[@for='ISU_QAD_CTF_034_1']")
	WebElement RecategoryRequiredYes;

	@FindBy(id = "ISU_QAD_CTF_038_error")
	WebElement ComplaintCategoryError;

	@FindBy(id = "ISU_QAD_CTF_038")
	WebElement ComplaintCategoryDropdown;

	@FindBy(id = "ISU_QAD_CTF_024_error")
	WebElement GenuinenessofComplaintError;

	@FindBy(id = "ISU_QAD_CTF_024")
	WebElement GenuinenessofComplaintDropdown;

	@FindBy(id = "ISU_QAD_CTF_011_error")
	WebElement CorrectiveActionPlanRequiredError;

	@FindBy(xpath = "//label[@for='ISU_QAD_CTF_011_2']")
	WebElement CorrectiveActionPlanRequiredNo;

	@FindBy(id = "ISU_QAD_CTF_013_error")
	WebElement PreventiveActionPlanRequiredError;

	@FindBy(xpath = "//label[@for='ISU_QAD_CTF_013_2']")
	WebElement PreventiveActionPlanRequiredNo;

	@FindBy(id = "ISU_QAD_CTF_015_error")
	WebElement OtherActionPlanRequiredError;

	@FindBy(xpath = "//label[@for='ISU_QAD_CTF_015_2']")
	WebElement OtherActionPlanRequiredNo;

	// Audit Trails
	@FindBy(xpath = "//div[@class='left-module ft-grid menu-icons'][2]")
	WebElement ProcessmanagerMenu;

	@FindBy(id = "MCQA_04")
	WebElement MarketComplaintsAuditTrailMenu;

	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeBtn;

	@FindBy(className = "event-div")
	WebElement Events;

	public void qaDecision(String summaryConclusion, String probableCategory, String probableReasons,
			String complaintCategory, String genuinenessOfComplaint) {
		switchToBodyFrame(driver);
		scrollToViewElement(MarketComplaintsMyTaskMenu);
		click(MarketComplaintsMyTaskMenu, "MarketComplaintsMyTaskMenu");
		click(QADecisionMyTaskMenu, "QADecisionMyTaskMenu");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(SummaryConclusionError, "Enter Value");
		sendText(SummaryConclusion, summaryConclusion, "Summary Conclusion");
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(PropbableReasonCategoryError, "Select Value");
		selectDropdownUsingVisisbleText(PropbableReasonCategoryDropdown, probableCategory,
				"Propbable Reason Category Dropdown");
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(PropbableReasonError, "Enter Value");
		sendText(PropbableReasonTextbox, probableReasons, "Propbable Reason Textbox");
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(ComplaintCategoryError, "Select Value");
		selectDropdownUsingVisisbleText(ComplaintCategoryDropdown, complaintCategory, "Complaint Category Dropdown");

		click(SubmitButton, "Submit Button");
		verifyCaptionContains(GenuinenessofComplaintError, "Select Value");
		selectDropdownUsingVisisbleText(GenuinenessofComplaintDropdown, genuinenessOfComplaint,
				"Genuineness of Complaint Dropdown");
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(CorrectiveActionPlanRequiredError, "Select Value");
		click(CorrectiveActionPlanRequiredNo, "Corrective ActionPlan Required No");
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(PreventiveActionPlanRequiredError, "Select Value");
		click(PreventiveActionPlanRequiredNo, "Preventive ActionPlan Required No");

		click(SubmitButton, "Submit Button");
		verifyCaptionContains(OtherActionPlanRequiredError, "Select Value");
		click(OtherActionPlanRequiredNo, "Other ActionPlan Required No");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevApprPwd"));

	}

	public void qaDecisionAuditTrail() {

		switchToDefaultContent(driver);
		click(ProcessmanagerMenu, "ProcessmanagerMenu");
		scrollToViewElement(MarketComplaintsAuditTrailMenu);
		click(MarketComplaintsAuditTrailMenu, "Market Complaints AuditTrail Menu");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToPopupModelFrame(driver);
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);

	}

}
