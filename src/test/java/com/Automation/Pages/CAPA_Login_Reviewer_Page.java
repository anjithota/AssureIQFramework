package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class CAPA_Login_Reviewer_Page extends ActionEngine {
	@FindBy(xpath = "//label[@for='EsignerDecision_3']")
	WebElement ReturnButton;

	@FindBy(xpath = "//label[@for='EsignerDecision_2']")
	WebElement ApproveButton;

	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkReasonErr;

	@FindBy(id = "txtRemarks")
	WebElement RemarkReason;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(id = "ISU_LGN_CTR_025_error")
	WebElement HODCommentsError;

	@FindBy(id = "ISU_LGN_CTR_025")
	WebElement HODComments;

	@FindBy(id = "ISU_LGN_CTR_195_Error")
	WebElement DepartmentsRequiredtoProvideCommentsError;

	@FindBy(id = "ISU_LGN_CTR_195_button")
	WebElement DepartmentsRequiredtoProvideComments;

	@FindBy(xpath = "//button[@class='caliber-button-primary float-right']")
	WebElement AllcationSubmit;

	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement TaskAllocationAlert;

	@FindBy(xpath = "//button[@class='toast-close-button']")
	WebElement TaskAllocationAlertClose;

	@FindBy(id = "btnAddTask_3457")
	WebElement TaskAllocationPopupAddItem;

	@FindBy(xpath = "//select[@class='task-allocation-ugp select2-hidden-accessible']")
	WebElement SelectDepartment;

	public void capaLoginReviewReturn(String remarks) {
		capaMyTaskMenuNavigations.capaLoginMytaskNavigation_SP();
		click(ReturnButton, "Return Button");
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(RemarkReasonErr, "Enter Value");
		sendText(RemarkReason, remarks, "Remark Reason");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		switchToDefaultContent(driver);
	}

	public void capaLoginReviewApprove(String hodComments, String department) {
		capaMyTaskMenuNavigations.capaLoginMytaskNavigation_SP();
		click(ApproveButton, "Approve Button");
		verifyCaptionContains(HODCommentsError, "Enter Value");
		sendText(HODComments, hodComments, "HOD Comments");

		click(ApproveButton, "Approve Button");
		verifyCaptionContains(DepartmentsRequiredtoProvideCommentsError, "Select Value");
		click(DepartmentsRequiredtoProvideComments, "Departments Required to Provide Comments Button");
		switchToPopupModalFrame2(driver);
		click(AllcationSubmit, "Allocation Submit");
		verifyCaptionContains(TaskAllocationAlert, "Select Atleast one task to allocate");
		click(TaskAllocationAlertClose, "Alert Close");
		click(TaskAllocationPopupAddItem, "AddItem Allocation");
		selectDropdownUsingVisisbleText(SelectDepartment, department, "Department"); // Information Technology ( IT )
		click(AllcationSubmit, "Allocation Submit");
		switchToParentFrame(driver);
		click(ApproveButton, "Approve Button");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		switchToDefaultContent(driver);

	}

	public void capaLoginReviewAgainApprove(String hodComments) {
		capaMyTaskMenuNavigations.capaLoginMytaskNavigation_SP();
		clearField(HODComments, "HOD Comments");
		sendText(HODComments, hodComments, "HOD Comments");
		click(ApproveButton, "Approve Button");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		switchToDefaultContent(driver);

	}

}
