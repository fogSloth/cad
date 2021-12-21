package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.SharedDependencies;




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

public class A_ComprobarquepodemosreaAction {
    
	private static By titleH1 = By.xpath("//h1[contains(text(),'HTML For Beginners')]");
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    
    
    
    
    public A_ComprobarquepodemosreaAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
         
        
        
    }
    

	public A_ComprobarquepodemosreaAction CheckTitle() {
        new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(titleH1));
            Report.reportLog(dependencies, "Condition titleH1 isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(dependencies.driver.findElement(titleH1).getText().contains("HTML For Beginners"), "Field titleH1 not found in assertion");
        	Report.reportLog(dependencies, "The field HTML For Beginners has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "CheckTitle action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    
    public void doA_ComprobarquepodemosreaAction() throws Exception {

		CheckTitle();
    }
}