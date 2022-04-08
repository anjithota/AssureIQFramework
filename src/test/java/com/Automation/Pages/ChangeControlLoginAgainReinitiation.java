package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;


public class ChangeControlLoginAgainReinitiation extends ActionEngine {

	@FindBy(xpath = "//div[@id='MyTaskDiv']//a//span[text()='Change Control Login']")
	WebElement ccLgn;

	@FindBy(id = "pageTitle")
	WebElement pageTitle;

	@FindBy(id = "btnAdvSearch")
	WebElement advSearchBtn;

	@FindBy(xpath = "//input[@placeholder='Issue Code']")
	WebElement issueCode;

	@FindBy(id = "btnSubmitListFilter")
	WebElement applyBtn;

	@FindBy(xpath = "//span[contains(@title, 'PROV')]")
	WebElement ICode;

//	@FindBy(xpath = "//span[@id='MainTitle']//ancestor::div[2]")
//	WebElement headerTitle;

	@FindBy(xpath = "//div[@class='event']")
	WebElement event;

	@FindBy(id = "select2-ISU_LGN_CTR_114-container")
	WebElement blockDD;

	@FindBy(xpath = "//ul[@role='listbox']//li[contains(@id, 'select2-ISU_LGN_CTR_114')][3]")
	WebElement block3;
	
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

	public void ccLgnAgnReinitiation(String RemarksReasons) {

		// Wait for 1sec
		waitForPageToLoad(1000);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Scroll to Deviation Login
		scrollToViewElement(ccLgn);

		// Click on Deviation Login
		click(ccLgn, "Change Control Login");

		// Switch to default Page
		switchToDefaultContent(driver);

		// Switch to Task List frame
		switchToBodyFrame(driver);

		// Verify Page Title
		verifyExactCaption(pageTitle, "Change Control Login My Task");

		// Click on Advanced search button
		click(advSearchBtn, "Advanced Search");

		// Enter Issue Code
		enterUniqueCode(driver, issueCode);

		// Click on Apply Button
		click(applyBtn, "Apply Button");

		// Click on Unique Code
		click(ICode, "ICode");

		// switch to Default Page
		switchToDefaultContent(driver);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Verify Event Section
		verifyExactCaption(event, "Event Section");

		// Select Block
		block();

		// Click Submit Button
		click(submitBtn, "Submit");

		// Verify Remarks/Reasons Alert
		verifyCaptionContains(RemarkReasonErr, "Enter Value");

		// Enter Remark(s)/Reason(s)
		remarkReason(RemarksReasons);

		// Click Submit Button
		click(submitBtn, "Submit");

		// ESign should display
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
//		e_SignAvailabe();
//
//		// Confirmation Message
//		EsignCnfrm(ConfigsReader.getPropValue("EPIQCCPWD"), cngMessage, "Change Control Login Registration Re Initiation", done);

		// Switch to Page
		switchToDefaultContent(driver);
	}

	public void block() {

		click(blockDD, "Block Drop Down");
		click(block3, "Block3");
	}

	public void remarkReason(String RemRsn) {

		sendText(remarkReason, RemRsn, "RemarksReasons");
	}
}
