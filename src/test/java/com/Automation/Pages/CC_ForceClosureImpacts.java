package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.TimeUtil;

public class CC_ForceClosureImpacts extends ActionEngine {
	@FindBy(xpath = "//a[@href='http://10.10.3.33//QAMS510BL_OQ/BasePages/ListReport?TT=21&Fid=77794']//span")
	WebElement OtherDepartmentComments;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssuecodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(xpath = "//td[text()='No data available in table']")
	WebElement NodataElement;

	public void cc_OTD_Frc() {
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);

		scrollToViewElement(OtherDepartmentComments);
		click(OtherDepartmentComments, "CC OTD Menu");// CC-PL01-Admin-21-0010
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		// sendText(IssuecodeFilter, "CC-PL01-Admin-21-0013", "Isssue Code Filter");

		enterUniqueCode(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		TimeUtil.shortWait();
		verifyCaptionContains(NodataElement, "No data available in table");
		switchToDefaultContent(driver);

	}

}
