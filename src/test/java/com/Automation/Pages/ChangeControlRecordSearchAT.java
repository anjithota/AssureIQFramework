package com.Automation.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.TimeUtil;


public class ChangeControlRecordSearchAT extends ActionEngine {
	
	@FindBy(xpath = "//a[@class='caliber-product-qams product-icon1']")
	WebElement assureIQ;

	@FindBy(xpath = "//ul[@id='MenuModule_QAMS']/child::li/child::a")
	List<WebElement> listOfAssureIQ;

	@FindBy(xpath = "//a[contains(text(), 'Process Manager')]")
	WebElement processManager;

	@FindBy(xpath = "//a[contains(text(), 'Change Control Login')]")
	WebElement loginChangeControl;

	@FindBy(id = "QAMS_PRSMGR_ISU_LGN_CC_FRM_ID_01_AUDMEN")
	WebElement ccAuditTrail;

	@FindBy(id = "pageTitle")
	WebElement pageTitle;

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

	public void ccRecordSearch() {

		// Switch to default Page
		switchToDefaultContent(driver);

		// Wait for 1sec
		waitForPageToLoad(1000);

		// Clicking on AssureIQ Icon
		click(assureIQ, "AssureIQIcon");
//				System.out.println("\n" + "-----------------------------------");
//				System.out.println("AssureIQ Menu");
		TimeUtil.shortWait();

		System.out.println("\n" + "-----------------------------------");

		// Get the Size of AssureIQ Icon
		getSize(listOfAssureIQ);
		System.out.println("\n" + "List of AssureIQ are:- " + getSize(listOfAssureIQ));

		// Printing AssureIQ Menu List in console
		//System.out.println("\n" + "AssureIQ Menu List are:-" + getTextList(listOfAssureIQ));

		// Clicking on Process Manager
		highLightElement(driver, processManager, test);
		jsClick(processManager, "ProcessManager");
//				System.out.println("Process Manager Menu");
		TimeUtil.shortWait();

		// Clicking on Change Control Login
		highLightElement(driver, loginChangeControl, test);
		jsClick(loginChangeControl, "ChangeControlLogin");
//				System.out.println("Change Control Login Menu");
		TimeUtil.shortWait();

		// Clicking on Change Control Login Audit Trail
		highLightElement(driver, ccAuditTrail, test);
		jsClick(ccAuditTrail, "ChangeControlAuditTrail");
		TimeUtil.shortWait();

		// Switch to Frame
		switchToBodyFrame(driver);

		// Title of Page
//				getText(pageTitle, "PageTitle");
		System.out.println("Title of the Page:- " + getText(pageTitle, "Page Title"));

		// To Display Columns Size and their Name
		System.out.println("\n" + "-----------------------------------");
		getSize(totalColumns);
		System.out.println("\n" + "List of Columns are:- " + getSize(totalColumns));
		//getTextList(totalColumns);

		// To Display Total Record
//				System.out.println("\n" + "-----------------------------------");
//				jsViewMoreClick(viewMore, "View More");
//				getSize(totalRows);
//				System.out.println("\n" + "Total Records are:- " + getSize(totalRows) + "\n");

		// Wait for 1sec
		waitForPageToLoad(1000);

		// Scroll to Advanced search and Click
		click(advancedSearch, "Advanced Search Button");

//				// Enter Issue Code
//				sendText(issueCode, IssueCode, "CCIssueCode");

		// Enter Issue Code
		clearField(issueCode, "issue code");
		enterUniqueCode(driver, issueCode);

		// Click Apply
		click(apply, "Apply Button");

		// click Issue Code based on search
		click(ICode, "ICode");
	}

}
