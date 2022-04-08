package com.Automation.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class ChangeControlQAApproval extends ActionEngine {

	@FindBy(xpath = "//span[text()='Change Control Login']")
	WebElement ccLgn;

	@FindBy(id = "pageTitle")
	WebElement pageTitleCC;

	@FindBy(id = "btnAdvSearch")
	WebElement advSearchBtn;

	@FindBy(xpath = "//input[@placeholder='Issue Code']")
	WebElement issueCode;

	@FindBy(id = "btnSubmitListFilter")
	WebElement applyBtn;

	@FindBy(className="text-ellipsis")
	WebElement ICode;

	@FindBy(xpath = "//div[@class='event']")
	WebElement eventSection;

	@FindBy(xpath = "//label[text()='Approve']")
	WebElement decisionReview;

	@FindBy(id = "ISU_LGN_CTR_030_error")
	WebElement QAReviewCmtsErr;

	@FindBy(id = "ISU_LGN_CTR_030")
	WebElement QAReviewCmts;

//	@FindBy(id = "ISU_LGN_CTR_194_target")
//	WebElement viewDetails;

//	@FindBy(xpath = "//span[text()='QA Decision and Comments']")
//	WebElement QADecisionHeading;

	@FindBy(id = "txtRemarks")
	WebElement remarkReason;

	@FindBy(id = "btnSubmit")
	WebElement submitBtn;

	@FindBy(xpath = "(//div[contains(@class, 'confirmation-message-text')])[2]")
	WebElement cngMsg;
	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement UCode;
	
	@FindBy(id = "cfnMsg_Next")
	WebElement done;

	public void ccQAApproval(String QAComments, String RemRsn) {

		// Wait for 1Sec
		waitForPageToLoad(1000);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Scroll to Change Control
		scrollToViewElement(ccLgn);

		// Click Change Control
		click(ccLgn, "Change Control Login");

		// Switch to default Page
		switchToDefaultContent(driver);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Verify Captions
		verifyCaptionContains(pageTitleCC, "Change Control Login");

		// Click Advanced Search
		click(advSearchBtn, "Advanced Search");

		// Enter Unique Code
		enterUniqueCode(driver, issueCode);

		// Click Apply Button
		click(applyBtn, "Apply Button");

		// Click Issue Code
		click(ICode, "ICode");

		// Switch to default Page
		switchToDefaultContent(driver);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify QA Review Alert
		verifyCaptionContains(QAReviewCmtsErr, "Enter Value");

		// Enter QA Review Comments
		sendText(QAReviewCmts, QAComments, "QA Review Comments");

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Enter Remarks/Reasons
		sendText(remarkReason, RemRsn, "Remarks/Reasons");

		// Click IHOD Submit button
		click(submitBtn, "IHOD Submit Button");

		// ESign should display
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		
		saveUniqueCode(driver, UCode);
		
		switchToDefaultContent(driver);
		/*e_SignAvailabe();

		// Entering E_Sign Password
		EsignCnfrm(ConfigsReader.getPropValue("CCLgnQAID"), cngMsg, "Change Control Login Registration Approval", done);*/
	}
	public void ccQASelectiveApproval(String QAComments) {
		// Wait for 1Sec
				waitForPageToLoad(1000);

				// Switch to Body frame
				switchToBodyFrame(driver);

				// Scroll to Change Control
				scrollToViewElement(ccLgn);

				// Click Change Control
				click(ccLgn, "Change Control Login");

				// Switch to default Page
				switchToDefaultContent(driver);

				// Switch to Body frame
				switchToBodyFrame(driver);

				// Verify Captions
				verifyCaptionContains(pageTitleCC, "Change Control Login");

				// Click Advanced Search
				click(advSearchBtn, "Advanced Search");

				// Enter Unique Code
				clearField(issueCode, "issue code");
				enterUniqueCode(driver, issueCode);

				// Click Apply Button
				click(applyBtn, "Apply Button");

				// Click Issue Code
				click(ICode, "ICode");

				// Switch to default Page
				switchToDefaultContent(driver);

				// Switch to Body frame
				switchToBodyFrame(driver);
				
				clearField(QAReviewCmts, "QA Review Comments");
				sendText(QAReviewCmts, QAComments, "QA Review Comments");

				// Click on Review Radio button
				click(decisionReview, "Review");
				
				click(submitBtn, "IHOD Submit Button");

				// ESign should display
				E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
				
				
		
	}
}
