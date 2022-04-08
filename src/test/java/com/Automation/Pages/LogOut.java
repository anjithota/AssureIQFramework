package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class LogOut extends ActionEngine {

@FindBy(id = "Logout")
WebElement logoutBtn;

public void logOut() {
	switchToDefaultContent(driver);

click(logoutBtn, "LogOutBtn");
}



}
