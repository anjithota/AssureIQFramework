package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class CC_ClosureApproval extends ActionEngine {
	@FindBy(xpath = "//a[@href='http://10.10.3.33//QAMS510BL_OQ/BasePages/ListReport?TT=21&Fid=83269']//span")
	WebElement CCClosure;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_CLS_CTR_001")
	WebElement IssuecodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;

	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkError;

	@FindBy(xpath = "//label[@for='EsignerDecision_3']")
	WebElement ReturnBtn;

	@FindBy(xpath = "//label[@for='EsignerDecision_2']")
	WebElement ApproveBtn;
	@FindBy(id = "ISU_CLS_CTR_010")
	WebElement QAComments;

	@FindBy(id = "ISU_CLS_CTR_010_error")
	WebElement QACommentsError;

	public void ccClosureReturn(String RemarkReason) {
		switchToBodyFrame(driver);

		scrollToViewElement(CCClosure);
		click(CCClosure, "CC closure Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		enterUniqueCodeConcat(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(ReturnBtn, "Return");
		click(SubmitBtn, "Submit");
		verifyCaptionContains(RemarkError, "Enter Value");
		sendText(Remarks, RemarkReason, "remarks");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnIHODPwd"));
		switchToDefaultContent(driver);

	}

	public void ccClosureApprove(String QAComment) {
		switchToBodyFrame(driver);

		scrollToViewElement(CCClosure);
		click(CCClosure, "CC closure Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		enterUniqueCodeConcat(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(ApproveBtn, "Approve");
		verifyCaptionContains(QACommentsError, "Enter Value");
		sendText(QAComments, QAComment, "QA Comments");
		click(ApproveBtn, "Approve");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnIHODPwd"));
		switchToDefaultContent(driver);

	}

}
