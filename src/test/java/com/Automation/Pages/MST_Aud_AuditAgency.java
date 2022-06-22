package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class MST_Aud_AuditAgency extends ActionEngine {
	Properties prop;
	public static String Uniquecode = "";

	public static String getUniqueCode() {
		return Uniquecode;
	}

	public static void setUniquecode(String uniquecode) {
		Uniquecode = uniquecode;
	}

	@FindBy(xpath = "//div[@class='left-menupanel']/div[5]")
	WebElement AuditManagementMenu;

	@FindBy(id = "AGNY_01")
	WebElement AuditAgencyRegistrationMenu;
	
	@FindBy(id = "AGNY_02")
	WebElement AuditAgencyModificationMenu;

	@FindBy(id = "AGNY_03")
	WebElement AuditAgencyStatusChangeMenu;
	
	@FindBy(id = "MST_AGN_CTR_001")
	WebElement AuditAgencyCode;

	@FindBy(id = "MST_AGN_CTR_001_error")
	WebElement AuditAgencyCodeError;

	@FindBy(id = "MST_AGN_CTR_002")
	WebElement AuditAgencyName;

	@FindBy(id = "MST_AGN_CTR_002_error")
	WebElement AuditAgencyNameError;

	@FindBy(id = "MST_AGN_CTR_003")
	WebElement AuditAgencyDetails;

	@FindBy(id = "MST_AGN_CTR_003_error")
	WebElement AuditAgencyDetailsError;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement AGNCodeValue;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearchButton;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;
	
	@FindBy(name = "MST_AGN_CTR_001")
	WebElement AuditAgencyCodeFilter;
	
	@FindBy(xpath = "//div[@id='StdRemarks_container']//div[2]//span")
	WebElement RemarksError;

	@FindBy(id = "txtRemarks")
	WebElement RemarksText;

	public void auditAgencyRegistrationInitiation(String aaCode, String aaName, String aaDetails) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
		}

		setUniquecode(Uniquecode = aaCode + s);

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(AuditManagementMenu, "Audit Management Menu");
		scrollToViewElement(AuditAgencyRegistrationMenu);
		click(AuditAgencyRegistrationMenu, "Audit Agency Registration menu");
		switchToBodyFrame(driver);
		click(SubmitButton, "Submit button");

		verifyCaptionContains(AuditAgencyCodeError, "Enter Value");
		sendText(AuditAgencyCode, Uniquecode, "Audit Agency Code");

		click(SubmitButton, "Submit button");

		verifyCaptionContains(AuditAgencyNameError, "Enter Value");

		sendText(AuditAgencyName, aaName, "Audit Agency Name");

		click(SubmitButton, "Submit button");

		verifyCaptionContains(AuditAgencyDetailsError, "Enter Value");

		sendText(AuditAgencyDetails, aaDetails, "Audit Agency details");
		click(SubmitButton, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, AGNCodeValue);
		switchToDefaultContent(driver);

	}
	
	public void auditAgencyModificationInitiation(String itemCode, String remarks) {
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(AuditManagementMenu, "Audit management Menu");
		scrollToViewElement(AuditAgencyModificationMenu);
		click(AuditAgencyModificationMenu, "VID Modification Menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search button");
		enterUniqueCode(driver, AuditAgencyCodeFilter);
		click(ApplyButton, "Apply button");
		
		
		
		click(SubmitButton, "Submit button");
		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks reasons");
		click(SubmitButton, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, AGNCodeValue);
		switchToDefaultContent(driver);
		
	}
	
	

}
