package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class MST_WeekendHoliday extends ActionEngine {
	
	@FindBy(xpath = "//div[@class='left-menupanel']/div[2]")
	WebElement MasterMenu;
	
	@FindBy(id = "CAL1_02")
	WebElement weekendModificationMenu;
	
	public void WeekendModificationScreen() {
		
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		
	}

}
