package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class CAPA_OTD_Page extends ActionEngine {
	@FindBy(id = "ISU_OTD_CTF_003_error")
	WebElement CommentsError;

	@FindBy(id = "ISU_OTD_CTF_003")
	WebElement Comments;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	public void capaOTDInitiation(String comments) {
		capaMyTaskMenuNavigations.capaOTDMytaskNavigation_SP();
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(CommentsError, "Enter Value");
		sendText(Comments, comments, "Comments");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		switchToDefaultContent(driver);

	}

}
