package com.Automation.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.TimeUtil;


public class ChangeControlQAApprovalAuditTrail extends ActionEngine {

	@FindBy(xpath = "//a[@class='caliber-product-qams product-icon1']")
	WebElement assureIQ;

	@FindBy(xpath = "//ul[@id='MenuModule_QAMS']/child::li/child::a")
	List<WebElement> assureIQList;

	@FindBy(xpath = "//a[contains(text(), 'Process Manager')]")
	WebElement processManager;

	@FindBy(xpath = "//a[contains(text(), 'Change Control Login')]")
	WebElement loginChangeControl;

	@FindBy(id = "QAMS_PRSMGR_ISU_LGN_CC_FRM_ID_01_AUDMEN") //QAMS_PRSMGR_ISU_OTD_FRM_01_AUDMEN
	WebElement ccAuditTrail;

	@FindBy(id = "pageTitle")
	WebElement pageTitleCCAT;

	@FindBy(xpath = "//table[@id='ReportTab']/thead/child::tr[@class='thead-bg']/th")
	List<WebElement> totalColumns;

	@FindBy(id = "listFetchMore")
	WebElement viewMore;

	@FindBy(xpath = "//table[@id='ReportTab']//tbody//tr[@role='row']")
	List<WebElement> totalRows;

	@FindBy(id = "btnAdvSearch")
	WebElement advancedSearch;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement issueCode;

	@FindBy(id = "btnSubmitListFilter")
	WebElement apply;

	@FindBy(xpath = "//span[@class='text-ellipsis']")
	WebElement ICode;
	
	@FindBy(xpath = "//div[@class='textdiv qsTitle']//span[text()='Revision No. 0']")
	WebElement RegRevision;
	
	@FindBy(id = "AuditEventModal_View")
	WebElement proceedBtn;
	
//	@FindBy(id = "MainTRN")
//	WebElement lgnRegDetails;

	@FindBy(xpath = "//span[text()='No. of Approvals Required:']")
	WebElement NoOfAppReq;

//	@FindBy(xpath = "//span[text()='No. of Approvals Completed:']")
//	WebElement NoOfAppCompleted;
//
//	@FindBy(xpath = "//*[contains(@class,'audit-preview-date')]")
//	WebElement dateInitiated;

	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeBtn;

	public void ccQAApprovalAT() {

		// Switch to default Page
		switchToDefaultContent(driver);

		// Wait for 1sec
		waitForPageToLoad(1000);

		// Clicking on AssureIQ Icon
		click(assureIQ, "AssureIQIcon");
		System.out.println("\n" + "-----------------------------------");

		// Get the Size of AssureIQ Icon
		System.out.println("\n" + "List of AssureIQ are:- " + getSize(assureIQList));


		// Clicking on Process Manager
		highLightElement(driver, processManager, test);
		jsClick(processManager, "ProcessManager");
		TimeUtil.shortWait();

		// Clicking on Deviation Login
		highLightElement(driver, loginChangeControl, test);
		jsClick(loginChangeControl, "DeviationLogin");
		TimeUtil.shortWait();

		// Clicking on Deviation Login Audit Trail
		highLightElement(driver, ccAuditTrail, test);
		jsClick(ccAuditTrail, "DeviationAuditTrail");
		TimeUtil.shortWait();

		// Switch to Frame
		switchToBodyFrame(driver);

		// Title of Page
		System.out.println("\n" + "-----------------------------------");
		System.out.println("Title of the Page:- " + getText(pageTitleCCAT, "CC Login Audit Trail"));

		// To Display Columns Size and their Name
		System.out.println("\n" + "-----------------------------------");
		getSize(totalColumns);
		System.out.println("\n" + "List of Columns are:- " + getSize(totalColumns) + "\n");
		

		// Scroll to Advanced search and Click
		click(advancedSearch, "Advanced Search Button");

		// Enter Issue Code
		clearField(issueCode, "clear issue code");
		enterUniqueCode(driver, issueCode);

		// Click Apply
		click(apply, "Apply Button");

		// click Issue Code based on search
		click(ICode, "ICode");
		
		//Switch to frame inside a frame
		switchToPopupModelFrame(driver);
		
		//Click Registration Revision No Draft
		click(RegRevision, "Registration Revision No Draft");
		
		//Click Proceed Button
		click(proceedBtn, "Proceed Button");
		
//		//Verify Data should be in Read Mode
//		isreadOnly(driver, lgnRegDetails);
		
		//Scroll To Element
		scrollToViewElement(NoOfAppReq);

		//Close Audit Trail Popup
		click(closeBtn, "Close Button");
		
		//Switch to Page
		switchToDefaultContent(driver);
	}

}
