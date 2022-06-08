package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MST_Batch {
	@FindBy(xpath = "//div[@class='left-module ft-folder menu-icons active']")
	WebElement MasterMenu;
	
	@FindBy(id = "BATM_01")
	WebElement BatchRegistration;
	
	@FindBy(xpath = "//label[@for='MST_BAT_CTF_004_1]")
	WebElement BatchButton;
	
	@FindBy(xpath = "//label[@for='MST_BAT_CTF_004_2]")
	WebElement LotButton;
	
	@FindBy(id = "MST_BAT_CTF_004_error")
	WebElement TypeError;
	
	@FindBy(id = "MST_BAT_CTF_005")
	WebElement BatchLotID;
	
	@FindBy(id = "MST_BAT_CTF_005_error")
	WebElement BatchLotIDError;
	
	@FindBy(id = "MST_BAT_CTF_001")
	WebElement ProductButton;
	
	@FindBy(id = "MST_BAT_CTF_001_error")
	WebElement ProductError;
	
	@FindBy(id ="btnOk")
	WebElement ProductOkButton;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearchButton;
	
	@FindBy(name)
	
	
	
	

}
