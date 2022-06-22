package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;
import com.gargoylesoftware.htmlunit.javascript.host.webkitURL;

public class MST_EquipmentCategory extends ActionEngine{
	

	Properties prop;
	public static String Uniquecode = "";
	
	public static String getUniqueCode() {
		return Uniquecode;
	}

	public static void setUniquecode(String uniquecode) {
		Uniquecode = uniquecode;
	}
	
	@FindBy(xpath = "//div[@class='left-menupanel']/div[2]/i")
	WebElement MasterMenu;
	
	
	//Category Registration
	
	@FindBy(id="INCA_01")
	WebElement EquipmentCategoryRegisarationMenu;
	
	@FindBy(id="btnSubmit_1")
	WebElement Submitbtn;
	
	@FindBy(id="MST_CAT_CTF_001_error")
	WebElement Errorcategoryname;
	
	@FindBy(id="MST_CAT_CTF_001")
	WebElement CategoryName;
	
	@FindBy(id="MST_CAT_CTF_002_error")
	WebElement ErrorDescription;
	
	@FindBy(id="MST_CAT_CTF_002")
	WebElement Description;
	
	@FindBy(id="MST_CAT_CTF_003_error")
	WebElement EquipmentType_Error;
	
	@FindBy(id="MST_CAT_CTF_003")
	WebElement EquipmentType_DropDown;
	
	@FindBy(id  = "cfnMsg_KeyFieldValue")
	WebElement EquipmmentCategoryUniquecode;;

	
	@FindBy(id="cfnMsg_Next")
	WebElement DoneBtn;
	
	@FindBy(id="MST_CAT_CTF_004_error")
	WebElement Locationtype_Error;
	
	@FindBy(id="MST_CAT_CTF_004")
	WebElement LocationType_DropDown;
		
//	@FindBy(id="btnSubmit")
//	WebElement submit;

	
	//category modification
	
	@FindBy(id="INCA_02")
	WebElement EquipmentCategoryModificationMenu;
	
	@FindBy(id="btnAdvSearch")
	WebElement AdvancedSearchFilter;
	
	@FindBy(name="MST_CAT_CTF_001")
	WebElement CategoryNameSearchFilter;
	
	@FindBy(id="btnSubmitListFilter")
	WebElement ApplyButton;
	
	@FindBy(xpath = "//span[@class='text-ellipsis']")
	WebElement CategoryNameRecord;
	
	@FindBy(id="MST_CAT_CTF_002")
	WebElement ModificationName;
	
	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement RemarkReason_Error;
	
	@FindBy(id="txtRemarks")
	WebElement Remarksreason;
	
    //status changes
	
	@FindBy(id="INCA_03")
	WebElement EquipmentCategoryStatusMenu;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement clickNname;
	
	@FindBy(xpath = "//span[text()='Select Value']")
	WebElement Active_Error;
	
	@FindBy(xpath = "//label[@for='NewStatus_5']")
	WebElement Active;
	
	@FindBy(id="txtRemarks")
	WebElement remarks;
	
	//caterogy audittrails
	
	@FindBy(id="INCA_04")
	WebElement EquipmentCategoryAudittrails;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement nameClick;
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closepop;
	
		
	
	public void equipmentCategoryRegistration(String E_category , String E_Description ,String equipmentType,String locationType)
	{
		String s = "";
		
		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
			System.out.println("Generated S Value is: " + s);
		}
		setUniquecode(Uniquecode = E_category + s);
		//switchToDefaultContent(driver);
		TimeUtil.shortWait();
		//click(MasterMenu, "manager folder");
		jsClick(MasterMenu, "-Master Menu-");
		scrollToViewElement(EquipmentCategoryRegisarationMenu);
		click(EquipmentCategoryRegisarationMenu, "registration login");
		switchToBodyFrame(driver);
		
		click(Submitbtn, "Submit");
		verifyCaptionContains(Errorcategoryname, "Enter Value");
		sendText(CategoryName, Uniquecode, "Department Code");
		click(Submitbtn, "Submit");
		
		verifyCaptionContains(ErrorDescription, "Enter Value");
		sendText(Description, E_Description, "Department Code");
		click(Submitbtn, "Submit");
		
		verifyCaptionContains(EquipmentType_Error, "Select Value");
		selectDropdownUsingVisisbleText(EquipmentType_DropDown, equipmentType, "Equipment Type");
		click(Submitbtn, "Submit");
		
		verifyCaptionContains(Locationtype_Error, "Select Value");
		selectDropdownUsingVisisbleText(LocationType_DropDown, locationType, "location Type");
		click(Submitbtn, "Submit");
			
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		//saveUniqueCode(driver, EquipmmentCategoryUniquecode); 
		saveUniqueCode(driver, EquipmmentCategoryUniquecode);
		click(DoneBtn, "Close done button");
		switchToDefaultContent(driver);
		
						
	}
	
	
	
	public void equipmentCategoryModiFication(String Description1 , String Remarks )
	{
		TimeUtil.shortWait();
		//scrollToViewElement(ModificationMenu);
		jsClick(MasterMenu, "Master Menu");
		
		//click(MasterMenu, "manager folder");
		scrollToViewElement(EquipmentCategoryModificationMenu);
		click(EquipmentCategoryModificationMenu, "modificationLogin");
		switchToBodyFrame(driver);
		click(AdvancedSearchFilter, "Advanced fileter button");
		enterUniqueCode(driver, CategoryNameSearchFilter);
		click(CategoryNameRecord, "Record");
		//modifyname.clear();
		clearField(Description, "Modification Name");
		sendText(Description, Description1, "modify name");
		click(Submitbtn, "Submit");
		verifyCaptionContains(RemarkReason_Error, "enter Value");
		sendText(Remarksreason, Remarks, "remarkseasons");
		click(Submitbtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, EquipmmentCategoryUniquecode);
		TimeUtil.shortWait();
		click(DoneBtn, "Close done button");
		switchToDefaultContent(driver);
	}
	
	
	
	public void equipmentCategoryStatusChange(String Remarks)
	{
		//click(MasterMenu, "manager Menu");
		jsClick(MasterMenu, "Maser Menu");
		click(EquipmentCategoryStatusMenu, "status change login");
		switchToBodyFrame(driver);
		
		click(AdvancedSearchFilter, "Advanced fileter button");
		enterUniqueCode(driver, CategoryNameSearchFilter);
		click(CategoryNameRecord, "Record");
		click(Submitbtn, "Submit");
		
		//click(clickNname, "name click");
		
		verifyCaptionContains(Active_Error, "Select Value");
		click(Active, "click user");
		sendText(remarks, Remarks, "remarksreason");
		click(Submitbtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		
		saveUniqueCode(driver, EquipmmentCategoryUniquecode);
//		System.out.println("ucode");
		TimeUtil.shortWait();
		click(DoneBtn, "Close done button");		
		switchToDefaultContent(driver);
		
	}
	
	public void equipmentCategoryAuditTrails()
	{
		//click(MasterMenu, "manager folder");
		jsClick(MasterMenu, "Master Menu");
		
		click(EquipmentCategoryAudittrails, "click audit");
		switchToBodyFrame(driver);
		click(AdvancedSearchFilter, "Advanced fileter button");
		enterUniqueCode(driver, CategoryNameSearchFilter);
		click(CategoryNameRecord, "Record");
		
		//click(nameClick, "click name");
		click(closepop, "close pop");	
		switchToDefaultContent(driver);
	}
		

}
