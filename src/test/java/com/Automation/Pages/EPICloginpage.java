/*package com.Automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.TimeUtil;

public class EPICloginpage extends ActionEngine{
	
	@FindBy(id = "company")
	WebElement companyTxtBx;

	@FindBy(id = "username")
	WebElement userNameTxtBx;

	@FindBy(id = "password")
	WebElement passwordTxtBx;
	
	@FindBy(id = "txtUserIdVis")
	WebElement SSOuserNameTxtBx;

	@FindBy(id = "txtPasswordVis")
	WebElement SSOpasswordTxtBx;
	
	@FindBy(id = "LoginBtn")
	WebElement SSOloginBtn;

	@FindBy(id = "btnSubmit")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='plant-name']//div[1]//i[1]")
	WebElement Plant1;
	
	@FindBy(xpath = "//span[@id='selectPlant_2']")
	WebElement Plant2;
	
	
	@FindBy(xpath = "//div[@class='plant-name']//div[2]//i[1]")
	WebElement Masterplant;
	
	@FindBy(xpath= "//li[@class='menuicon-NIC400  menu-icons product-icon']")
	WebElement Producticon;
	
	@FindBy(id = "TMS_Course Manager")
	WebElement CourseManagerMenu;
	
	@FindBy(id = "TMS_Course Manager_Initiate")
	WebElement InitiateMenu;
	
	@FindBy(xpath= "//li[@class='menuicon-NIC400  menu-icons product-icon']/ul[1]/li[2]/a[contains(text(),'Course Manager')]")
	WebElement CourseManager;
	
	@FindBy(xpath= "//li[@class='menuicon-NIC400  menu-icons product-icon']/ul[1]/li[2]/ul[1]/li[2]/a[1]")
	WebElement Initiate;
	
	@FindBy(xpath = "//a[@id='logoutBtn']")
	WebElement Signout;
	
	
	
	//This initElements method will create all WebElements
	public EPICloginpage() {
		PageFactory.initElements(driver, this);
		
	}
	public void loginToApplication(String company,String userNme, String pwd) {
		waitForPageToLoad(3000);
     	sendText(companyTxtBx, company, "company Txtfield");
		sendText(userNameTxtBx, userNme, "userName");
		click(passwordTxtBx, "passwordTxtBx");
		sendText(passwordTxtBx, pwd, "pwd");
		click(loginBtn, "Login Button");
		
//		try {
//			boolean multiLogin = driver.findElement(By.id("btnYes")).isDisplayed();
//			if (multiLogin == true) {
//				driver.findElement(By.id("btnYes")).click();
//			}
//				
//		} catch (NoSuchElementException e) {
//
//		}
		
	}
	public void loginToEPICOQApplication(String userNme, String pwd) {
		waitForPageToLoad(3000);
		sendText(userNameTxtBx, userNme, "userName");
		click(passwordTxtBx, "passwordTxtBx");
		sendText(passwordTxtBx, pwd, "pwd");
		click(loginBtn, "Login Button");
		
//		try {
//			boolean multiLogin = driver.findElement(By.id("btnYes")).isDisplayed();
//			if (multiLogin == true) {
//				driver.findElement(By.id("btnYes")).click();
//			}
//				
//		} catch (NoSuchElementException e) {
//
//		}
		
	}

	public void loginToSSOApplication(String company,String userNme, String pwd) {
		waitForPageToLoad(3000);
		sendText(companyTxtBx, company, "company Txtfield");
		sendText(SSOuserNameTxtBx, userNme, "userName");
		click(SSOpasswordTxtBx, "passwordTxtBx");
		sendText(SSOpasswordTxtBx, pwd, "pwd");
		click(SSOloginBtn, "Login Button");
		
		try {
			boolean multiLogin = driver.findElement(By.xpath("//button[@class='caliber-button-primary']")).isDisplayed();
			if (multiLogin == true) {
				driver.findElement(By.xpath("//button[@class='caliber-button-primary']")).click();
			}
				
		} catch (NoSuchElementException e) {

		}
		
	}
	public void loginToSSOOQApplication(String userNme, String pwd) {
		waitForPageToLoad(3000);
		
		sendText(SSOuserNameTxtBx, userNme, "userName");
		click(SSOpasswordTxtBx, "passwordTxtBx");
		sendText(SSOpasswordTxtBx, pwd, "pwd");
		click(SSOloginBtn, "Login Button");
		
		try {
			boolean multiLogin = driver.findElement(By.xpath("//button[@class='caliber-button-primary']")).isDisplayed();
			if (multiLogin == true) {
				driver.findElement(By.xpath("//button[@class='caliber-button-primary']")).click();
			}
				
		} catch (NoSuchElementException e) {

		}
		
	}
	public void loginToSSONewApplication(String company) {
		waitForPageToLoad(3000);
		String username = IM_UserRegistration.getName();
		sendText(companyTxtBx, company, "company Txtfield");
		sendText(SSOuserNameTxtBx, username, "userName");
		System.out.println(username);
		click(SSOpasswordTxtBx, "passwordTxtBx");
		System.out.println(ActionEngine.tempPwd);
		enterTempPwd(driver, SSOpasswordTxtBx);
		click(SSOloginBtn, "Login Button");
		
//		try {
//			boolean multiLogin = driver.findElement(By.xpath("//button[@class='caliber-button-primary']")).isDisplayed();
//			if (multiLogin == true) {
//				driver.findElement(By.xpath("//button[@class='caliber-button-primary']")).click();
//			}
//				
//		} catch (NoSuchElementException e) {
//
//		}
		
	}
	public void loginToSSOOQNewUserApplication() {
		waitForPageToLoad(3000);
		String username = IM_UserRegistration.getName();
	
		sendText(SSOuserNameTxtBx, username, "userName");
		click(SSOpasswordTxtBx, "passwordTxtBx");
		enterTempPwd(driver, SSOpasswordTxtBx);
		click(SSOloginBtn, "Login Button");
		
		try {
			boolean multiLogin = driver.findElement(By.xpath("//button[@class='caliber-button-primary']")).isDisplayed();
			if (multiLogin == true) {
				driver.findElement(By.xpath("//button[@class='caliber-button-primary']")).click();
			}
				
		} catch (NoSuchElementException e) {

		}
		
	}
	public void loginSSONewUserApplication(String company,String PWD) {
		waitForPageToLoad(3000);
		String username = IM_UserRegistration.getName();
		sendText(companyTxtBx, company, "company Txtfield");
		sendText(SSOuserNameTxtBx, username, "userName");
		click(SSOpasswordTxtBx, "passwordTxtBx");
		sendText(SSOpasswordTxtBx, PWD, "PWD Txt");
		click(SSOloginBtn, "Login Button");
		waitForPageToLoad(1000);
		jsClick(Signout, "Signout");
		
//		try {
//			boolean multiLogin = driver.findElement(By.xpath("//button[@class='caliber-button-primary']")).isDisplayed();
//			if (multiLogin == true) {
//				driver.findElement(By.xpath("//button[@class='caliber-button-primary']")).click();
//			}
//				
//		} catch (NoSuchElementException e) {
//
//		}
		
	}
		
	public void Plant1()
	{
	
		jsClick(Plant1, "Plant1 icon");
		
	}
	public void Plant2()
	{
	
		jsClick(Plant2, "Plant2 icon");
		
	}
	public void MasterPlant()
	{
		click(Masterplant, "Masterplant icon");
		
	}
		
	
	
	public void CourseManager()
	{
		click(Producticon, "Product icon");
		click(CourseManagerMenu, "CourseManager icon");
		click(InitiateMenu, "Initiate icon");	
	}
		
		
	
}

*/