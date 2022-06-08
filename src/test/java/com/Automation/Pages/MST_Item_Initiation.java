package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class MST_Item_Initiation extends ActionEngine{
	
	@FindBy(xpath = "//div[@class='left-module ft-folder menu-icons active']")
	WebElement filemanager;
	
	//Item Registration module
	
	@FindBy(id="PRDM_01")
	WebElement Registration;
	
	@FindBy(id="btnSubmit_1")
	WebElement subbtn;
	
	@FindBy(id="MST_PRD_CTF_002_error")
	WebElement unicodeerror;
	
	@FindBy(id="MST_PRD_CTF_002")
	WebElement UniqueCode;
	
	@FindBy(id="MST_PRD_CTF_001_error")
	WebElement errorname;
	
	@FindBy(id="MST_PRD_CTF_001")
	WebElement itemName;
	
	@FindBy(id="MST_PRD_CTF_003_error")
	WebElement errorgenericname;
	
	@FindBy(id="MST_PRD_CTF_003")
	WebElement GenericName;
	
	@FindBy(id="MST_PRD_CTF_004_error")
	WebElement selectvlaue;
	
	@FindBy(xpath = "//span[@id='select2-MST_PRD_CTF_004-container']")
	WebElement MaterialType;
	
	@FindBy(id="select2-MST_PRD_CTF_004-result-tvyq-1")
	WebElement clickRawMeterial;
	
	@FindBy(id="btnSubmit")
	WebElement submitBtn;
	
	@FindBy(id="txtESignPassword")
	WebElement enterpassword;
	
	@FindBy(id="Submit_Esign")
	WebElement preceed;
	
	@FindBy(id="cfnMsg_Next")
	WebElement Donepopup;
	
	// Item Modification
	
	@FindBy(id="PRDM_02")
	WebElement clickmodification;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement itemmodificationname;
	
	@FindBy(id="MST_PRD_CTF_001")
	WebElement modifyname;
	
	
	@FindBy(id="txtRemarks")
	WebElement textarea;
	
	@FindBy(id="btnSubmit")
	WebElement clickBtn;
	
	@FindBy(id="txtESignPassword") 
	WebElement txtESignPassword;
	
	@FindBy(id="Submit_Esign")
	WebElement Submit_Esign;
	
	@FindBy(id="cfnMsg_Next")
	WebElement donepopupclose;
	
	// Item Status change
	
	@FindBy(id="PRDM_03")
	WebElement statuschange;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement unicodeclick;
	
	@FindBy(id="btnSubmit_1")
	WebElement submitclick;
	
	@FindBy(xpath = "//span[text()='Select Value']")
	WebElement selectvalue;
	
	@FindBy(xpath = "//label[@for='NewStatus_5']")
	WebElement inactive;
	
	@FindBy(id="txtRemarks")
	WebElement RemarksReason;
	
	@FindBy(id="btnSubmit")
	WebElement clicksubmitBTN;
	
	@FindBy(id="txtESignPassword")
	WebElement password;
	
	@FindBy(id="Submit_Esign")
	WebElement clickpreceed;
	
	@FindBy(id="cfnMsg_Next")
	WebElement closepopup;
	
	//audit trails
	
	@FindBy(id="PRDM_04")
	WebElement clickadit;
	
	@FindBy(xpath = "//span[@title='name1']")
	WebElement clickname;
	
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeacoss;
	
	
	
	
	public void item_Registration(String Icode , String Iname,String Igenericname)
	{
		click(Registration, "item Registration");
		switchToBodyFrame(driver);
		
		verifyCaptionContains(unicodeerror, "Enter Value");
		sendText(UniqueCode, Icode, "Department Code");
		click(subbtn, "Submit");
		
		
		verifyCaptionContains(errorname, "Enter Value");
		sendText(itemName, Iname, "Department Code");
		click(subbtn, "Submit");
		
		verifyCaptionContains(selectvlaue, "Select Value");
				
		
		verifyCaptionContains(errorgenericname, "Enter Value");
		sendText(GenericName, Igenericname, "Department Code");
		click(subbtn, "Submit");
		
		
		click(MaterialType, "material type");
		click(clickRawMeterial, "raw material");
		click(submitBtn, "submitBtn");		
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		click(Donepopup, "pouup done");
		switchToDefaultContent(driver);
	}
	
	public void itemmodification(String Imodify , String Remarksreason,String password)
	{
		click(clickmodification, "item modification");
		switchToBodyFrame(driver);
		click(itemmodificationname, "modification name");
		click(modifyname, "modify name");
		//sendText(modifyname, Imodify, tempPwd);
		modifyname.clear();
		sendText(modifyname, Imodify, "modification test");
		sendText(textarea, Remarksreason, "remarks reason");
		click(clickBtn, "click button");
		sendText(txtESignPassword, password, "enter password");
		click(Submit_Esign, "submit esign");		
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		click(donepopupclose, "close popup");
		switchToDefaultContent(driver);
		
	}
	
	public void item_statuschange(String reasons) {
		click(statuschange, "status change");
		switchToBodyFrame(driver);
		click(unicodeclick, "click unicode");
		click(submitclick, "click submit");
		
		verifyCaptionContains(selectvalue, "select Value");		
		click(inactive, "in active user");
		sendText(RemarksReason, reasons, "reamarksreason");
		click(clicksubmitBTN, "click submit button");
		click(password, "password");
		click(clickpreceed, " click preceed");		
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		click(closepopup, "close pop up");
		switchToDefaultContent(driver);
		

  }
	
	public void item_audit()
	{
		click(clickadit, "click audit");
		switchToBodyFrame(driver);
		click(clickname, "click name");		
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		click(closepopup, "close window");
		switchToDefaultContent(driver);
		
	}
}
