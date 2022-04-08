package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class CM_Topic extends ActionEngine {
	Properties prop;
	public static String Topic = "";
	public static String Uniquecode = "";
	public static String Description = "";

	public static String getTopic() {
		return Topic;
	}

	public static void setTopic(String topic) {
		Topic = topic;
	}

	public static String getUniqueCode() {
		return Uniquecode;
	}

	public static void setUniquecode(String uniquecode) {
		Uniquecode = uniquecode;
	}

	@FindBy(xpath = "//a[@class='caliber-product-tms product-icon1']")
	WebElement Menu;
	@FindBy(xpath= "//ul[1]/li[2]/a[contains(text(),'Course Manager')]")
	WebElement CourseManagerMenu;
	@FindBy(xpath= "//ul[@id='TMS_Course Manager']/li[9]/a[1]")
	WebElement ConfigMenu;
	@FindBy(id = "TMS_Course Manager_Configure_MEN134")
	WebElement ConfigTopicMenu;
	@FindBy(xpath = "//ul[@id='TMS_Course Manager']/li[2]//a[contains(@class,'sub-menu')][contains(text(),'Initiate')]")
	WebElement InitiateMenu;
	@FindBy(id = "TMS_Course Manager_Initiate_MEN134")
	WebElement TopicMenu;
	@FindBy(id = "CMTopic_TopicDesc")
	WebElement Topicname;
	@FindBy(id = "CMTopic_UserCode")
	WebElement TopicuniqueCode;
	@FindBy(id = "CMTopic_Description")
	WebElement description;
	@FindBy(xpath = "//div[@class='conrol-column col-sm-12 p-2 border rounded']/input[2]")
	WebElement DocumentNameRadiobttn;
	@FindBy(id = "CMTopic_TreeVC_SearchTxt")
	WebElement DocumentSearchTextBox;
	@FindBy(xpath = "//a[@class='anchorTxt']")
	WebElement FetchRecordsHyperlink;
	@FindBy(xpath = "//input[contains(text(),'Recent 10 Documents')]")
	WebElement Top10RecordsHyperlink;
	@FindBy(xpath = "//input[contains(text(),'Reset')]")
	WebElement ResetHyperlink;
	@FindBy(xpath = "//div[@id='CMTopic_AvailableDocs']/ul[@id='CMTopic_AvailableDocs_ul']/li[1]")
	WebElement GreenTickMark;
	@FindBy(id = "btnSubmit")
	WebElement Submitbttn;
	@FindBy(id = "txtESignPassword")
	WebElement Esign;
	@FindBy(xpath = "//span[contains(@class,'confirmation_text')]")
	WebElement ConfirmMsg;
	@FindBy(id = "Submit_Esign")
	WebElement EsignProceed;
	@FindBy(id = "cfnMsg_Next")
	WebElement NextButton;
	@FindBy(xpath = "//li[contains(@class,'nav-item open')]//a[contains(@class,'nav-link nav-toggle')][contains(text(),'Audit Trails')]")
	WebElement AuditTrails;
	@FindBy(id = "TPCAT")
	WebElement AduitTopic;
	@FindBy(id = "btnAdvSearch")
	WebElement SearchFilter;
	@FindBy(id = "select2-SearchType-container")
	WebElement SearchByNew;
	@FindBy(xpath = "//span[@class='select2-results']/ul[1]/li[contains(text(),'Unique Code')]")
	WebElement SearchByNewDropdown;
	@FindBy(xpath = "//table[@id='ListTab']/tbody/tr[1]/td[1]")
	WebElement DisplayedRecord;
	@FindBy(xpath = "//input[@id='UniqueCode']")
	WebElement Aud_UniqueCodeField;
	@FindBy(id = "displayBtn")
	WebElement Display;
	@FindBy(xpath = "//div[@id='CompareTRN']//div[2]/div[1]//div[3]/div[1]/div[1]/div[1]/span[1]")
	WebElement ATTopicName;
	@FindBy(xpath = "//div[@id='CompareTRN']//div[2]/div[1]//div[4]/div[1]/div[1]/div[1]/span[1]")
	WebElement ATSUniquecode;
	@FindBy(xpath = "//div[@id='CompareTRN']//div[2]/div[1]//div[5]/div[1]/div[1]/div[1]/span[1]")
	WebElement ATUniquecode;
	@FindBy(xpath = "//div[@id='CompareTRN']//div[2]/div[1]//div[6]/div[1]/div[1]/div[1]/span[1]")
	WebElement ATDescription;
	@FindBy(xpath = "//div[@id='CompareTRN']//div[2]/div[1]/div[7]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement ATDocument;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[1]/td[1]")
	WebElement ActionValue;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[1]/td[2]")
	WebElement ActionByValue;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[1]/td[3]")
	WebElement DateTimeValue;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[1]/td[4]")
	WebElement RemarksValue;
	/* Approve Transaction */
	@FindBy(xpath = "//li[contains(@class,'nav-item open')]//a[contains(@class,'nav-link nav-toggle')][contains(text(),'Approve')]")
	WebElement ApproveMenu;
	@FindBy(xpath = "//a[@id='TPCAPP']")
	WebElement TopicAprvMenu;
	@FindBy(id = "SelectedDecision_2")
	WebElement ApproveRadioBtn;
	@FindBy(id = "Remarks")
	WebElement RemarksReason;
	@FindBy(id = "CMTopic_Remarks")
	WebElement ModRemarks;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[2]/td[1]")
	WebElement AprvActionValue;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[2]/td[2]")
	WebElement AprvActionByValue;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[2]/td[3]")
	WebElement AprvDateValue;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[2]/td[4]")
	WebElement AprvRemarksValue;
	/* Return Transaction */
	@FindBy(id = "SelectedDecision_3")
	WebElement ReturnRadioBtn;
	/* Drop Transaction */
	@FindBy(id = "SelectedDecision_4")
	WebElement DropRadioBtn;
	/* ReInitiation Transaction */
	@FindBy(xpath = "//li[contains(@class,'nav-item open')]//a[contains(@class,'nav-link nav-toggle')][contains(text(),'Re-initiation')]")
	WebElement ReinitiationMenu;
	@FindBy(xpath = "//a[@id='TPCRINI']")
	WebElement ReinitiationTopicMenu;
	@FindBy(id = "CMTopic_Remarks")
	WebElement ReInitRemarks;
	@FindBy(id = "CMTopic_TopicDesc")
	WebElement InitTopicName;
	@FindBy(id = "CMTopic_UserCode")
	WebElement InitTopicUniquecode;
	@FindBy(id = "CMTopic_Description")
	WebElement InitDescription;
	@FindBy(xpath = "//input[@value='2']")
	WebElement RIDocumentRadioBtn;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[3]/td[1]")
	WebElement ReinitActionValue;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[3]/td[2]")
	WebElement ReinitActionByValue;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[3]/td[3]")
	WebElement ReinitDateValue;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[3]/td[4]")
	WebElement ReinitRemarksValue;
	@FindBy(xpath = "//body/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/label[1]/div[1]/div[2]/div[1]")
	WebElement ReinitTaskTRNHLink;
	@FindBy(id = "AuditEventModal_View")
	WebElement Proceedbtn;
	/* RITransfer Transaction */
	@FindBy(xpath = "//li[contains(@class,'nav-item open')]//a[contains(@class,'nav-link nav-toggle')][contains(text(),'RI-Transfer')]")
	WebElement TransferMenu;
	@FindBy(xpath = "//a[@id='TPCRIT']")
	WebElement TransferTopicMenu;
	@FindBy(xpath = "//button[@id='TransferUserPopUpBtn']/span[contains(text(),'Add Item')]")
	WebElement TransferTo;
	@FindBy(xpath = "//span[@id='btnClientSearch']/i[@class='ft-search']")
	WebElement Search;
	@FindBy(xpath = "//div[@id='TransferTbl_filter']//input[@class='form-control caliber-textbox']")
	WebElement SearchNew;
	@FindBy(xpath = "//div[@id='MainTRN']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]")
	WebElement TransferFromUser;
	@FindBy(xpath = "//button[@id='TransferUserPopUpBtn']")
	WebElement TransferToUser;
	@FindBy(id = "btnClientSearch")
	WebElement userlistsearchbbtn;
	@FindBy(xpath = "//input[contains(@placeholder,'Search this Page_New')]")
	WebElement User;
	@FindBy(xpath = "//tbody/tr[1]/td[1]/input[1]")
	WebElement DisplayedUserRadioBtn;
	@FindBy(id = "Transfer_selectBtn")
	WebElement Okbtn;
	@FindBy(xpath = "//div[@class='textdiv qsTitle']//div[contains(text(),'Re-initiation Task Transfer (Reg.)')]")
	WebElement RITaskTRNHLink;
	@FindBy(xpath = "//div[@id='CompareTRN']//span[2]")
	WebElement TransferedFrom;
	@FindBy(xpath = "//body//span[4]")
	WebElement TransferedTo;
	@FindBy(xpath = "/html[1]/body[1]/form[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")
	WebElement TransferedBy;
	@FindBy(xpath = "//body//td[3]")
	WebElement TransferedOn;
	@FindBy(xpath = "//div[@id='CompareTRN']//div//div//div//table//tbody//tr//td//span")
	WebElement RITrnRemarks;
	/* ReInitiate Approve Transaction */

	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[4]/td[1]")
	WebElement ReinitiatedAprvValue;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[4]/td[2]")
	WebElement ReinitiatedAprvByValue;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[4]/td[3]")
	WebElement ReinitiatedAprvDateValue;
	@FindBy(xpath = "//table[@class='audit-preview-container my-3 w-100']/tbody/tr[4]/td[4]")
	WebElement ReinitiatedAprvRemarks;
	/* Modification */
	@FindBy(xpath = "//li[contains(@class,'nav-item open')]//a[contains(@class,'nav-link nav-toggle')][contains(text(),'Modify')]")
	WebElement ModifyMenu;
	@FindBy(xpath = "//a[@id='TPCMOD']")
	WebElement ModTopicMenu;
	@FindBy(xpath = "//button[contains(text(),'Modification')]")
	WebElement ModificationTab;
	@FindBy(xpath = "//div[@class='textdiv qsTitle']//div[contains(text(),'Modification')]")
	WebElement Modification1Hlink;
	@FindBy(xpath = "//body/form[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/label[1]/div[1]")
	WebElement Modification2Hlink;

	/* StatusChange Transaction */
	@FindBy(xpath = "//li[contains(@class,'nav-item open')]//a[contains(@class,'nav-link nav-toggle')][contains(text(),'Status Change')]")
	WebElement StatusChange;
	@FindBy(xpath = "//a[@id='TPCSCH']")
	WebElement StatusChangeTopic;
	@FindBy(xpath = "//button[contains(text(),'Inactive_New')]")
	WebElement InactiveListTab;
	@FindBy(xpath = "//div[@class='form-group']/span[contains(text(),'Active')]")
	WebElement CurrentStatus;
	@FindBy(xpath = "//div[@class='form-group']/span[contains(text(),'Inactive')]")
	WebElement ChangeStatus;
	@FindBy(xpath = "//body/form[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/label[1]/div[1]/div[2]")
	WebElement StatusChangeLink;
	@FindBy(xpath = "//div[@class='body']//div[2]//div[1]//label[1]")
	WebElement Stc1Hlink;
	@FindBy(xpath = "//body/form[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/span[1]/span[1]")
	WebElement StatusBeforeChangeValue;
	@FindBy(xpath = "//body/form[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/span[2]/span[1]")
	WebElement StatusAfterChangeValue;
	@FindBy(xpath = "//button[contains(text(),'Status Change')]")
	WebElement StatusChangeTab;
	@FindBy(xpath = "//div[@class='approve-status']/span[1]/span[1]")
	WebElement ApprovalRequiredValue;
	@FindBy(xpath = "//div[@class='approve-status']/span[2]/span[1]")
	WebElement ApprovalCompletedValue;
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement close;
	@FindBy(xpath = "//a[@href='#']//i[@class='icon-power']")
	WebElement SignoutBtn;
	@FindBy(id = "Config_IsEsignAtCreatInit")
	WebElement EsignAtInitCheckBox;	
	@FindBy(id = "Config_IsEsignAtModifyInit")
	WebElement EsignAtModInitCheckBox;
	@FindBy(id = "Config_IsEsignAtStatusChangeInit")
	WebElement EsignAtSTCInitCheckBox;	
	@FindBy(id = "Config_IsEsignAtCreatAppr")
	WebElement EsignAtInitAprCheckBox;
	@FindBy(id = "Config_IsEsignAtModifyAppr")
	WebElement EsignAtModAprCheckBox;
	@FindBy(id = "Config_IsEsignAtStatusChangeAppr")
	WebElement EsignAtSTCAprCheckBox;
	@FindBy(id = "select2-Config_NarAtCreate-container")
	WebElement NoOfAprReqForRegDrpdwn;	
	@FindBy(id = "select2-Config_NarAtModify-container")
	WebElement NoOfAprReqForModDrpdwn;
	@FindBy(id = "select2-Config_NarAtStatusChange-container")
	WebElement NoOfAprReqForSTCDrpdwn;	
	@FindBy(id = "Config_Remarks")
	WebElement Remarks;	
	@FindBy(xpath= "//ul[@id='select2-Config_NarAtCreate-results']/li[1]")
	WebElement SearchSel1;	
	@FindBy(xpath= "//ul[@id='select2-Config_NarAtModify-results']/li[1]")
	WebElement SearchSel2;
	@FindBy(xpath= "//ul[@id='select2-Config_NarAtStatusChange-results']/li[1]")
	WebElement SearchSel3;
	@FindBy(id = "btnSubmit")
	WebElement SubmitBtn;
	public CM_Topic() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is for Configuration
	 * 
	 * 
	 */
	public void Topicconfig(String noOfAprReqForInitDrpdwn, String noOfAprReqForModDrpdwn, String noOfAprReqForSTCDrpdwn) {
		
		click(EsignAtModInitCheckBox, "Esisn check box");
		click(Menu, "Menu");
		click(CourseManagerMenu, "Module Menu");
		click(ConfigMenu, "ConfigMenu");
		click(ConfigTopicMenu, "Menu");
		switchToBodyFrame(driver);
		TimeUtil.shortWait();	
		unCheckRadioBtnCheckbox(driver, EsignAtInitCheckBox);
		unCheckRadioBtnCheckbox(driver, EsignAtModInitCheckBox);
		unCheckRadioBtnCheckbox(driver, EsignAtSTCInitCheckBox);
		unCheckRadioBtnCheckbox(driver, EsignAtInitAprCheckBox);
		unCheckRadioBtnCheckbox(driver, EsignAtModAprCheckBox);
		unCheckRadioBtnCheckbox(driver, EsignAtSTCAprCheckBox);
		click(NoOfAprReqForRegDrpdwn, "NoOfAprReqForRegDrpdwn");
		WebElement Element = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		Element.sendKeys(noOfAprReqForInitDrpdwn);
		TimeUtil.shortWait();
		click(SearchSel1, "SearchSel");
		click(NoOfAprReqForModDrpdwn, "NoOfAprReqForModDrpdwn");	
		WebElement Element1 = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		Element1.sendKeys(noOfAprReqForModDrpdwn);
		TimeUtil.shortWait();
		click(SearchSel2, "SearchSel");
		click(NoOfAprReqForSTCDrpdwn, "NoOfAprReqForSTCDrpdwn");
		WebElement Element2 = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		Element2.sendKeys(noOfAprReqForSTCDrpdwn);
		TimeUtil.shortWait();
		click(SearchSel3, "SearchSel");
		sendText(Remarks, "Configured", "RemarksVal");
		click(SubmitBtn, "Submit Button");
		switchToDefaultContent(driver);
		click(ConfigMenu, "Menu");
		TimeUtil.shortWait();
	}

	/**
	 * This method is for topicRegistration 0
	 * 
	 */
	public void topicRegistration(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String eSign, String InitActionVal, String InitActionByVal, String ApprovalRequiredVal,
			String ApprovalCompletedVal) {

		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
			System.out.println("Generated S Value is: " + s);
		}
		
		setTopic(Topic = TopicName + s);
		click_CourseManager_InitiateMenu(Menu, CourseManagerMenu, InitiateMenu);
		click(TopicMenu, "Topic Menu");
		switchToBodyFrame(driver);
		sendText(Topicname, Topic, "Entering Topic Name");
		sendText(TopicuniqueCode, TopicUniqueCode + s, "TopicUniqueCode");
		sendText(description, Description + s, "Description");
		TimeUtil.shortWait();
		SelectRadioBtnAndCheckbox(driver, DocumentNameRadiobttn);
		sendText(DocumentSearchTextBox, Document, "Entering Document SearchTextBox");
		click(FetchRecordsHyperlink, "Fetch Records Hyperlink");
		click(GreenTickMark, "Gree Tick Mark");
		click(Submitbttn, "Submit Button");
		int numberOfApprovalReq = Integer.parseInt(ConfigsReader.getPropValue("ApprovalReqVal"));
		if (numberOfApprovalReq == 0) {

			switchToDefaultContent(driver);
			jsClick(SignoutBtn, "SignOut Button");
			TimeUtil.shortWait();
		} else {
			TimeUtil.shortWait();
			EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("RegInitiation"), NextButton);

			// Audit Trail verification

			switchToDefaultContent(driver);
			TimeUtil.shortWait();
			click(InitiateMenu, "Initiate Menu");
			TimeUtil.shortWait();
			jsClick(AuditTrails, "AuditTrails Menu");
			click(AduitTopic, "Topic under AuditTrails");
			switchToBodyFrame(driver);
			SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
			driver.switchTo().frame(0);
			TimeUtil.shortWait();
			verifyExactCaption(ATTopicName, Topic);
			verifyUniqueCode(ATSUniquecode);
			verifyExactCaption(ATDescription, Description + s);
			verifyExactCaption(ATDocument, Document);
			verifyExactCaption(ActionValue, "Initiated");
			verifyExactCaption(ActionByValue, InitActionByVal);
			String Currentdate = getCurrentDate("MMM dd yyyy");
			verifyCaptionContains(DateTimeValue, Currentdate);
			verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
			verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
			click(close, "Close");
			jsClick(AuditTrails, "AuditTrails Menu");
		}
	}

	public void topicReg(String TopicName, String TopicUniqueCode, String Description, String Document) {

		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
			System.out.println("Generated S Value is: " + s);
		}
		setTopic(Topic = TopicName + s);
		///String Documentval = DM_Document.getDocument();
		click_CourseManager_InitiateMenu(Menu, CourseManagerMenu, InitiateMenu);
		click(TopicMenu, "Topic Menu");
		switchToBodyFrame(driver);
		sendText(Topicname, Topic, "Entering Topic Name");
		sendText(TopicuniqueCode, TopicUniqueCode + s, "TopicUniqueCode");
		sendText(description, Description + s, "Description");
		TimeUtil.shortWait();
		SelectRadioBtnAndCheckbox(driver, DocumentNameRadiobttn);
		//sendText(DocumentSearchTextBox, Documentval, "Entering Document SearchTextBox");
		click(FetchRecordsHyperlink, "Fetch Records Hyperlink");
		click(GreenTickMark, "Gree Tick Mark");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
	}

	/**
	 * This method is for topicModInit
	 * 
	 * 
	 */
	public void topicModInit(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String ModDocument, String eSign, String InitActionVal, String InitActionByVal,
			String ModinitRemarks, String ApprovalRequiredVal, String ApprovalCompletedVal) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ModifyMenu(Menu, CourseManagerMenu, ModifyMenu);
		click(ModTopicMenu, "Modify Topic Menu");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		TimeUtil.shortWait();
		verifyAttribute(InitTopicName, "value", TopicName + s);
		verifyAttribute(InitTopicUniquecode, "value", TopicUniqueCode + s);
		verifyAttribute(InitDescription, "value", Description + s);
		SelectRadioBtnAndCheckbox(driver, DocumentNameRadiobttn);
		sendText(DocumentSearchTextBox, ModDocument, "Document TextBox");
		click(FetchRecordsHyperlink, "FetchRecords Hyperlink");
		click(GreenTickMark, "GreenTickMark");
		sendText(ModRemarks, ModinitRemarks, "Remarks Reason");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("ModInitiation"), NextButton);

		// Audit Trail verification

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ModifyMenu, "Modify Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		click(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		click(Modification1Hlink, "Modification1Hlink");
		click(Proceedbtn, "Proceed button");
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(ActionValue, InitActionVal);
		verifyExactCaption(ActionByValue, InitActionByVal);
		String Currentdate = getCurrentDate("MMM dd yyyy");
		verifyCaptionContains(DateTimeValue, Currentdate);
		verifyExactCaption(RemarksValue, ModinitRemarks);
		verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
		verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
		click(close, "Close");

	}

	/**
	 * This method is for topicApproval
	 * 
	 * 
	 */
	public void topicApproval(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String eSign, String InitActionVal, String InitActionByVal, String AppActionVal,
			String AppActionByVal, String AppRemarks, String ApprovalRequiredVal, String ApprovalCompletedVal,
			String ApprovalCompletedVal1) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ApproveMenu(Menu, CourseManagerMenu, ApproveMenu);
		click(TopicAprvMenu, "Topic Approve Menu");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(ActionValue, InitActionVal);
		verifyExactCaption(ActionByValue, InitActionByVal);
		click(ApproveRadioBtn, "Approve Radio Button");
		clearField(RemarksReason, "Remarks / Reason");
		sendText(RemarksReason, AppRemarks, "Remarks");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("RegApprover"), NextButton);

		// AudiTrails
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ApproveMenu, "Approve Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		click(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(AprvActionValue, AppActionVal);
		verifyExactCaption(AprvActionByValue, AppActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(AprvDateValue, Currentdate);
		verifyCaptionContains(AprvRemarksValue, AppRemarks);
		verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
		verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal1);
		click(close, "Close");
		TimeUtil.shortWait();

	}

	public void topicAprv(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String eSign) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ApproveMenu(Menu, CourseManagerMenu, ApproveMenu);
		click(TopicAprvMenu, "Topic Approve Menu");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		click(ApproveRadioBtn, "Approve Radio Button");
		clearField(RemarksReason, "Remarks / Reason");
		sendText(RemarksReason, "Approved", "Remarks");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("RegApprover"), NextButton);

	}

	/**
	 * This method is for topicReturn
	 * 
	 * 
	 */
	public void topicReturn(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String eSign, String RTNActionVal, String RTNActionByVal, String RTNRemarks,
			String ApprovalRequiredVal, String ApprovalCompletedVal) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ApproveMenu(Menu, CourseManagerMenu, ApproveMenu);
		click(TopicAprvMenu, "Topic Approve Menu");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		click(ReturnRadioBtn, "Return Radio Button");
		clearField(RemarksReason, "Remarks / Reason");
		sendText(RemarksReason, RTNRemarks, "Remarks");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("RegReturn"), NextButton);

		// AudiTrails
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ApproveMenu, "Approve Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		click(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(AprvActionValue, RTNActionVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(AprvDateValue, Currentdate);
		verifyCaptionContains(AprvRemarksValue, RTNRemarks);
		verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
		verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
		click(close, "Close");

	}

	/**
	 * This method is for topicDrop
	 * 
	 * 
	 */
	public void topicDrop(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String DPActionVal, String DPActionByVal, String eSign, String DropRemarks,
			String ApprovalRequiredVal, String ApprovalCompletedVal) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ApproveMenu(Menu, CourseManagerMenu, ApproveMenu);
		click(TopicAprvMenu, "Topic Approve Menu");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		click(DropRadioBtn, "Drop Radio Button");
		clearField(RemarksReason, "Remarks / Reason");
		sendText(RemarksReason, DropRemarks, "Remarks");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("RegDrop"), NextButton);

		// AudiTrails
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ApproveMenu, "Approve Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		click(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(AprvActionValue, DPActionVal);
		verifyExactCaption(AprvActionByValue, DPActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(AprvDateValue, Currentdate);
		verifyCaptionContains(AprvRemarksValue, DropRemarks);
		verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
		verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
		click(close, "Close");

	}

	/**
	 * This method is for topicReinitation
	 * 
	 * 
	 */
	public void topicReinitation(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String ReinitTopic, String eSign, String RTNActionVal, String RTNActionByVal,
			String RTNRemarks, String ReInitActionVal, String ReInitActionByVal, String ReinitRemarks,
			String ApprovalRequiredVal, String ApprovalCompletedVal) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ReinitationMenu(Menu, CourseManagerMenu, ReinitiationMenu);
		click(ReinitiationTopicMenu, "ReInitiation TopicName");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		verifyAttribute(InitTopicName, "value", TopicName + s);
		verifyAttribute(InitTopicUniquecode, "value", TopicUniqueCode + s);
		verifyAttribute(InitDescription, "value", TopicUniqueCode + s);
		verifyExactCaption(AprvActionValue, RTNActionVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(AprvDateValue, Currentdate);
		verifyCaptionContains(AprvRemarksValue, RTNRemarks);
		clearField(InitTopicName, "Initiate Topic Name");
		TimeUtil.shortWait();
		sendText(InitTopicName, ReinitTopic, "Reinitiate Topic Name");
		sendText(ReInitRemarks, ReinitRemarks, "Remarks Reason");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("RegReinit"), NextButton);

		// Audit Trails

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ReinitiationMenu, "Reinitiation Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		jsClick(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(ReinitActionValue, ReInitActionVal);
		verifyExactCaption(ReinitActionByValue, ReInitActionByVal);
		verifyCaptionContains(ReinitDateValue, Currentdate);
		verifyCaptionContains(ReinitRemarksValue, ReinitRemarks);
		verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
		verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
		click(close, "Close");
	}

	/**
	 * This method is for topicReinitApproval
	 * 
	 * 
	 */
	public void topicReinitApproval(String Menuname, String ReinitTopic, String TopicUniqueCode, String Description,
			String Document, String eSign, String ReInitActionVal, String ReInitActionByVal, String AppActionVal,
			String AppActionByVal, String AppRemarks, String ReinitRemarks, String ApprovalRequiredVal,
			String ApprovalCompletedVal, String ApprovalCompletedVal1) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ApproveMenu(Menu, CourseManagerMenu, ApproveMenu);
		click(TopicAprvMenu, "Topic Approve Menu");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		verifyExactCaption(ATTopicName, ReinitTopic + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(ReinitActionValue, ReInitActionVal);
		verifyExactCaption(ReinitActionByValue, ReInitActionByVal);
		click(ApproveRadioBtn, "Approve Radio Button");
		clearField(RemarksReason, "Remarks / Reason");
		sendText(RemarksReason, AppRemarks, "Remarks");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("RegApprover"), NextButton);

		// AudiTrails
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ApproveMenu, "Approve Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		click(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		verifyExactCaption(ATTopicName, ReinitTopic + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(ReinitiatedAprvValue, AppActionVal);
		verifyExactCaption(ReinitiatedAprvByValue, AppActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(ReinitiatedAprvDateValue, Currentdate);
		verifyCaptionContains(ReinitiatedAprvRemarks, AppRemarks);
		verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
		verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
		click(close, "Close");

	}

	/**
	 * This method is for topicRI_Transfer
	 * 
	 * 
	 */
	public void topicRI_Transfer(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String eSign, String RTNActionVal, String RTNActionByVal, String RTNRemarks, String Tuser,
			String TRNFrom, String TRNTo, String TRNBy, String TRNRemarks, String ApprovalRequiredVal,
			String ApprovalCompletedVal) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_RITransferMenu(Menu, CourseManagerMenu, TransferMenu);
		jsClick(TransferTopicMenu, "ReTransfer TopicName");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		TimeUtil.shortWait();
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(AprvActionValue, RTNActionVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(AprvDateValue, Currentdate);
		verifyCaptionContains(AprvRemarksValue, RTNRemarks);
		verifyCaptionContains(TransferFromUser, TRNFrom);
		click(TransferToUser, "Transfer dropdown");
		click(userlistsearchbbtn, "search button");
		TimeUtil.mediumWait();
		click(SearchNew, "SearchNew");
		TimeUtil.shortWait();
		User.sendKeys(Tuser);
		TimeUtil.shortWait();
		SelectRadioBtnAndCheckbox(driver, DisplayedUserRadioBtn);
		click(Okbtn, "ok Button");
		sendText(RemarksReason, TRNRemarks, "Remarks Reason");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("RegTransfer"), NextButton);

		// Audit Trail verification

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(TransferMenu, "TransferMenu Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		click(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		click(RITaskTRNHLink, "RI Transfer Hlink");
		click(Proceedbtn, "Proceed button");
		verifyExactCaption(ATTopicName, TopicName);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(TransferedFrom, TRNFrom);
		verifyExactCaption(TransferedTo, TRNTo);
		verifyExactCaption(TransferedBy, TRNBy);
		verifyCaptionContains(TransferedOn, Currentdate);
		verifyExactCaption(RITrnRemarks, TRNRemarks);
		click(close, "Close");

	}

	/**
	 * This method is for topicTransferReinitation
	 * 
	 * 
	 */
	public void topicTransferReinitation(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String eSign, String ReinitTopic, String RTNActionVal, String RTNActionByVal,
			String RTNRemarks, String TrnsfrActionVal, String TrnsfrActionByVal, String TRNFrom, String TRNTo,
			String TRNBy, String TRNRemarks, String ReinitRemarks, String ApprovalRequiredVal,
			String ApprovalCompletedVal) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ReinitationMenu(Menu, CourseManagerMenu, ReinitiationMenu);
		click(ReinitiationTopicMenu, "ReInitiation TopicName");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		verifyAttribute(InitTopicName, "value", TopicName + s);
		verifyAttribute(InitTopicUniquecode, "value", TopicUniqueCode + s);
		verifyAttribute(InitDescription, "value", Description + s);
		verifyExactCaption(AprvActionValue, RTNActionVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(AprvDateValue, Currentdate);
		verifyCaptionContains(AprvRemarksValue, RTNRemarks);
		clearField(InitTopicName, "Initiate Topic Name");
		TimeUtil.shortWait();
		sendText(InitTopicName, ReinitTopic, "Reinitiate Topic Name");
		sendText(ReInitRemarks, ReinitRemarks, "Remarks Reason");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("RegReinit"), NextButton);

		// Audit Trail verification

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ReinitiationMenu, "Reinitiation Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		jsClick(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		click(RITaskTRNHLink, "RI Transfer Hlink");
		click(Proceedbtn, "Proceed button");
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(TransferedFrom, TRNFrom);
		verifyExactCaption(TransferedTo, TRNTo);
		verifyCaptionContains(TransferedBy, TRNBy);
		verifyCaptionContains(TransferedOn, Currentdate);
		verifyCaptionContains(RITrnRemarks, TRNRemarks);
		click(close, "close Button");

	}

	/**
	 * This method is for topictransferReinitApproval
	 * 
	 * 
	 */
	public void topicTrnsfrReinitApproval(String Menuname, String ReinitTopic, String TopicUniqueCode,
			String Description, String Document, String eSign, String ReInitActionVal, String ReInitActionByVal,
			String AppActionVal, String AppActionByVal, String AppRemarks, String TRNFrom, String TRNTo, String TRNBy,
			String TRNRemarks, String ReinitRemarks, String ApprovalRequiredVal, String ApprovalCompletedVal,
			String ApprovalCompletedVal1) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ApproveMenu(Menu, CourseManagerMenu, ApproveMenu);
		click(TopicAprvMenu, "Topic Approve Menu");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		verifyExactCaption(ATTopicName, ReinitTopic + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(ReinitActionValue, ReInitActionVal);
		verifyExactCaption(ReinitActionByValue, ReInitActionByVal);
		click(ApproveRadioBtn, "Approve Radio Button");
		clearField(RemarksReason, "Remarks / Reason");
		sendText(RemarksReason, AppRemarks, "Remarks");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("RegApprover"), NextButton);

		// AudiTrails
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ApproveMenu, "Approve Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		click(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		click(RITaskTRNHLink, "RI Transfer Hlink");
		click(Proceedbtn, "Proceed button");
		verifyExactCaption(ATTopicName, ReinitTopic + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(TransferedFrom, TRNFrom);
		verifyExactCaption(TransferedTo, TRNTo);
		verifyCaptionContains(TransferedBy, TRNBy);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(TransferedOn, Currentdate);
		verifyCaptionContains(RITrnRemarks, TRNRemarks);
		click(close, "close Button");

	}

	/**
	 * This method is for topicModApproval
	 * 
	 * 
	 */
	public void topicModApproval(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String eSign, String InitActionVal, String InitActionByVal, String AppActionVal,
			String AppActionByVal, String AppRemarks, String ApprovalRequiredVal, String ApprovalCompletedVal,
			String ApprovalCompletedVal1) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ApproveMenu(Menu, CourseManagerMenu, ApproveMenu);
		click(TopicAprvMenu, "Topic Approve Menu");
		switchToBodyFrame(driver);
		click(ModificationTab, "Modification Tab");
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(ActionValue, InitActionVal);
		verifyExactCaption(ActionByValue, InitActionByVal);
		click(ApproveRadioBtn, "Approve Radio Button");
		clearField(RemarksReason, "Remarks / Reason");
		sendText(RemarksReason, AppRemarks, "Remarks");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("ModApprover"), NextButton);

		// AudiTrails
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ApproveMenu, "Approve Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		click(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		click(Modification1Hlink, "Modification1Hlink");
		click(Proceedbtn, "Proceed btn");
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(AprvActionValue, AppActionVal);
		verifyExactCaption(AprvActionByValue, AppActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(AprvDateValue, Currentdate);
		verifyCaptionContains(AprvRemarksValue, AppRemarks);
		verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
		verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
		click(close, "Close");

	}

	/**
	 * This method is for topicModReturn
	 * 
	 * 
	 */
	public void topicModReturn(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String eSign, String RTNActionVal, String RTNActionByVal, String RTNRemarks,
			String ApprovalRequiredVal, String ApprovalCompletedVal) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ApproveMenu(Menu, CourseManagerMenu, ApproveMenu);
		click(TopicAprvMenu, "Topic Approve Menu");
		switchToBodyFrame(driver);
		click(ModificationTab, "Modification Tab");
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		click(ReturnRadioBtn, "Return Radio Button");
		clearField(RemarksReason, "Remarks / Reason");
		sendText(RemarksReason, RTNRemarks, "Remarks");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("ModReturn"), NextButton);

		// AudiTrails
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ApproveMenu, "Approve Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		click(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		click(Modification1Hlink, "Modification1Hlink");
		click(Proceedbtn, "Proceed btn");
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(AprvActionValue, RTNActionVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(AprvDateValue, Currentdate);
		verifyCaptionContains(AprvRemarksValue, RTNRemarks);
		verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
		verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
		click(close, "Close");

	}

	/**
	 * This method is for topicModDrop
	 * 
	 * 
	 */
	public void topicModDrop(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String DPActionVal, String DPActionByVal, String eSign, String DropRemarks,
			String ApprovalRequiredVal, String ApprovalCompletedVal) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ApproveMenu(Menu, CourseManagerMenu, ApproveMenu);
		click(TopicAprvMenu, "Topic Approve Menu");
		switchToBodyFrame(driver);
		click(ModificationTab, "Modification Tab");
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		click(DropRadioBtn, "Drop Radio Button");
		clearField(RemarksReason, "Remarks / Reason");
		sendText(RemarksReason, DropRemarks, "Remarks");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("ModDrop"), NextButton);

		// AudiTrails
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ApproveMenu, "Approve Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		click(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		click(Modification1Hlink, "Modification1Hlink");
		click(Proceedbtn, "Proceed btn");
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(AprvActionValue, DPActionVal);
		verifyExactCaption(AprvActionByValue, DPActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(AprvDateValue, Currentdate);
		verifyCaptionContains(AprvRemarksValue, DropRemarks);
		verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
		verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
		click(close, "Close");

	}

	/**
	 * This method is for topicModReinitation
	 * 
	 * 
	 */
	public void topicModReinitation(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String eSign, String ReinitTopic, String RTNActionVal, String RTNActionByVal,
			String RTNRemarks, String ReInitActionVal, String ReInitActionByVal, String ReinitRemarks,
			String ApprovalRequiredVal, String ApprovalCompletedVal) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ReinitationMenu(Menu, CourseManagerMenu, ReinitiationMenu);
		click(ReinitiationTopicMenu, "ReInitiation TopicName");
		switchToBodyFrame(driver);
		click(ModificationTab, "Modification Tab");
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		verifyAttribute(InitTopicName, "value", TopicName + s);
		verifyAttribute(InitTopicUniquecode, "value", TopicUniqueCode + s);
		verifyAttribute(InitDescription, "value", TopicUniqueCode + s);
		verifyExactCaption(AprvActionValue, RTNActionVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(AprvDateValue, Currentdate);
		verifyCaptionContains(AprvRemarksValue, RTNRemarks);
		clearField(InitTopicName, "Initiate Topic Name");
		TimeUtil.shortWait();
		sendText(InitTopicName, ReinitTopic, "Reinitiate Topic Name");
		sendText(ReInitRemarks, ReinitRemarks, "Remarks Reason");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("ModReinit"), NextButton);

		// Audit Trails

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ReinitiationMenu, "ReinitiationMenu Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		jsClick(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		click(Modification1Hlink, "Modification1Hlink");
		click(Proceedbtn, "Proceed btn");
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(ReinitActionValue, ReInitActionVal);
		verifyExactCaption(ReinitActionByValue, ReInitActionByVal);
		verifyCaptionContains(ReinitDateValue, Currentdate);
		verifyCaptionContains(ReinitRemarksValue, ReinitRemarks);
		verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
		verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
		click(close, "Close");
	}

	/**
	 * This method is for topicTransferModReinitation
	 * 
	 * 
	 */
	public void topicModTRNReinitation(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String eSign, String ReinitTopic, String RTNActionVal, String RTNActionByVal,
			String RTNRemarks, String ReInitActionVal, String ReInitActionByVal, String ReinitRemarks,
			String ApprovalRequiredVal, String ApprovalCompletedVal) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ReinitationMenu(Menu, CourseManagerMenu, ReinitiationMenu);
		click(ReinitiationTopicMenu, "ReInitiation TopicName");
		switchToBodyFrame(driver);
		click(ModificationTab, "Modification Tab");
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		verifyAttribute(InitTopicName, "value", TopicName + s);
		verifyAttribute(InitTopicUniquecode, "value", TopicUniqueCode + s);
		verifyAttribute(InitDescription, "value", TopicUniqueCode + s);
		verifyExactCaption(AprvActionValue, RTNActionVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(AprvDateValue, Currentdate);
		verifyCaptionContains(AprvRemarksValue, RTNRemarks);
		clearField(InitTopicName, "Initiate Topic Name");
		TimeUtil.shortWait();
		sendText(InitTopicName, ReinitTopic, "Reinitiate Topic Name");
		sendText(ReInitRemarks, ReinitRemarks, "Remarks Reason");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("ModTransfer"), NextButton);

		// Audit Trails

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ReinitiationMenu, "Reinitiation Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		jsClick(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		click(Modification2Hlink, "Modification2Hlink");
		click(Proceedbtn, "Proceed btn");
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(ReinitActionValue, ReInitActionVal);
		verifyExactCaption(ReinitActionByValue, ReInitActionByVal);
		verifyCaptionContains(ReinitDateValue, Currentdate);
		verifyCaptionContains(ReinitRemarksValue, ReinitRemarks);
		verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
		verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
		click(close, "Close");
	}

	/**
	 * This method is for topicModReinitApproval
	 * 
	 * 
	 */
	public void topicModReinitApproval(String Menuname, String ReinitTopic, String TopicUniqueCode, String Description,
			String Document, String eSign, String ReInitActionVal, String ReInitActionByVal, String AppActionVal,
			String AppActionByVal, String AppRemarks, String ReinitRemarks, String ApprovalRequiredVal,
			String ApprovalCompletedVal, String ApprovalCompletedVal1) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ApproveMenu(Menu, CourseManagerMenu, ApproveMenu);
		click(TopicAprvMenu, "Topic Approve Menu");
		switchToBodyFrame(driver);
		click(ModificationTab, "Modification Tab");
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		verifyExactCaption(ATTopicName, ReinitTopic + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(ReinitActionValue, ReInitActionVal);
		verifyExactCaption(ReinitActionByValue, ReInitActionByVal);
		click(ApproveRadioBtn, "Approve Radio Button");
		clearField(RemarksReason, "Remarks / Reason");
		sendText(RemarksReason, AppRemarks, "Remarks");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("ModApprove"), NextButton);

		// AudiTrails
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ApproveMenu, "Approve Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		click(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		click(Modification1Hlink, "Modification1Hlink");
		click(Proceedbtn, "Proceed btn");
		verifyExactCaption(ATTopicName, ReinitTopic + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(ReinitiatedAprvValue, AppActionVal);
		verifyExactCaption(ReinitiatedAprvByValue, AppActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(ReinitiatedAprvDateValue, Currentdate);
		verifyCaptionContains(ReinitiatedAprvRemarks, AppRemarks);
		verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
		verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
		click(close, "Close");

	}

	/**
	 * This method is for topicModRI_Transfer
	 * 
	 * 
	 */
	public void topicModRI_Transfer(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String eSign, String RTNActionVal, String RTNActionByVal, String RTNRemarks, String Tuser,
			String TRNFrom, String TRNTo, String TRNBy, String TRNRemarks, String ApprovalRequiredVal,
			String ApprovalCompletedVal) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_RITransferMenu(Menu, CourseManagerMenu, TransferMenu);
		jsClick(TransferTopicMenu, "ReTransfer TopicName");
		switchToBodyFrame(driver);
		click(ModificationTab, "Modification Tab");
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		TimeUtil.shortWait();
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(AprvActionValue, RTNActionVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(AprvDateValue, Currentdate);
		verifyCaptionContains(AprvRemarksValue, RTNRemarks);
		verifyCaptionContains(TransferFromUser, TRNFrom);
		click(TransferToUser, "Transfer dropdown");
		click(userlistsearchbbtn, "search button");
		TimeUtil.mediumWait();
		click(SearchNew, "SearchNew");
		TimeUtil.shortWait();
		User.sendKeys(Tuser);
		TimeUtil.shortWait();
		SelectRadioBtnAndCheckbox(driver, DisplayedUserRadioBtn);
		click(Okbtn, "ok Button");
		sendText(RemarksReason, TRNRemarks, "Remarks Reason");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("ModTransfer"), NextButton);

		// Audit Trail verification

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ReinitiationMenu, "Reinitiation Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		jsClick(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		click(RITaskTRNHLink, "RI Transfer Hlink");
		click(Proceedbtn, "Proceed button");
		verifyExactCaption(ATTopicName, TopicName);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(TransferedFrom, TRNFrom);
		verifyExactCaption(TransferedTo, TRNTo);
		verifyExactCaption(TransferedBy, TRNBy);
		verifyCaptionContains(TransferedOn, Currentdate);
		verifyExactCaption(RITrnRemarks, TRNRemarks);
		click(close, "Close");

	}

	/**
	 * This method is for TopicModTransferReinitation
	 * 
	 * 
	 */
	public void TopicModTransferReinitation(String Menuname, String TopicName, String TopicUniqueCode,
			String Description, String Document, String eSign, String ReinitTopic, String RTNActionVal,
			String RTNActionByVal, String RTNRemarks, String TrnsfrActionVal, String TrnsfrActionByVal, String TRNFrom,
			String TRNTo, String TRNBy, String TRNRemarks, String ReinitRemarks, String ApprovalRequiredVal,
			String ApprovalCompletedVal) {
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ReinitationMenu(Menu, CourseManagerMenu, ReinitiationMenu);
		click(ReinitiationTopicMenu, "ReInitiation TopicName");
		switchToBodyFrame(driver);
		click(ModificationTab, "Modification Tab");
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		verifyAttribute(InitTopicName, "value", TopicName + s);
		verifyAttribute(InitTopicUniquecode, "value", TopicUniqueCode + s);
		verifyAttribute(InitDescription, "value", Description + s);
		verifyExactCaption(AprvActionValue, RTNActionVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		verifyExactCaption(AprvActionByValue, RTNActionByVal);
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(AprvDateValue, Currentdate);
		verifyCaptionContains(AprvRemarksValue, RTNRemarks);
		clearField(InitTopicName, "Initiate Topic Name");
		TimeUtil.shortWait();
		sendText(InitTopicName, ReinitTopic, "Reinitiate Topic Name");
		sendText(ReInitRemarks, ReinitRemarks, "Remarks Reason");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("ModReinit"), NextButton);

		// Audit Trail verification

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(ReinitiationMenu, "Reinitiation Menu");
		TimeUtil.shortWait();
		jsClick(AuditTrails, "AuditTrails Menu");
		jsClick(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		click(ReinitTaskTRNHLink, "ReinitTask TRNHLink");
		click(Proceedbtn, "Proceed btn");
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(TransferedFrom, TRNFrom);
		verifyExactCaption(TransferedTo, TRNTo);
		verifyCaptionContains(TransferedBy, TRNBy);
		verifyCaptionContains(TransferedOn, Currentdate);
		verifyCaptionContains(RITrnRemarks, TRNRemarks);
		click(close, "close Button");

	}

	/**
	 * This method is for topicStatusChangeActivetoInActive
	 * 
	 * 
	 */
	public void topicStatusChangeActivetoInActive(String Menuname, String TopicName, String TopicUniqueCode,
			String Description, String Document, String eSign, String STActive, String STInActive, String InitActionVal,
			String InitActionByVal, String STCRemarks, String ApprovalRequiredVal, String ApprovalCompletedVal)

	{
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_StatusChangeMenu(Menu, CourseManagerMenu, StatusChange);
		click(StatusChangeTopic, "StatusChange Topic");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		TimeUtil.shortWait();
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyCaptionContains(CurrentStatus, STActive);
		verifyCaptionContains(ChangeStatus, STInActive);
		sendText(RemarksReason, STCRemarks, "Remarks Reason");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("STCActivetoInActive"), NextButton);

		// confirmation message verification and Audit Trail verification

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(StatusChange, "Status Change");
		jsClick(AuditTrails, "AuditTrails Menu");
		click(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		click(Stc1Hlink, "Status Change Link");
		click(Proceedbtn, "Proceed button");
		verifyExactCaption(ATTopicName, TopicName);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(ActionValue, InitActionVal);
		verifyExactCaption(ActionByValue, InitActionByVal);
		verifyExactCaption(StatusBeforeChangeValue, "Active_New");
		verifyExactCaption(StatusAfterChangeValue, "Inactive_New");
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(DateTimeValue, Currentdate);
		verifyCaptionContains(RemarksValue, STCRemarks);
		verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
		verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
		click(close, "Close");

	}

	/**
	 * This method is for topicStatusChangeInActivetoActive
	 * 
	 * 
	 */
	public void topicStatusChangeInActivetoActive(String Menuname, String TopicName, String TopicUniqueCode,
			String Description, String Document, String eSign, String InitActionVal, String InitActionByVal,
			String STActive, String STInActive, String STCRemarks, String ApprovalRequiredVal,
			String ApprovalCompletedVal)

	{
		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_StatusChangeMenu(Menu, CourseManagerMenu, StatusChange);
		click(StatusChangeTopic, "StatusChange Topic");
		switchToBodyFrame(driver);
		click(InactiveListTab, "InactiveListTab");
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		TimeUtil.shortWait();
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyCaptionContains(CurrentStatus, STInActive);
		verifyCaptionContains(ChangeStatus, STActive);
		sendText(RemarksReason, STCRemarks, "Remarks Reason");
		click(Submitbttn, "Submit Button");
		TimeUtil.shortWait();
		EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("STCActivetoInActive"), NextButton);

		// Audit Trail verification

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(StatusChange, "Status Change");
		jsClick(AuditTrails, "AuditTrails Menu");
		click(AduitTopic, "Topic under AuditTrails");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		driver.switchTo().frame(0);
		click(Stc1Hlink, "Status Change Link");
		click(Proceedbtn, "Proceed button");
		verifyExactCaption(ATTopicName, TopicName);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(ActionValue, InitActionVal);
		verifyExactCaption(ActionByValue, InitActionByVal);
		verifyExactCaption(StatusBeforeChangeValue, "Inactive_New");
		verifyExactCaption(StatusAfterChangeValue, "Active_New");
		String Currentdate = getCurrentDate("dd MMM yyyy");
		verifyCaptionContains(DateTimeValue, Currentdate);
		verifyCaptionContains(RemarksValue, STCRemarks);
		verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
		verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
		click(close, "Close");

	}

	/**
	 * This method is for topicSTCApprove
	 * 
	 * 
	 */
	public void topicSTCApprove(String Menuname, String TopicName, String TopicUniqueCode, String Description,
			String Document, String eSign, String InitActionVal, String InitActionByVal, String AppActionVal,
			String AppActionByVal, String AppRemarks, String STActive, String STInActive, String STCRemarks,
			String ApprovalRequiredVal, String ApprovalCompletedVal, String ApprovalCompletedVal1) {

		String s = "";
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(5);
			System.out.println("Generated S Value is: " + s);
		}
		CourseManager_ApproveMenu(Menu, CourseManagerMenu, ApproveMenu);
		click(TopicAprvMenu, "Topic Approve Menu");
		switchToBodyFrame(driver);
		SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
		verifyExactCaption(ATTopicName, TopicName + s);
		verifyUniqueCode(ATSUniquecode);
		verifyExactCaption(ATDescription, Description + s);
		verifyExactCaption(ATDocument, Document);
		verifyExactCaption(ActionValue, InitActionVal);
		verifyExactCaption(ActionByValue, InitActionByVal);
		String StatusChangeValue = StatusBeforeChangeValue.getText();

		if (StatusChangeValue.equals("Active_New")) {

			click(ApproveRadioBtn, "Approve Radio Button");
			clearField(RemarksReason, "Remarks / Reason");
			sendText(RemarksReason, AppRemarks, "Remarks");
			click(Submitbttn, "Submit Button");
			TimeUtil.shortWait();
			EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("STCApprove"), NextButton);

			// AudiTrails
			switchToDefaultContent(driver);
			TimeUtil.shortWait();
			click(InitiateMenu, "Initiate Menu");
			TimeUtil.shortWait();
			jsClick(AuditTrails, "AuditTrails Menu");
			click(AduitTopic, "Topic under AuditTrails");
			switchToBodyFrame(driver);
			SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
			driver.switchTo().frame(0);
			click(Stc1Hlink, "Status Change Link");
			click(Proceedbtn, "Proceed button");
			verifyExactCaption(ATTopicName, TopicName + s);
			verifyUniqueCode(ATSUniquecode);
			verifyExactCaption(ATDescription, Description + s);
			verifyExactCaption(ATDocument, Document);
			verifyExactCaption(StatusBeforeChangeValue, "Active_New");
			verifyExactCaption(StatusAfterChangeValue, "Inactive_New");
			verifyExactCaption(AprvActionValue, AppActionVal);
			verifyExactCaption(AprvActionByValue, AppActionByVal);
			String Currentdate = getCurrentDate("dd MMM yyyy");
			verifyCaptionContains(AprvDateValue, Currentdate);
			verifyCaptionContains(AprvRemarksValue, AppRemarks);
			verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
			verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
			click(close, "Close");
		} else {
			click(ApproveRadioBtn, "Approve Radio Button");
			clearField(RemarksReason, "Remarks / Reason");
			sendText(RemarksReason, AppRemarks, "Remarks");
			click(Submitbttn, "Submit Button");
			TimeUtil.shortWait();
			EsignCnfrm(eSign, ConfirmMsg, Menuname + " " + prop.getProperty("STCApprove"), NextButton);

			// AudiTrails
			switchToDefaultContent(driver);
			TimeUtil.shortWait();
			click(InitiateMenu, "Initiate Menu");
			TimeUtil.shortWait();
			jsClick(AuditTrails, "AuditTrails Menu");
			click(AduitTopic, "Topic under AuditTrails");
			switchToBodyFrame(driver);
			SearchRecord(SearchFilter, SearchByNew, SearchByNewDropdown, DisplayedRecord, Aud_UniqueCodeField, Display);
			driver.switchTo().frame(0);
			click(Stc1Hlink, "Status Change Link");
			click(Proceedbtn, "Proceed button");
			verifyExactCaption(ATTopicName, TopicName + s);
			verifyUniqueCode(ATSUniquecode);
			verifyExactCaption(ATDescription, Description + s);
			verifyExactCaption(ATDocument, Document);
			verifyExactCaption(StatusBeforeChangeValue, "Inactive_New");
			verifyExactCaption(StatusAfterChangeValue, "Active_New");
			verifyExactCaption(AprvActionValue, AppActionVal);
			verifyExactCaption(AprvActionByValue, AppActionByVal);
			String Currentdate = getCurrentDate("dd MMM yyyy");
			verifyCaptionContains(AprvDateValue, Currentdate);
			verifyCaptionContains(AprvRemarksValue, AppRemarks);
			verifyCaptionContains(ApprovalRequiredValue, ApprovalRequiredVal);
			verifyCaptionContains(ApprovalCompletedValue, ApprovalCompletedVal);
			click(close, "Close");

		}

	}

}
