package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.SharedDependencies;




    import org.openqa.selenium.remote.LocalFileDetector;
    import org.openqa.selenium.remote.RemoteWebElement;
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

public class T_ComprobartodoslostiposAction {
    
	private static By assertNameById = By.id("name");
	private static By assertLastNameByXpathDoubleQuotes = By.xpath("//*[@id=\"lastName\"]");
	private static By assertEmailByXpathSingleQuote = By.xpath("//*[@id='email']");
	private static By assertPhoneByName = By.name("phone");
	private static By assertContains = By.id("name");
	private static By assertNotContains = By.id("name");
	private static By assertDistinct = By.id("name");
	private static By assertIsNotEmpty = By.id("name");
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    
    
    

    public T_ComprobartodoslostiposAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
        
        
        
    }
    

	public T_ComprobartodoslostiposAction FrontEndVerdictStepsAction() {
                new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertNameById));
            Report.reportLog(dependencies, "Condition assertNameById isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue("a name".equals(dependencies.driver.findElement(assertNameById).getAttribute("ng-reflect-model")), "Field assertNameById not found in assertion");
        	Report.reportLog(dependencies, "The field a name has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertLastNameByXpathDoubleQuotes));
            Report.reportLog(dependencies, "Condition assertLastNameByXpathDoubleQuotes isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue("a last name".equals(dependencies.driver.findElement(assertLastNameByXpathDoubleQuotes).getAttribute("ng-reflect-model")), "Field assertLastNameByXpathDoubleQuotes not found in assertion");
        	Report.reportLog(dependencies, "The field a last name has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertEmailByXpathSingleQuote));
            Report.reportLog(dependencies, "Condition assertEmailByXpathSingleQuote isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue("an email".equals(dependencies.driver.findElement(assertEmailByXpathSingleQuote).getAttribute("ng-reflect-model")), "Field assertEmailByXpathSingleQuote not found in assertion");
        	Report.reportLog(dependencies, "The field an email has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertPhoneByName));
            Report.reportLog(dependencies, "Condition assertPhoneByName isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue("123456".equals(dependencies.driver.findElement(assertPhoneByName).getAttribute("ng-reflect-model")), "Field assertPhoneByName not found in assertion");
        	Report.reportLog(dependencies, "The field 123456 has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertContains));
            Report.reportLog(dependencies, "Condition assertContains isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(dependencies.driver.findElement(assertContains).getAttribute("ng-reflect-model").contains("nam"), "Field assertContains not found in assertion");
        	Report.reportLog(dependencies, "The field nam has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertNotContains));
            Report.reportLog(dependencies, "Condition assertNotContains isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(!dependencies.driver.findElement(assertNotContains).getAttribute("ng-reflect-model").contains("not contained"), "Field assertNotContains not found in assertion");
        	Report.reportLog(dependencies, "The field not contained has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertDistinct));
            Report.reportLog(dependencies, "Condition assertDistinct isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(!"another name".equals(dependencies.driver.findElement(assertDistinct).getAttribute("ng-reflect-model")), "Field assertDistinct not found in assertion");
        	Report.reportLog(dependencies, "The field another name has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(assertIsNotEmpty));
            Report.reportLog(dependencies, "Condition assertIsNotEmpty isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(!"".equals(dependencies.driver.findElement(assertIsNotEmpty).getAttribute("ng-reflect-model")), "Field assertIsNotEmpty not found in assertion");
        	Report.reportLog(dependencies, "The field empty has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
                
                Report.reportLog(dependencies, "The field FrontEndVerdictStepsAction has been found on assertions", "INFO", 0, Status.PASS, false, "", "", null);
                return this;
            }
		
    public void doT_ComprobartodoslostiposAction() throws Exception {
		

		

		FrontEndVerdictStepsAction();
    }
}