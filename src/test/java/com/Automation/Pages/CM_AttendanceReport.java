package com.Automation.Pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.TimeUtil;


public class CM_AttendanceReport extends ActionEngine {
	@FindBy(xpath = "//a[@class='caliber-product-tms product-icon1']")
	WebElement Menu;
	@FindBy(xpath = "//ul[@id='TMS_Course Manager']/preceding-sibling::a")
	WebElement CourseManagerMenu;
	@FindBy(xpath = "//ul[@id='TMS_Course Manager_Reports']/preceding-sibling::a")
	WebElement ReportMenu;
	@FindBy(id = "TMS_Course Manager_Reports_MEN11")
	WebElement AttendanceReport;
	@FindBy(xpath = "//input[@id='ReportViewerControl_ToggleParam_img']")
	WebElement Togglebtn;
	@FindBy(id = "ReportViewerControl_ctl04_ctl03_cbNull")
	WebElement Null;
	@FindBy(id = "ReportViewerControl_ctl04_ctl03_txtValue")
	WebElement BatchName;
	@FindBy(id = "ReportViewerControl_ctl04_ctl00")
	WebElement ViewReport;
	@FindBy(xpath = "//Input[@id='ReportViewerControl_ctl05_ctl03_ctl00']")
	WebElement Searchtxt;
	@FindBy(xpath = "//a[@id='ReportViewerControl_ctl05_ctl03_ctl01']")
	WebElement Findtxt;
	@FindBy(xpath = "//table[1]/tbody[1]/tr[3]/td[1]/div[1]/a[1]/div[1]/div[1]/div[1]/span[1]")
	WebElement DisplayedCourse;
	@FindBy(xpath = "//table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]")
	WebElement Coursesessionname;
	@FindBy(xpath = "//table[1]/tbody[1]/tr[5]/td[2]/div[1]/div[1]")
	WebElement Trainer;
	@FindBy(xpath = "//table[1]/tbody[1]/tr[6]/td[2]/div[1]/div[1]")
	WebElement Evaluator;
	@FindBy(xpath = "//table[1]/tbody[1]/tr[9]/td[2]/div[1]/div[1]")
	WebElement AttendanceRecordedBy;
	@FindBy(xpath = "//table[1]/tbody[1]/tr[6]/td[2]/div[1]/div[1]")
	WebElement EmployeeName;
	@FindBy(xpath = "//table[1]/tbody[1]/tr[6]/td[2]/div[1]/div[1]")
	WebElement EmployeeID;
	@FindBy(xpath = "//table[1]/tbody[1]/tr[6]/td[2]/div[1]/div[1]")
	WebElement Status;

	public CM_AttendanceReport() {
		PageFactory.initElements(driver, this);
	}

	public void AttendanceReport()

	{
		//String CourseNameval = CM_Course.getCourse();

		click(Menu, "Menu");
		click(CourseManagerMenu, "Course Manager Menu");
		click(ReportMenu, "Report Menu");
		click(AttendanceReport, "Attendance Report");
		switchToBodyFrame(driver);
		int size= driver. findElements(By. tagName("iframe")). size(); 
		System.out.println(size);
		/*click(Togglebtn, "Toggle btn");
		SelectRadioBtnAndCheckbox(driver, Null);
		sendText(BatchName, CourseNameval, "Search txtfield");
		click(ViewReport, "ViewReport btn");
		TimeUtil.mediumWait();
		click(DisplayedCourse, "Displayed Course");
		TimeUtil.shortWait();
		verifyCaptionContains(Coursesessionname, CourseNameval);
		verifyCaptionContains(Trainer, Trainername);
		verifyCaptionContains(Evaluator, evaluatorname);
		verifyCaptionContains(AttendanceRecordedBy, RecordedBy);
		verifyCaptionContains(EmployeeName, employename);
		verifyCaptionContains(Status, status);*/

	}

	public void AttendReport() throws AWTException

	{
		//String CourseNameval = CM_Course.getCourse();

		click(Menu, "Menu");
		click(CourseManagerMenu, "Course Manager Menu");
		click(ReportMenu, "Report Menu");
		click(AttendanceReport, "Attendance Report");
		pasteDataUsingRobot("lakshmirv");
		Robot robot;
		robot = new Robot();
		TimeUtil.shortWait();
		robot.keyPress(KeyEvent.VK_DOWN);
		TimeUtil.shortWait();
		robot.keyPress(KeyEvent.VK_TAB);
		pasteDataUsingRobot("Harika@999");
		TimeUtil.shortWait();
		robot.keyPress(KeyEvent.VK_DOWN);
		TimeUtil.shortWait();
		robot.keyPress(KeyEvent.VK_TAB);
		TimeUtil.shortWait();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		TimeUtil.longwait();
		switchToBodyFrame(driver);
		
		int size= driver. findElements(By. tagName("iframe")). size(); 
		System.out.println(size);
		//driver.switchTo().frame(0);
		driver.findElement(By.className("A7b9cee6cc7dc4b908c540ef50389a6bc51")).click();
		/*for (int i = 0; i < size; i++) {
			driver.switchTo().frame(i);
			WebElement frm=driver.findElement(By.className("A7b9cee6cc7dc4b908c540ef50389a6bc51"));
			if (frm.isDisplayed()) {
				System.out.println("f"+i);
				
			}9963242210
			else {
				driver.switchTo().defaultContent();
				System.out.println("not found"+i);
			}
		}*/
		//A7b9cee6cc7dc4b908c540ef50389a6bc51
		
		
		
//		WebElement element1;
//		element1 = driver.findElement(By.xpath("/html[1]/body[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/div[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/input[1]"));
////		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
////				element1);
////		element1.click();
//		TimeUtil.shortWait();
//
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("arguments[0].scrollIntoView()", element1);
//		jse.executeScript("arguments[0].click();", element1);
//		element1.click();

		// dr.switchTo().window(win2);
		// List<WebElement> allframes =
		// driver.findElements(By.tagName("iframe"));
		//

		// switchToBodyFrame(driver);
		// TimeUtil.shortWait();

		// driver.switchTo().frame(0);
		// WebElement icon =
		// driver.findElement(By.xpath("//input[@id='ReportViewerControl_ToggleParam_img']"));
		// Actions builder = new Actions(driver);
		// builder.moveToElement( icon ).click( icon);
		// builder.perform();
		// List<WebElement> Frames= driver.findElements(By.tagName("iframe"));
		// int n=Frames.size();
		// System.out.println(n);
		//
		// WebElement webElement =
		// driver.findElement(By.xpath("//body[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/div[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/input[1]"));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
		// webElement);
		// webElement.click();
		// js.executeScript("arguments[0].click();", webElement);
		// System.out.println("javascriptclick" + " " + webElement);
		//

		// System.out.println(driver.findElements(By.tagName("iframe")).size());
		// switchToBodyFrame(driver);
		//
		// System.out.println(driver.findElements(By.tagName("iframe")).size());
		// int frame=driver.findElements(By.tagName("iframe")).size();
		// for(int i=0;i<frame;i++)
		// {
		// try{
		// System.out.println(i);
		// driver.switchTo().frame(i);
		//
		// System.out.println("Inner
		// iframes:"+driver.findElements(By.tagName("iframe")).size());
		// driver.findElement(By.xpath("//table[@id='ReportViewerControl_fixedTable']/tbody/tr[3]/td[1]//input[@id='ReportViewerControl_ToggleParam_img']")).click();
		//
		//
		//
		// jsClick(Togglebtn, "Toggle btn");
		// }catch(Exception e){
		// }
		// }
	}
	// click(DisplayedCourse, "Displayed Course");
	//
	//
	// SelectRadioBtnAndCheckbox(driver, Null);
	// sendText(BatchName, CourseNameval, "Search txtfield");
	// click(ViewReport, "ViewReport btn");
	// TimeUtil.mediumWait();
	// click(DisplayedCourse, "Displayed Course");
	// TimeUtil.shortWait();

}

