package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.SharedDependencies;


import com.dedalow.pages.ButtonsPage;


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

public class A_ComprobarelclickizquieAction1 {
    
	private static By checkTitle4 = By.xpath("//h2");
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    
    
    private ButtonsPage buttonsPage;
 	

    public A_ComprobarelclickizquieAction1(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
        
        buttonsPage = new ButtonsPage(dependencies);

        
    }
    


	public A_ComprobarelclickizquieAction1 goToApp4 () {
            dependencies.driver.get("https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage");
            Report.reportLog(dependencies, "Navigated to " + "https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
        }

	public A_ComprobarelclickizquieAction1 checkPage4() {
                
			assertTrue(dependencies.driver.getCurrentUrl().equals("https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage"), "Field checkPage4 not found in assertion");
        	Report.reportLog(dependencies, "The field https://cad-uat-cadqa-supertestui.caddev.everis.com/buttonsPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
                
                Report.reportLog(dependencies, "The field checkPage4 has been found on assertions", "INFO", 0, Status.PASS, false, "", "", null);
                return this;
            }
		


	public A_ComprobarelclickizquieAction1 assertOkPage1() {
                new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(checkTitle4));
            Report.reportLog(dependencies, "Condition checkTitle4 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(dependencies.driver.findElement(checkTitle4).getText().contains("OkPage"), "Field checkTitle4 not found in assertion");
        	Report.reportLog(dependencies, "The field OkPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
                
                Report.reportLog(dependencies, "The field assertOkPage1 has been found on assertions", "INFO", 0, Status.PASS, false, "", "", null);
                return this;
            }
		
    public void doA_ComprobarelclickizquieAction1() throws Exception {
		

		goToApp4();

		

		checkPage4();

		buttonsPage.disableButtons1();

		buttonsPage.clickToOkByXpath();

		

		assertOkPage1();
    }
}