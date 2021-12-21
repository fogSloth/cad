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

public class G_IralapginasupertestuAction {
    
	private static By checkTitle = By.xpath("//h2");
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    
    
    
    
    public G_IralapginasupertestuAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
         
        
        
    }
    


	public G_IralapginasupertestuAction goToApp () {
        dependencies.driver.get("https://cad-uat-cadqa-supertestui.caddev.everis.com/");
        Report.reportLog(dependencies, "Navigated to " + "https://cad-uat-cadqa-supertestui.caddev.everis.com/", "INFO", 0, Status.PASS, true, "", "", null);
        return this;
    }

	public G_IralapginasupertestuAction checkPage() {
        
			assertTrue(dependencies.driver.getCurrentUrl().equals("https://cad-uat-cadqa-supertestui.caddev.everis.com/"), "Field checkPage not found in assertion");
        	Report.reportLog(dependencies, "The field https://cad-uat-cadqa-supertestui.caddev.everis.com/ has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(checkTitle));
            Report.reportLog(dependencies, "Condition checkTitle isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(dependencies.driver.findElement(checkTitle).getText().contains("formPage"), "Field checkTitle not found in assertion");
        	Report.reportLog(dependencies, "The field formPage has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "checkPage action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    
    public void doG_IralapginasupertestuAction() throws Exception {

		goToApp();

		checkPage();
    }
}