package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class ChangeControlMyTaskSearch extends ActionEngine {

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

	@FindBy(xpath = "//span[contains(@title, 'PROV')]")
	WebElement ICode;

	public void myTaskChangeControlSearch() {

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
		verifyCaptionContains(pageTitleCC, "Change Control Login My Task");

		// Click Advanced Search
		click(advSearchBtn, "Advanced Search");

		// Enter Unique Code
		enterUniqueCode(driver, issueCode);

		// Click Apply Button
		click(applyBtn, "Apply Button");

		// Click Issue Code
		click(ICode, "ICode");
	}

}
