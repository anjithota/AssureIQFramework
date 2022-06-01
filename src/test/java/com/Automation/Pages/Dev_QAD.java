package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class Dev_QAD extends ActionEngine {

	@FindBy(id = "MyTaskPrc_DEV_ISU_DEV_QAD_FRM_01")
	WebElement DevQADMytask;

	@FindBy(xpath = "//span[@title='Deviation']")
	WebElement DevMyTaskMenu;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssuecodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(id = "btnSelectiveReturn")
	WebElement SelectiveReturnButton;

	@FindBy(xpath = "//input[@class='caliber-labeled-option StageRadioButton']/following :: label[contains(text(),'Stage 2')]")
	WebElement StageTwoCheckbox; // rbl_77759_2363_2363_2

	@FindBy(className = "toast-message")
	WebElement AlertMessage;

	@FindBy(className = "toast-close-button")
	WebElement AlertClose;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement RetUcode;

	@FindBy(xpath = "//a[@class='caliber-button-secondary']")
	WebElement Home;

	@FindBy(id = "txtRemarks")
	WebElement remarkReason;

	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkReasonErr;

	@FindBy(id = "ISU_QAD_CTF_003")
	WebElement ReviewcommentsBox;

	@FindBy(id = "ISU_QAD_CTF_003_error")
	WebElement ReviewcommentsBoxError;

	@FindBy(id = "ISU_QAD_CTF_022_error")
	WebElement RootCauseDropdownError;

	@FindBy(id = "ISU_QAD_CTF_022")
	WebElement RootCauseDropdown;

	@FindBy(id = "ISU_QAD_CTF_003_error")
	WebElement ReviewCommentsError;

	@FindBy(id = "ISU_QAD_CTF_003")
	WebElement ReviewCommentsText;

	@FindBy(id = "ISU_QAD_CTF_034_error")
	WebElement RecategorizationRequiredError;

	@FindBy(id = "ISU_QAD_CTF_034_2")
	WebElement RecategorizationRequiredNo;

	@FindBy(id = "ISU_QAD_CTF_011_error")
	WebElement CorrectiveActionPlanRequiredError;

	@FindBy(id = "ISU_QAD_CTF_011_2")
	WebElement CorrectiveActionPlanRequiredNo;

	@FindBy(id = "ISU_QAD_CTF_013_error")
	WebElement PreventiveActionPlanRequiredError;

	@FindBy(id = "ISU_QAD_CTF_013_2")
	WebElement PreventiveActionPlanRequiredNo;

	@FindBy(id = "ISU_QAD_CTF_015_error")
	WebElement OtherActionPlanRequiredError;

	@FindBy(id = "ISU_QAD_CTF_015_2")
	WebElement OtherActionPlanRequiredNo;

	@FindBy(id = "DVQA_04")
	WebElement DevQADAuditTrailMenu;

	@FindBy(xpath = "//div[@class='left-module ft-grid menu-icons'][2]")
	WebElement ProcessmanagerMenu;

	@FindBy(className = "popup-close-button")
	WebElement AuditTrailClose;

	@FindBy(id = "ISU_QAD_CTF_025_error")
	WebElement DetailsofRootCauseError;

	@FindBy(id = "ISU_QAD_CTF_025")
	WebElement DetailsofRootCause;

	public void devQAD(String rootCauseDropdown, String reviewComments, String rootCauseDetails) {

		switchToBodyFrame(driver);

		click(DevMyTaskMenu, "Deviation menu");
		click(DevQADMytask, "Deviation OTD Menu");
		switchToTaskListFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		enterUniqueCode(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");

		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(SubmitButton, "Submit");

		verifyCaptionContains(ReviewCommentsError, "Enter Value");
		sendText(ReviewCommentsText, reviewComments, "Review Comments");
		click(SubmitButton, "Submit");
		verifyCaptionContains(RootCauseDropdownError, "Select Value");
		selectDropdownUsingVisisbleText(RootCauseDropdown, rootCauseDropdown, "Root Cause Dropdown");
		// jsClick(RootCauseDropdown, "test");
		click(SubmitButton, "Submit");
		verifyCaptionContains(DetailsofRootCauseError, "Enter Value");
		sendText(DetailsofRootCause, rootCauseDetails, "detail of review comments");

		click(SubmitButton, "Submit");
		verifyCaptionContains(RecategorizationRequiredError, "Select Value");
		click(RecategorizationRequiredNo, "Recategorization Required No");

		click(SubmitButton, "Submit");
		verifyCaptionContains(CorrectiveActionPlanRequiredError, "Select Value");
		click(CorrectiveActionPlanRequiredNo, "Corrective Action Plan Required No");

		click(SubmitButton, "Submit");
		verifyCaptionContains(PreventiveActionPlanRequiredError, "Select Value");
		click(PreventiveActionPlanRequiredNo, "Preventive Action Plan Required No");

		click(SubmitButton, "Submit");
		verifyCaptionContains(OtherActionPlanRequiredError, "Select Value");
		click(OtherActionPlanRequiredNo, "Other Action Plan Required No");

		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));

	}

	public void devQADAuditTrail() {

		switchToDefaultContent(driver);
		click(ProcessmanagerMenu, "Process manager");
		click(DevQADAuditTrailMenu, "Deviation closure Audit Trail");
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced sreach button");
		enterUniqueCode(driver, IssuecodeFilter);
		click(ApplyButton, "Apply button");
		click(Record, "Record");
		switchToPopupModelFrame(driver);
		click(AuditTrailClose, "Close Button");
		switchToDefaultContent(driver);
	}

}
