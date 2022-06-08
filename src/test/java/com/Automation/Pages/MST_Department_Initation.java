package com.Automation.Pages;

import org.apache.bcel.generic.IF_ACMPEQ;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class MST_Department_Initation extends ActionEngine {
	
    	
	@FindBy(xpath = "//div[@class='left-module ft-folder menu-icons active']")
	WebElement clickMasterfolder;
	
	//Registration module
	
	@FindBy(xpath = "//a[@id='DEPT_01']")
	WebElement  clickRegistration;
	
	@FindBy(id="btnSubmit_1") 
    WebElement SubmitBtn;
	
	@FindBy(id="MST_DEP_CTF_002_error")
	WebElement DepartmentCode_errormsg;
	
	@FindBy(id="MST_DEP_CTF_002")
	WebElement DepartmentCode;
	
	
	
	@FindBy(id="MST_DEP_CTF_001_error")
	WebElement DepartmentName_errorname;
	
	@FindBy(id="MST_DEP_CTF_001")
	WebElement DepartmentName;
	
	
	
	@FindBy(id="MST_DEP_CTF_003_error")
	WebElement DepartmentDescription_errordesc;
	
	@FindBy(id="MST_DEP_CTF_003")
	WebElement Description;
	
	@FindBy(xpath = "//button[@id='btnSubmit']")
	WebElement Submitbtn;
	
	@FindBy(id="txtESignPassword")
	WebElement E_signbtn;
	
	@FindBy(id="Submit_Esign")
	WebElement preceedbtn;
	
	@FindBy(id="cfnMsg_Next")
	WebElement donepopup;
	
	//Status Change
	
	@FindBy(xpath = "//div[@class='left-module ft-folder menu-icons active']")
	WebElement clickstatuschange;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement GlobalSupport;
	
	@FindBy(id="btnSubmit_1")
	WebElement subBtn;
	
	@FindBy(xpath = "//span[text()='Select Value']")
	WebElement errormassage;
	
	@FindBy(xpath = "//label[@for='NewStatus_5']")
	WebElement activeuser;
	
	@FindBy(xpath = "//textarea[@id='txtRemarks']")
	WebElement RemarksReasons;
	
	@FindBy(xpath = "//button[@id='btnSubmit']")
	WebElement statussubmit;
	
	@FindBy(xpath = "txtESignPassword")
	WebElement enterpassword;
	
	@FindBy(xpath = "//button[@id='Submit_Esign']")
	WebElement clickProceed;
	
	@FindBy(id="cfnMsg_Next")
	WebElement donepop_up;
	
	//Audit trails
	
	@FindBy(xpath = "//div[@class='left-module ft-folder menu-icons active']")
	WebElement clickaudittrails;
	
	
	@FindBy(xpath = "//a[@id='DEPT_04']")
	WebElement audittrails;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement departmentCode;
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement crosspopup;
	
		
	
	
	public void deparment(String Dcode ,String Dname,String Desc)
	{
		switchToBodyFrame(driver);
	click(clickMasterfolder, "click manager folder");
	click(clickRegistration, "Registration");
	
	verifyCaptionContains(DepartmentCode_errormsg, "Enter Value");
	sendText(DepartmentCode, Dcode, "Department Code");
	click(SubmitBtn, "Submit");
	
	verifyCaptionContains(DepartmentName_errorname, "Enter Value");
	sendText(DepartmentName, Dcode, "Department Name");
	click(SubmitBtn, "Submit");
	
	
	verifyCaptionContains(DepartmentDescription_errordesc, "Enter Value");
	sendText(Description, Dcode, "Department Descrption");
	click(SubmitBtn, "Submit");
	
	click(Submitbtn, "submit");
		
	E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
	click(preceedbtn, "Submit");
	click(donepopup, "pop up close");
	switchToDefaultContent(driver);
		
	}
	
	public void status_change(String sample)
	{
		click(clickMasterfolder, "click status chnage");
		click(clickstatuschange, "status change");
		switchToBodyFrame(driver);
		click(GlobalSupport, "department name");
		click(subBtn, "submitbtn");
		verifyCaptionContains(errormassage, "Enter Value");
		
		click(activeuser, "user active");
		sendText(RemarksReasons, sample, "remarks reasons");
		click(statussubmit, "submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		click(clickProceed, "proceed button");
		click(donepop_up, "popup close"); 
		switchToDefaultContent(driver);
		
		
	}
	
	public void Aundittrails()
	{
		click(clickMasterfolder, "click audit trails");
		click(audittrails, "Audit trails");
		switchToBodyFrame(driver);
		click(DepartmentCode, "department code");
		click(crosspopup, "close window");
		switchToDefaultContent(driver);
		
		
	}
	
	
}
