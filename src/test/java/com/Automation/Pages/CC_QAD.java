package com.Automation.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.ESign;
import com.Automation.Utils.TimeUtil;

public class CC_QAD extends ActionEngine {
	
	@FindBy (xpath="//a[@href='http://10.10.3.33//QAMS510BL_OQ/BasePages/ListReport?TT=21&Fid=77799']//span")
	WebElement QAD_Menu;
	
	@FindBy(id="btnAdvSearch")
	WebElement AdvanceSearchButton;
	
	@FindBy(name="ISU_LGN_CTR_001")
	WebElement IssuecodeFilter;
	
	@FindBy(id="btnSubmitListFilter")
	WebElement ApplyButton;
	
	@FindBy(className="text-ellipsis")
	WebElement Record;
	
	@FindBy(id="btnSubmit_1")
	WebElement SubmitButton;
	
	@FindBy(id="ISU_QAD_CTF_003_error")
	WebElement CommentsError;
	
	@FindBy(id="ISU_QAD_CTF_003")
	WebElement ReviewComments;
	
	@FindBy(id="ISU_QAD_CTF_034_error")
	WebElement ReCategoryRequiredError;
	
	@FindBy(xpath="//label[@for='ISU_QAD_CTF_034_1']")
	WebElement CategoryRequired;
	
	@FindBy(id="ISU_QAD_CTF_004")
	WebElement Recotegory;
	
	@FindBy(id="ISU_QAD_CTF_004_error")
	WebElement RecotegoryError;
	
	@FindBy(id="ISU_QAD_CTF_006_error")
	WebElement ActionplanrequiredError;
	
	@FindBy(xpath="//label[@for='ISU_QAD_CTF_006_2']")
	WebElement ActionplanrequiredNo;
	
	@FindBy(id="ISU_QAD_CTF_008_error")
	WebElement DecisionOnCCError;
	
	@FindBy(xpath="//label[@for='ISU_QAD_CTF_008_1']")
	WebElement DecisionOnCC;
	
	@FindBy(xpath="//label[@for='ISU_QAD_CTF_008_2']")
	WebElement DecisionOnCCReject;
	
	@FindBy(id="btnSelectiveReturn")
	WebElement SelectiveReturnButton;
	
	@FindBy(xpath="//input[@class='caliber-labeled-option StageRadioButton']/following :: label[contains(text(),'Stage 2')]")
	WebElement StageTwoCheckbox;
	
	@FindBy(className="toast-message")
	WebElement AlertMessage;
	
	@FindBy(className="toast-close-button")
	WebElement AlertClose;
	
	@FindBy(xpath="//span[@class='confirmation_text']")
	WebElement RetUcode;
	
	@FindBy(id="ISU_QAD_CTF_009")
	WebElement RejectRemarks;
	
	
	
	public void ccQAD(String reviewComments, String Category) throws InterruptedException, AWTException {
		switchToBodyFrame(driver);
		scrollToViewElement(QAD_Menu);
		click(QAD_Menu, "QAD menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		//sendText(IssuecodeFilter, "CC-PL01-Admin-21-0014", "Isssue Code Filter");
		
		
		enterUniqueCode(driver, IssuecodeFilter);
		
		click(ApplyButton, "Apply Button");;
		click(Record, "Workitem");
		
		
		click(SubmitButton, "Submit");
		verifyCaptionContains(CommentsError, "Enter Value");
		sendText(ReviewComments, reviewComments, "Review Comments");
		click(SubmitButton, "Submit");
		
		verifyCaptionContains(ReCategoryRequiredError, "Select Value");
		
		click(CategoryRequired, "Yes");
		
		click(SubmitButton, "Submit");
		
		verifyCaptionContains(RecotegoryError, "Select Value");
		
		
		
		selectDropdownUsingVisisbleText(Recotegory, Category, "Category");
		
		click(SubmitButton, "Submit");
		
		verifyCaptionContains(ActionplanrequiredError, "Select Value");
		
		click(ActionplanrequiredNo, "Action plan No");
		
		click(SubmitButton, "Submit");
		
		verifyCaptionContains(DecisionOnCCError, "Select Value");
		
		click(DecisionOnCC, "Decisoin Approved");
		
		TimeUtil.shortWait();
		driver.findElement(By.id("btnSubmit_1")).click();
		Alert alert= driver.switchTo().alert();  
		alert.accept();
		
//		click(SubmitButton, "Submit");
		
		/*driver.findElement(By.id("PopUp")).click(); // Clicking on the popup button
		Robot robot = new Robot();
		robot.mouseMove(400, 5); // Navigating through mouse hover. Note that the coordinates might differ, kindly check the coordinates of x and y axis and update it accordingly.
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);*/
		
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_D);
//		robot.keyRelease(KeyEvent.VK_D);
		


		
		/*Alert alert= driver.switchTo().alert();  
		alert.accept();*/
		
		/*TimeUtil.shortWait();
		driver.switchTo().alert().accept();
		//TimeUtil.shortWait();
		//click(SubmitButton, "Submit");
		//isAlertPresent(driver);*/
		//alertAccept(driver);
		
		
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);
		
		
		//ver(ReCategoryRequiredError, "RE category required");
	}
	
	public void ccQADReject(String reviewComments, String Category, String Remarks) throws InterruptedException, AWTException {
		switchToBodyFrame(driver);
		scrollToViewElement(QAD_Menu);
		click(QAD_Menu, "QAD menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		//sendText(IssuecodeFilter, "CC-PL01-Admin-21-0014", "Issue Code Filter");
		
		
		enterUniqueCode(driver, IssuecodeFilter);
		
		click(ApplyButton, "Apply Button");;
		click(Record, "Workitem");
		
		
		click(SubmitButton, "Submit");
		verifyCaptionContains(CommentsError, "Enter Value");
		sendText(ReviewComments, reviewComments, "Review Comments");
		click(SubmitButton, "Submit");
		
		verifyCaptionContains(ReCategoryRequiredError, "Select Value");
		
		click(CategoryRequired, "Yes");
		
		click(SubmitButton, "Submit");
		
		verifyCaptionContains(RecotegoryError, "Select Value");
		
		
		
		selectDropdownUsingVisisbleText(Recotegory, Category, "Category");
		
		click(SubmitButton, "Submit");
		
		verifyCaptionContains(ActionplanrequiredError, "Select Value");
		
		click(ActionplanrequiredNo, "Action plan No");
		
		click(SubmitButton, "Submit");
		
		verifyCaptionContains(DecisionOnCCError, "Select Value");
		
		click(DecisionOnCCReject, "Decisoin Approved");
		
		  
		
		
		sendText(RejectRemarks, Remarks, "Rejected Remarks");
		
		
		
		TimeUtil.shortWait();
		driver.findElement(By.id("btnSubmit_1")).click();
		Alert alert= driver.switchTo().alert();  
		alert.accept();
		
//		click(SubmitButton, "Submit");
		
		/*driver.findElement(By.id("PopUp")).click(); // Clicking on the popup button
		Robot robot = new Robot();
		robot.mouseMove(400, 5); // Navigating through mouse hover. Note that the coordinates might differ, kindly check the coordinates of x and y axis and update it accordingly.
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);*/
		
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_D);
//		robot.keyRelease(KeyEvent.VK_D);
		


		
		/*Alert alert= driver.switchTo().alert();  
		alert.accept();*/
		
		/*TimeUtil.shortWait();
		driver.switchTo().alert().accept();
		//TimeUtil.shortWait();
		//click(SubmitButton, "Submit");
		//isAlertPresent(driver);*/
		//alertAccept(driver);
		
		
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);
		
		
		//ver(ReCategoryRequiredError, "RE category required");
	}

	
	public void ccQADSelectiveReturn() {
		switchToBodyFrame(driver);
		
		scrollToViewElement(QAD_Menu);
		click(QAD_Menu, "CC QAD Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		enterUniqueCode(driver, IssuecodeFilter);
		
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		
		click(SelectiveReturnButton, "Selective Return");
		switchToPopupModelFrame(driver);
		
		click(SubmitButton, "Submit");
		
		verifyCaptionContains(AlertMessage, "Select At least one stage to Return");
		
		click(AlertClose, "Alert close");
		
		click(StageTwoCheckbox, "IHod Stage");
		
		click(SubmitButton, "Submit button");
		
		E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnIHODPwd"));
		saveAlterUniqueCode(driver, RetUcode);
		
		switchToDefaultContent(driver);
	}

}
