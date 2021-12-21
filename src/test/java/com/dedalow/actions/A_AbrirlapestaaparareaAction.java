package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.SharedDependencies;


import com.dedalow.pages.HtmlPage;


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

public class A_AbrirlapestaaparareaAction {
    
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    
    
    
    private HtmlPage htmlPage;
 	
    
    public A_AbrirlapestaaparareaAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        
         
        htmlPage = new HtmlPage(dependencies);

        
    }
    


public A_AbrirlapestaaparareaAction ChangeWindowHtml() throws Exception {
      for (String winHandle : dependencies.driver.getWindowHandles()) {
        if ("HTML For Beginners The Easy Way: Start Learning HTML & CSS Today »".equals(dependencies.driver.switchTo().window(winHandle).getTitle())) {
          dependencies.driver.switchTo().window(winHandle);
          Report.reportLog(dependencies, "ChangeWindowHtml action completed", "INFO", 0, Status.PASS, true, "", "", null);
          return this;
        }
      }
      throw new Exception("Error: Window/Tab HTML For Beginners The Easy Way: Start Learning HTML & CSS Today » not found");
    }

    
    public void doA_AbrirlapestaaparareaAction() throws Exception {

		htmlPage.openNewTab();
		Thread.sleep(1000);

		ChangeWindowHtml();
    }
}