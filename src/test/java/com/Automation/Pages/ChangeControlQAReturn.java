package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;


public class ChangeControlQAReturn extends ActionEngine {

//	@FindBy(xpath = "//span[text()='Change Control Login']")
//	WebElement ccLgn;
//
//	@FindBy(id = "pageTitle")
//	WebElement pageTitleCC;
//
////	@FindBy(id = "btnTtlRcrds")
////	WebElement totalRecordsBtn;
////	
////	@FindBy(xpath = "//div[contains(text(), 'Total Record Count')]")
////	WebElement totalRecords;
//
//	@FindBy(id = "btnAdvSearch")
//	WebElement advSearchBtn;
//
//	@FindBy(xpath = "//input[@placeholder='Issue Code']")
//	WebElement issueCode;
//
//	@FindBy(id = "btnSubmitListFilter")
//	WebElement applyBtn;
//
//	@FindBy(xpath = "//span[contains(@title, 'PROV')]")
//	WebElement ICode;

	@FindBy(xpath = "//span[@id='MainTitle']//ancestor::div[2]")
	WebElement headerTitle;

	@FindBy(xpath = "//*[text()='Return']")
	WebElement decisionReturn;

	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkReasonErr;

	@FindBy(id = "txtRemarks")
	WebElement remarkReason;

	@FindBy(id = "btnSubmit")
	WebElement submitBtn;

	@FindBy(xpath = "(//div[@class='confirmation-message-text'])[2]")
	WebElement cngMessage;

	@FindBy(id = "cfnMsg_Next")
	WebElement done;

	public void returnTranAtQAReview(String RemarkReason) {

//		// Wait for 1Sec
//		waitForPageToLoad(1000);
//
//		// Switch to Body frame
//		switchToBodyFrame(driver);
//
//		// Scroll to Change Control
//		scrollToViewElement(ccLgn);
//
//		// Click Change Control
//		click(ccLgn, "Change Control Login");
//
//		// Switch to default Page
//		switchToDefaultContent(driver);
//
//		// Switch to Body frame
//		switchToBodyFrame(driver);
//
//		// Verify Captions
//		verifyCaptionContains(pageTitleCC, "Change Control Login My Task");
//
//		// Click Advanced Search
//		click(advSearchBtn, "Advanced Search");
//
//		// Enter Unique Code
//		enterUniqueCode(driver, issueCode);
//
//		// Click Apply Button
//		click(applyBtn, "Apply Button");
//
//		// Click Issue Code
//		click(ICode, "ICode");
		
		ccMyTaskSearch.myTaskChangeControlSearch();

		// Switch to default Page
		switchToDefaultContent(driver);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Select Return Radio Button
		click(decisionReturn, "Return");

		// Click Submit Button
		click(submitBtn, "Submit");

		// Verify Remarks/Reasons Alert
		verifyCaptionContains(RemarkReasonErr, "Enter Value");

		// Enter Remark(s)/Reason(s)
		sendText(remarkReason, RemarkReason, "RemarksReasons");

		// Click Submit Button
		click(submitBtn, "Submit");

		// ESign should display
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		/*e_SignAvailabe();

		// Confirmation Message
		EsignCnfrm(ConfigsReader.getPropValue("CCLgnQAPwd"), cngMessage, "Transaction Returned", done);*/

		// Switch to Page
		switchToDefaultContent(driver);
	}

}
