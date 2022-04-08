package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class PlantSelection extends ActionEngine {
	@FindBy(id= "selectPlant_233")
	WebElement SSOPlant;
	
	public void plant1() {
		click(SSOPlant, "p1");
	}

}
