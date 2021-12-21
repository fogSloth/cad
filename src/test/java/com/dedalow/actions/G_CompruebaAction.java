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

public class G_CompruebaAction {
    
	private static By ContieneSimboloEuro = By.xpath("//body/div[@id='content']/div[@id='bodyContent']/div[@id='mw-content-text']/div[1]/p[1]");
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    
    
    
    
    public G_CompruebaAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
         
        
        
    }
    


	public G_CompruebaAction FrontEndNavigate1 () {
        dependencies.driver.get("https://es.wikipedia.org/wiki/Euro");
        Report.reportLog(dependencies, "Navigated to " + "https://es.wikipedia.org/wiki/Euro", "INFO", 0, Status.PASS, true, "", "", null);
        return this;
    }

	public G_CompruebaAction CompruebaEuros() {
        new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.visibilityOfElementLocated(ContieneSimboloEuro));
            Report.reportLog(dependencies, "Condition ContieneSimboloEuro isVisible finished", "ASYNCHRONOUS", 0);
			assertTrue(dependencies.driver.findElement(ContieneSimboloEuro).getText().contains("€"), "Field ContieneSimboloEuro not found in assertion");
        	Report.reportLog(dependencies, "The field € has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "CompruebaEuros action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    
    public void doG_CompruebaAction() throws Exception {

		FrontEndNavigate1();

		CompruebaEuros();
    }
}