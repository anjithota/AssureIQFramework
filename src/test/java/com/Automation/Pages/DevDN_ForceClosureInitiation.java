package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class DevDN_ForceClosureInitiation extends ActionEngine{
	@FindBy(id = "btnCreate")
	WebElement initiate;

	@FindBy(id = "btnProcessClosure")
	WebElement ForceClosure;

	@FindBy(xpath = "//label[@for='item_DN']")
	WebElement DocumentationTile;

	@FindBy(id = "btnSubmit")
	WebElement proceedButton;
	
	
	
	

}
