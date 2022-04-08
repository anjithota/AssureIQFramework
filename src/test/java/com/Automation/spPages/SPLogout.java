package com.Automation.spPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class SPLogout extends ActionEngine {
	@FindBy(id = "Logout")
	WebElement logoutBtn;

	public void logOut() {
		switchToDefaultContent(driver);

	click(logoutBtn, "LogOutBtn");
	switchtoWidowOne();
	}

}
