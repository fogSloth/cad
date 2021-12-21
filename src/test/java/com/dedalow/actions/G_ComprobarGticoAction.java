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

public class G_ComprobarGticoAction {
    
	private static By TextoGoticoFrances = By.id("firstHeading");
	private static By TextoGoticoIngles = By.xpath("//a[contains(text(),'Gótico inglés')]");
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    
    
    
    
    public G_ComprobarGticoAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
         
        
        
    }
    


	public G_ComprobarGticoAction FrontEndNavigate () {
        dependencies.driver.get(dependencies.prop.getProperty("WEB_URL") + "");
        Report.reportLog(dependencies, "Navigated to " + dependencies.prop.getProperty("WEB_URL") + "", "INFO", 0, Status.PASS, true, "", "", null);
        return this;
    }

	public G_ComprobarGticoAction VerificaGotico() {
        
			assertTrue(dependencies.driver.getCurrentUrl().equals("https://es.wikipedia.org/wiki/G%C3%B3tico_franc%C3%A9s"), "Field VerificaGotico not found in assertion");
        	Report.reportLog(dependencies, "The field https://es.wikipedia.org/wiki/G%C3%B3tico_franc%C3%A9s has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(TextoGoticoFrances));
            Report.reportLog(dependencies, "Condition TextoGoticoFrances isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(dependencies.driver.findElement(TextoGoticoFrances).getText().contains("Gótico francés"), "Field TextoGoticoFrances not found in assertion");
        	Report.reportLog(dependencies, "The field Gótico francés has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(TextoGoticoIngles));
            Report.reportLog(dependencies, "Condition TextoGoticoIngles isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue("Gótico inglés".equals(dependencies.driver.findElement(TextoGoticoIngles).getText()), "Field TextoGoticoIngles not found in assertion");
        	Report.reportLog(dependencies, "The field Gótico inglés has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "VerificaGotico action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    
    public void doG_ComprobarGticoAction() throws Exception {

		FrontEndNavigate();

		VerificaGotico();
    }
}