package com.Automation.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Automation.Base.ActionEngine;


public class LoginPage extends ActionEngine{

	@FindBy(id = "username")
	WebElement userNameTxtBx;

	@FindBy(id = "password")
	WebElement passwordTxtBx;

	@FindBy(id = "btnSubmit")
	WebElement loginBtn;
	
	@FindBy(id = "Logout")
	WebElement logoutbttn;
public LoginPage() { 
		PageFactory.initElements(driver, this);
		
	}
	public void loginToApplication(String userNme, String pwd) {
		waitForPageToLoad(3000);
		sendText(userNameTxtBx, userNme, "userName");
		click(passwordTxtBx, "passwordTxtBx");
		sendText(passwordTxtBx, pwd, "pwd");
		click(loginBtn, "Login Button");
		waitForPageToLoad(3000);
		

	}	

	public  void logoutbutton() {
		
		click(logoutbttn, "logoutbttn");
		
		
	}
}
