package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class MST_Equipment extends ActionEngine{
	
	
	Properties prop;
	public static String Uniquecode = "";

	public static String getUniqueCode() {
		return Uniquecode;
	}

	public static void setUniquecode(String uniquecode) {
		Uniquecode = uniquecode;
	}
	
	
	
	@FindBy(xpath = "//div[@class='left-menupanel']/div[2]")
	WebElement MasterMenu;;
	
	//Equipment registration
	
	@FindBy(id="MEQP_01")
	WebElement equipmentregistration;
	
//	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
//	WebElement name;
	
	@FindBy(id="btnAdvSearch")
	WebElement Advancedsearchicon;
	
	@FindBy(xpath = "//span[@class='ft-calendar']")
	WebElement calender;
	
	@FindBy(xpath = "//li[text()='Last 30 Days']")
	WebElement last30days;
	
	@FindBy(id="btnSubmitListFilter")
	WebElement appltbtn;
	
	@FindBy(xpath = "//span[@class='text-ellipsis']")
	WebElement EquipmentRecord;
	
//	@FindBy(className = "text-ellipsis")
//	WebElement CategoryRecord;

	
	@FindBy(id="btnSubmit_1")
	WebElement clickbtn;
	
	@FindBy(id="MST_EQP_CTF_002_error")
	WebElement Eqipment_Error;
	
	@FindBy(id="MST_EQP_CTF_002")
	WebElement Equipment;
	
	@FindBy(id="MST_EQP_CTF_003_error")
	WebElement EquipmentID_Error;
	
	@FindBy(id="MST_EQP_CTF_003")
	WebElement Equipment_ID;
	
	@FindBy(id="MST_EQP_CTF_004_error")
	WebElement Make_Error;
	
	@FindBy(id="MST_EQP_CTF_004")
	WebElement Make;
	
	@FindBy(id="txtESignPassword")
	WebElement click_esing;
	
	@FindBy(id="Submit_Esign")
	WebElement precced;
	
	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement EquipmentUniqeCode;
	
	@FindBy(id="cfnMsg_Next")
	WebElement donepopu;
	
	//modificaation
	
	@FindBy(id="MEQP_02")
	WebElement clickmodification;
	
	@FindBy(id="btnAdvSearch")
	WebElement advancedsearch;
	
//	@FindBy(xpath = "//input[@title='dd MMM yyyy'][1]")
//	WebElement claredate;
	
//	@FindBy(xpath = "//button[@title='dd MMM yyyy']")
//	WebElement calenderBtn;
//	
//	@FindBy(xpath = "//li[text()='Last 30 Days']")
//	WebElement last30Days;
	
	
	@FindBy(name="MST_EQP_CTF_003")
	WebElement Issuecode;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement clickblinder;
	
	@FindBy(id="MST_EQP_CTF_007")
	WebElement namemodify;
	
	@FindBy(id="btnSubmitListFilter")
	WebElement ApplyBtn;
	
	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement Entervalue;
	
	@FindBy(id="txtRemarks")
	WebElement Remarks;
	
	@FindBy(id="cfnMsg_Next")
	WebElement Done;
	
	//Status change
	
	@FindBy(id="MEQP_03")
	WebElement EquipmentStatusChangeMenu;
	
	@FindBy(id="MST_EQP_CTF_003")
	WebElement EquipmentSearchFilter;
	
	@FindBy(className = "confirmation_text")
	WebElement IssueCode;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement name;
	
	@FindBy(xpath = "//span[text()='Select Value']")
	WebElement Selectvalue;
	
	@FindBy(xpath = "//label[@for='NewStatus_5']")
	WebElement inactivruser;
	
	@FindBy(xpath = "//label[@for='NewStatus_1']")
	WebElement Active;
	
	@FindBy(xpath = "//label[@for='NewStatus_10']")
	WebElement PermanentInActive;
	
	@FindBy(id="confirmationRevertYes")
	WebElement Yes;
	
	@FindBy(id="txtRemarks")
	WebElement reasons;
	
	//auditrails
	
	@FindBy(id="MEQP_04")
	WebElement equipmentAuditTrails;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement blinderclick;
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closewindow;
	
	
	
	public void equipmentRegistration(String E_name ,String E_id ,String E_make)
	{
		
		
	
		String s = "";

		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
			System.out.println("Generated S Value is: " + s);
		}
		setUniquecode(Uniquecode = E_id + s);
			
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menur");
		click(equipmentregistration, "equipment category");
		scrollToViewElement(equipmentregistration);
		switchToBodyFrame(driver);
		click(Advancedsearchicon, "advanced search");
		click(calender, "click calinder");
		click(last30days, " last 30 days");
		click(appltbtn, "click apply");
		
		click(name, "click name");
		click(clickbtn, "click submit");
		
		verifyCaptionContains(Eqipment_Error, "Enter Value");
		sendText(Equipment, E_name, "eqipment name");
		click(clickbtn, "Submit");
		
		verifyCaptionContains(EquipmentID_Error, "Enter Value");
		sendText(Equipment_ID, Uniquecode, "eqipment id");
		click(clickbtn, "Submit");
			
		verifyCaptionContains(Make_Error, "Enter Value");
		sendText(Make, E_make, "eqipment make");
		click(clickbtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, EquipmentUniqeCode);
		switchToDefaultContent(driver);
									
	}
	
	public void equipmentModifiaction(String equipment  ,String Remarksreasons)
	{
		click(MasterMenu, "Master Menur");
		scrollToViewElement(clickmodification);
		click(clickmodification, "modification click");
		switchToBodyFrame(driver);
		click(advancedsearch, "advanced search");
//		click(calenderBtn, "click calender button");
//		click(last30Days, "click last 30 Days");
//		click(appltbtn, " apply button");
		
		//switchToBodyFrame(driver);
		enterUniqueCode(driver, Issuecode);
		click(appltbtn, " apply button");	
		click(clickblinder, "click blinder");
		clearField(Equipment, "Modification name");
		sendText(Equipment, equipment, "equipment modification");
		click(clickbtn, "Submit");
		//namemodify.clear();
		//sendText(namemodify, testing, " modification name");
		verifyCaptionContains(Entervalue, "Enter Value");
		sendText(Remarks, Remarksreasons, "remarkseason");
		click(clickbtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, EquipmentUniqeCode);
		//click(Done, "doneBtn");
		switchToDefaultContent(driver);	
	}
	
	public void equipmentstatusChangeInActive(String RemarksReasons)
	{
		
		
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menur");
		scrollToViewElement(EquipmentStatusChangeMenu);
		click(EquipmentStatusChangeMenu, "status chages");
		switchToBodyFrame(driver);
		click(advancedsearch, "click search");
		enterUniqueCode(driver, Issuecode);
		//click(EquipmentSearchFilter, "Equipment Search Filter");
		click(appltbtn, " apply button");	
		//enterUniqueCode(driver, Issuecode);
		//click(appltbtn, " apply button");	
//		click(calenderBtn, "click calender button");
//		click(last30Days, "click last 30 Days");
//		click(appltbtn, " apply button");
		
		//switchToBodyFrame(driver);
		click(name, "click button");
		click(clickbtn, "Submit");
		verifyCaptionContains(Selectvalue, "Select Value");
		click(inactivruser, "click user");
		sendText(reasons, RemarksReasons, "remarks");
		click(clickbtn, "Submit");	
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, EquipmentUniqeCode);
		switchToDefaultContent(driver);
		
	}
		
	public void equipmentstatusChangeActive(String Reasons)
	{
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menur");
		scrollToViewElement(EquipmentStatusChangeMenu);
		click(EquipmentStatusChangeMenu, "status chages");
		switchToBodyFrame(driver);
		click(advancedsearch, "click search");
		enterUniqueCode(driver, Issuecode);
		click(appltbtn, " apply button");	
		click(name, "click button");
		click(clickbtn, "Submit");
		
		verifyCaptionContains(Selectvalue, "Select Value");
		click(Active, "equipment Active");
		
		sendText(reasons, Reasons, "remarks");
		click(clickbtn, "Submit");	
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, EquipmentUniqeCode);
		switchToDefaultContent(driver);
		
		
	}
	
	public void eqipmentPermanentInActive(String Reasons)
	{
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menur");
		scrollToViewElement(EquipmentStatusChangeMenu);
		click(EquipmentStatusChangeMenu, "status chages");
		switchToBodyFrame(driver);
		click(advancedsearch, "click search");
		enterUniqueCode(driver, Issuecode);
		click(appltbtn, " apply button");	
		click(name, "click button");
		click(clickbtn, "Submit");
		
		verifyCaptionContains(Selectvalue, "Select Value");
		click(PermanentInActive, "Permanent In Active");
		click(Yes, "Yes");
		sendText(reasons, Reasons, "remarks");
		click(clickbtn, "Submit");	
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, EquipmentUniqeCode);
		switchToDefaultContent(driver);
		
		
	}
	
	public void equipmentauditTrails()
	{
		click(MasterMenu, "Master Menur");
		scrollToViewElement(equipmentAuditTrails);
		click(equipmentAuditTrails, "equipmentAuditTrails");
		switchToBodyFrame(driver);
		click(advancedsearch, "click search");
		enterUniqueCode(driver, Issuecode);
//		click(calenderBtn, "click calender button");
//		click(last30Days, "click last 30 Days");
		
		click(appltbtn, " apply button");
		
		click(blinderclick, "click blender");
		switchToPopupModelFrame(driver);
		click(closewindow, "close window");
		switchToDefaultContent(driver);
						
	}
	
	
}
