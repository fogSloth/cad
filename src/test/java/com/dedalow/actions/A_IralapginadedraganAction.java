package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.SharedDependencies;


import com.dedalow.pages.DragAndDropPage;


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

public class A_IralapginadedraganAction {
    
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    
    
    private DragAndDropPage dragAndDropPage;
 	
    
    public A_IralapginadedraganAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
         
        dragAndDropPage = new DragAndDropPage(dependencies);

        
    }
    


	public A_IralapginadedraganAction goToApp6 () {
        dependencies.driver.get("https://cad-uat-cadqa-supertestui.caddev.everis.com/dragAndDropPage");
        Report.reportLog(dependencies, "Navigated to " + "https://cad-uat-cadqa-supertestui.caddev.everis.com/dragAndDropPage", "INFO", 0, Status.PASS, true, "", "", null);
        return this;
    }

	public A_IralapginadedraganAction checkPage6() {
        
			assertTrue(dependencies.driver.getCurrentUrl().equals("https://cad-uat-cadqa-supertestui.caddev.everis.com/dragAndDropPage"), "Field checkPage6 not found in assertion");
        	Report.reportLog(dependencies, "The field https://cad-uat-cadqa-supertestui.caddev.everis.com/dragAndDropPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "checkPage6 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    

    public void doA_IralapginadedraganAction() throws Exception {

		goToApp6();

		checkPage6();

		dragAndDropPage.enableDrag();
    }
}