package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class Dev_DN_ForceClosure_Initiation extends ActionEngine{
	@FindBy(id="btnCreate")
	WebElement initiate;
	
	@FindBy(xpath = "//a[text()='Force Closure']")
	WebElement ForceclosureDN;
	
	@FindBy(xpath = "//label[@for='item_DN']")
	WebElement DocumentActionplan;
	
	@FindBy(xpath ="/button[@id='btnSubmit'")
	WebElement processbtn;
	
	@FindBy(xpath = "//span[@id='btnAdvSearch']")
	WebElement AdvancedSearch;
	
	@FindBy(xpath = "//button[@class='dateVCBtn']")
	WebElement calinderbtn;
	
	@FindBy(xpath = "//li[text()='Last 30 Days']")
	WebElement last30days;
	
	@FindBy(name = "DN_LGN_CTR_006")
	WebElement issusecode;
	
	@FindBy(xpath = "//button[@id='btnSubmitListFilter']")
	WebElement ApplyBtn;
	
	@FindBy(className = "text-ellipsis")
	WebElement clickrecord;
	
	@FindBy(xpath = "//button[@id='btnSubmit']")
	WebElement SubmitBtn;
	
	public void devDNForceClosureInitiation()
	{
		click(initiate, "initiate btn");
		click(ForceclosureDN, "clickbtn");
		switchToPopupModelFrame(driver);
		click(DocumentActionplan, "Documantation action plan");
		click(processbtn, "proced btn");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Search filter");
		click(last30days, "Days Click");
		//enterUniqueCode(driver,issusecode);
		enterUniqueCodeConcat(driver, issusecode);
		click(ApplyBtn, "Apply button");
		click(clickrecord, "Click Record");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		switchToDefaultContent(driver);
		
		
		
	}

}



