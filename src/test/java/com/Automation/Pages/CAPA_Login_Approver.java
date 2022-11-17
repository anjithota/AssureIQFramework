package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class CAPA_Login_Approver extends ActionEngine {
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

	@FindBy(id = "ISU_LGN_CTR_030_error")
	WebElement QAReviewCommentsError;

	@FindBy(id = "ISU_LGN_CTR_030")
	WebElement QAReviewComments;

	public void capaLoginApproverReturn(String remarks) {
		capaMyTaskMenuNavigations.capaLoginMytaskNavigation_SP();
		click(ReturnButton, "Return Button");
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(RemarkReasonErr, "Enter Value");
		sendText(RemarkReason, remarks, "Remark Reason");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		switchToDefaultContent(driver);
	}

	public void capaLoginApproverApprove(String qaComments) {
		capaMyTaskMenuNavigations.capaLoginMytaskNavigation_SP();
		click(ApproveButton, "Approve Button");
		verifyCaptionContains(QAReviewCommentsError, "Enter Value");
		sendText(QAReviewComments, qaComments, "QA Comments");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevApprPwd"));
		switchToDefaultContent(driver);

	}

}
