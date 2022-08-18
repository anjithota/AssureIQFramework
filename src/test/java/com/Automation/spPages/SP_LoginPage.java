package com.Automation.spPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class SP_LoginPage extends ActionEngine {
	@FindBy(id = "btnSubmit")
	WebElement EnterButton;

	@FindBy(id = "username")
	WebElement userIDTxtBx;

	@FindBy(id = "password")
	WebElement passwordTxtBx;

	@FindBy(id = "btnSubmit")
	WebElement loginBtn;

	@FindBy(id = "btnYes")
	WebElement BtnYes;

	public void loginToSPApplication(String userID, String pwd) {
		waitForPageToLoad(1000);
		click(EnterButton, "Home Page Enter Button");
		switchtoWidowTwo();

		// Enter UserID
		sendText(userIDTxtBx, userID, "userName");

		// Enter Password
		sendText(passwordTxtBx, pwd, "pwd");

		// Click Login Button
		click(loginBtn, "btnSubmit");

		/*try {
			click(BtnYes, "Yes Button");
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		/*try {
			if(driver.findElement(By.xpath("//*[@id='btnYes']")).isDisplayed())
			{
			driver.findElement(By.xpath("//*[@id='btnYes']")).click();
			
			}
			}catch(Exception e){
			
			}*/
		
	}

	
	
	
	
	
}
