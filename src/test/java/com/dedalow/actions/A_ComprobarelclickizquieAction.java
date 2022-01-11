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

public class A_ComprobarelclickizquieAction {
    
	private static By checkTitle3 = By.xpath("//h2");
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    
    
    private ButtonsPage buttonsPage;
 	

    public A_ComprobarelclickizquieAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
        
        buttonsPage = new ButtonsPage(dependencies);

        
    }
    



	public A_ComprobarelclickizquieAction assertOkPage() {
                new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(checkTitle3));
            Report.reportLog(dependencies, "Condition checkTitle3 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(dependencies.driver.findElement(checkTitle3).getText().contains("OkPage"), "Field checkTitle3 not found in assertion");
        	Report.reportLog(dependencies, "The field OkPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
                
                Report.reportLog(dependencies, "The field assertOkPage has been found on assertions", "INFO", 0, Status.PASS, false, "", "", null);
                return this;
            }
		
    public void doA_ComprobarelclickizquieAction() throws Exception {
		

		buttonsPage.disableButtons();

		buttonsPage.clickToOk();

		

		assertOkPage();
    }
}