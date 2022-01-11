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

public class G_AbrirunnuevonavegadorAction {
    
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    
    
    

    public G_AbrirunnuevonavegadorAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
        
        
        
    }
    


	public G_AbrirunnuevonavegadorAction HomePage () {
            dependencies.driver.get(dependencies.prop.getProperty("WEB_URL") + "");
            Report.reportLog(dependencies, "Navigated to " + dependencies.prop.getProperty("WEB_URL") + "", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
        }

public G_AbrirunnuevonavegadorAction NewBrowserJIRAITO() throws Exception {
            dependencies.setUpEnvironment("WIKIPEDIA");
            Report.reportLog(dependencies, "NewBrowserJIRAITO action completed", "INFO", 1000, Status.PASS, true, "", "", null);
            return this;
        }
		

	public G_AbrirunnuevonavegadorAction JIRAITO () {
            dependencies.driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
            Report.reportLog(dependencies, "Navigated to " + "https://es.wikipedia.org/wiki/Wikipedia:Portada", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
        }

    public void doG_AbrirunnuevonavegadorAction() throws Exception {
		

		HomePage();

		NewBrowserJIRAITO();
		Thread.sleep(1000);

		JIRAITO();
    }
}