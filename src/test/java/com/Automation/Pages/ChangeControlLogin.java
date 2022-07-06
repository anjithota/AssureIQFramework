package com.Automation.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class ChangeControlLogin extends ActionEngine {

	@FindBy(id = "btnCreate")
	WebElement initiate;

	@FindBy(xpath = "//div[@id='CreateBtnOptions']//a[@class='dropdown-item createitems']")
	List<WebElement> listInitiate;

	@FindBy(id = "btnProcessLogin")
	WebElement processLogin;

	@FindBy(xpath = "//div[@class='col-lg-3 col-md-4 col-sm-6 col-12 qstile']")
	List<WebElement> listOfProcess;

	@FindBy(xpath = "//label[@for='item_CC']")
	WebElement changeControl;

	@FindBy(id = "btnSubmit")
	WebElement proceedButton;

	public void changeControlLoginPage() {

		// Wait for 1sec
//		waitForPageToLoad(1000);

		// Clicking on Initiate Button
		click(initiate, "InitiateButtton");

		// Size of Initiate Menu
//		getSize(listInitiate);
		System.out.println("\n" + "List in Initiate Menu:- " + getSize(listInitiate));

		// To display Initiate Menu list in console
		// getTextList(listInitiate);

		// Clicking on Process Login
		click(processLogin, "ProcessLogin");

		// Switch to Frame
		switchToPopupModelFrame(driver);
		System.out.println("\n" + "-----------------------------------");

		// Size of Process Menu
//		getSize(listOfProcess);
		System.out.println("\n" + "Process List are:- " + getSize(listOfProcess));

		// To display Process List in console
		// getTextList(listOfProcess);

		// Clicking on Change Control Process
		click(changeControl, "ChangeControlProcess");

		// Clicking on Proceed Button
		click(proceedButton, "Proceed");
	}

	public void changeControlLoginPageSP() {

		// Wait for 1sec
//		waitForPageToLoad(1000);

		switchtoWidowTwo();
		// Clicking on Initiate Button
		click(initiate, "InitiateButtton");

		// Size of Initiate Menu
//		getSize(listInitiate);
		System.out.println("\n" + "List in Initiate Menu:- " + getSize(listInitiate));

		// To display Initiate Menu list in console
		// getTextList(listInitiate);

		// Clicking on Process Login
		click(processLogin, "ProcessLogin");

		// Switch to Frame
		switchToPopupModelFrame(driver);
		System.out.println("\n" + "-----------------------------------");

		// Size of Process Menu
//		getSize(listOfProcess);
		System.out.println("\n" + "Process List are:- " + getSize(listOfProcess));

		// To display Process List in console
		// getTextList(listOfProcess);

		// Clicking on Change Control Process
		click(changeControl, "ChangeControlProcess");

		// Clicking on Proceed Button
		click(proceedButton, "Proceed");
	}

}
