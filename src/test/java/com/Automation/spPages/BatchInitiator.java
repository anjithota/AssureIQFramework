package com.Automation.spPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class BatchInitiator extends ActionEngine {
	
@FindBy(id = "")
WebElement master;

@FindBy(id = "")
WebElement inti;

@FindBy(id = "")
WebElement BA;

@FindBy(id = "Ucode")
WebElement Ucode;

@FindBy(id = "CustomerModel_CustomerCode-error")
WebElement UcodeError;


@FindBy(id = "Ucode")
WebElement Name;

public void baInitiate() {
	click(master, "Master Menu");
	click(inti, "Master Menu");
	click(BA, "BA");
	//click(sub, "sub");
	verifyCaptionContains(UcodeError, "Enter Value");
	sendText(Ucode, "bhh", "Send Ucode");

	sendText(Name, "bhh", "Name Ucode");
	
	E_sign.e_Sign("ghhghf");
}

public void baReinitiate() {
	sendText(Name, "hh", "Name");
	
}


}
