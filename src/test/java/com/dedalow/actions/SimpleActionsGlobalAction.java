package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.SharedDependencies;


import com.dedalow.pages.FromPage;
import com.dedalow.pages.DragAndDropPage;
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

public class SimpleActionsGlobalAction {
    
	private static By checkTitle8 = By.xpath("//h2");
	private static By assertDistinct1 = By.id("name");
	private static By assertPhoneByName1 = By.name("phone");
	private static By assertContains1 = By.id("name");
	private static By assertNotContains1 = By.id("name");
	private static By assertIsNotEmpty1 = By.id("name");
	private static By assertNameById1 = By.id("name");
	private static By assertLastNameByXpathDoubleQuotes1 = By.xpath("//*[@id=\"lastName\"]");
	private static By assertEmailByXpathSingleQuote1 = By.xpath("//*[@id='email']");
	private static By checkTitle9 = By.xpath("//h2");
	private static By checkTitle10 = By.xpath("//h2");
	private By waitForButton1 = By.xpath("//*[@id=\"doubleClickToOk\"]");
	
	private static By checkTitle11 = By.xpath("//h2");
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    
    
    private FromPage fromPage;
 	private DragAndDropPage dragAndDropPage;
 	private ButtonsPage buttonsPage;
 	
    
    public SimpleActionsGlobalAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
         
        fromPage = new FromPage(dependencies);
dragAndDropPage = new DragAndDropPage(dependencies);
buttonsPage = new ButtonsPage(dependencies);

        
    }
    


	public SimpleActionsGlobalAction checkInputs() {
        new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertDistinct1));
            Report.reportLog(dependencies, "Condition assertDistinct1 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(!"another name".equals(dependencies.driver.findElement(assertDistinct1).getAttribute("ng-reflect-model")), "Field assertDistinct1 not found in assertion");
        	Report.reportLog(dependencies, "The field another name has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertPhoneByName1));
            Report.reportLog(dependencies, "Condition assertPhoneByName1 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue("123456".equals(dependencies.driver.findElement(assertPhoneByName1).getAttribute("ng-reflect-model")), "Field assertPhoneByName1 not found in assertion");
        	Report.reportLog(dependencies, "The field 123456 has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertContains1));
            Report.reportLog(dependencies, "Condition assertContains1 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(dependencies.driver.findElement(assertContains1).getAttribute("ng-reflect-model").contains("nam"), "Field assertContains1 not found in assertion");
        	Report.reportLog(dependencies, "The field nam has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertNotContains1));
            Report.reportLog(dependencies, "Condition assertNotContains1 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(!dependencies.driver.findElement(assertNotContains1).getAttribute("ng-reflect-model").contains("not contained"), "Field assertNotContains1 not found in assertion");
        	Report.reportLog(dependencies, "The field not contained has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertIsNotEmpty1));
            Report.reportLog(dependencies, "Condition assertIsNotEmpty1 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(!"".equals(dependencies.driver.findElement(assertIsNotEmpty1).getAttribute("ng-reflect-model")), "Field assertIsNotEmpty1 not found in assertion");
        	Report.reportLog(dependencies, "The field empty has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertNameById1));
            Report.reportLog(dependencies, "Condition assertNameById1 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue("a name".equals(dependencies.driver.findElement(assertNameById1).getAttribute("ng-reflect-model")), "Field assertNameById1 not found in assertion");
        	Report.reportLog(dependencies, "The field a name has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertLastNameByXpathDoubleQuotes1));
            Report.reportLog(dependencies, "Condition assertLastNameByXpathDoubleQuotes1 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue("a last name".equals(dependencies.driver.findElement(assertLastNameByXpathDoubleQuotes1).getAttribute("ng-reflect-model")), "Field assertLastNameByXpathDoubleQuotes1 not found in assertion");
        	Report.reportLog(dependencies, "The field a last name has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertEmailByXpathSingleQuote1));
            Report.reportLog(dependencies, "Condition assertEmailByXpathSingleQuote1 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue("an email".equals(dependencies.driver.findElement(assertEmailByXpathSingleQuote1).getAttribute("ng-reflect-model")), "Field assertEmailByXpathSingleQuote1 not found in assertion");
        	Report.reportLog(dependencies, "The field an email has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "checkInputs action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    

	public SimpleActionsGlobalAction goToApp9 () {
        dependencies.driver.get("https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage");
        Report.reportLog(dependencies, "Navigated to " + "https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage", "INFO", 0, Status.PASS, true, "", "", null);
        return this;
    }

	public SimpleActionsGlobalAction checkPage9() {
        
			assertTrue(dependencies.driver.getCurrentUrl().equals("https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage"), "Field checkPage9 not found in assertion");
        	Report.reportLog(dependencies, "The field https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "checkPage9 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    


	public SimpleActionsGlobalAction assertOkPage4() {
        new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(checkTitle9));
            Report.reportLog(dependencies, "Condition checkTitle9 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(dependencies.driver.findElement(checkTitle9).getText().contains("OkPage"), "Field checkTitle9 not found in assertion");
        	Report.reportLog(dependencies, "The field OkPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "assertOkPage4 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    

	public SimpleActionsGlobalAction goToApp8 () {
        dependencies.driver.get("https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage");
        Report.reportLog(dependencies, "Navigated to " + "https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage", "INFO", 0, Status.PASS, true, "", "", null);
        return this;
    }

	public SimpleActionsGlobalAction checkPage10() {
        
			assertTrue(dependencies.driver.getCurrentUrl().equals("https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage"), "Field checkPage10 not found in assertion");
        	Report.reportLog(dependencies, "The field https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "checkPage10 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    


	public SimpleActionsGlobalAction assertOkPage5() {
        new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(checkTitle10));
            Report.reportLog(dependencies, "Condition checkTitle10 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(dependencies.driver.findElement(checkTitle10).getText().contains("OkPage"), "Field checkTitle10 not found in assertion");
        	Report.reportLog(dependencies, "The field OkPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "assertOkPage5 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    

	public SimpleActionsGlobalAction goToApp10 () {
        dependencies.driver.get("https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage");
        Report.reportLog(dependencies, "Navigated to " + "https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage", "INFO", 0, Status.PASS, true, "", "", null);
        return this;
    }

	public SimpleActionsGlobalAction checkPage11() {
        
			assertTrue(dependencies.driver.getCurrentUrl().equals("https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage"), "Field checkPage11 not found in assertion");
        	Report.reportLog(dependencies, "The field https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "checkPage11 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    
	public SimpleActionsGlobalAction waitForButton1() {
        	new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(waitForButton1));
            Report.reportLog(dependencies, "Condition waitForButton1 isClickable finished", "INFO", 20, Status.PASS, true, "", "", null);
        	return this;
        }


	public SimpleActionsGlobalAction assertOkPage6() {
        new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(checkTitle11));
            Report.reportLog(dependencies, "Condition checkTitle11 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(dependencies.driver.findElement(checkTitle11).getText().contains("OkPage"), "Field checkTitle11 not found in assertion");
        	Report.reportLog(dependencies, "The field OkPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "assertOkPage6 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    

	public SimpleActionsGlobalAction goToApp11 () {
        dependencies.driver.get("https://cad-uat-cadqa-supertestui.caddev.everis.com/dragAndDropPage");
        Report.reportLog(dependencies, "Navigated to " + "https://cad-uat-cadqa-supertestui.caddev.everis.com/dragAndDropPage", "INFO", 0, Status.PASS, true, "", "", null);
        return this;
    }

	public SimpleActionsGlobalAction checkPage8() {
        
			assertTrue(dependencies.driver.getCurrentUrl().equals("https://cad-uat-cadqa-supertestui.caddev.everis.com/dragAndDropPage"), "Field checkPage8 not found in assertion");
        	Report.reportLog(dependencies, "The field https://cad-uat-cadqa-supertestui.caddev.everis.com/dragAndDropPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "checkPage8 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    


	public SimpleActionsGlobalAction assertOkPage3() {
        new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(checkTitle8));
            Report.reportLog(dependencies, "Condition checkTitle8 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue("OkPage".equals(dependencies.driver.findElement(checkTitle8).getText()), "Field checkTitle8 not found in assertion");
        	Report.reportLog(dependencies, "The field OkPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "assertOkPage3 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    
    public void doSimpleActionsGlobalAction() throws Exception {

		fromPage.fillInputs1();

		checkInputs();

		goToApp9();

		checkPage9();

		buttonsPage.disableButtons3();

		buttonsPage.clickToOk1();

		assertOkPage4();

		goToApp8();

		checkPage10();

		buttonsPage.disableButtons4();

		buttonsPage.clickToOkByXpath1();

		assertOkPage5();

		goToApp10();

		checkPage11();

		buttonsPage.disableButtons5();

		waitForButton1();

		buttonsPage.doubleClickToOkByXpath1();

		assertOkPage6();

		goToApp11();

		checkPage8();

		dragAndDropPage.enableDrag1();

		dragAndDropPage.dragImage1();

		assertOkPage3();
    }
}