package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.SharedDependencies;

import com.dedalow.customActions.CustomActionPagAleatoria;
	import com.dedalow.customActions.CustomActionCambiosRecientes;
	


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

public class G_RealizaCustomAction {
    
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    private CustomActionPagAleatoria customActionPagAleatoria;
	private CustomActionCambiosRecientes customActionCambiosRecientes;
	
    
    
    
    public G_RealizaCustomAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
         
        
        customActionPagAleatoria = new CustomActionPagAleatoria(dependencies);
	customActionCambiosRecientes = new CustomActionCambiosRecientes(dependencies);
	
    }
    


	public G_RealizaCustomAction FrontEndNavigate () {
        dependencies.driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        Report.reportLog(dependencies, "Navigated to " + "https://es.wikipedia.org/wiki/Wikipedia:Portada", "INFO", 0, Status.PASS, true, "", "", null);
        return this;
    }

public G_RealizaCustomAction CustomActionCambiosRecientes() throws Exception {
          customActionCambiosRecientes.doCustomActionCambiosRecientes();
          Report.reportLog(dependencies, "CustomActionCambiosRecientes action completed", "INFO", 3000, Status.PASS, false, "", "", null);
          return this;
        }
        
        
	public G_RealizaCustomAction FrontEndVerdictStepsAction() {
        
			assertTrue(dependencies.driver.getCurrentUrl().equals("https://es.wikipedia.org/wiki/Especial:CambiosRecientes?hidebots=1&hidecategorization=1&hideWikibase=1&limit=50&days=7&urlversion=2"), "Field FrontEndVerdictStepsAction not found in assertion");
        	Report.reportLog(dependencies, "The field https://es.wikipedia.org/wiki/Especial:CambiosRecientes?hidebots=1&hidecategorization=1&hideWikibase=1&limit=50&days=7&urlversion=2 has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
        Report.reportLog(dependencies, "FrontEndVerdictStepsAction action completed", "INFO", 0, Status.PASS, false, "", "", null);
        return this;
    }

    
public G_RealizaCustomAction CustomActionPagAleatoria() throws Exception {
          customActionPagAleatoria.doCustomActionPagAleatoria();
          Report.reportLog(dependencies, "CustomActionPagAleatoria action completed", "INFO", 0, Status.PASS, false, "", "", null);
          return this;
        }
        
        
    public void doG_RealizaCustomAction() throws Exception {

		FrontEndNavigate();

		CustomActionCambiosRecientes();
		Thread.sleep(3000);

		FrontEndVerdictStepsAction();

		CustomActionPagAleatoria();
    }
}