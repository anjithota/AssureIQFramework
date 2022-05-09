package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class Dev_Lgn_Approval extends ActionEngine {
	@FindBy(xpath = "//span[@title='Deviation']")
	WebElement DevMyTaskMenu;

	@FindBy(id = "MyTaskPrc_DEV_ISU_LGN_DEV_FRM_ID_01")
	WebElement DevLgnTaskMenu;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssuecodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(xpath = "//label[@for='EsignerDecision_2']")
	WebElement ApproveDecision;

	@FindBy(xpath = "//label[@for='EsignerDecision_3']")
	WebElement ReturnDecision;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_131_2']")
	WebElement ExtendedActionRequired;

	@FindBy(id = "ISU_LGN_CTR_131_error")
	WebElement ExtendedActionRequiredError;

	@FindBy(id = "btnSubmit")
	WebElement submitBtn;

	@FindBy(id = "txtRemarks")
	WebElement remarkReason;

	@FindBy(id = "ISU_LGN_CTR_030")
	WebElement QaCommentsText;

	@FindBy(id = "ISU_LGN_CTR_030_error")
	WebElement QaCommentsTextError;

	public void devLgnApprove(String QAComments) {
		switchToBodyFrame(driver);
		click(DevMyTaskMenu, "Deviation my task menu");
		click(DevLgnTaskMenu, "Deviation Login My task menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		// sendText(IssuecodeFilter, "CC-PL01-Admin-21-0013", "Isssue Code Filter");

		enterUniqueCode(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");

		scrollToViewElement(ApproveDecision);

		click(ApproveDecision, "Approve");

		verifyCaptionContains(QaCommentsTextError, "Enter Value");
		sendText(QaCommentsText, QAComments, "QA Comments");

		scrollToViewElement(ApproveDecision);

		click(ApproveDecision, "Approve");
		verifyCaptionContains(ExtendedActionRequiredError, "Select Value");
		click(ExtendedActionRequired, "Extended Action No");

		
		click(submitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevApprPwd"));

		switchToDefaultContent(driver);
	}

	public void devLgnApprReturn(String Reason) {
		switchToBodyFrame(driver);
		click(DevMyTaskMenu, "Deviation my task menu");
		click(DevLgnTaskMenu, "Deviation Login My task menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		// sendText(IssuecodeFilter, "CC-PL01-Admin-21-0013", "Isssue Code Filter");

		enterUniqueCode(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");

		scrollToViewElement(ReturnDecision);
		click(ReturnDecision, "Return");
		sendText(remarkReason, Reason, "Remarks");

	}

	public void devLgnApprSelectiveReturn(String QaComment, String Reason) {
		switchToBodyFrame(driver);
		click(DevMyTaskMenu, "Deviation my task menu");
		click(DevLgnTaskMenu, "Deviation Login My task menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		// sendText(IssuecodeFilter, "CC-PL01-Admin-21-0013", "Isssue Code Filter");

		enterUniqueCode(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");

	}

}
