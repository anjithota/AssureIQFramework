package com.Automation.Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class EPIQLoginPage extends ActionEngine {

	@FindBy(id = "username")
	WebElement userIDTxtBx;

	@FindBy(id = "password")
	WebElement passwordTxtBx;
	
	@FindBy(id = "company")
	WebElement companyTxtBx;

	@FindBy(id = "btnSubmit")
	WebElement loginBtn;
	
	@FindBy(id = "btnYes")
	WebElement BtnYes;

	public void loginToEPICOQApplication(String userID, String pwd) {
		
		//Wait for 1sec
		waitForPageToLoad(1000);
		
		//sendText(companyTxtBx, company, "company");
		
		//Enter UserID
		sendText(userIDTxtBx, userID, "userName");
		
		//Enter Password
		sendText(passwordTxtBx, pwd, "pwd");
		
		//Click Login Button
		click(loginBtn, "btnSubmit");

		/*try {

			
				click(BtnYes, "Yes Button");
			}
		catch (Exception e) {
			e.printStackTrace();
		}*/
//		try {
//			
//			driver.findElement(By.id("btnYes")).click();
//			
//
//			} catch (NoSuchElementException e) {
//
//				e.printStackTrace();
//
//			}
	}
	
}
