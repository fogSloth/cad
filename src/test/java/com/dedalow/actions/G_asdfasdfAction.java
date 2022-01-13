package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.SharedDependencies;

import com.dedalow.customActions.CustomAction;
	


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

public class G_asdfasdfAction {
    
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    private CustomAction customAction;
	
    
    

    public G_asdfasdfAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
        
        
        customAction = new CustomAction(dependencies);
	
    }
    

public G_asdfasdfAction CustomAction() throws Exception {
                customAction.doCustomAction();
                Report.reportLog(dependencies, "CustomAction action completed", "INFO", 0, Status.PASS, false, "", "", null);
                return this;
            }
		
    public void doG_asdfasdfAction() throws Exception {
		

		CustomAction();
    }
}