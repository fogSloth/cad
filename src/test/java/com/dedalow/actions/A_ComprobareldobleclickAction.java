package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.SharedDependencies;


import com.dedalow.pages.ButtonsPage;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.Status;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.restassured.response.Response;

public class A_ComprobareldobleclickAction {
    
	private static By checkTitle5 = By.xpath("//h2");
	private By waitForButton = By.xpath("//*[@id=\"doubleClickToOk\"]");
	
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    
    
    private ButtonsPage buttonsPage;
 	
    
    public A_ComprobareldobleclickAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
         
        buttonsPage = new ButtonsPage(dependencies);

        
    }
    


	public A_ComprobareldobleclickAction goToApp5 () {
        dependencies.driver.get("https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage");
        Report.reportLog(dependencies, "Navigated to " + "https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage", "INFO", 0, Status.PASS, true, "", "", null);
        return this;
    }

	public A_ComprobareldobleclickAction checkPage5() {
        
			assertTrue(dependencies.driver.getCurrentUrl().equals("https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage"), "Field checkPage5 not found in assertion");
        	Report.reportLog(dependencies, "The field https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "checkPage5 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    
	public A_ComprobareldobleclickAction waitForButton() {
        	new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(waitForButton));
            Report.reportLog(dependencies, "Condition waitForButton isClickable finished", "INFO", 20, Status.PASS, true, "", "", null);
        	return this;
        }


	public A_ComprobareldobleclickAction assertOkPage2() {
        new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(checkTitle5));
            Report.reportLog(dependencies, "Condition checkTitle5 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(dependencies.driver.findElement(checkTitle5).getText().contains("OkPage"), "Field checkTitle5 not found in assertion");
        	Report.reportLog(dependencies, "The field OkPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "assertOkPage2 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    
    public void doA_ComprobareldobleclickAction() throws Exception {

		goToApp5();

		checkPage5();

		buttonsPage.disableButtons2();

		waitForButton();

		buttonsPage.doubleClickToOkByXpath();

		assertOkPage2();
    }
}