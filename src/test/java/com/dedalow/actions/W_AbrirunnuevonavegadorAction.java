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

public class W_AbrirunnuevonavegadorAction {
    
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    
    
    
    
    public W_AbrirunnuevonavegadorAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
         
        
        
    }
    

public W_AbrirunnuevonavegadorAction NewBrowserHTML() throws Exception {
          dependencies.setUpEnvironment("Html");
          Report.reportLog(dependencies, "NewBrowserHTML action completed", "INFO", 1000, Status.PASS, true, "", "", null);
          return this;
        }
        
        

	public W_AbrirunnuevonavegadorAction WebGmail () {
        dependencies.driver.get("https://html.com/attributes/a-target/");
        Report.reportLog(dependencies, "Navigated to " + "https://html.com/attributes/a-target/", "INFO", 0, Status.PASS, true, "", "", null);
        return this;
    }

    public void doW_AbrirunnuevonavegadorAction() throws Exception {

		NewBrowserHTML();
		Thread.sleep(1000);

		WebGmail();
    }
}