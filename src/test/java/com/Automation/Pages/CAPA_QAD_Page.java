package com.Automation.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class CAPA_QAD_Page extends ActionEngine {

	@FindBy(id = "ISU_QAD_CTF_003_error")
	WebElement ReviewCommentsError;

	@FindBy(id = "ISU_QAD_CTF_003")
	WebElement ReviewComments;

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

	@FindBy(id = "ISU_QAD_CTF_017_error")
	WebElement DecisiononCAPAError;

	@FindBy(xpath = "//label[@for='ISU_QAD_CTF_017_1']")
	WebElement DecisiononCAPAApprove;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	public void capaQADInitiation(String reviewComments) {
		capaMyTaskMenuNavigations.capaQADMytaskNavigation_SP();

		click(SubmitButton, "Submit Button");
		verifyCaptionContains(ReviewCommentsError, "Enter Value");
		sendText(ReviewComments, reviewComments, "Review Comments");

		click(SubmitButton, "Submit Button");
		verifyCaptionContains(CorrectiveActionPlanRequiredError, "Select Value");
		click(CorrectiveActionPlanRequiredNo, "Corrective Action Plan Required No");

		click(SubmitButton, "Submit Button");
		verifyCaptionContains(PreventiveActionPlanRequiredError, "Select Value");
		click(PreventiveActionPlanRequiredNo, "Preventive Action Plan Required No");
		click(PreventiveActionPlanRequiredNo, "Preventive Action Plan Required No");

		click(SubmitButton, "Submit Button");
		verifyCaptionContains(OtherActionPlanRequiredError, "Select Value");
		click(OtherActionPlanRequiredNo, "Other Action Plan Required No");
		click(OtherActionPlanRequiredNo, "Other Action Plan Required No");

		click(SubmitButton, "Submit Button");
		verifyCaptionContains(DecisiononCAPAError, "Select Value");
		click(DecisiononCAPAApprove, "Decision on CAPA Approve");
		click(DecisiononCAPAApprove, "Decision on CAPA Approve");

		TimeUtil.shortWait();
		click(SubmitButton, "Submit Button");
		//TimeUtil.shortWait();
		/*Alert alert = driver.switchTo().alert();
		alert.accept();*/
		alertAccept(driver);
		/*switchToDefaultContent(driver);
		switchToBodyFrame(driver);*/
	E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));

		switchToDefaultContent(driver);

	}

}
