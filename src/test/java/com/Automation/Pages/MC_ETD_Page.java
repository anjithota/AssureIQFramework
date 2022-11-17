package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class MC_ETD_Page extends ActionEngine {
	@FindBy(id = "btnCreate")
	WebElement initiate;

	@FindBy(id = "btnEtd")
	WebElement ETDButton;

	@FindBy(id = "btnSubmit")
	WebElement proceedButton;

	@FindBy(xpath = "//div[text()='Market Complaints']")
	WebElement MarketComplaintsIcon;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	public void mcEtdInitiator() {
		switchToDefaultContent(driver);
		// switchToBodyFrame(driver);
		click(initiate, "InitiateButtton");

		click(ETDButton, "ProcessLogin");

		// Switch to Frame
		switchToPopupModelFrame(driver);

		click(MarketComplaintsIcon, "Market Complaints Icon");

		click(proceedButton, "Proceed button");

		switchToDefaultContent(driver);

		switchToBodyFrame(driver);

	}

}
