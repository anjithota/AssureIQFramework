package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class CAPA_Closure_Intiator_Page extends ActionEngine {

	@FindBy(id = "ISU_CLS_CTR_013_error")
	WebElement CommentsError;

	@FindBy(id = "ISU_CLS_CTR_013")
	WebElement Comments;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkReasonErr;

	@FindBy(id = "txtRemarks")
	WebElement RemarkReason;

	@FindBy(xpath = "//label[@for='EsignerDecision_3']")
	WebElement ReturnButton;

	@FindBy(xpath = "//label[@for='EsignerDecision_2']")
	WebElement ApproveButton;

	@FindBy(id = "ISU_CLS_CTR_010_error")
	WebElement QACommentsError;

	@FindBy(id = "ISU_CLS_CTR_010")
	WebElement QAComments;

	@FindBy(id = "ISU_CLS_CTR_011_error")
	WebElement ClosureStatusError;

	@FindBy(id = "ISU_CLS_CTR_011")
	WebElement ClosureStatusDropdown;

	public void capaClosureInitiation(String comments) {
		capaMyTaskMenuNavigations.capaClosureMytaskNavigation_SP();
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(CommentsError, "Eneter Value");
		sendText(Comments, comments, "Comments");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		switchToDefaultContent(driver);

	}

	public void capaClosureReInitiation(String comments, String remarks) {
		capaMyTaskMenuNavigations.capaClosureMytaskNavigation_SP();
		clearField(Comments, "Comments");
		sendText(Comments, comments, "Comments");
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(RemarkReasonErr, "Eneter Value");
		sendText(RemarkReason, remarks, "Remarks");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		switchToDefaultContent(driver);

	}

	public void capaClosureReviewerReturn(String remarks) {
		capaMyTaskMenuNavigations.capaClosureMytaskNavigation_SP();
		click(ReturnButton, "Return Button");
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(RemarkReasonErr, "Eneter Value");
		sendText(RemarkReason, remarks, "Remarks");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		switchToDefaultContent(driver);

	}

	public void capaClosureReviewerApprove(String qaComments, String closureStatus) {
		capaMyTaskMenuNavigations.capaClosureMytaskNavigation_SP();
		click(ApproveButton, "Approve Button");
		verifyCaptionContains(QACommentsError, "Eneter Value");
		sendText(QAComments, qaComments, "QA Comments");
		click(ApproveButton, "Approve Button");
		verifyCaptionContains(ClosureStatusError, "Select Value");
		selectDropdownUsingVisisbleText(ClosureStatusDropdown, closureStatus, "Closure Status Dropdown");
		click(ApproveButton, "Approve Button");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		switchToDefaultContent(driver);

	}

}
