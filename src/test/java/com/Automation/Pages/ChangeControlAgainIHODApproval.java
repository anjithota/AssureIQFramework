package  com.Automation.Pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class ChangeControlAgainIHODApproval extends ActionEngine {

	@FindBy(xpath = "//span[text()='Change Control Login']")
	WebElement ccLgn;

	@FindBy(id = "pageTitle")
	WebElement pageTitleCC;

	@FindBy(id = "btnAdvSearch")
	WebElement advSearchBtn;

	@FindBy(xpath = "//input[@placeholder='Issue Code']")
	WebElement issueCode;

	@FindBy(id = "btnSubmitListFilter")
	WebElement applyBtn;

	@FindBy(className="text-ellipsis")
	WebElement ICode;

	@FindBy(xpath = "//label[text()='Review']")
	WebElement decisionReview;

	@FindBy(id = "ISU_LGN_CTR_025")
	WebElement IHODCmts;

	@FindBy(id = "select2-ISU_LGN_CTR_191-container")
	WebElement assumedCtgDD;

	@FindBy(xpath = "//li[contains(text(),'Major')]")
	WebElement MajorCtg;

	@FindBy(id = "txtRemarks")
	WebElement remarkReason;

	@FindBy(id = "btnSubmit")
	WebElement submitBtn;
	
	@FindBy(xpath = "(//div[contains(@class, 'confirmation-message-text')])[2]")
	WebElement cngMsg;

	@FindBy(id = "cfnMsg_Next")
	WebElement done;

	public void ccAgnIHODApproval(String IHODComments, String RemRsn) {

		// Wait for 1Sec
		waitForPageToLoad(1000);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Scroll to Change Control
		scrollToViewElement(ccLgn);

		// Click Change Control
		click(ccLgn, "Change Control Login");

		// Switch to default Page
		switchToDefaultContent(driver);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Verify Captions
		verifyCaptionContains(pageTitleCC, "Change Control Login");

		// Click Advanced Search
		click(advSearchBtn, "Advanced Search");

		// Enter Unique Code
		clearField(issueCode, "Issue code");
		enterUniqueCode(driver, issueCode);

		// Click Apply Button
		click(applyBtn, "Apply Button");

		// Click Issue Code
		click(ICode, "ICode");

		// Switch to default Page
		switchToDefaultContent(driver);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Enter IHOD Comments
		sendText(IHODCmts, IHODComments, "IHOD Commets");

		//Select Major Category
		assumedCtgy();

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Enter Remarks/Reasons
		sendText(remarkReason, RemRsn, "Remarks/Reasons");

		// Click IHOD Submit button
		click(submitBtn, "IHOD Submit Button");

		// ESign should display
		/*e_SignAvailabe();

		// Entering E_Sign Password
		EsignCnfrm(ConfigsReader.getPropValue("CCLgnIHODPwd"), cngMsg, "Change Control Login Registration Approval",
				done);*/
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
	}
	
	public void assumedCtgy() {
		
		click(assumedCtgDD, "Assumed Category Drop Down");
		click(MajorCtg, "Major");
	}
	
	public void ccAgnIHODApproval_SP(String IHODComments, String RemRsn) {

		// Wait for 1Sec
		waitForPageToLoad(1000);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Scroll to Change Control
		scrollToViewElement(ccLgn);

		// Click Change Control
		click(ccLgn, "Change Control Login");

		// Switch to default Page
		switchToDefaultContent(driver);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Verify Captions
		verifyCaptionContains(pageTitleCC, "Change Control Login");

		// Click Advanced Search
		click(advSearchBtn, "Advanced Search");

		// Enter Unique Code
		clearField(issueCode, "Issue code");
		enterUniqueCode(driver, issueCode);

		// Click Apply Button
		click(applyBtn, "Apply Button");

		// Click Issue Code
		click(ICode, "ICode");

		// Switch to default Page
		switchToDefaultContent(driver);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Enter IHOD Comments
		sendText(IHODCmts, IHODComments, "IHOD Commets");

		//Select Major Category
		assumedCtgy();

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Enter Remarks/Reasons
		sendText(remarkReason, RemRsn, "Remarks/Reasons");

		// Click IHOD Submit button
		click(submitBtn, "IHOD Submit Button");

		// ESign should display
		/*e_SignAvailabe();

		// Entering E_Sign Password
		EsignCnfrm(ConfigsReader.getPropValue("CCLgnIHODPwd"), cngMsg, "Change Control Login Registration Approval",
				done);*/
		E_sign.e_Sign(ConfigsReader.getPropValue(""));
	}
	
	
}
