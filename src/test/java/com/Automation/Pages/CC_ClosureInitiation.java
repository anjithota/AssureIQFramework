package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class CC_ClosureInitiation extends ActionEngine {
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

	@FindBy(id = "ISU_CLS_CTR_003_error")
	WebElement ImplementationDetailsError;

	@FindBy(id = "ISU_CLS_CTR_003")
	WebElement ImplementationDetails;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;

	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkError;

	public void ccClosureInitiation(String ImplemetationDetail) {
		switchToBodyFrame(driver);

		scrollToViewElement(CCClosure);
		click(CCClosure, "CC closure Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		enterUniqueCodeConcat(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");

		click(SubmitBtn, "Submit Button");

		verifyCaptionContains(ImplementationDetailsError, "Enter Value");
		sendText(ImplementationDetails, ImplemetationDetail, "Imp Details");

		click(SubmitBtn, "Submit Button");

		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));

		switchToDefaultContent(driver);
	}

	public void ccClosureReInitiation(String ImplemetationDetail, String RemarkReason) {
		switchToBodyFrame(driver);

		scrollToViewElement(CCClosure);
		click(CCClosure, "CC closure Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		enterUniqueCodeConcat(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");

		clearField(ImplementationDetails, "ImplementationDetails");
		sendText(ImplementationDetails, ImplemetationDetail, "imp Details");

		

		

		click(SubmitBtn, "Submit Button");

		verifyCaptionContains(RemarkError, "Enter Value");
		sendText(Remarks, RemarkReason, "remarks");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));

		switchToDefaultContent(driver);
	}

}
